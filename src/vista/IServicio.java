package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;

// Interfaz para la gesti�n de servicios.
public interface IServicio {
    // Constantes para los botones
    String ACTUALIZAR = "Actualizar";
    String SELECCION = "Seleccion";

    void arrancar();  // Inicializa y muestra la interfaz de gesti�n de servicios.

    /**
     * Carga los servicios en la interfaz.
     * @param cbmServicio El modelo de lista desplegable de servicios.
     */
    void cargarServicio(ComboBoxModel cbmServicio); //

    /**
     * Maneja el evento de selecci�n de un servicio.
     * @param e El evento de selecci�n.
     */
    void servicioSeleccion(ItemEvent e);

    /**
     * Muestra la informaci�n del servicio seleccionado.
     * @param horario El horario del servicio.
     * @param ubicacion La ubicaci�n del servicio.
     * @param estatus El estado del servicio.
     */
    void mostrarServicio(String horario, String ubicacion, String estatus);

    /**
     * Establece el controlador para esta interfaz.
     * @param controlador El controlador asociado a esta interfaz.
     */
    void setControlador(CServicio controlador);

    /**
     * Obtiene el caso del servicio.
     * @return El caso del servicio.
     */
    int getCaso();

    /**
     * Obtiene el nombre del servicio.
     * @return El nombre del servicio.
     */
    String getNombreServicio();


    /**
     * Obtiene el horario del servicio.
     * @return El horario del servicio.
     */
    String getHorarioServicio();

    /**
     * Obtiene la ubicaci�n del servicio.
     * @return La ubicaci�n del servicio.
     */
    String getUbicacionServicio();

    /**
     * Obtiene el estatus del servicio
     * @return El estatus del servicio.
     */
    String getEstatusServicio();
}
