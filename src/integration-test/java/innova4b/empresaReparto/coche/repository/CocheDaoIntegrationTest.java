package innova4b.empresaReparto.coche.repository;

import static org.junit.Assert.*;

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
public class CocheDaoIntegrationTest {

	@Autowired
	CocheDao cocheDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void listDisponibles_devuelve_todos_los_coches_sin_incidencias_pendientes() {
		assertEquals(4, cocheDao.listDisponibles().size());
	}

}
