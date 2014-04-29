package innova4b.empresaReparto.incidencia.repository;

import static org.junit.Assert.*;

import java.util.Date;

import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.incidencia.domain.Incidencia;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.IndirectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class IncidenciaDaoIntegrationTest {
	

	@Autowired
	private IncidenciaDao incidenciasDao;
	
	@Before
	public void setUp(){
		Incidencia incidencia = new Incidencia();
		incidencia.setDescripcion("Se ha pinchado una rueda");
		incidencia.setFechaCreacion(LocalDate.now());
		incidencia.setResuelta(false);
	}
	
	@Test
	public void list_devuelve_una_lista_de_incidencias_de_un_coche() {
		assertEquals(2,incidenciasDao.list(2).size());
	}
			
	@Test
	public void get_devuelve_una_incidencia_por_id(){
		assertNotNull(incidenciasDao.getById(3));
	}
	
}
