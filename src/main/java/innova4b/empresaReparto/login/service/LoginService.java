package innova4b.empresaReparto.login.service;

import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	EmpleadoDao empleadoDao;
	
	public void setEmpladoDao(EmpleadoDao empleadoDao){
		this.empleadoDao = empleadoDao;
	}

	public Usuario getUsuario(String usuario, String password) throws UserNotFoundException, IncorrectPasswordException {
		Usuario user;
		try {
			user = empleadoDao.getByUsuario(usuario);
		} catch(IndexOutOfBoundsException exception){
			logger.info("Intento de logueo con usuario incorrecto.");
			logger.info("Usuario: "+usuario);
			throw new UserNotFoundException("usuario no encontrado");
		}
		if (!user.getPassword().equals(password)){
			logger.info("Intento de logueo con password incorrecta.");
			logger.info("Usuario: "+usuario);
			logger.info("Password: "+password);
			throw new IncorrectPasswordException("password incorrecta");	
		}
		return user;
	}

}
