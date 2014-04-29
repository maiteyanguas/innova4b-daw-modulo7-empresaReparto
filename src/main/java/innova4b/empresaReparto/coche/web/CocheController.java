package innova4b.empresaReparto.coche.web;

import javax.validation.Valid;

import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.coche.web.FiltroReserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/coche")
@Controller
public class CocheController {

	@Autowired
	CocheDao cocheDao;
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/listWithOutIncidencias", method = RequestMethod.GET)
	public void list(ModelMap model) {
		FiltroReserva filtro = new FiltroReserva();
		model.addAttribute("filtro", filtro);
		
		model.addAttribute("coches", cocheDao.listWithOutIncidencia());	
	}
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/listWithOutIncidenciasFilter", method = RequestMethod.POST)
	public void listWithOutIncidenciaFilter(@Valid FiltroReserva filtro, BindingResult result, ModelMap model) {
		model.addAttribute("coches", cocheDao.listWithOutIncidenciaFilter(filtro.getFechaInicioPrevista(),filtro.getFechaDevolucionPrevista()));
	}

	//Lista todos los coches
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) {
		model.addAttribute("coches", cocheDao.listAll());	
	}
}
