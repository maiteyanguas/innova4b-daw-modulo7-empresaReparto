package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceTest {

	private static final int EMPRESA_ID = 25;
	EmpresaService empresaService;
	@Mock
	EmpresaDao empresaDaoMock;
	
	@Before
	public void setUp() throws Exception {
		empresaService = new EmpresaService();
		empresaService.setEmpresaDao(empresaDaoMock);
	}
	

	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_empleados() throws EmpresaWithEmpleadosException {
		when(empresaDaoMock.hasEmpleados(EMPRESA_ID)).thenReturn(true);
		
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			verify(empresaDaoMock,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithCochesException e) {}
		fail();
	}
	
	@Test
	public void delete_no_borra_y_lanza_excepcion_si_la_empresa_contiene_coches() throws EmpresaWithEmpleadosException {
		when(empresaDaoMock.hasCoches(EMPRESA_ID)).thenReturn(true);
		
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithCochesException e) {
			verify(empresaDaoMock,never()).delete(EMPRESA_ID);
			return;
		} catch (EmpresaWithEmpleadosException e) {}	
		fail();
	}	

}
