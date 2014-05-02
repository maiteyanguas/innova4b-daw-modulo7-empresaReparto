package innova4b.empresaReparto.coche.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.coche.service.CocheService;
import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.reserva.domain.FiltroReserva;
import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/coche")
@Controller
public class CocheController {
	@Autowired
	CocheDao cocheDao;
	@Autowired
	EmpresaDao empresaDao;
	@Autowired
	CocheService cocheService;

	
	@RequestMapping(value = "/listDisponibles", method = RequestMethod.GET)
	public void listDisponibles( HttpSession session, ModelMap model) {
		if (!model.containsKey("filtro"))
			model.addAttribute("filtro", new FiltroReserva());
		model.addAttribute("coches", cocheService.listDisponibles((Usuario) session.getAttribute("usuario")));				
	}
	
	@RequestMapping(value = "/listDisponiblesFilter", method = RequestMethod.POST)
	public String listDisponiblesFilter(@Valid FiltroReserva filtro, BindingResult result, RedirectAttributes redirect, ModelMap model) {
		if(result.hasErrors()) {
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.filtro", result);
			redirect.addFlashAttribute("filtro",filtro);
			return "redirect:/empresaReparto/coche/listDisponibles";
		}
		
		model.addAttribute("coches", cocheDao.listDisponiblesBetweenDates(filtro.getFechaInicioPrevista(),filtro.getFechaDevolucionPrevista()));
		model.addAttribute("filtro", filtro);
		
		return "coche/listDisponibles";
	}

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
	public String add(ModelMap model,@Valid Coche coche, BindingResult result, @RequestParam int idEmpresa) {
		Empresa empresa = empresaDao.get(idEmpresa);
		if (result.hasErrors()){
			model.addAttribute("empresas", empresaDao.list());
			return "coche/new";}
		coche.setEmpresa(empresa);
		cocheDao.insert(coche);
		return "redirect:/empresaReparto/coche/listAll";
	}
}
