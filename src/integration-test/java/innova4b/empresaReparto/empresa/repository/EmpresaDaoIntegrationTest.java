package innova4b.empresaReparto.empresa.repository;

import static org.junit.Assert.*;
import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

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
public class EmpresaDaoIntegrationTest {
	
	private static final int NUMERO_EMPRESAS = 5;
	private static final int EMPRESA_CON_COCHES_Y_EMPLEADOS = 4;
	private static final int EMPRESA_SIN_COCHES_NI_EMPLEADOS = 5;
	private Empresa empresa;	
	
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Before
	public void setUp(){
		empresa = new Empresa("chuchu","A123456B",943617317,"chuchu@lala.com","12/12/2013");
	}
	
	@Test
	public void list_devuelve_una_lista_de_empresas_2() {
		assertEquals(5,empresaDao.list().size());
	}
	
	@Test
	public void hasEmpleados_devuelve_si_una_empresa_tiene_empleados() {
		assertTrue(empresaDao.hasEmpleados(EMPRESA_CON_COCHES_Y_EMPLEADOS));
		assertFalse(empresaDao.hasEmpleados(EMPRESA_SIN_COCHES_NI_EMPLEADOS));
	}
	
	@Test
	public void hasCoches_devuelve_si_una_empresa_tiene_coches() {
		assertTrue(empresaDao.hasCoches(EMPRESA_CON_COCHES_Y_EMPLEADOS));
		assertFalse(empresaDao.hasCoches(EMPRESA_SIN_COCHES_NI_EMPLEADOS));
	}
	
	@Test
	public void insert_inserta_una_empresa_en_BD() {
		Direccion direccion1 = new Direccion("calle", 1, 1, "", "", 20301, "Irún", empresa);
		Direccion direccion2 = new Direccion("calle", 1, 1, "", "", 20301, "Irún", empresa);
		empresa.addDireccion(direccion1);
		empresa.addDireccion(direccion2);
		
		int id = empresaDao.insert(empresa);
		
		assertEquals(NUMERO_EMPRESAS+1,empresaDao.list().size());
		assertEquals(2,empresaDao.get(id).getDirecciones().size());
		
		empresaDao.delete(id);
	}
	
	@Test
	public void delete_borra_una_empresa_en_BD() {
		int id = empresaDao.insert(empresa);
		empresaDao.delete(id);
		
		assertEquals(NUMERO_EMPRESAS,empresaDao.list().size());
	}
	
	@Test
	public void get_devuelve_una_empresa_por_id(){
		assertNotNull(empresaDao.get(EMPRESA_CON_COCHES_Y_EMPLEADOS));
	}
	
	@Test
	public void update_actualiza_una_empresa_en_BD(){
		String nombre1 = "nombre1";
		empresa = new Empresa(nombre1,"A123456B",943617317,"chuchu@lala.com","12/12/2013");
		int id = empresaDao.insert(empresa);
		empresa = empresaDao.get(id);
		assertEquals(nombre1,empresa.getNombre());
		
		String nombre2 = "nombre2";
		empresa.setNombre("nombre2");
		empresaDao.update(empresa);
		assertEquals(nombre2,empresa.getNombre());
		
		empresaDao.delete(id);
	}
	
	

}
