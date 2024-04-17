package controlador;

import modelo.MCrudSugerencia;
import vista.ISugerencias;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class CSugerencias {
    private final ISugerencias vista;
    private final MCrudSugerencia mCrudSugerencia;
    private ResultSet rs;

    public CSugerencias(ISugerencias vista, MCrudSugerencia mCrudSugerencia) {
        this.vista = vista;
        this.mCrudSugerencia = mCrudSugerencia;
    }

    public void cargarSugerencias()  {
        JPanel evento = null;
        rs = mCrudSugerencia.getSugestlist();
        try
        {
            while (rs.next()){
                String titulo = rs.getString("TituloSu");
                String estudiante = rs.getString("NombresEs") + " "+ rs.getString("ApellidosEs");
                String cedula = rs.getString("CedulaEs");
                String fecha = rs.getString("FechaSu");
                String descripcion = rs.getString("DescripcionSu");
                evento = vista.getSugest(titulo, estudiante, cedula, fecha, descripcion);
                vista.cargarSugest(evento);
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

}
