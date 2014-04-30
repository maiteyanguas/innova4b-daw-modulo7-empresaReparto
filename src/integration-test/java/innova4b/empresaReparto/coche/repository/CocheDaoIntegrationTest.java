package innova4b.empresaReparto.coche.repository;

import static org.junit.Assert.assertEquals;
import innova4b.empresaReparto.coche.domain.Coche;

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
	
	private static final int NUMERO_COCHES = 5;
	
	private Coche coche;
	
	@Autowired
	private CocheDao cocheDao;
	
	
	@Before
	public void setUp(){
		coche = new Coche();
		
		coche.setMatricula("5656TRE");
		coche.setCombustible("Gasolina");
		coche.setKms(499999);
		coche.setMarca("Honda");
		coche.setModelo("Civic");
		
	}
	
	@Test
	public void list_devuelve_una_lista_de_coches_2() {
		assertEquals(5,cocheDao.listAll().size());
	}
	
	@Test
	public void insert_inserta_un_coche_en_BD(){
		int id = cocheDao.insert(coche);
		
		assertEquals(NUMERO_COCHES+1,cocheDao.listAll().size());
		
	}
	

}
