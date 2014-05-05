package innova4b.empresaReparto.incidencia.repository;


import java.util.List;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.incidencia.domain.Incidencia;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class IncidenciaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Incidencia getById(int idIncidencia) throws IndexOutOfBoundsException {
		return (Incidencia)sessionFactory.getCurrentSession().createQuery("from Incidencia where id=?").setInteger(0, idIncidencia).list().get(0);

	} 
	
	public List<Incidencia> list(int idCoche) throws IndexOutOfBoundsException {
		 
		return (List<Incidencia>)sessionFactory.getCurrentSession().createQuery("from Incidencia where coche_id="+idCoche).list();

	}  	
	
	public boolean empleadoEstaEnIncidenciasNoResueltas(long idEmpleado) throws IndexOutOfBoundsException {
		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from Incidencia where resuelta=:resuelta and (idUsuarioCreacion=:persona or idUsuarioResolucion=:persona)");
		query.setBoolean("resuelta", false);
		query.setLong("idUsuarioCreacion", idEmpleado);
		query.setLong("idUsuarioResolucion", idEmpleado);
		Long numElementos =(Long) query.uniqueResult();
		if(numElementos>0){return false;}
		return true;
	}
	
}
