package innova4b.empresaReparto.reserva.repository;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReservaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Reserva> list() {
		return (List<Reserva>) sessionFactory.getCurrentSession().createQuery("FROM Reserva").list();
	}
	
	public int insert (Reserva reserva) {
		return (Integer) sessionFactory.getCurrentSession().save(reserva);
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().delete(session.get(Reserva.class,id));
	}

	public boolean isCarFreeBetweenDates(Reserva reserva) {
		return sessionFactory.getCurrentSession().createQuery("FROM Reserva as r WHERE r.coche.id = :idCoche AND r.fechaInicioPrevista >= "+reserva.getFechaInicioPrevista()+" AND r.fechaDevolucionPrevista <= "+reserva.getFechaDevolucionPrevista()).setParameter("idCoche", reserva.getCoche().getId()).list().size()>0;
	}
	
	public boolean cocheHasReservas(Coche coche) {
		return sessionFactory.getCurrentSession().createQuery("FROM Reserva as r WHERE r.coche.id=:idCoche").setParameter(":idCoche", coche.getId()).list().size()>0;
	}
	
	public Reserva get(int id) {
		return (Reserva) sessionFactory.getCurrentSession().get(Reserva.class, id);
	}

	public void update(Reserva reserva) {
		sessionFactory.getCurrentSession().update(reserva);
	}

	public List<Reserva> getReservasSinDevolucion(Long id) {
		return (List<Reserva>) sessionFactory.getCurrentSession().createQuery("FROM Reserva as r WHERE r.fechaDevolucion IS NULL").list();
	}
	
}
