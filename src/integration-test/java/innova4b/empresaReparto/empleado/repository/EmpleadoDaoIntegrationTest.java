package innova4b.empresaReparto.empleado.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.coche.repository.CocheDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class EmpleadoDaoIntegrationTest {
	
	@Autowired
	EmpleadoDao empleadoDao;

	@Test
	public void listAdministradores_devuelve_la_lista_de_administradores() {
		assertEquals(2, empleadoDao.listAdministradores().size());
	}

}
