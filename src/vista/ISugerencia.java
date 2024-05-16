package vista;
import javax.swing.*;
import controlador.CSugerencia;
// Interfaz para la gestión de sugerencias.
public interface ISugerencia {
    // Constante para la acción de un boton
    String ENVIAR = "Enviar";

    void arrancar(); // Inicia la interfaz de sugerencias

    /**
     * Obtiene el título de la sugerencia.
     * @return El título de la sugerencia.
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
     * Muestra el resultado de la acción de enviar una sugerencia.
     * @param nombre El nombre del usuario que envió la sugerencia.
     * @param apellido El apellido del usuario que envió la sugerencia.
     * @param telefono El teléfono del usuario que envió la sugerencia.
     * @param correo El correo electrónico del usuario que envió la sugerencia.
     * @param sugerencia El título de la sugerencia.
     * @param descripcion Los detalles de la sugerencia.
     * @param fecha La fecha de envío de la sugerencia.
     */
    void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
