package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.OModelo;
import vista.ICambioContrasena;
import vista.IIniciarSesion;

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
			if(vista.getNuevaContrasena()==null) {JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
				} else {
			usuario.cambiarContrasena(usuario.getUsuario(),vista.getContrasenaActual(),vista.getNuevaContrasena());
		}
			}
		}
}


	
	


