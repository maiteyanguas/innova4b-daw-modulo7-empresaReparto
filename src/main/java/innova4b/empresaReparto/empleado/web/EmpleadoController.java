package innova4b.empresaReparto.empleado.web;

import javax.validation.Valid;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/empleado")
@Controller
public class EmpleadoController {
	
	@Autowired
	EmpleadoDao empleadoDao;

	@Autowired
	EmpresaDao empresaDao;
	///@Autowired
	//EmpleadoService empleadoService;
	///
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("empleado", empleadoDao.list());	
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newEmpresa(ModelMap model) {
		model.addAttribute("empresa",empresaDao.list());
		model.addAttribute("empleado",new Empleado());
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmpleado(ModelMap model, @PathVariable("id") String id) {
		if (!model.containsKey("empleado"))
			model.addAttribute("empleado", empleadoDao.getByUsuario(id));
		return "empleado/edit";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Empleado empleado, BindingResult result) {
		if (result.hasErrors())
			return "empleado/new";
		empleadoDao.insert(empleado);
		return "redirect:/empresaReparto/empleado/list";
	}
	
}