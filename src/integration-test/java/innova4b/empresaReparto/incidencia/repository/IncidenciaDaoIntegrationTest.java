package innova4b.empresaReparto.incidencia.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.incidencia.domain.Incidencia;

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
public class IncidenciaDaoIntegrationTest {
	
	private Incidencia incidencia;	
	
	
	@Autowired
	private IncidenciaDao incidenciaDao;
	
	@Before
	public void setUp(){
		incidencia = new Incidencia("Se ha pinchado la rueda", new LocalDate("2014-04-09"), new LocalDate("2014-04-10"),true, null/*Coche*/, null/*Empleado Creacion*/, null/*Empleado Resolucion*/, "Se ha cambiado la rueda");
	}
	
	@Test
	public void insert_una_incidencia_en_BD(){
		String descripcion = "Se ha pinchado la rueda";
		incidencia = new Incidencia(descripcion, new LocalDate("2014-04-09"), new LocalDate("2014-04-10"),true, null/*Coche*/, null/*Empleado Creacion*/, null/*Empleado Resolucion*/, "Se ha cambiado la rueda");
		int id = incidenciaDao.insert(incidencia);
		incidencia = incidenciaDao.getById(id);
		assertEquals(descripcion,incidencia.getDescripcion());
	}
	
	

}
