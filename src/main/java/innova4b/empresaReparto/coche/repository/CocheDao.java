package innova4b.empresaReparto.coche.repository;

import innova4b.empresaReparto.coche.domain.Coche;

import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CocheDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//Falta implementar bien la lista
	public List<Coche> listWithOutIncidencia() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche as c where size(c.incidencias)=0").list();
	} 
	
	//Falta implementar bien la lista
	public List<Coche> listWithOutIncidenciaFilter(LocalDate dateFirst, LocalDate dateLast) {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche as c where size(c.incidencias)=0 fechaInicioPrevista >= "+dateFirst+" AND fechaDevolucionPrevista <= "+dateLast+" ").list();
	}	

	public List<Coche> listAll() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche").list();
	} 
}
