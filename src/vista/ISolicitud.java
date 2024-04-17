package vista;

import controlador.CIniciarSesion;
import controlador.CSolicitud;

import javax.swing.*;

public interface ISolicitud {
	String ENVIAR = "Enviar";
	String MATERIA = "Materia";
	void cargarMaterias(String usuario);
	void mostrarResultado(String nombre, String apellido, String telefono, String correo, String tipo, String descripcion, String fecha);
	void arrancar();
	String getTipo();
	String getTipoNombre();
	Object getMateria();
	String getDescripcion();
	String getImagen();
	String getUsuario();

	void setControlador(CSolicitud c);
	
}
