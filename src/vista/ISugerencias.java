package vista;

import controlador.CSugerencias;

import javax.swing.*;
    // Interfaz para la gestión de sugerencias.
public interface ISugerencias {


    void arrancar();  // Inicia la interfaz de sugerencias.

        /**
         * Carga las sugerencias en un panel.
         * @param sugerencia El panel donde se cargarán las sugerencias.
         */
    void cargarSugest(JPanel sugerencia);

        /**
         * Establece el controlador para la interfaz de sugerencias.
         * @param controlador El controlador de sugerencias.
         */
    void setControlador(CSugerencias controlador);


        /**
         * Obtiene un panel con la información de una sugerencia.
         * @param titulo El título de la sugerencia.
         * @param estudiante El nombre del estudiante que envió la sugerencia.
         * @param cedula La cédula del estudiante que envió la sugerencia.
         * @param fecha La fecha de envío de la sugerencia.
         * @param descripcion La descripción de la sugerencia.
         * @return Un panel con la información de la sugerencia.
         */
    JPanel getSugest(String titulo, String estudiante, String cedula, String fecha, String descripcion);
}
