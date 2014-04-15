package innova4b.empresaReparto.empleado.repository;

import innova4b.empresaReparto.empleado.domain.Empleado;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpleadoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Empleado getByUsuario(String usuario) throws IndexOutOfBoundsException {
		return (Empleado)sessionFactory.getCurrentSession().createQuery("from Empleado where usuario=?").setString(0, usuario).list().get(0);
	} 

}
