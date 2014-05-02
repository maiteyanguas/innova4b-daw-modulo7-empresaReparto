package innova4b.empresaReparto.reserva.service;

import innova4b.empresaReparto.exceptions.CocheNotFreeForReservationException;
import innova4b.empresaReparto.exceptions.LastDateNotFutureOfFirstDateException;
import innova4b.empresaReparto.reserva.domain.Reserva;
import innova4b.empresaReparto.reserva.repository.ReservaDao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaService {
	
	private static final Logger logger = Logger.getLogger(ReservaService.class);
	
	@Autowired
	ReservaDao reservaDao;

	public void setEmpresaDao(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}

	public void insert(Reserva reserva) throws CocheNotFreeForReservationException, LastDateNotFutureOfFirstDateException  {
		
		if (reserva.getFechaDevolucionPrevista().isBefore(reserva.getFechaInicioPrevista())) {
			String errorMsg = "La fecha de devolucion prevista no puede ser inferior a la fecha de inicio prevista.";
			logger.debug(errorMsg);
			throw new LastDateNotFutureOfFirstDateException(errorMsg);			
		}
		else if (!reservaDao.isCarFreeBetweenDates(reserva)){
			String errorMsg = "El coche con matricula \""+reserva.getCoche().getMatricula()+"\" no esta disponible en las fechas solicitadas.";
			logger.debug(errorMsg);
			throw new CocheNotFreeForReservationException(errorMsg);
		}
		else 
		{
			//TODO: Implementar la reserva
			//int id = reservaDao.insert(reserva);
		}
		
	}
	
}
