package innova4b.empresaReparto.empleado.repository;

import java.util.List;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.login.domain.Usuario;

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
	 
	public List<Empleado> list() {
		return (List<Empleado>) sessionFactory.getCurrentSession().createQuery("from Empleado").list();
	}
	
	public int insert(Empleado empleado) {
		//TODO - Obtener empresa con id = empleado.empresa
		return (Integer) sessionFactory.getCurrentSession().save(empleado);
	}
	
	public void update(Empleado empleado) {
		sessionFactory.getCurrentSession().update(empleado);
	}

	public void actualizarSubalternos(int id) {
		/*
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		String hqlUpdateJefeNull = "update empleado set jefe = NULL where id = :idUsuario";
		int updatedEntities = sessionFactory.getCurrentSession().createQuery( hqlUpdateJefeNull )
				.setInteger( "idUsuario", id )
		        .executeUpdate();
		tx.commit();
		*/
		sessionFactory.getCurrentSession().createQuery("update empleado set jefe = NULL where id ="+id).executeUpdate();
	}
}
