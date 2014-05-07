package innova4b.empresaReparto.coche.service;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.login.domain.Usuario;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CocheService {
	
	@Autowired
	EmpleadoDao empleadoDao;
	@Autowired
	CocheDao cocheDao;
	
	public List<Coche> listDisponibles(Usuario usuario){
		List<Coche> coches = new ArrayList<Coche>();
		if (usuario.isAdministrador())
			coches = cocheDao.listDisponibles();	
		else
			coches = cocheDao.listDisponiblesByEmpresa(empleadoDao.get(usuario.getId()).getEmpresa());
		return coches;
	}
	
	public List<Coche> listDisponiblesBetweenDates(LocalDate fechaInicio, LocalDate fechaDevolucion, Usuario usuario){
		List<Coche> coches = new ArrayList<Coche>();
		if (usuario.isAdministrador())
			coches = cocheDao.listDisponiblesBetweenDates(fechaInicio, fechaDevolucion);	
		else
			coches = cocheDao.listDisponiblesByEmpresaBetweenDates(fechaInicio, fechaDevolucion, empleadoDao.get(usuario.getId()).getEmpresa());
		return coches;
	}
	
	public List<Coche> getCochesFiltrados(String eleccionCombo,int idEmpresa, String eleccionEmpresa, String matricula) {
		List<Coche>  coches = new ArrayList<Coche>();
		if (eleccionCombo.equals("incidenciasPendientes")){
			coches = (List<Coche>) cocheDao.listWithIncidencias();
		} else if (eleccionCombo.equals("empresa")){
			coches = getCochesFiltradosPorEmpresa(idEmpresa, eleccionEmpresa, coches);
		}else if (eleccionCombo.equals("matricula")){
			coches=(List<Coche>) cocheDao.listWithMatricula(matricula);
		}else{
			coches = (List<Coche>) cocheDao.listAll();
		}
		return coches;
	}

	private List<Coche> getCochesFiltradosPorEmpresa(int idEmpresa, String eleccionEmpresa, List<Coche> coches) {
		if (eleccionEmpresa.equals("todos")){
			coches = (List<Coche>) cocheDao.listWithEmpresa(idEmpresa);	
		}else if(eleccionEmpresa.equals("conIncidencia")){
			coches=(List<Coche>) cocheDao.listWithEmpresaConIncidencias(idEmpresa);	
		}else if(eleccionEmpresa.equals("sinIncidencia")){
			coches=(List<Coche>) cocheDao.listWithEmpresaSinIncidencias(idEmpresa);
		}
		return coches;
	}

}
