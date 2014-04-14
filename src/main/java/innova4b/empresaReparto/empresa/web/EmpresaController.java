package innova4b.empresaReparto.empresa.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	private List<String> empresas;
	
	public void setEmpresas(List<String> empresas){
		this.empresas = empresas;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("empresas", this.empresas);
		
	}

}
