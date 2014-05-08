package innova4b.empresaReparto.reserva.domain;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue
	private int id;
	
	private Integer kmIniciales;
	private Integer kmFinales;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion")
	private LocalDate fechaDevolucion;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio_prevista")
	private LocalDate fechaInicioPrevista;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_devolucion_prevista")
	private LocalDate fechaDevolucionPrevista;
	
	@ManyToOne
	@JoinColumn(name="empleado_id", referencedColumnName="id")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="coche_id", referencedColumnName="id")
	private Coche coche;
	
	public Reserva() {
	}
	
	public Reserva(int kmIniciales, int kmFinales,
			LocalDate fechaInicio, LocalDate fechaDevolucion,
			LocalDate fechaInicioPrevista, LocalDate fechaDevolucionPrevista,
			Empleado empleado, Coche coche) {
		this.id = id;
		this.kmIniciales = kmIniciales;
		this.kmFinales = kmFinales;
		this.fechaInicio = fechaInicio;
		this.fechaDevolucion = fechaDevolucion;
		this.fechaInicioPrevista = fechaInicioPrevista;
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
		this.empleado = empleado;
		this.coche = coche;
	}
	
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

	public Integer getKmFinales() {
		return kmFinales;
	}

	public void setKmFinales(Integer kmFinales) {
		this.kmFinales = kmFinales;
	}

	public Integer getKmIniciales() {
		return kmIniciales;
	}

	public void setKmIniciales(Integer kmIniciales) {
		this.kmIniciales = kmIniciales;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicio=" + fechaInicio
				+ ", fechaDevolucion=" + fechaDevolucion
				+ ", fechaInicioPrevista=" + fechaInicioPrevista
				+ ", fechaDevolucionPrevista=" + fechaDevolucionPrevista
				+ ", empleado=" + empleado + ", coche=" + coche + "]";
	}
	
	

}
