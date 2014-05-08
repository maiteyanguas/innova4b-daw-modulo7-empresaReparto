package innova4b.empresaReparto.coche.service;

import java.util.ArrayList;
import java.util.List;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.reserva.repository.ReservaDao;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CocheService {
	
	 static final String FILTRO_COCHES_SIN_INCIDENCIA_POR_EMPRESA = "sinIncidencia";
	 static final String FILTRO_COCHES_CON_INCIDENCIA_POR_EMPRESA = "conIncidencia";
	 static final String FILTRO_TODOS_COCHES_POR_EMPRESA = "todos";
	 static final String FILTRO_INCIDENCIAS_PENDIENTES = "incidenciasPendientes";
	 static final String FILTRO_MATRICULA = "matricula";
	 static final String FILTRO_EMPRESA = "empresa";
	
	@Autowired
	EmpleadoDao empleadoDao;
	@Autowired
	CocheDao cocheDao;
	@Autowired
	ArrayList<String> marcas;
	@Autowired
	ReservaDao reservaDao;
	
	public void setCocheDao(CocheDao cocheDao) {
		this.cocheDao = cocheDao;
	}
	
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
		if (eleccionCombo.equals(FILTRO_INCIDENCIAS_PENDIENTES)){
			coches = (List<Coche>) cocheDao.listWithIncidencias();
		} else if (eleccionCombo.equals(FILTRO_EMPRESA)){
			coches = getCochesFiltradosPorEmpresa(idEmpresa, eleccionEmpresa, coches);
		}else if (eleccionCombo.equals(FILTRO_MATRICULA)){
			coches=(List<Coche>) cocheDao.listWithMatricula(matricula);
		}else{
			coches = (List<Coche>) cocheDao.listAll();
		}
		return coches;
	}

	private List<Coche> getCochesFiltradosPorEmpresa(int idEmpresa, String eleccionEmpresa, List<Coche> coches) {
		if (eleccionEmpresa.equals(FILTRO_TODOS_COCHES_POR_EMPRESA)){
			coches = (List<Coche>) cocheDao.listWithEmpresa(idEmpresa);	
		}else if(eleccionEmpresa.equals(FILTRO_COCHES_CON_INCIDENCIA_POR_EMPRESA)){
			coches=(List<Coche>) cocheDao.listWithEmpresaConIncidencias(idEmpresa);	
		}else if(eleccionEmpresa.equals(FILTRO_COCHES_SIN_INCIDENCIA_POR_EMPRESA)){
			coches=(List<Coche>) cocheDao.listWithEmpresaSinIncidencias(idEmpresa);
		}
		return coches;
}

	public List<String> getMarcasEncontradas(String query) {

		query = query.toLowerCase();

		List<String> marcas_encontradas = new ArrayList<String>();

		for (String marca : marcas) {
			if (marca.toLowerCase().startsWith(query)) {
				marcas_encontradas.add(marca);
			}
		}

		return marcas_encontradas;
	}
	
	public void deleteCoche(Coche coche){
		reservaDao.deleteCoche(coche);
		cocheDao.delete(coche);
	}

}
