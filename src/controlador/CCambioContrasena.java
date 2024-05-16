package controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

import modelo.OModelo;
import vista.ICambioContrasena;
import vista.IIniciarSesion;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

 // Controlador para la vista de cambio de contraseña.

public class CCambioContrasena implements ActionListener {

	private final ICambioContrasena vista; // Vista de cambio de contraseña
	private final IIniciarSesion vistaIniciarSesion; // Vista de inicio de sesión
	private final OModelo usuario; // Modelo de usuario

	/**
	 * Constructor de la clase CCambioContrasena.
	 * @param vista La vista de cambio de contraseña.
	 * @param vistaIniciarSesion La vista de inicio de sesión.
	 * @param usuario El modelo de usuario.
	 */

	public CCambioContrasena(ICambioContrasena vista,IIniciarSesion vistaIniciarSesion, OModelo usuario) {
		this.vista = vista;
		this.vistaIniciarSesion = vistaIniciarSesion;
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub        
		// Método para realizar acción en la vista

		if (e.getActionCommand().equals(ICambioContrasena.ACEPTAR)) {
			// Acción al presionar el botón de "Aceptar"

			if(vista.getNuevaContrasena()==null) {
				UIManager UI=new UIManager();
				UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
				UI.put("OptionPane.background", new Color (255,255,255));
				UI.put("Panel.background", new Color (255,255,255));
				UI.put("Button.background", new Color (3,150,177));
				UIManager.put("Button.foreground", Color.white);


				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
				}

		    else if (vista.getNuevaContrasena().length()<6) {JOptionPane.showMessageDialog(null, "La contraseña es muy corta");
			}

			else if(Objects.equals(vista.getNuevaContrasena(), "")){JOptionPane.showMessageDialog(null, "La contraseña esta en blanco");
			}

			else {
				// Confirmación para cambiar la contraseña
				UIManager UI=new UIManager();
				UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
				UI.put("OptionPane.background", new Color (255,255,255));
				UI.put("Panel.background", new Color (255,255,255));
				UI.put("Button.background", new Color (3,150,177));
				UIManager.put("Button.foreground", Color.white);

				ImageIcon icon = new ImageIcon("media/advertencia.png");



				int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres cambiar tu contraseña?", "Advertencia",
						JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, icon,
						new String[]{"Si", "No"}, "Si");

				if (n== JOptionPane.YES_OPTION){
					// Cambiar la contraseña del usuario
				usuario.cambiarContrasena(usuario.getUsuario(),vista.getContrasenaActual(),vista.getNuevaContrasena());
				}
				}
		}
		else if (e.getActionCommand().equals(ICambioContrasena.CANCELAR)){
			// Acción cuando se presiona el botón de "Cancelar"
			vista.cancelar();
		}
		}
}


	
	


