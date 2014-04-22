package innova4b.empresaReparto.empleado.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import innova4b.empresaReparto.empresa.domain.Empresa;


@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="empresa_id", referencedColumnName="id")
	private Empresa empresa;
	
	private Integer activo;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private String telefono;
	private String email;
	
	private Integer jefe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getJefe() {
		return jefe;
	}
	public void setJefe(int jefe) {
		this.jefe = jefe;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	public void setJefe(Integer jefe) {
		this.jefe = jefe;
	}
	
	public boolean is_Jefe(){
		return  this.jefe == null;
	}

}
