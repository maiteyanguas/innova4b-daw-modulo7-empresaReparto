package innova4b.empresaReparto.empresa.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="direccion")
public class Direccion {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String calle;
	@NotNull
	private Integer portal;
	private Integer piso;
	private String letra;
	private String otros;
	@Column(name="codigo_postal")
	private Integer codigoPostal;
	@NotEmpty
	private String municipio;
	@ManyToOne
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	@JsonIgnore
	private Empresa empresa;
	private Boolean principal;
		
	public Direccion(String calle, Integer portal, Integer piso,
			String letra, String otros, Integer codigoPostal, String municipio,
			Empresa empresa) {
		this.calle = calle;
		this.portal = portal;
		this.piso = piso;
		this.letra = letra;
		this.otros = otros;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
		this.empresa = empresa;
	}
	
	public Direccion(){}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getPortal() {
		return portal;
	}
	public void setPortal(Integer portal) {
		this.portal = portal;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Boolean isPrincipal() {
		return principal!=null?principal:false;
	}
	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	@JsonIgnore
	public String getDireccionAsString(){
		return this.calle+" "+this.portal+", "+this.municipio;
	}
	
	
}
