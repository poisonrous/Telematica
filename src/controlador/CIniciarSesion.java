package controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.UIManager.getIcon;
import modelo.Modelo;
import modelo.OModelo;
import principal.Principal;
import vista.IIniciarSesion;


// Controlador para la funcionalidad de inicio de sesión.

public class CIniciarSesion implements ActionListener {

	private final IIniciarSesion vista; // Vista de inicar sesión
	private final Modelo modelo;   // Modelo de de datos para usuario
	private final OModelo modelo2; // Otro modelo para datos de usuario
	private Principal principal;   // Clase principal de la aplicaión

	/**
	 * Constructor de la clase CIniciarSesion.
	 * @param vista La vista de inicio de sesión.
	 * @param modelo El modelo de datos para usuarios.
	 * @param modelo2 Otro modelo de datos para usuarios.
	 */
	public CIniciarSesion(IIniciarSesion vista,Modelo modelo, OModelo modelo2) {

		this.vista = vista;
		this.modelo = modelo;
		this.modelo2 = modelo2;
	}


	/**
	 * Maneja los eventos de acción generados por la vista.
	 * @param e El evento de acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		// Verifica si se hizo clic en el botón de iniciar sesión
		if ( e.getActionCommand().equals(vista.IniciarSesion)) {

			// Obtiene el nombre de usuario y la contraseña desde la vista
			String usuario = vista.getUsuario();
			String contrasena = String.valueOf(vista.getContrasena());
			Modelo user ; // Variable para almacenar el usuario
			 

			try {
				// Intenta consultar el usuario en el modelo2
				user = modelo2.consultaUsuario(usuario, contrasena);

		        if (user != null) { // Si el usuario existe

		            if (user.getRol().equals("Estudiante")) {  // Si el usuario es un estudiante
						principal = new Principal();		// Crea una instancia de la clase principal
						principal.pantallaEstudiante();		// Muestra la pantalla de estudiante
		            } else if (user.getRol().equals("Profesor")) {	// Si el usuario es un eprofesor
		                principal = new Principal();		// Crea una instancia de la clase principal
						principal.pantallaAdministrador();	// Muestra la pantalla de administrador
		            }

		        } else {
					UIManager UI=new UIManager();
					UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
					UI.put("OptionPane.background", new Color (255,255,255));
					UI.put("Panel.background", new Color (255,255,255));
					UI.put("Button.background", new Color (3,150,177));
					UIManager.put("Button.foreground", Color.white);

					ImageIcon iconC = new ImageIcon("media/informacion.png");
		            //JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos"); // Muestra un mensaje de error si el usuario no existe
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrectos", "Información",JOptionPane.PLAIN_MESSAGE,iconC);
		        }

		    } catch (NullPointerException ex) { // Captura si ocurre un error
				// No hace nada si no ocurre
		    }



		}
   }
}


