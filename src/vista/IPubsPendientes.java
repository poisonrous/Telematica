package vista;

import controlador.CCartelera;
import controlador.CPubsPendientes;

import javax.swing.*;
import java.time.temporal.TemporalAccessor;
// Interfaz para la pantalla de publicaciones pendientes.
public interface IPubsPendientes {
    void arrancar();    // Inicializa y muestra la pantalla de publicaciones pendientes.

    /**
     * Carga las publicaciones pendientes en un panel.
     * @param publicacion El panel donde se cargarán las publicaciones pendientes.
     */
    void cargarPub(JPanel publicacion);

    /**
     * Establece el controlador para esta interfaz.
     * @param controlador El controlador asociado a esta interfaz.
     */
    void setControlador(CPubsPendientes controlador);

    /**
     * Obtiene un panel que representa una publicación pendiente.
     * @param titulo     El título de la publicación.
     * @param autor      El autor de la publicación.
     * @param contenido  El contenido de la publicación.
     * @param fecha      La fecha de la publicación.
     * @return           El panel que representa la publicación pendiente.
     */
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);

}
