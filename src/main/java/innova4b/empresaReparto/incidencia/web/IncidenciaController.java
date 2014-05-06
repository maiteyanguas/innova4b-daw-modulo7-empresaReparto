package innova4b.empresaReparto.incidencia.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.incidencia.repository.IncidenciaDao;
import innova4b.empresaReparto.login.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/incidencia")
@Controller
public class IncidenciaController {

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	IncidenciaDao incidenciaDao;
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(ModelMap model,@PathVariable("id") int idIncidencia) {
		model.addAttribute("incidencia", incidenciaDao.getById(idIncidencia));
		return "incidencia/show";
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String list(ModelMap model,@PathVariable("id") int idCoche) {
		model.addAttribute("incidencias", incidenciaDao.list(idCoche));
		return "incidencia/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editIncidencia(ModelMap model, @PathVariable("id") int id) {
		if (!model.containsKey("incidencia"))
			model.addAttribute("incidencia", incidenciaDao.getById(id));
		return "incidencia/edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Incidencia incidenciaActualizada, BindingResult result, RedirectAttributes redirect, HttpSession session) {
		Empleado empleado = empleadoDao.get(((Usuario)session.getAttribute("usuario")).getId());
		Incidencia incidencia = incidenciaDao.getById(incidenciaActualizada.getId());
		if (result.hasErrors()){
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.incidencia", result);
			redirect.addFlashAttribute("incidencia",incidenciaActualizada);
			return "redirect:/empresaReparto/incidencia/edit/"+incidenciaActualizada.getId();
		}
		incidenciaActualizada.setCoche(incidencia.getCoche());
		incidenciaActualizada.setEmpleadoCreacion(incidencia.getEmpleadoCreacion());
		incidenciaActualizada.setEmpleadoResolucion(empleado);	
		incidenciaActualizada.setResuelta(true);
		incidenciaDao.update(incidenciaActualizada);
		String resultado = "redirect:/empresaReparto/incidencia/list/"+incidenciaActualizada.getCoche().getId();
		return resultado;
	}

}
