package innova4b.empresaReparto.incidencia.service;

import java.util.List;

import innova4b.empresaReparto.exceptions.JsonUtilException;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.incidencia.repository.IncidenciaDao;
import innova4b.empresaReparto.reserva.domain.Reserva;
import innova4b.empresaReparto.reserva.repository.ReservaDao;
import innova4b.empresaReparto.util.JsonUtil;
import innova4b.empresaReparto.util.TypeReferenceDireccionList;


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
	
	public Reserva buildReserva(Reserva reserva, String incidenciasJSON) {
		if (!incidenciasJSON.isEmpty()) {
			List<Incidencia> incidencias = null;
			
			try {
				incidencias = (List<Incidencia>) jsonUtil.fromJsonToList(incidenciasJSON, TypeReferenceDireccionList.getInstance());
			} catch (JsonUtilException e) {
				logger.error("error al convertir el json de incidencias: "+ incidenciasJSON);
			}
					
			if (incidencias!=null){
				for (Incidencia incidencia:incidencias)
					incidenciaDao.insert(incidencia);
			}
		}
		return reserva;
	}
}
