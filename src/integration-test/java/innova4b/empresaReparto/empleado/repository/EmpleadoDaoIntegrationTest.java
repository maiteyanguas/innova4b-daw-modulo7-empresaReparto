package innova4b.empresaReparto.empleado.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empresa.domain.Empresa;

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
	
	@Autowired EmpleadoDao empleadoDao;

	@Test
	public void list_recupera_empleados_y_empresas() {
		List<Empleado> empleados = empleadoDao.list();
		List<Empresa> empresas = new ArrayList<Empresa>();
		for (Empleado empleado: empleados){
			if (null!=empleado.getEmpresa() && !empresas.contains(empleado.getEmpresa()))
				empresas.add(empleado.getEmpresa());
		}
		assertEquals(16,empleados.size());
		assertEquals(4,empresas.size());
	}

}
