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
import org.joda.time.LocalDate;
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
	private LocalDate fechaInicio;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion")
	private LocalDate fechaDevolucion;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio_prevista")
	private LocalDate fechaInicioPrevista;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion_prevista")
	private LocalDate fechaDevolucionPrevista;
	
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
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

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
