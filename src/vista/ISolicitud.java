package vista;

import controlador.CIniciarSesion;
import controlador.CSolicitud;

import javax.swing.*;
	// Interfaz para la gesti�n de solicitudes.
public interface ISolicitud {
	// Constante para acciones en botones
	String ENVIAR = "Enviar";
	String MATERIA = "Materia";

		/**
		 * Carga las materias disponibles para el usuario.
		 * @param usuario El usuario para el cual se cargan las materias.
		 */
	void cargarMaterias(String usuario);

		/**
		 * Muestra el resultado de la solicitud.
		 * @param nombre El nombre del solicitante.
		 * @param apellido El apellido del solicitante.
		 * @param telefono El tel�fono del solicitante.
		 * @param correo El correo electr�nico del solicitante.
		 * @param tipo El tipo de solicitud.
		 * @param descripcion La descripci�n de la solicitud.
		 * @param fecha La fecha de la solicitud.
		 */

	void mostrarResultado(String nombre, String apellido, String telefono, String correo, String tipo, String descripcion, String fecha);
	void arrancar();	// Inicializa y muestra la interfaz de solicitud.


		/**
		 * Obtiene el tipo de solicitud.
		 * @return El tipo de solicitud.
		 */
	String getTipo();

		/**
		 * Obtiene el nombre del tipo de solicitud.
		 * @return El nombre del tipo de solicitud.
		 */
	String getTipoNombre();

		/**
		 * Obtiene la materia seleccionada en la solicitud.
		 * @return La materia seleccionada.
		 */
	Object getMateria();

		/**
		 * Obtiene la descripci�n de la solicitud.
		 * @return La descripci�n de la solicitud.
		 */
	String getDescripcion();

		/**
		 * Obtiene la imagen asociada a la solicitud.
		 * @return La ruta de la imagen de la solicitud.
		 */
	String getImagen();

		/**
		 * Obtiene el usuario que realiza la solicitud.
		 * @return El usuario que realiza la solicitud.
		 */
	String getUsuario();

		/**
		 * Establece el controlador para esta interfaz.
		 * @param c El controlador asociado a esta interfaz.
		 */
	void setControlador(CSolicitud c);
	
}
