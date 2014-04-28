package innova4b.empresaReparto.reserva.domain;

import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empleado.domain.Empleado;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue
	private int id;

	private Date fecha_inicio;
	private Date fecha_devolucion;
	private Date fecha_inicio_prevista;
	private Date fecha_devolucion_prevista;
	
	@ManyToOne
	@JoinColumn(name = "empleado_id", referencedColumnName = "id")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "coche_id", referencedColumnName = "id")
	private Coche coche;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public Date getFecha_inicio_prevista() {
		return fecha_inicio_prevista;
	}
	public void setFecha_inicio_prevista(Date fecha_inicio_prevista) {
		this.fecha_inicio_prevista = fecha_inicio_prevista;
	}
	public Date getFecha_devolucion_prevista() {
		return fecha_devolucion_prevista;
	}
	public void setFecha_devolucion_prevista(Date fecha_devolucio_prevista) {
		this.fecha_devolucion_prevista = fecha_devolucio_prevista;
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

}
