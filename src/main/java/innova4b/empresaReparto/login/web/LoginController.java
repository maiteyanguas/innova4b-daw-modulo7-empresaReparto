package innova4b.empresaReparto.login.web;

import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;
import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.login.service.LoginService;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	HashMap<String,String> menuUsuario;
	@Autowired
	HashMap<String,String> menuAdministrador;
	
	@RequestMapping(value = "/new", method= RequestMethod.GET)
	public void newLogin(ModelMap model){
		model.addAttribute("usuario",new Usuario());
	}
	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public String addLogin(HttpSession session, @Valid Usuario usuario, BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return "login/new";
		}
		try {
			Usuario user = loginService.getUsuario(usuario.getUsuario(),usuario.getPassword());
			session.setAttribute("usuario", user);
			if (user.isAdministrador())
				session.setAttribute("menu", menuAdministrador);
			else
				session.setAttribute("menu", menuUsuario);
			return "redirect:/empresaReparto/empresa/list";
		} catch (IncorrectPasswordException ipe) {
			redirect.addFlashAttribute("error", ipe.getMessage());
		} catch (UserNotFoundException une) {
			redirect.addFlashAttribute("error", une.getMessage());
		}
		return "redirect:/empresaReparto/login/new";
	}

}
