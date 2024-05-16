package vista;

import controlador.CIniciarSesion;
 //  Interfaz para la pantalla de inicio de sesi�n.
public interface IIniciarSesion {

	// Constante del evento de inicio de sesi�n.
	String IniciarSesion = "Iniciar Sesi�n";

	 /**
	  * Establece el controlador para esta interfaz.
	  * @param c El controlador asociado a esta interfaz.
	  */
	void setControlador(CIniciarSesion c);

	void arrancar();  // Inicializa y muestra la pantalla de inicio de sesi�n.
	void cerrar();  // Cierra la pantalla de inicio de sesi�n.
	void limpiar();  // Limpia los campos de usuario y contrase�a

	 /**
	  * Obtiene el nombre de usuario ingresado en la pantalla de inicio de sesi�n.
	  * @return El nombre de usuario ingresado.
	  */
	 String getUsuario();

	 /**
	  * Obtiene la contrase�a ingresada en la pantalla de inicio de sesi�n.
	  * @return La contrase�a ingresada.
	  */
	 String getContrasena();

	 /**
	  * Obtiene el rol seleccionado en la pantalla de inicio de sesi�n.
	  * @return El rol seleccionado (Estudiante, Administrador, etc.).
	  */
	 String getRol();

	 /**
	  * Realiza la consulta del usuario y la contrase�a en la base de datos para iniciar sesi�n.
	  * @param usuario El nombre de usuario.
	  * @param contrasena La contrase�a del usuario.
	  * @return Un mensaje indicando el resultado de la consulta (�xito o error).
	  */
	 String consultaUsuario(String usuario, String contrasena);

	 void inicioEstudiante();	// Inicia la sesi�n para un usuario tipo estudiante.
	 void inicioAdmin(); 	// Inicia la sesi�n para un usuario tipo administrador.
	
	
}
