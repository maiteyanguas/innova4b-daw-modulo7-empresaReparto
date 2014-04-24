package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceWithStubsTest {

	private static final int EMPRESA_ID_CON_EMPLEADOS = 25;
	private static final int EMPRESA_ID_CON_COCHES= 63;
	private static final int EMPRESA_ID_SIN_COCHES_NI_EMPLEADOS= 41;
	
	Empresa empresaConEmpleados;
	Empresa empresaConCoches;
	Empresa empresa;
	
	List<Empresa> empresas;
	
	EmpresaService empresaService;
	
	EmpresaDaoStub empresaDaoStub;
	
	private class EmpresaDaoStub extends EmpresaDao {
		
		@Override
		public boolean hasEmpleados(int id) {
			if (id==EMPRESA_ID_CON_EMPLEADOS)
				return true;
			return false;
		}
		
		@Override
		public boolean hasCoches(int id) {
			if (id==EMPRESA_ID_CON_COCHES)
				return true;
			return false;
		}
		
		@Override
		public void delete(int id) {
			int idx = 0;
			for (Empresa emp : empresas) {
				if (emp.getId()==id)
					idx = empresas.indexOf(emp);
			}
			empresas.remove(idx);
		}
	}
	
	@Before
	public void setUp() { 
		empresaConEmpleados = buildEmpresa(EMPRESA_ID_CON_EMPLEADOS);
		empresaConCoches = buildEmpresa(EMPRESA_ID_CON_EMPLEADOS);
		empresa = buildEmpresa(EMPRESA_ID_SIN_COCHES_NI_EMPLEADOS);
		
		empresas = new ArrayList<Empresa>();
		empresas.add(empresa);
		empresas.add(empresaConCoches);
		empresas.add(empresaConEmpleados);
		
		empresaService = new EmpresaService();
		empresaDaoStub = new EmpresaDaoStub();
		empresaService.setEmpresaDao(empresaDaoStub);
		
	}
	

	private Empresa buildEmpresa(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		return empresa;
	}


	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_empleados() throws EmpresaWithEmpleadosException {
		try {
			empresaService.delete(EMPRESA_ID_CON_EMPLEADOS);
		} catch (EmpresaWithEmpleadosException e) {
			//No se puede usar si no es un mock
			//verify(empresaDaoStub,never()).delete(EMPRESA_ID_CON_EMPLEADOS);
			assertEquals(3, empresas.size());
			return;
		} catch (EmpresaWithCochesException e) {}
		fail();
	}
	
	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_coches() throws EmpresaWithEmpleadosException {
		try {
			empresaService.delete(EMPRESA_ID_CON_COCHES);
		} catch (EmpresaWithCochesException e) {
			assertEquals(3, empresas.size());
			return;
		} catch (EmpresaWithEmpleadosException e) {}	
		fail();
	}	
	
	@Test
	public void delete_borra_la_empresa_si_no_tiene_coches_ni_empleados() {
		try {
			empresaService.delete(EMPRESA_ID_SIN_COCHES_NI_EMPLEADOS);
		} catch (EmpresaWithEmpleadosException e) {
			fail();
		} catch (EmpresaWithCochesException e) {
			fail();
		}
		assertEquals(2, empresas.size());
	}
	
	

}
