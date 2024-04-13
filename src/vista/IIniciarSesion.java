package vista;

import controlador.CIniciarSesion;

public interface IIniciarSesion {

	String IniciarSesion = "Iniciar Sesión";
	
	void setControlador(CIniciarSesion c);
	void arrancar();
	void cerrar();
	void limpiar();
	String getUsuario();
	String getContrasena();
	String getRol();
	String consultaUsuario(String usuario, String contrasena);
	void inicioEstudiante();
	void inicioAdmin();
	
	
}
