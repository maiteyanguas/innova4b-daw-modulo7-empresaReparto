package innova4b.empresaReparto.coche.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.reserva.domain.Reserva;

@Entity
@Table(name = "coche")
public class Coche {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private Empresa empresa;

	private Integer kms;
	private String combustible;
	private String marca;
	private String matricula;
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

}
