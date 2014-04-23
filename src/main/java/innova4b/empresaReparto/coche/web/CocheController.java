package innova4b.empresaReparto.coche.web;

import innova4b.empresaReparto.coche.repository.CocheDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/coche")
@Controller
public class CocheController {

	@Autowired
	CocheDao cocheDao;
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("coches", cocheDao.listWithOutIncidencia());	
	}

	//Lista todos los coches
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) {
		model.addAttribute("coches", cocheDao.list());	
	}
}
