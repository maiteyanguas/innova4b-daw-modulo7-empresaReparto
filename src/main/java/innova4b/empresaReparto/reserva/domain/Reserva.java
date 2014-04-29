package innova4b.empresaReparto.reserva.domain;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue
	private int id;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio_prevista")
	private Date fechaInicioPrevista;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion_prevista")
	private Date fechaDevolucionPrevista;
	
	@ManyToOne
	@JoinColumn(name="empleado_id", referencedColumnName="id")
	@NotNull
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="coche_id", referencedColumnName="id")
	@NotNull
	private Coche coche;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Date getFechaInicioPrevista() {
		return fechaInicioPrevista;
	}
	
	public void setFechaInicioPrevista(Date fechaInicioPrevista) {
		this.fechaInicioPrevista = fechaInicioPrevista;
	}
	
	public Date getFechaDevolucionPrevista() {
		return fechaDevolucionPrevista;
	}
	
	public void setFechaDevolucionPrevista(Date fechaDevolucioPrevista) {
		this.fechaDevolucionPrevista = fechaDevolucioPrevista;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Coche getCoche() {
		return coche;
	}
	
	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicio=" + fechaInicio
				+ ", fechaDevolucion=" + fechaDevolucion
				+ ", fechaInicioPrevista=" + fechaInicioPrevista
				+ ", fechaDevolucionPrevista=" + fechaDevolucionPrevista + "]";
	}
	
	

}
