package modelo;
import java.sql.Connection;
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
        Connection con = (Connection) bd.getConexion();
        Servicio servicio = new Servicio();
     //   rs = bd.consultar("SELECT * FROM servicio WHERE nombreSe = '"+nombre+"'");
        try {
            String sql = "SELECT * FROM servicio WHERE nombreSe = '"+nombre+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getString("idSe"));
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
    public int crearServicio(String nombre, String horario, String ubicacion, String estatus) {
        int resultado = 0;
        try {
            bd.abrirConexion();
            bd.ejecutar("INSERT INTO servicio (nombreSe, horarioSe, ubicacionSe, estatusSe) VALUES ('"+nombre+"', '"+horario+"', '"+ubicacion+"', '"+estatus+"')");
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
