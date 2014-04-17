package innova4b.empresaReparto.empresa.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

@Component
public class EmpresaService {
	
	private static final Logger logger = Logger.getLogger(EmpresaService.class);
	
	@Autowired
	EmpresaDao empresaDao;

	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}

	public void delete(int id) throws EmpresaWithEmpleadosException, EmpresaWithCochesException {
		if (empresaDao.hasEmpleados(id)){
			logger.debug("La empresa con id= "+id+" contiene empleados y no se puede borrar");
			throw new EmpresaWithEmpleadosException("La empresa con id= "+id+" contiene empleados y no se puede borrar");
		}
		else if (empresaDao.hasCoches(id)){
			logger.debug("La empresa con id= "+id+" contiene coches y no se puede borrar");
			throw new EmpresaWithCochesException("La empresa con id= "+id+" contiene coches y no se puede borrar");
		}
		else	
			empresaDao.delete(id);
	}
	
	

}
