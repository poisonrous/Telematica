package principal;

import controlador.*;
import modelo.*;
import vista.*;

public class Principal {

	private static IIniciarSesion vista;
	private static Modelo modelo;
	private static OModelo modelo2;
	private static CIniciarSesion controlador5;
	public static Instanciar instanciar;
	private static VEstudiante estudiante;
	private static VAdministrador administrador;

	public static void main(String[] args) {

		 vista = new VIniciarSesion();
		 modelo = new Modelo();
		 modelo2 = new OModelo();
		 controlador5 = new CIniciarSesion(vista, modelo, modelo2);
		 vista.setControlador(controlador5);
		 instanciar = new Instanciar(vista, modelo, modelo2, controlador5);
			vista.arrancar();
	}

	public void pantallaEstudiante() {
		estudiante = new VEstudiante(modelo2, instanciar);
		estudiante.setVisible(true);
		vista.cerrar();
	}

	public void pantallaAdministrador(){
		administrador = new VAdministrador(modelo2, instanciar);
		administrador.setVisible(true);
		vista.cerrar();
	}

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
