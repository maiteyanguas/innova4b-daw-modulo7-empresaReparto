package innova4b.empresaReparto.empleado.service;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;

	public Empleado getUsuario(String usuario, String password) throws UserNotFoundException, IncorrectPasswordException {
		Empleado empleado;
		try {
			empleado = empleadoDao.getByUsuario(usuario);
		} catch(IndexOutOfBoundsException exception){
			System.out.println("logueo");
			throw new UserNotFoundException("usuario no encontrado");
		}
		if (!empleado.getPassword().equals(password)){
			System.out.println("logueo");
			throw new IncorrectPasswordException("password incorrecta");	
		}
		return empleado;
	}

}
