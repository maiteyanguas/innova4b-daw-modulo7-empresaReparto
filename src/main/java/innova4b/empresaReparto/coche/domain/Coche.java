package innova4b.empresaReparto.coche.domain;

import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.ui.ModelMap;

@Entity
@Table(name = "coche")
public class Coche {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private Empresa empresa;
	@NotNull
	@NumberFormat(style = Style.NUMBER) 
	@Max(999999)
	private Integer kms;
	@NotEmpty
	private String combustible;
	@NotEmpty
	private String marca;
	@NotEmpty
	@Pattern(regexp="\\d{4}[a-zA-Z]{3}$")
	private String matricula;
	@NotEmpty
	private String modelo;
	
	@OneToMany(mappedBy="coche", fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy="coche", fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<Incidencia> incidencias;

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	
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

	public Integer getKms() {
		return kms;
	}

	public void setKms(Integer kms) {
		this.kms = kms;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public boolean getIncidenciasPendientes(){
		boolean incidenciasPendienes = false;
		if (tieneIncidencias()) {
			for (Incidencia incidencia : incidencias){
				if (!incidencia.getResuelta()) 
					incidenciasPendienes=true;
			}
		}
		return incidenciasPendienes;
	}

	private boolean tieneIncidencias() {
		return null!=incidencias && incidencias.size()>=0;
	}
	
	

}
