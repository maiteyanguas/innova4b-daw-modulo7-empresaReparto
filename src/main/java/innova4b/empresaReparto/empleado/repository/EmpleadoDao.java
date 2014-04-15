package innova4b.empresaReparto.empleado.repository;

import innova4b.empresaReparto.login.domain.Usuario;

import org.hibernate.SessionFactory;
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

}
