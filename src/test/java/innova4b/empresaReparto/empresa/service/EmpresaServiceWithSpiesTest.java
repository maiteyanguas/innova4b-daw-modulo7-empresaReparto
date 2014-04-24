package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceWithSpiesTest {

	private static final int EMPRESA_ID = 25;
	EmpresaService empresaService;
	@Spy
	EmpresaDao empresaDaoSpy;
	
	@Before
	public void setUp() throws Exception {
		empresaService = new EmpresaService();
		empresaService.setEmpresaDao(empresaDaoSpy);
		doReturn(false).when(empresaDaoSpy).hasEmpleados(EMPRESA_ID);
		doReturn(false).when(empresaDaoSpy).hasCoches(EMPRESA_ID);
	}
	
	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_empleados() {
		doReturn(true).when(empresaDaoSpy).hasEmpleados(EMPRESA_ID);		
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			verify(empresaDaoSpy,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithCochesException e) {}
		fail();
	}
	
	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_coches() throws EmpresaWithEmpleadosException {
		doReturn(true).when(empresaDaoSpy).hasCoches(EMPRESA_ID);
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithCochesException e) {
			verify(empresaDaoSpy,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithEmpleadosException e) {}	
		fail();
	}	
	
	@Test
	public void delete_borra_la_empresa_si_no_tiene_coches_ni_empleados() {
		//Con Mocks no es necesario, pero con Spies sí
		doNothing().when(empresaDaoSpy).delete(EMPRESA_ID);
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			fail();
		} catch (EmpresaWithCochesException e) {
			fail();
		}
		verify(empresaDaoSpy).delete(EMPRESA_ID);
	}
	
	

}
