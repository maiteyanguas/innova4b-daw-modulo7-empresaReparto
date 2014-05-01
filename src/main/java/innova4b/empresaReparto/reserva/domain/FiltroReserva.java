package innova4b.empresaReparto.reserva.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class FiltroReserva {
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.LocalDate")
	private LocalDate fechaInicioPrevista;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.LocalDate")
	private LocalDate fechaDevolucionPrevista;
	
	public FiltroReserva() {}

	public LocalDate getFechaInicioPrevista() {
		return fechaInicioPrevista;
	}
	public void setFechaInicioPrevista(LocalDate fechaInicioPrevista) {
		this.fechaInicioPrevista = fechaInicioPrevista;
	}
	public LocalDate getFechaDevolucionPrevista() {
		return fechaDevolucionPrevista;
	}
	public void setFechaDevolucionPrevista(LocalDate fechaDevolucionPrevista) {
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
	}
}
