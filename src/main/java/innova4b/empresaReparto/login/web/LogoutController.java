package innova4b.empresaReparto.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/logout")
@Controller
public class LogoutController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String logout(HttpSession session){
        if(session != null){
        	session.removeAttribute("usuario");
            session.invalidate();
        }
        return "redirect:/empresaReparto/login/new";
	}
}
