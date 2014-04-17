package innova4b.empresaReparto.login.service;

import static org.junit.Assert.*;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;
import innova4b.empresaReparto.login.domain.Usuario;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	private static final String PASSWORD = "password";
	private static final String USUARIO = "usuario";
	private Usuario user;
	LoginService loginService;
	@Mock
	private EmpleadoDao empledaoDaoMock;
	
	@Before
	public void setUp() throws Exception {
		user = new Usuario();
		loginService = new LoginService();
		loginService.setEmpladoDao(empledaoDaoMock);	
	}

	@Test
	public void getUsuario_devuelve_el_usuario_si_el_usuario_y_password_son_correctos() throws UserNotFoundException, IncorrectPasswordException {
		user.setUsuario(USUARIO);
		user.setPassword(PASSWORD);
		when(empledaoDaoMock.getByUsuario(USUARIO)).thenReturn(user);
		
		assertEquals(user, loginService.getUsuario(USUARIO, PASSWORD));
	}
	
	@Test
	public void getUsuario_lanza_excepcion_si_el_usuario_es_incorrecto()  {
		when(empledaoDaoMock.getByUsuario(USUARIO)).thenThrow(IndexOutOfBoundsException.class);
		try {
			loginService.getUsuario(USUARIO, PASSWORD);
		} catch (UserNotFoundException e) {
			return;
		} catch (IncorrectPasswordException e) {
			fail();
		}
		fail();
	}
	
	@Test
	public void getUsuario_lanza_excepcion_si_el_password_es_incorrecto()  {
		user.setUsuario(USUARIO);
		user.setPassword("chuchu");
		when(empledaoDaoMock.getByUsuario(USUARIO)).thenReturn(user);
		try {
			loginService.getUsuario(USUARIO, PASSWORD);
		} catch (UserNotFoundException e) {
			fail();
		} catch (IncorrectPasswordException e) {
			return;
		}
		fail();
	}


}
