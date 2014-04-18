package innova4b.empresaReparto.empresa.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class EmpresaDaoIntegrationTest {
	
	@Autowired
	private EmpresaDao empresaDao;
	
//	@Test
//	public void list_devuelve_una_lista_de_empresas() {
//		assertEquals(5,empresaDao.list().size());
//	}
//	
//	@Test
//	public void hasEmpleados_devuelve_si_una_empresa_tiene_empleados() {
//		assertTrue(empresaDao.hasEmpleados(4));
//		assertFalse(empresaDao.hasEmpleados(5));
//	}
//	
//	@Test
//	public void hasCoches_devuelve_si_una_empresa_tiene_coches() {
//		assertTrue(empresaDao.hasCoches(4));
//		assertFalse(empresaDao.hasCoches(5));
//	}
	
	@Test
	public void insert_inserta_un_coche_en_BD() {
		Empresa empresa = new Empresa("chuchu","A123456B",943617317,"chuchu@lala.com","12/12/2013");
		
		empresaDao.insert(empresa);
		
		assertEquals(6,empresaDao.list().size());
	}
	
	
	

}
