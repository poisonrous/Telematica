package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.BdConex;
import modelo.Servicio;

import javax.swing.*;

public class MCrudServicio {
    Servicio servicio = new Servicio();
    BdConex bd = new BdConex();
    PreparedStatement ps;
    ResultSet rs;

    public Servicio buscarServicio(String nombre) {
        Servicio servicio = new Servicio();
        bd.abrirConexion();
        rs = bd.consultar("SELECT * FROM servicio WHERE nombreSe = '"+nombre+"'");
        try {
            if (rs.next()) {
                servicio.setIdServicio(rs.getString("idServicio"));
                servicio.setNombreServicio(rs.getString("nombreSe"));
                servicio.setHorarioServicio(rs.getString("horarioSe"));
                servicio.setUbicacionServicio(rs.getString("ubicacionSe"));
                servicio.setEstatusServicio(rs.getString("estatusSe"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el servicio.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el servicio");
        }
        return servicio;
    }
    public int crearServicio(String nombre, String horario, String ubicacion) {
        int resultado = 0;
        try {
            bd.abrirConexion();
            rs=bd.consultar("INSERT INTO servicio (nombreSe, horarioSe, ubicacionSe) VALUES ('"+nombre+"', '"+horario+"', '"+ubicacion+"')");
            JOptionPane.showMessageDialog(null, "Servicio creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear el servicio");
        }
        return resultado;
    }

    public int modificarServicio(String nombre, String horario, String ubicacion, String estatus) {
        int resultado = 0;
        try {
            bd.abrirConexion();
            bd.ejecutar("UPDATE servicio SET horarioSe = '"+horario+"', ubicacionSe = '"+ubicacion+"', estatusSe = '"+estatus+"' WHERE nombreSe = '"+nombre+"'");
            JOptionPane.showMessageDialog(null, "Servicio modificado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar el servicio");
        }
        return resultado;
    }
}
