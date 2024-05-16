package vista;

import controlador.CServicios;

import javax.swing.*;
    // Interfaz para la gestión de la lista de servicios.
public interface IServicios {
    void arrancar();  // Inicializa y muestra la interfaz de la lista de servicios.

        /**
         * Carga los servicios en la interfaz.
         * @param servicio El panel de servicios.
         */
    void cargarSer(JPanel servicio);

        /**
         * Establece el controlador para esta interfaz.
         * @param controlador El controlador asociado a esta interfaz.
         */
    void setControlador(CServicios controlador);


        /**
         * Obtiene el panel de un servicio.
         * @param titulo El título del servicio.
         * @param ubicacion La ubicación del servicio.
         * @param horario El horario del servicio.
         * @return El panel de servicio.
         */
    JPanel getServicio(String titulo, String ubicacion, String horario);
}
