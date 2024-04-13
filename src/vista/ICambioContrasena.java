package vista;

import controlador.CCambioContrasena;
import controlador.CIniciarSesion;

public interface ICambioContrasena {

	
	String ACEPTAR = "Aceptar";
	String CANCELAR = "Cancelar";
	
	void setControlador(CCambioContrasena c);
	void arrancar();
	int getIdContrasena();
	String getContrasenaActual();
	String getNuevaContrasena();
	String verificarContrasena(String contrasena);
	String cambiarContrasena();
	String getUsuario();
	
	
	
	
	
	
	
	
}
