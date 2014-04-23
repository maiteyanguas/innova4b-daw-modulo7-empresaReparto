package innova4b.empresaReparto.reserva.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.exceptions.IncorrectPasswordException;
import innova4b.empresaReparto.exceptions.UserNotFoundException;
import innova4b.empresaReparto.login.domain.Usuario;
import innova4b.empresaReparto.reserva.domain.Reserva;
import innova4b.empresaReparto.reserva.repository.ReservaDao;
import innova4b.empresaReparto.reserva.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		//Coche coche = cocheDao.getCoche(idCoche);		@FIXME
		Reserva reserva = new Reserva();
		//reserva.setCoche(coche); @FIXME
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		//Empleado empleado = empleadoDao.getEmpleadoById(usuario.getId());  @FIXME
		model.addAttribute("reserva", reserva);	
		return "reserva/new";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReserva(@Valid Reserva reserva, BindingResult result) {
		if (result.hasErrors())
			return "reserva/new";
		/*try{ @FIXME
			reservaService.insert(reserva);
		} catch (CocheNotFreeForReservationException coNotFreeEx) {
			redirect.addFlashAttribute("error", coNotFreeEx.getMessage());
		} catch (LastDateNotFutureOfFirstDateException LastDatNotFutOfFirstEx) {
			redirect.addFlashAttribute("error", LastDatNotFutOfFirstEx.getMessage());
		}*/
		return "redirect:/empresaReparto/coche/list";
	}
	
	
}
