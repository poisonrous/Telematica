package vista;

import controlador.CSugerencias;

import javax.swing.*;
    // Interfaz para la gesti�n de sugerencias.
public interface ISugerencias {


    void arrancar();  // Inicia la interfaz de sugerencias.

        /**
         * Carga las sugerencias en un panel.
         * @param sugerencia El panel donde se cargar�n las sugerencias.
         */
    void cargarSugest(JPanel sugerencia);

        /**
         * Establece el controlador para la interfaz de sugerencias.
         * @param controlador El controlador de sugerencias.
         */
    void setControlador(CSugerencias controlador);


        /**
         * Obtiene un panel con la informaci�n de una sugerencia.
         * @param titulo El t�tulo de la sugerencia.
         * @param estudiante El nombre del estudiante que envi� la sugerencia.
         * @param cedula La c�dula del estudiante que envi� la sugerencia.
         * @param fecha La fecha de env�o de la sugerencia.
         * @param descripcion La descripci�n de la sugerencia.
         * @return Un panel con la informaci�n de la sugerencia.
         */
    JPanel getSugest(String titulo, String estudiante, String cedula, String fecha, String descripcion);
}
