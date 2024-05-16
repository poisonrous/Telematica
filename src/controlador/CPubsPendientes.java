package controlador;

import modelo.MCartelera;
import vista.IPub;
import vista.IPubsPendientes;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

// Controlador para la gestión de publicaciones pendientes.

public class CPubsPendientes {
    private final IPubsPendientes vista; // Vista para las publicaciones pendientes
    private MCartelera mCartelera = new MCartelera();  // Modelo de la cartelera
    private ResultSet rs = mCartelera.getPubsPendientes(); // Resultado de las publicaciones pendientes


    /**
     * Constructor de la clase CPubsPendientes.
     * @param vista La vista para las publicaciones pendientes.
     */
    public CPubsPendientes(IPubsPendientes vista) {
        this.vista = vista;
    }

    /**
     * Carga las publicaciones pendientes en la vista.
     */
public void cargarPubsPendientes() {
        JPanel publicacion = null;
        try {
            while (rs.next()){
                // Obtiene los detalles de la publicación pendiente
                String titulo = rs.getString("tituloPu");
                String autor = rs.getString("NombresUs")+" "+rs.getString("ApellidosUs");
                String contenido = rs.getString("descripcionPu");
                // Carga la publicación en la vista
                vista.cargarPub(vista.getPublicacion(titulo, autor, contenido, rs.getTimestamp("fechaPu").toLocalDateTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Aprueba una publicación pendiente.
     * @throws SQLException Si ocurre un error SQL.
     */
    public void aprobarPub() throws SQLException {
        rs.next();  // Avanza al siguiente registro
        // Intenta aprobar la publicación en la base de datos

        if(mCartelera.aprobarPub(rs.getInt("idPu"))>0) {

            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);


            JOptionPane.showMessageDialog(null, "Publicación aprobada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al aprobar la publicación.");
        };
    }

    /**
     * Rechaza una publicación pendiente.
     * @throws SQLException Si ocurre un error SQL.
     */
    public void rechazarPub() throws SQLException {
        rs.next(); // Avanza al siguiente registro
        // Intenta rechazar la publicación en la base de datos
        if(mCartelera.rechazarPub(rs.getInt("idPu"))>0) {
            JOptionPane.showMessageDialog(null, "Publicación rechazada.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al rechazar la publicación.");
        };
    }
}
