package innova4b.empresaReparto.incidencia.domain;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "incidencia")
public class Incidencia {

	@Id
	@GeneratedValue
	private int id;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "fechaResolucion")
	private LocalDate fechaResolucion;

	private Boolean resuelta;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idUsuarioCreacion", referencedColumnName = "id")
	private Empleado empleadoCreacion;

	@ManyToOne
	@JoinColumn(name = "idUsuarioResolucion", referencedColumnName = "id")
	private Empleado empleadoResolucion;

	private String resolucion;

	@ManyToOne
	@JoinColumn(name = "coche_id", referencedColumnName = "id")
	private Coche coche;
	
	public Incidencia(){}
	
	public Incidencia(String descripcion, LocalDate fechaCreacion,
			LocalDate fechaResolucion, Boolean resuelta, Coche coche,
			Empleado empleadoCreacion, Empleado empleadoResolucion,
			String resolucion) {
		this.fechaCreacion = fechaCreacion;
		this.fechaResolucion = fechaResolucion;
		this.resuelta = resuelta;
		this.descripcion = descripcion;
		this.empleadoCreacion = empleadoCreacion;
		this.empleadoResolucion = empleadoResolucion;
		this.resolucion = resolucion;
		this.coche = coche;
	}

	public Incidencia(String string, LocalDate fechaResolucion2,
			LocalDate localDate, int i, int j, int k, int l, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(LocalDate fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Boolean getResuelta() {
		return resuelta;
	}

	public void setResuelta(Boolean resuelta) {
		this.resuelta = resuelta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getEmpleadoCreacion() {
		return empleadoCreacion;
	}

	public void setEmpleadoCreacion(Empleado empleadoCreacion) {
		this.empleadoCreacion = empleadoCreacion;
	}

	public Empleado getEmpleadoResolucion() {
		return empleadoResolucion;
	}

	public void setEmpleadoResolucion(Empleado empleadoResolucion) {
		this.empleadoResolucion = empleadoResolucion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	@JsonIgnore
	public String getIncidenciaAsString() {
		return this.fechaCreacion + " " + this.empleadoCreacion + ", "
				+ this.resuelta;
	}
}
