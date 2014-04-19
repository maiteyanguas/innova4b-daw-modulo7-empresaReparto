package innova4b.empresaReparto.empresa.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {
	
	Empresa empresa;
	Direccion direccion1;
	Direccion direccion2;
	
	@Before
	public void setUp() throws Exception {
		empresa = new Empresa("chuchu","A1234567B",943112233,"info@chuchu","25/11/1998");
		direccion1 = new Direccion("calle", 1, 1, "", "", 20301, "Irún", empresa);
		direccion2 = new Direccion("calle", 1, 1, "", "", 20301, "Irún", empresa);
	}

	@Test
	public void getDireccionPrincipal_devuelve_nulo_si_la_empresa_no_tiene_direccion() {
		assertNull(empresa.getDireccionPrincipal());
	}
	
	@Test
	public void getDireccionPrincipal_devuelve_una_direccion_cualquiera_en_caso_de_que_no_se_defina_ningua(){
		empresa.addDireccion(direccion1);
		empresa.addDireccion(direccion2);
		
		assertNotNull(empresa.getDireccionPrincipal());	
	}
	
	@Test
	public void getDireccionPrincipal_devuelve_una_direccion_cualquiera_en_caso_de_que_haya_definada_más_de_una(){
		direccion1.setPrincipal(true);
		direccion2.setPrincipal(true);
		empresa.addDireccion(direccion1);
		empresa.addDireccion(direccion2);
		
		assertNotNull(empresa.getDireccionPrincipal());	
	}
	
	@Test
	public void getDireccionPrincipal_devuelve_la_direccion_principal(){
		direccion1.setPrincipal(false);
		direccion2.setPrincipal(true);
		empresa.addDireccion(direccion1);
		empresa.addDireccion(direccion2);
		
		assertEquals(direccion2, empresa.getDireccionPrincipal());	
	}
}
