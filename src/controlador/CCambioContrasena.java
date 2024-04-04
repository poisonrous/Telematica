package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.MCambioContrasena;

import modelo.OCambioContrasena;
import vista.ICambioContrasena;
import vista.IIniciarSesion;
import vista.VIniciarSesion;

public class CCambioContrasena implements ActionListener {

	private ICambioContrasena vista;
	private IIniciarSesion vistaIniciarSesion;
	private MCambioContrasena modelo;
	private OCambioContrasena modelo2;
	
	
	public CCambioContrasena(ICambioContrasena vista,IIniciarSesion vistaIniciarSesion, MCambioContrasena modelo, OCambioContrasena modelo2) {
		this.vista = vista;
		this.modelo = modelo;
		this.modelo2 = modelo2;
		this.vistaIniciarSesion = vistaIniciarSesion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub        

		if (e.getActionCommand().equals(ICambioContrasena.ACEPTAR)) {

			JOptionPane.showMessageDialog(null,"el botón funciona");

			MCambioContrasena consu= new MCambioContrasena();
			consu.setConfirmarContrasena(vista.getConfirmarContrasena());
			boolean resultado; 

			if(vista.getContrasenaActual().length()==0 || vista.getNuevaContrasena().length()==0 || vista.getConfirmarContrasena().length()==0 ) {
				JOptionPane.showMessageDialog(null, "Uno o m�s de los campos estan vacios.");

			} else {

				if(vista.getContrasenaActual().equals(vistaIniciarSesion.getUsuario())) {
					JOptionPane.showMessageDialog(null, "La contrase�a actual no es correcta.");
				} else {
					resultado = modelo2.verificarContrasena(consu);

					if(!vista.getNuevaContrasena().equals(vista.getConfirmarContrasena())) {

						JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden.");

					} else {

						resultado = modelo2.verificarContrasena(consu);
						JOptionPane.showMessageDialog(null, "Contrase�a cambiada con �xito.");

					}





				}




			}
			JOptionPane.showMessageDialog(null, "El usuario es: " + vistaIniciarSesion.getUsuario());

		}
	}
}


	
	


