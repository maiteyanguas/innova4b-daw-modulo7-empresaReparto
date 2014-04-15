package innova4b.empresaReparto.login.web;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empleado.service.EmpleadoService;
import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@RequestMapping(value = "/new", method= RequestMethod.GET)
	public void newLogin(){}
	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public String addLogin(HttpSession session, @RequestParam String usuario, @RequestParam String password){
		session.removeAttribute("error");
		try {
			Empleado empleado = empleadoService.getUsuario(usuario,password);
			session.setAttribute("usuario", usuario);
			List<String> menu = new ArrayList<String>();
			menu.add("chuchu");
			menu.add("lala");
			menu.add("lolo");
			session.setAttribute("menu", menu);
			return "redirect:/empresaReparto/empresa/list";
		} catch (IncorrectPasswordException ipe) {
			session.setAttribute("error", ipe.getMessage());
		} catch (UserNotFoundException une) {
			session.setAttribute("error", une.getMessage());
		}
		return "redirect:/empresaReparto/login/new";
	}

}
