package innova4b.empresaReparto.empleado.repository;

import java.util.List;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.login.domain.Usuario;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpleadoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Usuario getByUsuario(String usuario) throws IndexOutOfBoundsException {
		return (Usuario)sessionFactory.getCurrentSession().createQuery("from Usuario where usuario=?").setString(0, usuario).list().get(0);
	}
	
	public Empleado get(int id){
		return (Empleado) sessionFactory.getCurrentSession().get(Empleado.class, id);
	}
	
	public List<Empleado> listAdministradores(){
		return (List<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado where rol='a'").list();
	}
	 
	public List<Empleado> list() {
		return (List<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado e order by e.apellido1 asc, e.apellido2 asc").list();
	}
	
	public int insert(Empleado empleado) {
		return (Integer) sessionFactory.getCurrentSession().save(empleado);
	}
	
	public void update(Empleado empleado) {
		sessionFactory.getCurrentSession().update(empleado);
	}
	
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().delete(session.get(Empleado.class,id));
		return id;
	}

	public void actualizarSubalternos(int id) {
		sessionFactory.getCurrentSession().createQuery("update Empleado set jefe = NULL where jefe ="+id).executeUpdate();
	}
	public void eliminarRelacionJefe(int id) {
		sessionFactory.getCurrentSession().createQuery("update Empleado set jefe = NULL where id ="+id).executeUpdate();
	}
	public List<Empleado> listJefe() {
		return (List<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado where jefe = NULL and rol = 'u'").list();
	}
	public List<Empleado> listRange(int origen,int numElementos) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Empleado e order by e.apellido1 asc, e.apellido2 asc");
		query.setFirstResult(origen);
		query.setMaxResults(numElementos);
		return (List<Empleado>) query.list();
	}
	public Long numberOfEmpleados(){
		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from Empleado");
		return (Long) query.uniqueResult();

	}
}
