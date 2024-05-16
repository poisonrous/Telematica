package vista;
import controlador.CEventos;

import javax.swing.JPanel;

// Interfaz que define los métodos necesarios para la gestión de eventos.
public interface IEventos {
    void arrancar();  // Inicializa y muestra la interfaz de usuario para la gestión de eventos
    void cargarEve(JPanel evento);  // Carga la información de los eventos en un panel de la interfaz de usuario
    void setControlador(CEventos controlador);  // Establece el controlador para esta interfaz.

    /**
     * Obtiene un panel que muestra la información detallada de un evento.
     * @param titulo El título del evento.
     * @param descripcion La descripción del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param lugar El lugar del evento.
     * @param organizador El organizador del evento.
     * @param modalidad La modalidad del evento.
     * @param precio El precio del evento.
     * @return Un panel que muestra la información detallada del evento.
     */
    JPanel getEvento(String titulo, String descripcion, String fecha, String hora, String lugar, String organizador, String modalidad, String precio);

}
