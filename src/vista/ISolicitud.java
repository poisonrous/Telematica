package vista;

import controlador.CIniciarSesion;
import controlador.CSolicitud;

import javax.swing.*;

public interface ISolicitud {
	public static String ENVIAR = "Enviar";
	public static String MATERIA = "Materia";
	public void cargarMaterias(String usuario);
	public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String tipo, String descripcion, String fecha);
	public void arrancar ();
	public String getTipo();
	public Object getMateria();
	public String getDescripcion();
	public String getImagen();
	public String getUsuario();

	public void setControlador(CSolicitud c);
	
}
