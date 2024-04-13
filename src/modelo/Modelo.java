package modelo;

public class Modelo {

	private String usuario, nombres, apellidos, rol, contrasena;

	
	public Modelo(String usuario, String nombres, String apellidos, String rol, String contrasena) {
		
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
		this.contrasena = contrasena;
	}
	public Modelo () {
		
	}

    public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getUsuario() {
		return usuario;
	}
	

	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;

	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	}
