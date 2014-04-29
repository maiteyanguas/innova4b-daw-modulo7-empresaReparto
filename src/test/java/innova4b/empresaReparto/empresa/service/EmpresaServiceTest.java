package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import innova4b.empresaReparto.empresa.domain.Empresa;
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
		when(empresaDaoMock.hasEmpleados(EMPRESA_ID)).thenReturn(false);
		when(empresaDaoMock.hasCoches(EMPRESA_ID)).thenReturn(false);
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

	@Test
	public void delete_borra_la_empresa_si_no_tiene_coches_ni_empleados() {
		try {
			empresaService.delete(EMPRESA_ID);
		} catch (EmpresaWithEmpleadosException e) {
			fail();
		} catch (EmpresaWithCochesException e) {
			fail();
		}
		verify(empresaDaoMock).delete(EMPRESA_ID);
	}
	
	@Test
	public void insert_inserta_una_empresa_con_sus_direcciones_a_partir_del_json_de_direcciones() throws Exception {
		String direccionesJSON = "[{\"id\":0,\"calle\":\"Renteria\",\"portal\":24,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Irun\"},"
								+ "{\"id\":0,\"calle\":\"Paseo Colon\",\"portal\":5,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Donostia\"}]";
		Empresa empresa = new Empresa();
		Empresa empresaNew = empresaService.insert(empresa, direccionesJSON);
		assertNotNull(empresaNew);
		assertEquals(2, empresaNew.getDirecciones().size());
		assertEquals(empresa,empresaNew.getDirecciones().get(0).getEmpresa());
		verify(empresaDaoMock).insert(empresa);
	}
	
	@Test
	public void insert_inserta_una_empresa_sin_direcciones_si_el_json_de_direcciones_es_vacio() throws Exception {
		String direccionesJSON = "";
		Empresa empresa = new Empresa();
		Empresa empresaNew = empresaService.insert(empresa, direccionesJSON);
		assertNotNull(empresaNew);
		assertNull(empresaNew.getDirecciones());
		verify(empresaDaoMock).insert(empresa);
	}
	
	@Test
	public void insert_inserta_una_empresa_sin_direcciones_si_el_json_de_direcciones_esta_mal_formado() throws Exception {
		String direccionesJSON = "[{\"id\"\"calle\":\"Renteria\",\"portal\":24,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Irun\"},"
				+ "{\"id\":0,\"calle\":\"Paseo Colon\",\"portal\":5,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Donostia\"}]";

		Empresa empresa = new Empresa();
		Empresa empresaNew = empresaService.insert(empresa, direccionesJSON);
		assertNotNull(empresaNew);
		assertNull(empresaNew.getDirecciones());
		verify(empresaDaoMock).insert(empresa);
	}

}
