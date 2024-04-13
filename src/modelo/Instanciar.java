package modelo;
import vista.*;
import controlador.*;

public class Instanciar {

    private static IIniciarSesion vista;
    private static Modelo modelo;
    private static OModelo modelo2;
    private static CIniciarSesion controlador;
    public Instanciar(IIniciarSesion vista, Modelo modelo, OModelo modelo2, CIniciarSesion controlador) {
        this.vista = vista;
        this.modelo = modelo;
        this.modelo2 = modelo2;
        this.controlador = controlador;

    }

    public ISolicitud llamarSolicitud() {
        ISolicitud solicitud = new VSolicitud();
        CSolicitud controladorSolicitud = new CSolicitud(solicitud, modelo2);
        solicitud.setControlador(controladorSolicitud);
        solicitud.cargarMaterias(modelo2.getUsuario());
        return solicitud;
    }

    public ISolicitudes llamarSolicitudes() {
        ISolicitudes solicitudes = new VSolicitudes();
        MCrudSolicitud mCrudSolicitud = new MCrudSolicitud();
        CSolicitudes controladorSolicitudes = new CSolicitudes(solicitudes, mCrudSolicitud, modelo2);
        solicitudes.setControlador(controladorSolicitudes);
        controladorSolicitudes.cargarSolicitudes();
        return solicitudes;
    }

    public IServicio llamarServicio() {
        IServicio servicio = new VServicio();
        MCrudServicio mCrudServicio = new MCrudServicio();
        CServicio controladorServicio = new CServicio(servicio, mCrudServicio);
        servicio.setControlador(controladorServicio);
        controladorServicio.cargarServicio(servicio);
        return servicio;
    }

    public IServicios llamarServicios() {
        IServicios servicios = new VServicios();
        MCrudServicio mCrudServicio = new MCrudServicio();
        CServicios controladorServicios = new CServicios(servicios, mCrudServicio);
        controladorServicios.cargarServicios();
        return servicios;
    }

    public IEvento llamarEvento() {
        IEvento evento = new VEvento();
        CEvento controladorEvento = new CEvento(evento);
        evento.setControlador(controladorEvento);
        return evento;
    }

    public IEventos llamarEventos() {
        IEventos eventos = new VEventos();
        MCrudEvento mCrudEvento = new MCrudEvento();
        CEventos controladorEventos = new CEventos(eventos, mCrudEvento);
        controladorEventos.cargarEventos();
        return eventos;
    }

    public ISugerencia llamarSugerencia() {
        ISugerencia sugerencia = new VSugerencia();
        MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
        CSugerencia controladorSugerencia = new CSugerencia(sugerencia, modelo2);
        sugerencia.setControlador(controladorSugerencia);
        return sugerencia;
    }

    public ISugerencias llamarSugerencias() {
        ISugerencias sugerencias = new VSugerencias();
        MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
        CSugerencias controladorSugerencias = new CSugerencias(sugerencias, mCrudSugerencia);
        sugerencias.setControlador(controladorSugerencias);
        controladorSugerencias.cargarSugerencias();
        return sugerencias;
    }

    public IPublicacion llamarPublicacion() {
        IPublicacion publicacion = new VPublicacion();
        CPublicacion controladorPublicacion = new CPublicacion(publicacion, modelo2);
        publicacion.setControlador(controladorPublicacion);
        return publicacion;
    }

    public ICartelera llamarCartelera() {
        ICartelera cartelera = new VCartelera();
        IPub pub = new VPub();
        MCartelera mCartelera = new MCartelera();
        CCartelera controlador = new CCartelera(cartelera, pub, mCartelera);
        controlador.cargarCartelera();
        return cartelera;
    }

    public IPubsPendientes llamarPubsPendientes() {
        IPubsPendientes pubsPendientes = new VPubsPendientes();
        MCartelera mCartelera = new MCartelera();
        CPubsPendientes controlador = new CPubsPendientes(pubsPendientes);
        controlador.cargarPubsPendientes();
        return pubsPendientes;
    }

    public ISolicitudCurso llamarSolicitudCurso() {
        ISolicitudReporte solicitudReporte = new VSolicitudReporte();
        MSolicitudR modulo = new MSolicitudR();
        CSolicitudReporte controladorSolicitudReporte = new CSolicitudReporte(solicitudReporte, modulo);
        solicitudReporte.setControlador(controladorSolicitudReporte);

        ISolicitudCurso solicitudCurso = new VSolicitudCurso(solicitudReporte);
        MSolicitudR modulo2 = new MSolicitudR();
        CSolicitudCurso controladorSolicitudCurso = new CSolicitudCurso(solicitudCurso, modulo2);
        solicitudCurso.setControlador(controladorSolicitudCurso);
        solicitudCurso.mostrar();
        solicitudCurso.desplegar();

        return solicitudCurso;
    }

    public ICambioContrasena llamarCambioContrasena() {
        ICambioContrasena cambioContrasena = new VCambioContrasena();
        CCambioContrasena controladorCambioContrasena = new CCambioContrasena(cambioContrasena, vista, modelo2);
        cambioContrasena.setControlador(controladorCambioContrasena);
        return cambioContrasena;
    }

}
