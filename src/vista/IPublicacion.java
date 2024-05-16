package vista;

import controlador.CPublicacion;
import controlador.CSugerencia;
    // Interfaz para la creación de una publicación.
public interface IPublicacion {
   // Constante para una accion de un boton
    String ENVIAR = "Enviar";
    void arrancar(); // Inicia la interfaz de publicación.
    void limpiar();  // Limpia los campos de la interfaz de publicación.

        /**
         * Obtiene el título de la publicación.
         * @return El título de la publicación.
         */
    String getTitulo();

        /**
         * Obtiene la descripción de la publicación
         * @return La descripción de la publicación.
         */
    String getDescripcion();

        /**
         * Establece el controlador de la interfaz de publicación.
         * @param c El controlador de la publicación.
         */
    void setControlador(CPublicacion c);
 //   public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
