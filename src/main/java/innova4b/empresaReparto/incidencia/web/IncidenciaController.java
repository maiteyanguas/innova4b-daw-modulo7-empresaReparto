package innova4b.empresaReparto.incidencia.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Direccion;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.incidencia.repository.IncidenciaDao;
import innova4b.empresaReparto.login.domain.Usuario;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@RequestMapping("/incidencia")
@Controller
public class IncidenciaController {

	@Autowired
	IncidenciaDao incidenciaDao;

	@Autowired
	EmpleadoDao empleadoDao;
	
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
//	@RequestMapping(value = "/new", method = RequestMethod.GET)
//	public void newEmpresa(ModelMap model) {
//		model.addAttribute("empresa",new Empresa());
//	}
//	
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String editEmpresa(ModelMap model, @PathVariable("id") int id) {
//		if (!model.containsKey("empresa"))
//			model.addAttribute("empresa", empresaDao.get(id));
//		return "empresa/edit";
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String add(@Valid Empresa empresa, BindingResult result) {
//		if (result.hasErrors())
//			return "empresa/new";
//		empresaDao.insert(empresa);
//		return "redirect:/empresaReparto/empresa/list";
//	}
//	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(@Valid Empresa empresa, BindingResult result, RedirectAttributes redirect) {
//		if (result.hasErrors()){
//			redirect.addFlashAttribute("org.springframework.validation.BindingResult.empresa", result);
//			redirect.addFlashAttribute("empresa",empresa);
//			return "redirect:/empresaReparto/empresa/edit/"+empresa.getId();
//		}
//		empresaDao.update(empresa);
//		return "redirect:/empresaReparto/empresa/list";
//	}
//	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {		
//			try {
//				empresaService.delete(id);
//			} catch (EmpresaWithEmpleadosException e) {
//				redirect.addFlashAttribute("error",e.getMessage());	
//			} catch (EmpresaWithCochesException e) {
//				redirect.addFlashAttribute("error",e.getMessage());	
//			}
//			return "redirect:/empresaReparto/empresa/list";
//	}

	
	@Autowired
    private MessageSource messageSource;
	
	@Autowired 
	private CookieLocaleResolver localResolver;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request, @Valid Incidencia incidencia, BindingResult result, HttpSession session) {
		Map<String,Object> response = new HashMap<String, Object>();	
		if (result.hasErrors()){
			Locale locale = localResolver.resolveLocale(request);
			response.put("respuesta", "ERROR");
			response.put("errores", getErrorMessages(result,locale));
		}else{
			response.put("respuesta", "OK");
			
			//Usuario usuario = (Usuario) session.getAttribute("usuario");
			//Empleado empleado = empleadoDao.get(usuario.getId());
			//incidencia.setEmpleadoCreacion(empleado);
			incidencia.setFechaCreacion(new LocalDate());
			response.put("incidencia",incidencia);
			response.put("incidenciaAsString", incidencia.getIncidenciaAsString());
		}
		return response;
	}
	
	private Map<String ,String> getErrorMessages(BindingResult result, Locale locale) {
		Map<String ,String> errors = new HashMap<String, String>();
		List<FieldError> fieldErrors = result.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
		    String[] resolveMessageCodes = result.resolveMessageCodes(fieldError.getCode());
		    String string = resolveMessageCodes[0];
			String message = messageSource.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, locale);
		    errors.put(fieldError.getField(), message);
		}
		return errors;
	}
}
