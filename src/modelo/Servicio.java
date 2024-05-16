package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

// Clase Servicio es un servicio social.
public class Servicio {
    private String idServicio, nombreServicio, horarioServicio, ubicacionServicio, estatusServicio;

    /**
     * Constructor de Servicio
     * @param idServicio        El ID del servicio.
     * @param nombreServicio    El nombre del servicio.
     * @param horarioServicio   El horario del servicio.
     * @param ubicacionServicio La ubicación del servicio.
     * @param estatusServicio   El estado del servicio.
     */
    public Servicio(String idServicio, String nombreServicio, String horarioServicio, String ubicacionServicio, String estatusServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.horarioServicio = horarioServicio;
        this.ubicacionServicio = ubicacionServicio;
        this.estatusServicio = estatusServicio;
    }

    // Constructor vacío de Servicio.
    public Servicio() {

    }
    /**
     * Obtiene el ID del servicio.
     * @return El ID del servicio.
     */
    public String getIdServicio() {
        if (idServicio == null) {
            return "";
        }
        return idServicio;
    }

    /**
     * Establece el ID del servicio.
     * @param idServicio El ID del servicio.
     */
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * Obtiene el nombre del servicio.
     * @return El nombre del servicio.
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * Establece el nombre del servicio.
     * @param nombreServicio El nombre del servicio.
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * Obtiene el horario del servicio.
     * @return El horario del servicio.
     */
    public String getHorarioServicio() {
        return horarioServicio;
    }

    /**
     * Establece el horario del servicio.
     * @param horarioServicio El horario del servicio.
     */
    public void setHorarioServicio(String horarioServicio) {
        this.horarioServicio = horarioServicio;
    }

    /**
     * Obtiene la ubicación del servicio.
     * @return La ubicación del servicio.
     */
    public String getUbicacionServicio() {
        return ubicacionServicio;
    }

    /**
     * Establece la ubicación del servicio.
     * @param ubicacionServicio La ubicación del servicio.
     */
    public void setUbicacionServicio(String ubicacionServicio) {
        this.ubicacionServicio = ubicacionServicio;
    }

    /**
     * Obtiene el estado del servicio.
     * @return El estado del servicio.
     */
    public String getEstatusServicio() {
        return estatusServicio;
    }

    /**
     * Establece el estado del servicio.
     * @param estatusServicio El estado del servicio.
     */
    public void setEstatusServicio(String estatusServicio) {
        this.estatusServicio = estatusServicio;
    }

    /**
     * Muestra una representación de cadena del objeto Servicio
     * @return El nombre del servicio.
     */
    @Override
    public String toString() {
        return nombreServicio;
    }

    /**
     * Obtiene un vector de objetos Servicio.
     * @return Un vector de objetos Servicio.
     */
    public Vector<Servicio> vectorServicio() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = conn.getConexion();
        Vector<Servicio> datos = new Vector<Servicio>();
        Servicio dat = null;
        try {
            // Consulta SQL para obtener los servicios sociales no borrados
            String sql = "SELECT * FROM serviciossociales WHERE borradoSS = 0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Se crea un objeto Servicio con datos vacíos y se añade al vector
            dat = new Servicio();
            dat.setIdServicio("");
            dat.setNombreServicio("");
            dat.setHorarioServicio("");
            dat.setUbicacionServicio("");
            dat.setEstatusServicio("");
            datos.add(dat);
            // Se recorre el resultado de la consulta y se van añadiendo los servicios al vector
            while (rs.next()) {
                dat = new Servicio();
                dat.setIdServicio(rs.getString("IdSS"));
                dat.setNombreServicio(rs.getString("TipoSS"));
                dat.setHorarioServicio(rs.getString("HorarioSS"));
                dat.setUbicacionServicio(rs.getString("UbicacionSS"));
                dat.setEstatusServicio(rs.getString("EstatusSS"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datos;
    }
}
