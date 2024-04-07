package vista;

import controlador.CSolicitudCurso;

import javax.swing.*;
import java.sql.ResultSet;

public interface ISolicitudCurso {
    String SELECT = "select";
    String PARAMETROS = "parametros";

    void setControlador(CSolicitudCurso a);
    void cargarEstado (ComboBoxModel cbEstado);
    void cargarTipo (ComboBoxModel cbTipo);
    String getEstado();
    //void setEstado();
    void setConsulta(ResultSet rs);
    void mostrar();
    void desplegar () ;
    void activar();
    int getTest();
    void probando();

    void nuevatabla();

    void limpiarTabla();

    Object getTipo();
}
