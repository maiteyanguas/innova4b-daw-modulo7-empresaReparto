package innova4b.empresaReparto.coche.repository;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empresa.domain.Empresa;

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
	
	public List<Coche> listDisponibles() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche as c where c.id not in (select distinct(i.coche.id) from Incidencia i where i.resuelta=0)").list();
	} 
	
	//TODO: Implementar la busqueda: coches de la empresa sin incidencias pendientes
	public List<Coche> listDisponiblesByEmpresa(Empresa empresa) {
		return null;
	}
	
	//TODO: Implementar bien la busqueda: coches sin incidencias pendientes y sin reserva en esas fechas
	public List<Coche> listDisponiblesBetweenDates(LocalDate fechaInicio, LocalDate fechaDevolucion) {
		String hql = 	" Select c " +
						"FROM Coche as c " +
						"LEFT JOIN c.reservas as r " + 
						"WHERE size(c.incidencias)=0 " +
						"AND ( " +
							"size(c.reservas) = 0 " +
							"OR " +
							"( " +
								"r.fechaInicioPrevista not between :fechaInicio and :fechaDevolucion " +
								"AND r.fechaDevolucionPrevista not between :fechaInicio and :fechaDevolucion " +
								"AND :fechaInicio not between r.fechaInicioPrevista and r.fechaDevolucionPrevista " +
								"AND :fechaDevolucion not between r.fechaInicioPrevista and r.fechaDevolucionPrevista " +
							") " +
						")";		
		
		return (List<Coche>) sessionFactory.getCurrentSession().createQuery(hql)
		.setParameter("fechaInicio", fechaInicio)
		.setParameter("fechaDevolucion", fechaDevolucion)
		.list();	
	}	

	//TODO: Implementar la busqueda: coches de la empresa sin incidencias pendientes y sin reserva en esas fechas
	public List<Coche> listDisponiblesByEmpresaBetweenDates(LocalDate fechaInicio, LocalDate fechaDevolucion, Empresa empresa) {
		return null;
	}
	
	public List<Coche> listAll() {
		return (List<Coche>)sessionFactory.getCurrentSession().createQuery("from Coche").list();

	}
	
	public Coche getCocheById(int idCoche){
		Coche c = (Coche)sessionFactory.getCurrentSession().createQuery("from Coche where id=" + idCoche).list().get(0);
		return c;
	}

	
	public int insert (Coche coche) {
		return (Integer) sessionFactory.getCurrentSession().save(coche);
	}
	
}
