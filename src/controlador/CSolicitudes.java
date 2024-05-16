package controlador;

import modelo.MCrudSolicitud;
import modelo.OModelo;
import vista.ISolicitudes;

import javax.swing.*;
import java.sql.ResultSet;

// Controlador para la gestión de solicitudes.

public class CSolicitudes {
    private final ISolicitudes vista;  // Vista de solicitudes
    private final MCrudSolicitud mCrudSolicitud; // Modelo de CRUD de solicitud
    private final OModelo usuario; // Modelo de usuario
    private ResultSet rs; // Resultado de las solicitudes

    /**
     * Constructor de la clase CSolicitudes.
     * @param vista         Vista de usuario ISolicitudes.
     * @param mCrudSolicitud Modelo para el manejo de solicitudes.
     * @param usuario       Objeto de usuario.
     */
    public CSolicitudes(ISolicitudes vista, MCrudSolicitud mCrudSolicitud, OModelo usuario) {
        this.vista = vista;
        this.mCrudSolicitud = mCrudSolicitud;
        this.usuario = usuario;
    }

    /**
     * Carga las solicitudes del usuario y las muestra en la vista.
     */
    public void cargarSolicitudes(){
        JPanel solicitud = null;

        /**
         * Carga las solicitudes del usuario y las muestra en la vista.
         */
        rs = mCrudSolicitud.getSolicitudes(usuario.getUsuario());
        try {
            while (rs.next()){
                // Obtiene los datos de la solicitud desde el ResultSet
                String id = rs.getString("idSo");
                String tipo = rs.getString("tipoTiSo");
                String descripcion = rs.getString("descripcionSo");
                String fecha = rs.getString("fechaSo");
                String status = rs.getString("EstadoSo");
                // Crea un panel de solicitud y lo carga con los datos obtenidos
                solicitud = vista.getSolicitud(id, tipo, descripcion, fecha, status);
                // Agrega el panel de solicitud a la vista
                vista.cargarSolicitud(solicitud);
            }
        }   catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la carga de las solicitudes
            e.printStackTrace();

}
    }
}