package principal;

import controlador.*;
import modelo.*;
import vista.*;

public class Principal {

	private static IIniciarSesion vista;
	private static Modelo modelo;
	private static OModelo modelo2;
	private static CIniciarSesion controlador5;

	public static void main(String[] args) {

		 vista = new VIniciarSesion();
		 modelo = new Modelo();
		 modelo2 = new OModelo();
		 controlador5 = new CIniciarSesion(vista, modelo, modelo2);
		vista.setControlador(controlador5);
		vista.arrancar();


		//vista.setVisible(true);
	}

	public void pantallaEstudiante() {
		ICartelera cartelera = new VCartelera();
		IPub pub = new VPub();
		MCartelera mCartelera = new MCartelera();
		CCartelera controlador = new CCartelera(cartelera, pub, mCartelera);
		controlador.cargarCartelera();

		ISolicitud solicitud = new VSolicitud();
		CSolicitud controladorSolicitud = new CSolicitud(solicitud, modelo2);
		solicitud.setControlador(controladorSolicitud);

		IServicios servicios = new VServicios();
		MCrudServicio mCrudServicio = new MCrudServicio();
		CServicios controladorServicios = new CServicios(servicios, mCrudServicio);
		controladorServicios.cargarServicios();

		IEventos eventos = new VEventos();
		MCrudEvento mCrudEvento = new MCrudEvento();
		CEventos controladorEventos = new CEventos(eventos, mCrudEvento);
		controladorEventos.cargarEventos();

		ISugerencia sugerencia = new VSugerencia();
		MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
		CSugerencia controladorSugerencia = new CSugerencia(sugerencia, modelo2);
		sugerencia.setControlador(controladorSugerencia);

		IPublicacion publicacion = new VPublicacion();
		CPublicacion controladorPublicacion = new CPublicacion(publicacion, modelo2);
		publicacion.setControlador(controladorPublicacion);

		ICambioContrasena cambioContrasena = new VCambioContrasena();
		CCambioContrasena controladorCambioContrasena = new CCambioContrasena(cambioContrasena, vista, modelo2);
		cambioContrasena.setControlador(controladorCambioContrasena);

		VEstudiante estudiante = new VEstudiante(modelo2, cartelera, solicitud, servicios, eventos, sugerencia, publicacion, cambioContrasena);
		estudiante.setVisible(true);
	}

	public void pantallaAdministrador(){
		ICartelera cartelera = new VCartelera();
		IPub pub = new VPub();
		MCartelera mCartelera = new MCartelera();
		CCartelera controlador = new CCartelera(cartelera, pub, mCartelera);
		controlador.cargarCartelera();

		IServicios servicios = new VServicios();
		MCrudServicio mCrudServicio = new MCrudServicio();
		CServicios controladorServicios = new CServicios(servicios, mCrudServicio);
		controladorServicios.cargarServicios();

		IServicio servicio = new VServicio();
		CServicio controladorServicio = new CServicio(servicio, mCrudServicio);
		servicio.setControlador(controladorServicio);
		controladorServicio.cargarServicio(servicio);

		IEventos eventos = new VEventos();
		MCrudEvento mCrudEvento = new MCrudEvento();
		CEventos controladorEventos = new CEventos(eventos, mCrudEvento);
		controladorEventos.cargarEventos();

		IPublicacion publicacion = new VPublicacion();
		CPublicacion controladorPublicacion = new CPublicacion(publicacion, modelo2);
		publicacion.setControlador(controladorPublicacion);

		ICambioContrasena cambioContrasena = new VCambioContrasena();
		CCambioContrasena controladorCambioContrasena = new CCambioContrasena(cambioContrasena, vista, modelo2);
		cambioContrasena.setControlador(controladorCambioContrasena);

		ISolicitudReporte solicitudReporte = new VSolicitudReporte();
		MSolicitudR modulo = new MSolicitudR();
		CSolicitudReporte controladorSolicitudReporte = new CSolicitudReporte(solicitudReporte, modulo);
		solicitudReporte.setControlador(controladorSolicitudReporte);

		ISolicitudCurso solicitudCurso = new VSolicitudCurso(solicitudReporte);
		CSolicitudCurso controladorSolicitudCurso = new CSolicitudCurso(solicitudCurso, modulo);
		solicitudCurso.setControlador(controladorSolicitudCurso);
		solicitudCurso.mostrar();
		solicitudCurso.desplegar();


		IEvento evento = new VEvento();
		CEvento controladorEvento = new CEvento(evento);
		evento.setControlador(controladorEvento);

		VAdministrador administrador = new VAdministrador(modelo2, solicitudReporte, solicitudCurso, servicios, servicio, cartelera, publicacion, eventos, evento, cambioContrasena);
		administrador.setVisible(true);
	}
}
