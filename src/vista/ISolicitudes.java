package vista;

import controlador.CSolicitudes;

import javax.swing.*;

public interface ISolicitudes {
    void arrancar();
    void setControlador(CSolicitudes controlador);
    void cargarSolicitud(JPanel solicitud);
    JPanel getSolicitud(String id, String tipo, String descripcion, String fecha, String status);

}
