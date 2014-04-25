package innova4b.empresaReparto.coche.web;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/coche")
@Controller
public class CocheController {

	@Autowired
	CocheDao cocheDao;
	
	@Autowired
	EmpresaDao empresaDao;
	
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
	public void newCoche(ModelMap model,Coche coche) {

		model.addAttribute("coche",coche);
		model.addAttribute("empresas", empresaDao.list());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Coche coche, BindingResult result, @RequestParam int idEmpresa) {
		Empresa empresa = empresaDao.get(idEmpresa);
		if (result.hasErrors())
			return "coche/new";
		coche.setEmpresa(empresa);
		cocheDao.insert(coche);
		return "redirect:/empresaReparto/coche/listAll";
	}
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String add(Coche coche) {
//		int idEmpresa = req
//		cocheDao.insert(coche);
//		return "redirect:/empresaReparto/coche/listAll";
//	}
}
