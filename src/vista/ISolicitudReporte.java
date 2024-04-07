package vista;

import controlador.CSolicitudReporte;

import java.sql.ResultSet;

public interface ISolicitudReporte {
    String CAMBIAR = "cambiar";
    String CAMBIARPLUS = "cambiarplus";


        void setConsulta(ResultSet rs);
        void setControlador(CSolicitudReporte a);


    void llamar(String idSo);
    void activar();
    String getEstado();
    String getIdSo();



}
