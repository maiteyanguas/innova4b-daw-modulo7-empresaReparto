package innova4b.empresaReparto.empleado.web;

import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/empleado")
@Controller
public class EmpleadoController {
	
	@Autowired
	EmpleadoDao empleadoDao;

	///@Autowired
	//EmpleadoService empleadoService;
	///
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("empleado", empleadoDao.list());	
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newEmpresa(ModelMap model) {
		model.addAttribute("empleado",new Empresa());
	}
	
	
}
