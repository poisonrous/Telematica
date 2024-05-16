package vista;

import controlador.CCambioContrasena;
import controlador.CIniciarSesion;

// Interfaz que define los métodos para cambiar la contraseña.
public interface ICambioContrasena {

	// Constantes para los comandos de los botones
	String ACEPTAR = "Aceptar";
	String CANCELAR = "Cancelar";

	/**
	 * Establece el controlador para esta interfaz.
	 * @param c el controlador CCambioContrasena
	 */
	void setControlador(CCambioContrasena c);
	void arrancar(); // Inicia la interfaz para cambiar la contraseña.
	int getIdContrasena(); // Obtiene el ID de la contraseña.
	String getContrasenaActual(); // Obtiene la contraseña actual ingresada por el usuario.
	String getNuevaContrasena(); // Obtiene la nueva contraseña ingresada por el usuario.
	String verificarContrasena(String contrasena);  // Verifica si la nueva contraseña cumple con las condiciones
	String cambiarContrasena();  // Cambia la contraseña del usuario en la base de datos.


	void cancelar(); // Cancela el proceso
	String getUsuario(); //Obtiene el nombre de usuario  asociado
	
	
	
	
	
	
	
	
}
