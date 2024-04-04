package modelo;

public class MCambioContrasena {

	private int idContrasena;
	private String confirmarContrasena, contrasenaActual,usuario;
	
	
	
	public MCambioContrasena(int idContrasena, String confirmarContrasena) {
        this.idContrasena = idContrasena;
        this.confirmarContrasena = confirmarContrasena;
    }



	public MCambioContrasena() {
		// TODO Auto-generated constructor stub
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasenaActual() {
		return contrasenaActual;
	}



	public void setContrasenaActual(String contrasenaActual) {
		this.contrasenaActual = contrasenaActual;
	}



	public int getIdContrasena() {
		return idContrasena;
	}



	public void setIdContrasena(int idContrasena) {
		this.idContrasena = idContrasena;
	}



	public String getConfirmarContrasena() {
		return confirmarContrasena;
	}



	public void setConfirmarContrasena(String confirmarContrasena) {
		this.confirmarContrasena = confirmarContrasena;
	}


		


	




	}
	

