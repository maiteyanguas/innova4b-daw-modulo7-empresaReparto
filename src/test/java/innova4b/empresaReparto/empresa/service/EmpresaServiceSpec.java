package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceSpec {

	private static final int EMPRESA_ID = 25;
	EmpresaService empresaService;
	@Mock
	EmpresaDao empresaDaoMock;
	
	@Before
	public void setUp() throws Exception {
		empresaService = new EmpresaService();
		empresaService.setEmpresaDao(empresaDaoMock);
		given(empresaDaoMock.hasEmpleados(EMPRESA_ID)).willReturn(false);
		given(empresaDaoMock.hasCoches(EMPRESA_ID)).willReturn(false);
	}
	

	@Test
	public void no_se_debe_borrar_una_empresa_si_contiene_empleados() throws EmpresaWithEmpleadosException {
		given(empresaDaoMock.hasEmpleados(EMPRESA_ID)).willReturn(true);
		
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			verify(empresaDaoMock,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithCochesException e) {}
		fail();
	}
	
	@Test
	public void no_se_debe_borrar_una_empresa_si_contiene_coches() throws EmpresaWithEmpleadosException {
		given(empresaDaoMock.hasCoches(EMPRESA_ID)).willReturn(true);
		
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithCochesException e) {
			verify(empresaDaoMock,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithEmpleadosException e) {}	
		fail();
	}	
	
	@Test
	public void se_debe_borrar_una_empresa_si_no_tiene_coches_ni_empleados() {
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			fail();
		} catch (EmpresaWithCochesException e) {
			fail();
		}
		verify(empresaDaoMock).delete(EMPRESA_ID);
	}
	
	

}
