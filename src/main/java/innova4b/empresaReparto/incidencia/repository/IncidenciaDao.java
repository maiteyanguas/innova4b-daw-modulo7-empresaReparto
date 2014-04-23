package innova4b.empresaReparto.incidencia.repository;


import innova4b.empresaReparto.incidencia.domain.Incidencia;

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
//		return (Incidencia)sessionFactory.getCurrentSession().createQuery("from Incidencia").list().get(0);

	} 

	public Incidencia get(int id){
		return (Incidencia) sessionFactory.getCurrentSession().get(Incidencia.class, id);
	}
	
}
