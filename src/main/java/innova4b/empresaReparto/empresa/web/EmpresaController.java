package innova4b.empresaReparto.empresa.web;

import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.empresa.repository.EmpresaDao;
import innova4b.empresaReparto.empresa.service.EmpresaService;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/empresa")
@Controller
public class EmpresaController {

	@Autowired
	EmpresaDao empresaDao;
	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("empresas", empresaDao.list());	
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void newEmpresa(ModelMap model) {
		model.addAttribute("empresa",new Empresa());
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmpresa(ModelMap model, @PathVariable("id") int id) {
		if (!model.containsKey("empresa"))
			model.addAttribute("empresa", empresaDao.get(id));
		return "empresa/edit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Empresa empresa, BindingResult result) {
		if (result.hasErrors())
			return "empresa/new";
		empresaDao.insert(empresa);
		return "redirect:/empresaReparto/empresa/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Empresa empresa, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()){
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.empresa", result);
			redirect.addFlashAttribute("empresa",empresa);
			return "redirect:/empresaReparto/empresa/edit/"+empresa.getId();
		}
		empresaDao.update(empresa);
		return "redirect:/empresaReparto/empresa/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {		
			try {
				empresaService.delete(id);
			} catch (EmpresaWithEmpleadosException e) {
				redirect.addFlashAttribute("error",e.getMessage());	
			} catch (EmpresaWithCochesException e) {
				redirect.addFlashAttribute("error",e.getMessage());	
			}
			return "redirect:/empresaReparto/empresa/list";
	}

}
