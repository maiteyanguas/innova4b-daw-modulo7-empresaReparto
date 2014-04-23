package innova4b.empresaReparto.coche.repository;

import innova4b.empresaReparto.coche.domain.Coche;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CocheDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Coche> listWithOutIncidencia() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche as c where size(c.incidencias)=0").list();
	} 

	public List<Coche> list() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche").list();
	} 
}
