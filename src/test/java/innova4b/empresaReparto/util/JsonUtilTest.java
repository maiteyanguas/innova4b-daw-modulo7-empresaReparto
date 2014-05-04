package innova4b.empresaReparto.util;

import static org.junit.Assert.*;

import java.util.List;

import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.exceptions.JsonUtilException;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class JsonUtilTest {
	
	JsonUtil jsonUtil;
	
	ObjectMapper objectMapperSpy;
	
	@Before
	public void setUp() throws Exception {
		objectMapperSpy = new ObjectMapper();
		jsonUtil = new JsonUtil();
		jsonUtil.setObjectMapper(objectMapperSpy);
	}

	@Test
	public void fromJsonToList_deveulve_una_lista_de_direcciones_a_partir_de_un_json_de_direcciones() {
		String direccionesJSON = "[{\"id\":0,\"calle\":\"Renteria\",\"portal\":24,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Irun\"},"
								+ "{\"id\":0,\"calle\":\"Paseo Colon\",\"portal\":5,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Donostia\"}]";
		List<Direccion> direcciones = null;
		try {
			direcciones = (List<Direccion>) jsonUtil.fromJsonToList(direccionesJSON, TypeReferenceDireccionList.getInstance());
		} catch (JsonUtilException e) {
			fail();
		}
		assertNotNull(direcciones);
		assertEquals(2, direcciones.size());
	}
	
	@Test
	public void fromJsonToList_lanza_una_excepcion_si_el_json_de_direcciones_esta_mal_formado() {
		String direccionesJSON = "[{\"id\"\"calle\":\"Renteria\",\"portal\":24,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Irun\"},"
				+ "{\"id\":0,\"calle\":\"Paseo Colon\",\"portal\":5,\"piso\":null,\"letra\":\"\",\"otros\":\"\",\"codigoPostal\":null,\"municipio\":\"Donostia\"}]";
		try {
			List<Direccion> direcciones = (List<Direccion>) jsonUtil.fromJsonToList(direccionesJSON, TypeReferenceDireccionList.getInstance());	
		} catch (JsonUtilException e) {
			return;
		}
		fail();
		
	}
	

}
