package innova4b.empresaReparto.empleado.web;

import java.util.List;

import javax.validation.Valid;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empleado.service.EmpleadoService;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/empleado")
@Controller
public class EmpleadoController {
	
	@Autowired
	EmpleadoDao empleadoDao;
	@Autowired
	EmpresaDao empresaDao;
	@Autowired
	EmpleadoService empleadoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("empleado", empleadoDao.list());	
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newEmpleado(ModelMap model) {
		model.addAttribute("empleado",new Empleado());
		model.addAttribute("empresas", empresaDao.list());
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmpleado(ModelMap model, @PathVariable("id") int id) {
		if (!model.containsKey("empleado"))
			model.addAttribute("empleado", empleadoDao.get(id));
		return "empleado/edit";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Empleado empleado, BindingResult result, @RequestParam int idEmpresa) {
		Empresa emp = empresaDao.get(idEmpresa);
		empleado.setEmpresa(emp);
		if (result.hasErrors())
			return "empleado/new";
		empleadoDao.insert(empleado);
		return "redirect:/empresaReparto/empleado/list";
	}

	@RequestMapping(value = "/addJefe", method = RequestMethod.POST)
	public String addJefe(@Valid Empleado empleado, BindingResult result) {
		if (result.hasErrors())
			return "empleado/new";
		empleadoDao.insert(empleado);
		return "redirect:/empresaReparto/empleado/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {		
		
		empleadoService.delete(id);

		return "redirect:/empresaReparto/empleado/list";
	}

}
