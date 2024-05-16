package vista;

import controlador.CCartelera;

import javax.swing.*;

 // Interfaz que define los métodos necesarios para la vista de la cartelera de publicaciones.
public interface ICartelera {
    // Inicia la vista de la cartelera.
    void arrancar();

     /**
      * Carga las publicaciones en el panel especificado.
      * @param publicacion el panel donde se cargarán las publicaciones
      */
    void cargarPub(JPanel publicacion);


     /**
      * Establece el controlador para esta interfaz.
      * @param controlador el controlador CCartelera
      */
    void setControlador(CCartelera controlador);


}
