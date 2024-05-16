package vista;

import controlador.CPublicacion;
import controlador.CSugerencia;
    // Interfaz para la creaci�n de una publicaci�n.
public interface IPublicacion {
   // Constante para una accion de un boton
    String ENVIAR = "Enviar";
    void arrancar(); // Inicia la interfaz de publicaci�n.
    void limpiar();  // Limpia los campos de la interfaz de publicaci�n.

        /**
         * Obtiene el t�tulo de la publicaci�n.
         * @return El t�tulo de la publicaci�n.
         */
    String getTitulo();

        /**
         * Obtiene la descripci�n de la publicaci�n
         * @return La descripci�n de la publicaci�n.
         */
    String getDescripcion();

        /**
         * Establece el controlador de la interfaz de publicaci�n.
         * @param c El controlador de la publicaci�n.
         */
    void setControlador(CPublicacion c);
 //   public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
