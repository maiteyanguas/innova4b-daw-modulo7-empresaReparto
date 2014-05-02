package innova4b.empresaReparto.empresa.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import innova4b.empresaReparto.empresa.domain.Direccion;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@RequestMapping("/direccion")
@Controller
public class DireccionController {

	@Autowired
    private MessageSource messageSource;
	
	@Autowired 
	private CookieLocaleResolver localResolver;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request, @Valid Direccion direccion, BindingResult result) {
		Map<String,Object> response = new HashMap<String, Object>();	
		if (result.hasErrors()){
			Locale locale = localResolver.resolveLocale(request);
			response.put("respuesta", "ERROR");
			response.put("errores", getErrorMessages(result,locale));
		}else{
			response.put("respuesta", "OK");
			response.put("direccion",direccion);
			response.put("direccionAsString", direccion.getDireccionAsString());
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
