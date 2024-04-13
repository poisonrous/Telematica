package controlador;

import modelo.MCrudEvento;
import vista.IEventos;

import javax.swing.*;
import java.sql.ResultSet;

public class CEventos {
    private final IEventos vista;
    private final MCrudEvento mCrudEvento;
    private ResultSet rs;

    public CEventos(IEventos vista, MCrudEvento mCrudEvento) {
        this.vista = vista;
        this.mCrudEvento = mCrudEvento;
    }

    public void cargarEventos(){
        JPanel evento = null;
        rs = mCrudEvento.getResultSet();
        try {
            while (rs.next()){
                String titulo = rs.getString("tituloEv");
                String descripcion = rs.getString("descripcionEv");
                String fecha = rs.getString("fechaEv");
                String hora = rs.getString("horaEv");
                String lugar = rs.getString("lugarEv");
                String organizador = rs.getString("organizadorEv");
                String modalidad = rs.getString("modalidadEv");
                String precio = rs.getString("precioEv");
                evento = vista.getEvento(titulo, descripcion, fecha, hora, lugar, organizador, modalidad, precio);
                vista.cargarEve(evento);
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
