package innova4b.empresaReparto.empresa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="empresa")
public class Empresa {
	
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z]{1}\\d{7}[a-zA-Z0-9]{1}$")
	private String cif;
	@Digits(integer=9, fraction = 0)
	private Integer telefono;
	@Email
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;	
	
	public Empresa(String nombre, String cif, Integer telefono, String email, String fechaInicio) {
		this.nombre = nombre;
		this.cif = cif;
		this.telefono = telefono;
		this.email = email;
		this.setFechaInicio(fechaInicio);
	}
	
	public Empresa() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaInicioAsString(){
		return fechaInicio==null?"":fechaInicio.toString(org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
	}
	
	public void setFechaInicio(String fInicio) {
		this.fechaInicio = LocalDate.parse(fInicio,org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}	

}
