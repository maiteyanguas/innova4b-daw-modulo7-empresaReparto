package innova4b.empresaReparto.reserva.web;

import java.util.Iterator;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.exceptions.CocheNotFreeForReservationException;
import innova4b.empresaReparto.exceptions.LastDateNotFutureOfFirstDateException;
import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.reserva.domain.Reserva;
import innova4b.empresaReparto.reserva.repository.ReservaDao;
import innova4b.empresaReparto.reserva.service.ReservaService;

import javax.servlet.http.HttpSession;
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

@RequestMapping("/reserva")
@Controller
public class ReservaController {
	@Autowired
	ReservaDao reservaDao;
	@Autowired
	EmpleadoDao empleadoDao;
	@Autowired
	CocheDao cocheDao;
	@Autowired
	ReservaService reservaService;

	@RequestMapping(value = "/new/{idCoche}", method = RequestMethod.GET)
	public String newReserva(@PathVariable("idCoche") int idCoche, HttpSession session, ModelMap model) {		
		Coche coche = cocheDao.getCocheById(idCoche);
		Reserva reserva = new Reserva();
		reserva.setCoche(coche);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Empleado empleado = empleadoDao.get(usuario.getId());
		reserva.setEmpleado(empleado);
		model.addAttribute("reserva", reserva);		
		return "reserva/new";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReserva(@Valid Reserva reserva, BindingResult result, RedirectAttributes redirect) {
		System.out.println("TRACE:********************" + reserva.toString());
		if (result.hasErrors()) {
			System.out.println("TRACE:ERROR");
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("errorName: " + error.getObjectName() + "errorMessage: " + error.getDefaultMessage() + "errorToString: " + error.toString());
			}
			return "reserva/new";
		} try{
			System.out.println("TRACE:Not error" + reserva.toString());
			reservaService.insert(reserva);
		} catch (CocheNotFreeForReservationException coNotFreeEx) {
			redirect.addFlashAttribute("error", coNotFreeEx.getMessage());
		} catch (LastDateNotFutureOfFirstDateException LastDatNotFutOfFirstEx) {
			redirect.addFlashAttribute("error", LastDatNotFutOfFirstEx.getMessage());
		}
		return "redirect:/empresaReparto/coche/listWithOutIncidencias";
	}
	
	
}
