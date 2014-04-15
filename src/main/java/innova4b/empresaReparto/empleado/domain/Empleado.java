package innova4b.empresaReparto.empleado.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue
	private int id;
	private String usuario;
	private String password;
	private String rol;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	private enum Rol{
		USUARIO("u"), ADMINISTRADOR("a");
		
		private String rol;
		
		private Rol(String r){
			rol = r;
		}
		
		private String getRol(){
			return rol;
		}
	}

}
