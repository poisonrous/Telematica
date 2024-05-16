package controlador;

import modelo.MCrudEvento;
import vista.IEventos;

import javax.swing.*;
import java.sql.ResultSet;

// Controlador para la funcionalidad de eventos.

public class CEventos {
    private final IEventos vista;       // Vista de eventos
    private final MCrudEvento mCrudEvento;    // Modelo para manipulación de eventos
    private ResultSet rs;       // Resultado de la consulta a la base de datos

    /**
     * Constructor de la clase CEventos.
     * @param vista La vista de eventos.
     * @param mCrudEvento El modelo para manipulación de eventos.
     */
    public CEventos(IEventos vista, MCrudEvento mCrudEvento) {
        this.vista = vista;
        this.mCrudEvento = mCrudEvento;
    }


    /**
     * Carga los eventos desde el modelo para luego mostrarlos en la vista.
     */
    public void cargarEventos(){
        JPanel evento = null;   // Panel que contendrá la información de cada evento
        rs = mCrudEvento.getResultSet();    // Obtiene el resultado de la consulta a la base de datos
        try {
            while (rs.next()){ // Recorre el resultado de la consulta
                // Obtiene los datos de cada evento
                String titulo = rs.getString("tituloEv");
                String descripcion = rs.getString("descripcionEv");
                String fecha = rs.getString("fechaEv");
                String hora = rs.getString("horaEv");
                String lugar = rs.getString("lugarEv");
                String organizador = rs.getString("organizadorEv");
                String modalidad = rs.getString("modalidadEv");
                String precio = rs.getString("precioEv");

                // Obtiene el panel del evento y lo carga en la vista
                evento = vista.getEvento(titulo, descripcion, fecha, hora, lugar, organizador, modalidad, precio);
                vista.cargarEve(evento);
            }
        }   catch (Exception e) {
            e.printStackTrace();    // Maneja los errores
        }
    }
}
