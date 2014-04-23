package innova4b.empresaReparto.empleado.service;

import innova4b.empresaReparto.empleado.repository.EmpleadoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public void delete(int id){
		//if (empleadoDao.get(id).isJefe())
		//	empleadoDao.borraSubalternos(id);
		empleadoDao.delete(id);
	}

}
