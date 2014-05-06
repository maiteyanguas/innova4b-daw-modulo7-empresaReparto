package innova4b.empresaReparto.empleado.service;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.incidencia.repository.IncidenciaDao;
import innova4b.empresaReparto.reserva.repository.ReservaDao;
import innova4b.empresaReparto.util.ProgramExceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;

	@Autowired
	EmpresaDao empresaDao;
	
	@Autowired
	IncidenciaDao incidenciaDao;
	
	@Autowired
	ReservaDao reservaDao;
	
	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public void delete(int id)throws ProgramExceptions{
		Empleado empleado=empleadoDao.get(id);
		
		if(reservaDao.empleadoTieneUnCocheOcupado(id)){
			System.out.println("1");
			if(incidenciaDao.empleadoEstaEnIncidenciasNoResueltas(empleado)){
				System.out.println("2");
				incidenciaDao.ponerEmpleadoCreacionNull(empleado);
				System.out.println("3");
				incidenciaDao.ponerEmpleadoResolucionNull(empleado);
				System.out.println("4");
			}
			System.out.println("5");
			
			if (empleadoDao.get(id).isJefe())
				empleadoDao.actualizarSubalternos(id);
			
			empleadoDao.delete(id);
			System.out.println("6");
			reservaDao.eliminarResevasFuturasDelEmpleado(id);

			System.out.println("7");
		}else{
			System.out.println("No sepuede borrar coche ocupado");
			throw new ProgramExceptions("No sepuede borrar coche ocupado");
			
		}
	}
	
	public List<Empleado> getJefes(){
		List<Empleado> jefes = new ArrayList<Empleado>();
		jefes.add(Empleado.buildJefeNulo());
		jefes.addAll(empleadoDao.listJefe());
		return jefes;
	}

	public Empleado buildEmpleado(Empleado empleado, int idJefe, int idEmpresa) {
		Empleado builtEmpleado = empleado;
		if (idJefe!=Empleado.JEFE_NULO_ID) {
			Empleado jefe= empleadoDao.get(idJefe);
			builtEmpleado.setJefe(jefe);
		}
		builtEmpleado.setEmpresa(empresaDao.get(idEmpresa));
		return builtEmpleado;
	} 

}
