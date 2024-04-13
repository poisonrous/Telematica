package vista;

import controlador.CServicios;

import javax.swing.*;

public interface IServicios {
    void arrancar();
    void cargarSer(JPanel servicio);
    void setControlador(CServicios controlador);
    JPanel getServicio(String titulo, String ubicacion, String horario);
}
