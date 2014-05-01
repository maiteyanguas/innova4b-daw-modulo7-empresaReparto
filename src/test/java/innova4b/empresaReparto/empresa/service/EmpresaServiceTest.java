package innova4b.empresaReparto.empresa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;
import innova4b.empresaReparto.exceptions.JsonUtilException;
import innova4b.empresaReparto.util.JsonUtil;
import innova4b.empresaReparto.util.TypeReferenceDireccionList;

import java.util.ArrayList;
import java.util.List;

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
	@Mock 
	JsonUtil jsonUtilMock;
	
	List<Direccion> direcciones;
	
	@Before
	public void setUp() throws Exception {
		empresaService = new EmpresaService();
		empresaService.setEmpresaDao(empresaDaoMock);
		when(empresaDaoMock.hasEmpleados(EMPRESA_ID)).thenReturn(false);
		when(empresaDaoMock.hasCoches(EMPRESA_ID)).thenReturn(false);
		empresaService.setJsonUtil(jsonUtilMock);
		buildDirecciones();
		when(jsonUtilMock.fromJsonToList(anyString(), any(TypeReferenceDireccionList.class))).thenReturn(direcciones);
	}


	private void buildDirecciones() {
		direcciones = new ArrayList<Direccion>();
		Direccion direccion = new Direccion();
		Direccion direccion2 = new Direccion();
		direcciones.add(direccion);
		direcciones.add(direccion2);
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
	public void buildEmpresa_construye_una_empresa_con_sus_direcciones_a_partir_del_json_de_direcciones() throws Exception {
		String direccionesJSON = "{}";
		Empresa empresa = new Empresa();
		Empresa builtEmpresa = empresaService.buildEmpresa(empresa, direccionesJSON);
		assertNotNull(builtEmpresa);
		assertEquals(2, builtEmpresa.getDirecciones().size());
		assertEquals(empresa,builtEmpresa.getDirecciones().get(0).getEmpresa());
	}
	
	@Test
	public void buildEmpresa_construye_una_empresa_sin_direcciones_si_el_json_de_direcciones_es_vacio() throws Exception {
		String direccionesJSON = "";
		Empresa empresa = new Empresa();
		Empresa builtEmpresa = empresaService.buildEmpresa(empresa, direccionesJSON);
		assertNotNull(builtEmpresa);
		assertNull(builtEmpresa.getDirecciones());
	}
	
	@Test
	public void buildEmpresa_construye_una_sin_direcciones_si_el_json_de_direcciones_esta_mal_formado() throws Exception {
		when(jsonUtilMock.fromJsonToList(anyString(), any(TypeReferenceDireccionList.class))).thenThrow(JsonUtilException.class);
		String direccionesJSON = "{}";
		Empresa empresa = new Empresa();
		Empresa empresaNew = empresaService.buildEmpresa(empresa, direccionesJSON);
		assertNotNull(empresaNew);
		assertNull(empresaNew.getDirecciones());
	}

}
