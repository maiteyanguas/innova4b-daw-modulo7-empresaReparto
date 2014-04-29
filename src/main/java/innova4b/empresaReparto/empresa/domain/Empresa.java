
package innova4b.empresaReparto.empresa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "empresa")
public class Empresa {

	private static final Logger logger = Logger.getLogger(Empresa.class);

	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{1}\\d{7}[a-zA-Z0-9]{1}$")
	private String cif;
	@Digits(integer = 9, fraction = 0)
	private Integer telefono;
	@Email
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

	// Cuando recupero empresas, recupero también direcciones
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
	// Para borrar las direcciones de una empresa si la empresa se borra
	// Para grabar las direcciones de una empresa cuando grabo una empresa
	@Cascade({ CascadeType.ALL })
	private List<Direccion> direcciones;

	public Empresa(String nombre, String cif, Integer telefono, String email,
			String fechaInicio) {
		this.nombre = nombre;
		this.cif = cif;
		this.telefono = telefono;
		this.email = email;
		this.setFechaInicio(fechaInicio);
	}

	public Empresa() {
	}

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

	public String getFechaInicioAsString() {
		return fechaInicio == null ? "" : fechaInicio
				.toString(org.joda.time.format.DateTimeFormat
						.forPattern("dd/MM/yyyy"));
	}

	public void setFechaInicio(String fInicio) {
		this.fechaInicio = LocalDate.parse(fInicio,
				org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Direccion getDireccionPrincipal() {
		Direccion direccionPrincipal = null;
		if (null != direcciones && direcciones.size() > 0) {
			direccionPrincipal = direcciones.get(0);
			for (Direccion direccion : direcciones) {
				if (direccion.isPrincipal())
					direccionPrincipal = direccion;
			}
		}
		return direccionPrincipal;
	}

	public String getDireccionPrincipalAsString() {
		String direccionAsString = "";
		Direccion direccion = getDireccionPrincipal();
		if (direccion != null)
			direccionAsString = direccion.getCalle() + " "
					+ direccion.getPortal() + ", " + direccion.getMunicipio();
		return direccionAsString;
	}

	public void addDireccion(Direccion direccion) {
		if (null == direcciones || direcciones.size() == 0)
			direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion);
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", cif=" + cif
				+ ", telefono=" + telefono + ", email=" + email
				+ ", fechaInicio=" + fechaInicio + ", direcciones="
				+ direcciones + "]";
	}
	
	
}
