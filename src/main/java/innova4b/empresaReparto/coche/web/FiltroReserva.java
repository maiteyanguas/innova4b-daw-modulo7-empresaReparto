package innova4b.empresaReparto.coche.web;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class FiltroReserva {
	@NotNull
	private Date fechaInicioPrevista;
	@NotNull
	private Date fechaDevolucionPrevista;
	
	public FiltroReserva() {}
	
	public Date getFechaInicioPrevista() {
		return fechaInicioPrevista;
	}
	public void setFechaInicioPrevista(Date fechaInicioPrevista) {
		this.fechaInicioPrevista = fechaInicioPrevista;
	}
	public Date getFechaDevolucionPrevista() {
		return fechaDevolucionPrevista;
	}
	public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
	}	
}
