package innova4b.empresaReparto.reserva.domain;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReservaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Reserva> list() {
		return (List<Reserva>) sessionFactory.getCurrentSession().createQuery("from Reserva").list();
	} 
	
	public List<Reserva> listBetweenDates(LocalDate dateFirst, LocalDate dateLast) {
		return (List<Reserva>) sessionFactory.getCurrentSession().createQuery("from Reserva where fechaInicio >= "+dateFirst+" and fechaDevolucionPrevista <= "+dateLast+"" ).list();
	}
	
	public int insert (Reserva reserva) {
		return (Integer) sessionFactory.getCurrentSession().save(reserva);
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().delete(session.get(Reserva.class,id));
	}

	public boolean isCarFreeBetweenDates(Reserva reserva, LocalDate dateFirst, LocalDate dateLast) {
		return sessionFactory.getCurrentSession().createQuery("from Reserva where coche = "+reserva.getCoche()+" fechaInicio >= "+dateFirst+" and fechaDevolucionPrevista <= "+dateLast+"" ).list().size()>0;
	}
	
	public Reserva get(int id) {
		return (Reserva) sessionFactory.getCurrentSession().get(Reserva.class, id);
	}

	public void update(Reserva reserva) {
		sessionFactory.getCurrentSession().update(reserva);
	}
	
}
