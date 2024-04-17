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
        Connection con = bd.getConexion();
        Servicio servicio = new Servicio();
     //   rs = bd.consultar("SELECT * FROM servicio WHERE nombreSe = '"+nombre+"'");
        try {
            String sql = "SELECT * FROM serviciossociales WHERE tipoSS = '"+nombre.replace("'","''")+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getString("idSS"));
                servicio.setNombreServicio(rs.getString("tipoSS"));
                servicio.setHorarioServicio(rs.getString("horarioSS"));
                servicio.setUbicacionServicio(rs.getString("ubicacionSS"));
                servicio.setEstatusServicio(rs.getString("estatusSS"));
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
            bd.ejecutar("INSERT INTO serviciossociales (tipoSS, horarioSS, ubicacionSS, estatusSS) VALUES ('"+nombre.replace("'","''")+"', '"+horario.replace("'","''")+"', '"+ubicacion.replace("'","''")+"', '"+estatus.replace("'","''")+"')");
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
            bd.ejecutar("UPDATE serviciossociales SET horarioSS = '"+horario.replace("'","''")+"', ubicacionSS = '"+ubicacion.replace("'","''")+"', estatusSS = '"+estatus.replace("'","''")+"' WHERE tipoSS = '"+nombre.replace("'","''")+"'");
            JOptionPane.showMessageDialog(null, "Servicio modificado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar el servicio");
        }
        return resultado;
    }

    public ResultSet getResultSet(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM serviciossociales WHERE estatusSS='1'");
        return rs;
    }
}
