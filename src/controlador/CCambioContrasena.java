package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

import modelo.OModelo;
import vista.ICambioContrasena;
import vista.IIniciarSesion;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class CCambioContrasena implements ActionListener {

	private final ICambioContrasena vista;
	private final IIniciarSesion vistaIniciarSesion;
	private final OModelo usuario;
	
	
	public CCambioContrasena(ICambioContrasena vista,IIniciarSesion vistaIniciarSesion, OModelo usuario) {
		this.vista = vista;
		this.vistaIniciarSesion = vistaIniciarSesion;
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub        

		if (e.getActionCommand().equals(ICambioContrasena.ACEPTAR)) {
			if(vista.getNuevaContrasena()==null) {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
				}

		    else if (vista.getNuevaContrasena().length()<6) {JOptionPane.showMessageDialog(null, "La contraseña es muy corta");
			}

			else if(Objects.equals(vista.getNuevaContrasena(), "")){JOptionPane.showMessageDialog(null, "La contraseña esta en blanco");
			}

			else {


				int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres cambiar tu contraseña?", "Advertencia",
						JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, null,
						new String[]{"Si", "No"}, "Si");

				if (n== JOptionPane.YES_OPTION){

				usuario.cambiarContrasena(usuario.getUsuario(),vista.getContrasenaActual(),vista.getNuevaContrasena());
				}
				}
		}
		else if (e.getActionCommand().equals(ICambioContrasena.CANCELAR)){
			vista.cancelar();
		}
		}
}


	
	


