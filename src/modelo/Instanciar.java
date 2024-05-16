package modelo;
import vista.*;
import controlador.*;

import javax.swing.*;
import java.awt.*;

// Clase Instanciar que crear instancias de las interfaces y controladores
public class Instanciar {


    // Variables de instancia
    private static IIniciarSesion vista;
    private static Modelo modelo;
    private static OModelo modelo2;
    private static CIniciarSesion controlador;


    /**
     * Constructor de la clase Instanciar.
     * @param vista Vista de inicio de sesión.
     * @param modelo Modelo general.
     * @param modelo2 Modelo de usuario.
     * @param controlador Controlador de inicio de sesión.
     */
    public Instanciar(IIniciarSesion vista, Modelo modelo, OModelo modelo2, CIniciarSesion controlador) {
        this.vista = vista;
        this.modelo = modelo;
        this.modelo2 = modelo2;
        this.controlador = controlador;

    }

    /**
     * Crea y retorna una instancia de la vista ISolicitud.
     * @return Instancia de ISolicitud.
     */
    public ISolicitud llamarSolicitud() {
        ISolicitud solicitud = new VSolicitud();
        CSolicitud controladorSolicitud = new CSolicitud(solicitud, modelo2);
        solicitud.setControlador(controladorSolicitud);
        solicitud.cargarMaterias(modelo2.getUsuario());
        return solicitud;
    }

    /**
     * Crea y retorna una instancia de la interfaz ISolicitudes.
     * @return Instancia de ISolicitudes.
     */
    public ISolicitudes llamarSolicitudes() {
        ISolicitudes solicitudes = new VSolicitudes();
        MCrudSolicitud mCrudSolicitud = new MCrudSolicitud();
        CSolicitudes controladorSolicitudes = new CSolicitudes(solicitudes, mCrudSolicitud, modelo2);
        solicitudes.setControlador(controladorSolicitudes);
        controladorSolicitudes.cargarSolicitudes();
        return solicitudes;
    }

    /**
     * Crea y retorna una instancia de la interfaz IServicio.
     * @return Instancia de IServicio.
     */
    public IServicio llamarServicio() {
        IServicio servicio = new VServicio();
        MCrudServicio mCrudServicio = new MCrudServicio();
        CServicio controladorServicio = new CServicio(servicio, mCrudServicio);
        servicio.setControlador(controladorServicio);
        controladorServicio.cargarServicio(servicio);
        return servicio;
    }

    /**
     * Crea y retorna una instancia de la interfaz IServicios.
     * @return Instancia de IServicios.
     */
    public IServicios llamarServicios() {
        IServicios servicios = new VServicios();
        MCrudServicio mCrudServicio = new MCrudServicio();
        CServicios controladorServicios = new CServicios(servicios, mCrudServicio);
        controladorServicios.cargarServicios();
        return servicios;
    }

    /**
     * Crea y retorna una instancia de la interfaz IEvento.
     * @return Instancia de IEvento.
     */
    public IEvento llamarEvento() {
        IEvento evento = new VEvento();
        CEvento controladorEvento = new CEvento(evento);
        evento.setControlador(controladorEvento);
        return evento;
    }

    /**
     * Crea y retorna una instancia de la interfaz IEventos.
     * @return Instancia de IEventos.
     */
    public IEventos llamarEventos() {
        IEventos eventos = new VEventos();
        MCrudEvento mCrudEvento = new MCrudEvento();
        CEventos controladorEventos = new CEventos(eventos, mCrudEvento);
        controladorEventos.cargarEventos();
        return eventos;
    }

    /**
     * Crea y retorna una instancia de la interfaz ISugerencia.
     * @return Instancia de ISugerencia.
     */
    public ISugerencia llamarSugerencia() {
        ISugerencia sugerencia = new VSugerencia();
        MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
        CSugerencia controladorSugerencia = new CSugerencia(sugerencia, modelo2);
        sugerencia.setControlador(controladorSugerencia);
        return sugerencia;
    }

