package vista;
import javax.swing.*;
import controlador.CSugerencia;
// Interfaz para la gesti�n de sugerencias.
public interface ISugerencia {
    // Constante para la acci�n de un boton
    String ENVIAR = "Enviar";

    void arrancar(); // Inicia la interfaz de sugerencias

    /**
     * Obtiene el t�tulo de la sugerencia.
     * @return El t�tulo de la sugerencia.
     */
    String getTitulo(); //

    /**
     * Obtiene los detalles de la sugerencia.
     * @return Los detalles de la sugerencia.
     */
    String getDetalles();

    /**
     * Establece el controlador para la interfaz de sugerencias.
     * @param c El controlador de sugerencias.
     */
    void setControlador(CSugerencia c);

    /**
     * Muestra el resultado de la acci�n de enviar una sugerencia.
     * @param nombre El nombre del usuario que envi� la sugerencia.
     * @param apellido El apellido del usuario que envi� la sugerencia.
     * @param telefono El tel�fono del usuario que envi� la sugerencia.
     * @param correo El correo electr�nico del usuario que envi� la sugerencia.
     * @param sugerencia El t�tulo de la sugerencia.
     * @param descripcion Los detalles de la sugerencia.
     * @param fecha La fecha de env�o de la sugerencia.
     */
    void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
