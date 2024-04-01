package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class Servicio {
    private String idServicio, nombreServicio, horarioServicio, ubicacionServicio, estaatusServicio;

    public Servicio(String idServicio, String nombreServicio, String horarioServicio, String ubicacionServicio, String estaatusServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.horarioServicio = horarioServicio;
        this.ubicacionServicio = ubicacionServicio;
        this.estaatusServicio = estaatusServicio;
    }

    public Servicio() {

    }

    public String getIdServicio() {
        if (idServicio == null) {
            return "";
        }
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getHorarioServicio() {
        return horarioServicio;
    }

    public void setHorarioServicio(String horarioServicio) {
        this.horarioServicio = horarioServicio;
    }

    public String getUbicacionServicio() {
        return ubicacionServicio;
    }

    public void setUbicacionServicio(String ubicacionServicio) {
        this.ubicacionServicio = ubicacionServicio;
    }

    public String getEstatusServicio() {
        return estaatusServicio;
    }

    public void setEstatusServicio(String estaatusServicio) {
        this.estaatusServicio = estaatusServicio;
    }

    @Override
    public String toString() {
        return nombreServicio;
    }

    public Vector<Servicio> vectorServicio() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();
        Vector<Servicio> datos = new Vector<Servicio>();
        Servicio dat = null;
        try {
            String sql = "SELECT * FROM servicio";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            dat = new Servicio();
            dat.setIdServicio("");
            dat.setNombreServicio("");
            dat.setHorarioServicio("");
            dat.setUbicacionServicio("");
            dat.setEstatusServicio("");
            datos.add(dat);
            while (rs.next()) {
                dat = new Servicio();
                dat.setIdServicio(rs.getString("idSe"));
                dat.setNombreServicio(rs.getString("nombreSe"));
                dat.setHorarioServicio(rs.getString("horarioSe"));
                dat.setUbicacionServicio(rs.getString("ubicacionSe"));
                dat.setEstatusServicio(rs.getString("estatusSe"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datos;
    }
}
