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
	

}
