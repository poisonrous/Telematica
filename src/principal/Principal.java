package principal;

import controlador.*;
import modelo.*;
import vista.*;

import javax.swing.*;

// Clase Principal es la clase principal del programa, se encarga de iniciar la aplicación y gestionar las pantallas de inicio de sesión y los diferentes roles de usuario.
 public class Principal {

	private static IIniciarSesion vista; // Vista de inicio de sesión
	private static Modelo modelo; // Modelo de datos
	private static OModelo modelo2; // Modelo de operaciones
	private static CIniciarSesion controlador5; // Controlador de inicio de sesión
	public static Instanciar instanciar; // Instanciador de pantallas
	private static VEstudiante estudiante; // Vista para el rol de estudiante
	private static VProfesor administrador; // Vista para el rol de administrador

	// Método principal que inicia la aplicación.
	public static void main(String[] args) {
		// Configurar la apariencia de los diálogos de confirmación
		UIManager.put(JOptionPane.YES_OPTION, "Sí");
		 vista = new VIniciarSesion(); // Crear la vista de inicio de sesión
		// Crear el modelo de datos y el modelo de operaciones
		 modelo = new Modelo();
		 modelo2 = new OModelo();
		// Crear el controlador de inicio de sesión y establecerlo en la vista
		 controlador5 = new CIniciarSesion(vista, modelo, modelo2);
		 vista.setControlador(controlador5);

		 instanciar = new Instanciar(vista, modelo, modelo2, controlador5); // Instanciador de pantallas
			vista.arrancar();
	}

	// Método para mostrar la pantalla de estudiante.
	public void pantallaEstudiante() {
		estudiante = new VEstudiante(modelo2, instanciar);
		estudiante.setVisible(true);
		vista.cerrar();
	}

	// Método para mostrar la pantalla de administrador
	public void pantallaAdministrador(){
		administrador = new VProfesor(modelo2, instanciar);
		administrador.setVisible(true);
		vista.cerrar();
	}

	// Método para cerrar la sesión actual y volver a la pantalla de inicio de sesión.
	public void cerrarSesion(){
		if(estudiante != null){
			estudiante.setVisible(false);
			estudiante = null;
		} else if(administrador != null) {
			administrador.setVisible(false);
			administrador = null;}
		vista.arrancar();
		vista.limpiar();
	}
}
