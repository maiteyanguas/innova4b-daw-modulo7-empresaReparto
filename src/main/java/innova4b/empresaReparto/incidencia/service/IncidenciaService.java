package innova4b.empresaReparto.incidencia.service;

import java.util.List;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.exceptions.JsonUtilException;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.incidencia.repository.IncidenciaDao;
import innova4b.empresaReparto.reserva.repository.ReservaDao;
import innova4b.empresaReparto.util.JsonUtil;
import innova4b.empresaReparto.util.TypeReferenceIncidenciaList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncidenciaService {
	
	private static final Logger logger = Logger.getLogger(IncidenciaService.class);
	
	@Autowired
	ReservaDao reservaDao;
	
	@Autowired
	IncidenciaDao incidenciaDao;
	
	@Autowired
	JsonUtil jsonUtil;
	
	public void buildIncidencias(String incidenciasJSON, Empleado empleadoCreacion, Coche coche) {
		if (!incidenciasJSON.isEmpty()) {
			List<Incidencia> incidencias = null;
			
			try {
				incidencias = (List<Incidencia>) jsonUtil.fromJsonToList(incidenciasJSON, TypeReferenceIncidenciaList.getInstance());
			} catch (JsonUtilException e) {
				logger.error(e.getMessage() + ". Error al convertir el json de incidencias: "+ incidenciasJSON);
			}
								
			if (incidencias!=null && incidencias.size() > 0){
				for (Incidencia incidencia : incidencias) {
					incidencia.setEmpleadoCreacion(empleadoCreacion);
					incidencia.setCoche(coche);
					incidenciaDao.insert(incidencia);
				}
			}
		}
	}
}
