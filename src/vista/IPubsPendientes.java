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
     * @param publicacion El panel donde se cargar�n las publicaciones pendientes.
     */
    void cargarPub(JPanel publicacion);

    /**
     * Establece el controlador para esta interfaz.
     * @param controlador El controlador asociado a esta interfaz.
     */
    void setControlador(CPubsPendientes controlador);

    /**
     * Obtiene un panel que representa una publicaci�n pendiente.
     * @param titulo     El t�tulo de la publicaci�n.
     * @param autor      El autor de la publicaci�n.
     * @param contenido  El contenido de la publicaci�n.
     * @param fecha      La fecha de la publicaci�n.
     * @return           El panel que representa la publicaci�n pendiente.
     */
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);

}
