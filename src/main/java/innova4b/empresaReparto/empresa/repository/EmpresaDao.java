package innova4b.empresaReparto.empresa.repository;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.empresa.domain.Empresa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpresaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Empresa> list() {
		return (List<Empresa>)sessionFactory.getCurrentSession().createQuery("from Empresa").list();
	} 
	
	public int insert (Empresa empresa) {
		return (Integer) sessionFactory.getCurrentSession().save(empresa);
	}

	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().delete(session.get(Empresa.class,id));
		return id;
	}

	public boolean hasEmpleados(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Empleado where empresa_id="+id).list().size()>0;
	}

	public boolean hasCoches(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Coche where empresa_id="+id).list().size()>0;
	}

	public Empresa get(int id) {
		return (Empresa) sessionFactory.getCurrentSession().get(Empresa.class, id);
	}

	public void update(Empresa empresa) {
		sessionFactory.getCurrentSession().update(empresa);
	}
	
	
	public List<Empresa> getEmpresas(){
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas.add(Empresa.buildEmpresaNulo());
		empresas.addAll(list());
		return empresas;
	}

}
