package innova4b.empresaReparto.coche.web;

import javax.validation.Valid;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empresa.domain.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/coche")
@Controller
public class CocheController {

	@Autowired
	CocheDao cocheDao;
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/listWithOutIncidencias", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("coches", cocheDao.listWithOutIncidencia());	
	}

	//Lista todos los coches
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) {
		model.addAttribute("coches", cocheDao.listAll());	
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newCoche(ModelMap model) {
		model.addAttribute("coche",new Coche());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Coche coche, BindingResult result) {
		if (result.hasErrors())
			return "coche/new";
		cocheDao.insert(coche);
		return "redirect:/empresaReparto/coche/listAll";
	}
}
