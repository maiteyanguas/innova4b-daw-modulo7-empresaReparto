package innova4b.empresaReparto.coche.web;

import java.util.Date;

import javax.validation.Valid;

import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.reserva.domain.Reserva;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/coche")
@Controller
public class CocheController {

	@Autowired
	CocheDao cocheDao;
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/listWithOutIncidencias", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("coches", cocheDao.listWithOutIncidencia());	
	}
	
	//Lista los coches sin incidencias
	@RequestMapping(value = "/listWithOutIncidenciasFilter", method = RequestMethod.POST)
	public void listWithOutIncidenciaFilter(@RequestParam Date fechaInicio, @RequestParam Date fechaDevolucion, ModelMap model) {
		model.addAttribute("coches", cocheDao.listWithOutIncidenciaFilter(fechaInicio,fechaDevolucion));
	}

	//Lista todos los coches
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) {
		model.addAttribute("coches", cocheDao.listAll());	
	}
}
