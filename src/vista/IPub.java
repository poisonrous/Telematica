package vista;

import javax.swing.*;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
    // Interfaz para la creación de una publicación
public interface IPub {
        /**
         * Crea y devuelve un panel de publicación con la información proporcionada.
         * @param titulo El título de la publicación.
         * @param autor El autor de la publicación.
         * @param contenido El contenido de la publicación.
         * @param fecha La fecha de la publicación.
         * @return El panel de la publicación.
         */
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);
}
