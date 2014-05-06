package innova4b.empresaReparto.empleado.domain;

import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="empleado")
public class Empleado {
	
	private static final String JEFE_NULO_NOMBRE = "Ninguno";

	public static final int JEFE_NULO_ID = -1;
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="empresa_id", referencedColumnName="id")
	private Empresa empresa;
	
	@NotEmpty
	private String usuario;
	@NotEmpty
	private String password;
	private String rol = "u";
	
	private Integer activo = 1;
	
	@Pattern(regexp="^[0-9]{8}[a-zA-Z]{1}$")
	private String dni;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido1;
	@NotEmpty
	private String apellido2;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate fechaNacimiento;
	@Pattern(regexp="^[0-9]{9}[0-9]*$")
	private String telefono;
	@NotEmpty
	@Email
	private String email;
	

	@OneToMany(mappedBy="empleado", fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<Reserva> reservas;
	
	@ManyToOne(cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="jefe")
	private Empleado jefe;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Empleado getJefe() {
		return jefe;
	}
	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}	
	public String getFechaInicioAsString(){
		return fechaNacimiento==null?"":fechaNacimiento.toString(org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
	}
	public void setFechaInicio(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento,org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public boolean soyJefe(){
		return  this.jefe == null;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", empresa=" + empresa.getNombre() + ", usuario="
				+ usuario + ", password=" + password + ", rol=" + rol
				+ ", activo=" + activo + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaNacimiento=" + fechaNacimiento + ", telefono="
				+ telefono + ", email=" + email + ", jefe=" + jefe + "]";
	}
	
	public static Empleado buildJefeNulo(){
		Empleado empleado = new Empleado();
		empleado.setId(JEFE_NULO_ID);
		empleado.setNombre(JEFE_NULO_NOMBRE);
		return empleado;
	}
	
}
