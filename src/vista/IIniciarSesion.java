package vista;

import controlador.CIniciarSesion;

public interface IIniciarSesion {

	final String IniciarSesion = "Iniciar Sesión";
	
	public void setControlador(CIniciarSesion c);
	public void arrancar ();
	public String getUsuario();
	public String getContrasena();
	public String getRol();
	public String consultaUsuario(String usuario, String contrasena);
	public void inicioEstudiante();
	public void inicioAdmin();
	
	
}
