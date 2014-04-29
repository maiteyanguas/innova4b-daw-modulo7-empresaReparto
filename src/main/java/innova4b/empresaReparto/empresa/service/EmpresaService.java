package innova4b.empresaReparto.empresa.service;

import java.io.IOException;
import java.util.List;

import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public Empresa insert(Empresa empresa, String direccionesJSON) {
		if (!direccionesJSON.isEmpty()) {
			List<Direccion> direcciones = null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				direcciones = mapper.readValue(direccionesJSON,
						new TypeReference<List<Direccion>>() {
						});
			} catch (JsonParseException e) {
				logger.error("eror al convertir el json de direcciones: "
						+ direccionesJSON);
			} catch (JsonMappingException e) {
				e.printStackTrace();
				logger.error("eror al convertir el json de direcciones: "
						+ direccionesJSON);
			} catch (IOException e) {
				logger.error("eror al convertir el json de direcciones: "
						+ direccionesJSON);
			}
			if (direcciones!=null){
				for (Direccion direccion:direcciones)
					direccion.setEmpresa(empresa);
				empresa.setDirecciones(direcciones);
			}
		}
		empresaDao.insert(empresa);
		return empresa;
	}
}
