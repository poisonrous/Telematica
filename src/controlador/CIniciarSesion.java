package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Modelo;
import modelo.OModelo;
import vista.IIniciarSesion;

public class CIniciarSesion implements ActionListener {

	private IIniciarSesion vista;
	private Modelo modelo;
	private OModelo modelo2;



	public CIniciarSesion(IIniciarSesion vista,Modelo modelo, OModelo modelo2) {

		this.vista = vista;
		this.modelo = modelo;
		this.modelo2 = modelo2;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub



		if ( e.getActionCommand().equals(vista.IniciarSesion)) {


			String usuario = vista.getUsuario();
			String contrasena = String.valueOf(vista.getContrasena());
			Modelo user ;
			 

			try {

				user = modelo2.consultaUsuario(usuario, contrasena);

		        if (user != null) {

		            if (user.getRol().equals("Estudiante")) {
		                vista.inicioEstudiante();
		            } else if (user.getRol().equals("Administrador")) {
		                vista.inicioAdmin();
		            }

		        } else {
		            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		           
		        }

		    } catch (NullPointerException ex) {

		    }

			

		}
   }
}


