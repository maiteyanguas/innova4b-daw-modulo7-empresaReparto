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
import innova4b.empresaReparto.login.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	
	private static final int NUMERO_EMPLEADOS_POR_LISTA=10;
	private Long numeroEmpleados=(long) 0;
	private int numeroPaginas=0;
	
	private String empresaString = "%";
	private String apellido1 = "%";
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		
		numeroEmpleados=empleadoDao.numberOfEmpleados();
		List<Empleado> listaEmpleados=empleadoDao.listRange(0,NUMERO_EMPLEADOS_POR_LISTA,apellido1,empresaString);	
		numeroPaginas=0;
		if(listaEmpleados.size()>0){
			numeroPaginas= numeroEmpleados.intValue()/NUMERO_EMPLEADOS_POR_LISTA;
			if(numeroEmpleados.intValue()%NUMERO_EMPLEADOS_POR_LISTA >0){
				numeroPaginas++;
			}
		}
		model.addAttribute("empleadoFiltro",new Empleado());
		model.addAttribute("empresas", empresaDao.getEmpresas());
		model.addAttribute("numElementosMostrar",NUMERO_EMPLEADOS_POR_LISTA);
		model.addAttribute("numberOfPages", numeroPaginas);	
		model.addAttribute("responsePage", 1);	
		model.addAttribute("empleado", listaEmpleados);	
	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String listRango(ModelMap model, @PathVariable("id") int id) {
		System.out.println("page-->"+id);
		int posicionInicio=((id-1)*NUMERO_EMPLEADOS_POR_LISTA)+1;
		if(posicionInicio>numeroEmpleados){
			posicionInicio=0;
		}
		List<Empleado> listaEmpleados=empleadoDao.listRange(posicionInicio,NUMERO_EMPLEADOS_POR_LISTA,apellido1,empresaString);	
		numeroPaginas=0;
		if(listaEmpleados.size()>0){
			numeroPaginas= numeroEmpleados.intValue()/NUMERO_EMPLEADOS_POR_LISTA;
			if(numeroEmpleados.intValue()%NUMERO_EMPLEADOS_POR_LISTA >0){
				numeroPaginas++;
			}
		}
		model.addAttribute("empleadoFiltro",new Empleado());
		model.addAttribute("empresas", empresaDao.getEmpresas());
		model.addAttribute("numElementosMostrar",NUMERO_EMPLEADOS_POR_LISTA);
		model.addAttribute("numberOfPages", numeroPaginas);	
		model.addAttribute("responsePage", id);	
		model.addAttribute("empleado", listaEmpleados);	
		return "empleado/list";
	}	
	
	@RequestMapping(value = "/listaEmpleadoFiltro", method = RequestMethod.POST)
	public String listaEmpleadoFiltro(@Valid Empleado empleado, BindingResult result,RedirectAttributes redirect,@RequestParam int idEmpresa) {
		apellido1 = empleado.getApellido1();

		if (idEmpresa!=Empresa.EMPRESA_NULO_ID) empresaString = String.valueOf(idEmpresa);
		else empresaString = "%";
		if (apellido1.isEmpty()) apellido1 ="%";

		return "redirect:/empresaReparto/empleado/list";
	}	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newEmpleado(ModelMap model) {
	
		if (!model.containsKey("empleado"))
			model.addAttribute("empleado",new Empleado());
		model.addAttribute("jefes", empleadoService.getJefes());
		model.addAttribute("empresas", empresaDao.list());
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmpleado(ModelMap model, @PathVariable("id") int id) {
		if (!model.containsKey("empleado"))
			model.addAttribute("empleado", empleadoDao.get(id));
		model.addAttribute("jefes",empleadoService.getJefes());
		model.addAttribute("empresas", empresaDao.list());
		return "empleado/edit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Empleado empleado, BindingResult result,RedirectAttributes redirect,@RequestParam int idEmpresa, @RequestParam int idJefe) {
		Empleado builtEmpleado = empleadoService.buildEmpleado(empleado,idJefe,idEmpresa);
		if (result.hasErrors()){
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.empleado", result);
			redirect.addFlashAttribute("empleado",builtEmpleado);
			return "redirect:/empresaReparto/empleado/new";
		}
		try {
			empleadoDao.insert(builtEmpleado);
			return "redirect:/empresaReparto/empleado/list";
		} catch(Exception e) {
			result.rejectValue("usuario", "error.empleado", "El usuario ya est&aacute; en uso.");
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.empleado", result);
			redirect.addFlashAttribute("empleado",builtEmpleado);
			return "redirect:/empresaReparto/empleado/new";
		}
		
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Empleado empleado, BindingResult result, RedirectAttributes redirect, @RequestParam int idEmpresa, @RequestParam int idJefe) {
		Empleado builtEmpleado = empleadoService.buildEmpleado(empleado,idJefe,idEmpresa);
		if (result.hasErrors()){
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.empleado", result);
			redirect.addFlashAttribute("empleado",builtEmpleado);
			return "redirect:/empresaReparto/empleado/edit/"+empleado.getId();
		}
		empleadoDao.update(builtEmpleado);
		return "redirect:/empresaReparto/empleado/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {		
		
		empleadoService.delete(id);

		return "redirect:/empresaReparto/empleado/list";
	}

}
