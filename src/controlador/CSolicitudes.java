package controlador;

import modelo.MCrudSolicitud;
import modelo.OModelo;
import vista.ISolicitudes;

import javax.swing.*;
import java.sql.ResultSet;

public class CSolicitudes {
    private final ISolicitudes vista;
    private final MCrudSolicitud mCrudSolicitud;
    private final OModelo usuario;
    private ResultSet rs;

    public CSolicitudes(ISolicitudes vista, MCrudSolicitud mCrudSolicitud, OModelo usuario) {
        this.vista = vista;
        this.mCrudSolicitud = mCrudSolicitud;
        this.usuario = usuario;
    }

    public void cargarSolicitudes(){
        JPanel solicitud = null;
        rs = mCrudSolicitud.getSolicitudes(usuario.getUsuario());
        try {
            while (rs.next()){
                String id = rs.getString("idSo");
                String tipo = rs.getString("tipoTiSo");
                String descripcion = rs.getString("descripcionSo");
                String fecha = rs.getString("fechaSo");
                String status = rs.getString("EstadoSo");
                solicitud = vista.getSolicitud(id, tipo, descripcion, fecha, status);
                vista.cargarSolicitud(solicitud);
            }
        }   catch (Exception e) {
            e.printStackTrace();

}
    }
}