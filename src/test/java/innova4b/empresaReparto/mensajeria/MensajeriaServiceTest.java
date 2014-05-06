package innova4b.empresaReparto.mensajeria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MensajeriaServiceTest {
	
	MensajeriaService mensajeriaService;

	@Before
	public void setUp() throws Exception {
		mensajeriaService = new MensajeriaService();
	}

	@Test
	public void buildObjetoName_construye_el_nombre_del_objeto_a_partir_del_joinPoint() {
		String joinPoint="innova4b.empresaReparto.empresa.repository.empresaDao";
		assertEquals("empresa",mensajeriaService.buildObjetoName(joinPoint)); 
	}

}
