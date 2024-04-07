package controlador;

import modelo.MCrudServicio;
import vista.IServicios;

import javax.swing.*;
import java.sql.ResultSet;

public class CServicios {
    private IServicios vista;
    private MCrudServicio mCrudServicio;
    private ResultSet rs;


    public CServicios(IServicios vista, MCrudServicio mCrudServicio) {
        this.vista = vista;
        this.mCrudServicio = mCrudServicio;
    }

    public void cargarServicios() {
        JPanel servicio = null;
        rs = mCrudServicio.getResultSet();
        try {
            while (rs.next()){
                String titulo = rs.getString("tipoSS");
                String ubicacion = rs.getString("ubicacionSS");
                String horario = rs.getString("horarioSS");
                servicio = vista.getServicio(titulo, ubicacion, horario);
                vista.cargarSer(servicio);
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
