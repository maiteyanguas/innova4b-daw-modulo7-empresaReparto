package innova4b.empresaReparto.reserva.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.reserva.domain.Reserva;

import org.joda.time.LocalDate;
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
public class ReservaDaoIntegrationTest {
	
	private Reserva reserva;	
	
	
	@Autowired
	private ReservaDao reservaDao;
	
	@Before
	public void setUp(){
		reserva = new Reserva(100,0,null,null,new LocalDate("2014-04-09"),new LocalDate("2014-04-15"),null,null);
	}

	@Test
	public void insert_una_reserva_en_BD(){
		int kmIniciales = 150;
		reserva = new Reserva(kmIniciales,0,null,null,new LocalDate("2014-04-09"),new LocalDate("2014-04-15"),null,null);
		int id = reservaDao.insert(reserva);
		reserva = reservaDao.get(id);
		assertEquals(kmIniciales,reserva.getKmIniciales());
	}
	
	

}
