package vista;

import controlador.CSolicitudCurso;

import javax.swing.*;
import java.sql.ResultSet;

public interface ISolicitudCurso {
    String SELECT = "select";
    String PARAMETROS = "parametros";

    void setControlador(CSolicitudCurso a);
    String getEstado();
    String getTipo();
    String getCarrera();


    //void setEstado();
    void setConsulta(ResultSet rs);
    void mostrar();
    void desplegar () ;
    void activar();
    Double getTest();
    void probando();

    void nuevatabla();

    void limpiarTabla();

}
