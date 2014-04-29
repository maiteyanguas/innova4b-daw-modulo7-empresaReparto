package innova4b.empresaReparto.reserva.web;

import java.util.Date;

public class FiltroReserva {
	private Date fechaInicioPrevista;
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
