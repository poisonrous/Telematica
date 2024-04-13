package controlador;

import modelo.MCartelera;
import vista.IPub;
import vista.IPubsPendientes;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CPubsPendientes {
    private final IPubsPendientes vista;
    private MCartelera mCartelera = new MCartelera();
    private ResultSet rs = mCartelera.getPubsPendientes();



    public CPubsPendientes(IPubsPendientes vista) {
        this.vista = vista;
    }

public void cargarPubsPendientes() {
        JPanel publicacion = null;
        try {
            while (rs.next()){
                String titulo = rs.getString("tituloPu");
                String autor = rs.getString("NombresUs")+" "+rs.getString("ApellidosUs");
                String contenido = rs.getString("descripcionPu");
                vista.cargarPub(vista.getPublicacion(titulo, autor, contenido, rs.getTimestamp("fechaPu").toLocalDateTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aprobarPub() throws SQLException {
        rs.next();
        if(mCartelera.aprobarPub(rs.getInt("idPu"))>0) {
            JOptionPane.showMessageDialog(null, "Publicación aprobada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al aprobar la publicación.");
        };
    }

    public void rechazarPub() throws SQLException {
        rs.next();
        if(mCartelera.rechazarPub(rs.getInt("idPu"))>0) {
            JOptionPane.showMessageDialog(null, "Publicación rechazada.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al rechazar la publicación.");
        };
    }
}
