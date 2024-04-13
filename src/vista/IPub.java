package vista;

import javax.swing.*;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public interface IPub {
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);
}
