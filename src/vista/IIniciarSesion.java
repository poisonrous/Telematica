package vista;

import controlador.CIniciarSesion;
 //  Interfaz para la pantalla de inicio de sesión.
public interface IIniciarSesion {

	// Constante del evento de inicio de sesión.
	String IniciarSesion = "Iniciar Sesión";

	 /**
	  * Establece el controlador para esta interfaz.
	  * @param c El controlador asociado a esta interfaz.
	  */
	void setControlador(CIniciarSesion c);

	void arrancar();  // Inicializa y muestra la pantalla de inicio de sesión.
	void cerrar();  // Cierra la pantalla de inicio de sesión.
	void limpiar();  // Limpia los campos de usuario y contraseña

	 /**
	  * Obtiene el nombre de usuario ingresado en la pantalla de inicio de sesión.
	  * @return El nombre de usuario ingresado.
	  */
	 String getUsuario();

	 /**
	  * Obtiene la contraseña ingresada en la pantalla de inicio de sesión.
	  * @return La contraseña ingresada.
	  */
	 String getContrasena();

	 /**
	  * Obtiene el rol seleccionado en la pantalla de inicio de sesión.
	  * @return El rol seleccionado (Estudiante, Administrador, etc.).
	  */
	 String getRol();

	 /**
	  * Realiza la consulta del usuario y la contraseña en la base de datos para iniciar sesión.
	  * @param usuario El nombre de usuario.
	  * @param contrasena La contraseña del usuario.
	  * @return Un mensaje indicando el resultado de la consulta (éxito o error).
	  */
	 String consultaUsuario(String usuario, String contrasena);

	 void inicioEstudiante();	// Inicia la sesión para un usuario tipo estudiante.
	 void inicioAdmin(); 	// Inicia la sesión para un usuario tipo administrador.
	
	
}
