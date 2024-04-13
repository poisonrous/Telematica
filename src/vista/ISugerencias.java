package vista;

import controlador.CSugerencias;

import javax.swing.*;

public interface ISugerencias {


    void arrancar();
    void cargarSugest(JPanel sugerencia);

    void setControlador(CSugerencias controlador);

    JPanel getSugest(String titulo, String estudiante, String cedula, String fecha, String descripcion);
}
