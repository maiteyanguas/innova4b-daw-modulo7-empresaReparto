package innova4b.empresaReparto.reserva.repository;

import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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
		return sessionFactory.getCurrentSession().createQuery("FROM Reserva WHERE coche = "+reserva.getCoche()+" AND fechaInicioPrevista >= "+reserva.getFechaInicio()+" AND fechaDevolucionPrevista <= "+reserva.getFechaDevolucionPrevista()+"").list().size()>0;
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
	public boolean empleadoTieneUnCocheOcupado(long idEmpleado){
		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from Reserva where empleado=:empleado and fechaInicio!=null and fechaDevolucion=null ");
		
		query.setLong("empleado", idEmpleado);
		Long numElementos =(Long) query.uniqueResult();
		if(numElementos>0){return false;}
		return true;
	}
	public void eliminarResevasFuturasDelEmpleado(int id){
		Date hoy=new Date();
		Query query = sessionFactory.getCurrentSession().createQuery("delete Reserva where empleado=:empleado and fechaInicioPrevista>:fechaInicio");
		query.setLong("empleado", id);
		query.setDate("fechaInicio", hoy);
		int result = query.executeUpdate();
	}
}
