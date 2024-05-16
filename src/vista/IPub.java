package vista;

import javax.swing.*;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
    // Interfaz para la creaci�n de una publicaci�n
public interface IPub {
        /**
         * Crea y devuelve un panel de publicaci�n con la informaci�n proporcionada.
         * @param titulo El t�tulo de la publicaci�n.
         * @param autor El autor de la publicaci�n.
         * @param contenido El contenido de la publicaci�n.
         * @param fecha La fecha de la publicaci�n.
         * @return El panel de la publicaci�n.
         */
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);
}
