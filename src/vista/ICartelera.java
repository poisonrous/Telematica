package vista;

import controlador.CCartelera;

import javax.swing.*;

public interface ICartelera {
    public void arrancar();
    public void cargarPub(JPanel publicacion);
    public void setControlador(CCartelera controlador);

}
