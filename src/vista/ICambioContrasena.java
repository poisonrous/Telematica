package vista;

import controlador.CCambioContrasena;
import controlador.CIniciarSesion;

public interface ICambioContrasena {

	
	final String ACEPTAR = "Aceptar";
	final String CANCELAR = "Cancelar";
	
	public void setControlador (CCambioContrasena c);
	public void arrancar ();
	public int getIdContrasena();
	public String getContrasenaActual();
	public String getNuevaContrasena();
	public String verificarContrasena(String contrasena);
	public String cambiarContrasena();
	public String getUsuario();
	
	
	
	
	
	
	
	
}
