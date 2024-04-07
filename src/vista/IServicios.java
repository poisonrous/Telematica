package vista;

import controlador.CServicios;

import javax.swing.*;

public interface IServicios {
    public void arrancar();
    public void cargarSer(JPanel servicio);
    public void setControlador(CServicios controlador);
    public JPanel getServicio(String titulo, String ubicacion, String horario);
}
