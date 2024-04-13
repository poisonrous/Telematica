package vista;

import controlador.CCartelera;
import controlador.CPubsPendientes;

import javax.swing.*;
import java.time.temporal.TemporalAccessor;

public interface IPubsPendientes {
    void arrancar();
    void cargarPub(JPanel publicacion);
    void setControlador(CPubsPendientes controlador);
    JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha);

}