    /**
     * Crea y retorna una instancia de la interfaz ISugerencias.
     * @return Instancia de ISugerencias.
     */
    public ISugerencias llamarSugerencias() {
        ISugerencias sugerencias = new VSugerencias();
        MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
        CSugerencias controladorSugerencias = new CSugerencias(sugerencias, mCrudSugerencia);
        sugerencias.setControlador(controladorSugerencias);
        controladorSugerencias.cargarSugerencias();
        JOptionPane.showMessageDialog((Component) vista,
                "¡Justo iba a sugerir eso!",
                "¿Revisas las sugerencias?",
                JOptionPane.PLAIN_MESSAGE);
        return sugerencias;

    }

    /**
     * Crea y retorna una instancia de la interfaz IPublicacion.
     * @return Instancia de IPublicacion.
     */
    public IPublicacion llamarPublicacion() {
        IPublicacion publicacion = new VPublicacion();
        CPublicacion controladorPublicacion = new CPublicacion(publicacion, modelo2);
        publicacion.setControlador(controladorPublicacion);
        return publicacion;
    }

    /**
     * Crea y retorna una instancia de la interfaz ICartelera.
     * @return Instancia de ICartelera.
     */
    public ICartelera llamarCartelera() {
        ICartelera cartelera = new VCartelera();
        IPub pub = new VPub();
        MCartelera mCartelera = new MCartelera();
        CCartelera controlador = new CCartelera(cartelera, pub, mCartelera);
        controlador.cargarCartelera();
        return cartelera;
    }

    /**
     * Crea y retorna una instancia de la interfaz IPubsPendientes.
     * @return Instancia de IPubsPendientes.
     */
    public IPubsPendientes llamarPubsPendientes() {
        IPubsPendientes pubsPendientes = new VPubsPendientes();
        MCartelera mCartelera = new MCartelera();
        CPubsPendientes controlador = new CPubsPendientes(pubsPendientes);
        controlador.cargarPubsPendientes();
        return pubsPendientes;
    }

    /**
     * Crea y retorna una instancia de la interfaz ISolicitudCurso.
     * @return Instancia de ISolicitudCurso.
     */
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

        JOptionPane.showMessageDialog((Component) vista,
                "¡Eres un sol!",
                "¿Revisas las solicitudes?",
                JOptionPane.PLAIN_MESSAGE);

        return solicitudCurso;
    }

    /**
     * Crea y retorna una instancia de la interfaz ICambioContrasena.
     * @return Instancia de ICambioContrasena.
     */
    public ICambioContrasena llamarCambioContrasena() {
        ICambioContrasena cambioContrasena = new VCambioContrasena();
        CCambioContrasena controladorCambioContrasena = new CCambioContrasena(cambioContrasena, vista, modelo2);
        cambioContrasena.setControlador(controladorCambioContrasena);
        return cambioContrasena;
    }

    /**
     * Crea y retorna una instancia de la interfaz IDatos.
     * @return Instancia de IDatos.
     */
    public IDatos llamarDatos() {
        IDatos datos = new VDatos();
        MDatos modulo = new MDatos();
        CDatos controladorDatos = new CDatos(datos, modulo);
        datos.setControlador(controladorDatos);
        datos.llamar();
        return datos;
    }

    /**
     * Crea y retorna una instancia de la interfaz IListado.
     * @return Instancia de IListado.
     */
    public IListado llamarListado() {
        IListado listado = new VListado();
        MListado modelo = new MListado();
        CListado controlador = new CListado(listado, modelo, modelo2);
        listado.setControlador(controlador);
        controlador.cargarMaterias();
        return listado;
    }

    /**
     * Crea y retorna una instancia de la interfaz IRegistro.
     * @return Instancia de IRegistro.
     */
    public IRegistro llamarRegistro() {
        IRegistro registro = new VRegistro();
        MRegistro modelo = new MRegistro();
        Estudiante estudiante = new Estudiante();
        CRegistro controlador = new CRegistro(registro, estudiante, modelo);
        registro.setControlador(controlador);
        registro.cargarMateria();
        return registro;
    }

}
