package vista;

import controlador.CSolicitudes;

import javax.swing.*;
    // Interfaz para la gestión de solicitudes.
public interface ISolicitudes {
    void arrancar();    // Inicia la interfaz de gestión de solicitudes.

        /**
         * Establece el controlador de la interfaz de gestión de solicitudes.
         * @param controlador El controlador de la gestión de solicitudes.
         */
    void setControlador(CSolicitudes controlador);

        /**
         * Carga las solicitudes en el panel de la interfaz.
         * @param solicitud El panel de solicitud.
         */
    void cargarSolicitud(JPanel solicitud);

        /**
         * Obtiene un panel de solicitud con la información proporcionada.
         * @param id El ID de la solicitud.
         * @param tipo El tipo de solicitud.
         * @param descripcion La descripción de la solicitud.
         * @param fecha La fecha de la solicitud.
         * @param status El estado de la solicitud.
         * @return El panel de solicitud.
         */
    JPanel getSolicitud(String id, String tipo, String descripcion, String fecha, String status);

}
