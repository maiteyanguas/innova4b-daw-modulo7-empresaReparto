package innova4b.empresaReparto.empleado.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
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
public class EmpleadoDaoIntegrationTest {
	
	@Autowired
	EmpleadoDao empleadoDao;
	@Autowired
	EmpresaDao empresaDao;

	@Test
	public void listAdministradores_devuelve_la_lista_de_administradores() {
		assertEquals(2, empleadoDao.listAdministradores().size());
	}
	
	@Test
	public void delete_borra_un_empleado() {
		LocalDate fechaNacimiento = LocalDate.parse("25/11/1988",org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
		Empleado empleado = new Empleado("usuario","password","a",1,"44554499A","nombre","apellido1","apellido2",
										fechaNacimiento,"943998877","prueba@prueba.com");
		empleado.setJefe(empleadoDao.get(17));
		empleado.setEmpresa(empresaDao.get(1));
		int id = empleadoDao.insert(empleado);
		assertNotNull(empleadoDao.get(id));
		
		empleadoDao.delete(id);
		
		assertNull(empleadoDao.get(id));
	}


}
