package vista;

import controlador.CCartelera;

import javax.swing.*;

public interface ICartelera {
    void arrancar();
    void cargarPub(JPanel publicacion);
    void setControlador(CCartelera controlador);


}
