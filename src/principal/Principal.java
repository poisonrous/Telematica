package principal;

import controlador.*;
import modelo.Modelo;
import modelo.OModelo;
import vista.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IIniciarSesion vista = new VIniciarSesion();
		Modelo modelo = new Modelo();
		OModelo modelo2 = new OModelo();
		CIniciarSesion controlador5 = new CIniciarSesion(vista, modelo, modelo2);
		ICambioContrasena vista1 = new VCambioContrasena();
		CCambioContrasena controlador1 = new CCambioContrasena(vista1, vista,modelo2);
		vista1.setControlador(controlador1);
		ISolicitud vista2 = new VSolicitud();
		ICambioContrasena vista3 = new VCambioContrasena();
		ISugerencia vista4 = new VSugerencia();
		CSolicitud controlador = new CSolicitud(vista2, modelo2);
		CSugerencia controlador2 = new CSugerencia(vista4, modelo2);
		IPublicacion vista5 = new VPublicacion();
		CPublicacion controlador3 = new CPublicacion(vista5, modelo2);
		IServicio vista6 = new VServicio();
		CServicio controlador4 = new CServicio(vista6);
		vista6.setControlador(controlador4);
		//vista6.arrancar();
		controlador4.cargarServicio(vista6);
		vista.setControlador(controlador5);
		vista2.setControlador(controlador);
		vista4.setControlador(controlador2);
		vista5.setControlador(controlador3);
		vista.arrancar();
		//vista2.arrancar();
		//vista4.arrancar();
		//vista5.arrancar();
		vista1.arrancar();

	}

}
