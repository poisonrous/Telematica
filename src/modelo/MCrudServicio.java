package modelo;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.BdConex;
import modelo.Servicio;


import javax.swing.*;

// Clase MCrudServicio aporta métodos para la gestión de servicios sociales en la base de datos.

public class MCrudServicio {
    Servicio servicio = new Servicio();
    BdConex bd = new BdConex();
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Busca un servicio en la base de datos por su nombre.
     * @param nombre El nombre del servicio a buscar.
     * @return Un objeto de tipo Servicio que contiene la información del servicio encontrado, o un objeto vacío si no se encuentra.
     */
    public Servicio buscarServicio(String nombre) {
        Connection con = bd.getConexion();
        Servicio servicio = new Servicio();
     //   rs = bd.consultar("SELECT * FROM servicio WHERE nombreSe = '"+nombre+"'");
        try {
            // Consulta SQL para buscar el servicio por su nombre
            String sql = "SELECT * FROM serviciossociales WHERE tipoSS = '"+nombre.replace("'","''")+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Si se encuentra el servicio, se crea un objeto Servicio con la información encontrada
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

    /**
     * Crea un nuevo servicio en la base de datos.
     * @param nombre El nombre del servicio.
     * @param horario El horario del servicio.
     * @param ubicacion La ubicación del servicio.
     * @param estatus El estado del servicio (activo o inactivo).
     * @return Un entero que indica si la operación fue exitosa (1) o no (0).
     */
    public int crearServicio(String nombre, String horario, String ubicacion, String estatus) {
        int resultado = 0;
        try {
            bd.abrirConexion();
            bd.ejecutar("INSERT INTO serviciossociales (tipoSS, horarioSS, ubicacionSS, estatusSS) VALUES ('"+nombre.replace("'","''")+"', '"+horario.replace("'","''")+"', '"+ubicacion.replace("'","''")+"', '"+estatus.replace("'","''")+"')");
            // Mensaje de confirmación de la operación exitosa

            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);

            ImageIcon iconC = new ImageIcon("media/informacion.png");

            JOptionPane.showMessageDialog(null, "Servicio creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear el servicio");
        }
        return resultado;
    }

    /**
     * Modifica un servicio existente en la base de datos.
     * @param nombre El nombre del servicio a modificar.
     * @param horario El nuevo horario del servicio.
     * @param ubicacion La nueva ubicación del servicio.
     * @param estatus El nuevo estado del servicio (activo o inactivo).
     * @return Un entero que indica si la operación fue exitosa (1) o no (0).
     */
    public int modificarServicio(String nombre, String horario, String ubicacion, String estatus) {
        int resultado = 0;
        try {
            bd.abrirConexion();
            bd.ejecutar("UPDATE serviciossociales SET horarioSS = '"+horario.replace("'","''")+"', ubicacionSS = '"+ubicacion.replace("'","''")+"', estatusSS = '"+estatus.replace("'","''")+"' WHERE tipoSS = '"+nombre.replace("'","''")+"'");
            // Mensaje de confirmación de la operación exitosa
            JOptionPane.showMessageDialog(null, "Servicio modificado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar el servicio");
        }
        return resultado;
    }

    /**
     * Obtiene un conjunto de resultados que representa los servicios activos en la base de datos.
     * @return Un objeto ResultSet que contiene los servicios activos.
     */
    public ResultSet getResultSet(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        // Consulta SQL para obtener los servicios activos
        rs= bd.consultar("SELECT * FROM serviciossociales WHERE estatusSS='1'");
        return rs;
    }
}
