package controlador;

import modelo.MCrudServicio;
import vista.IServicios;

import javax.swing.*;
import java.sql.ResultSet;

// Controlador para la gestión de servicios

public class CServicios {
    private final IServicios vista;  // Vista de servicios
    private final MCrudServicio mCrudServicio;  // Modelo del CRUD de servicios
    private ResultSet rs;

    /**
     * Constructor de la clase CServicios.
     * @param vista Interfaz IServicios para la visualización.
     * @param mCrudServicio Modelo MCrudServicio para la gestión de datos.
     */
    public CServicios(IServicios vista, MCrudServicio mCrudServicio) {
        this.vista = vista;
        this.mCrudServicio = mCrudServicio;
    }

    /**
     * Carga los servicios desde la base de datos y los muestra en la interfaz.
     */
    public void cargarServicios() {
        JPanel servicio = null;  // Panel que representa un servicio
        rs = mCrudServicio.getResultSet(); // Obtiene el conjunto de resultados de la consulta
        try {
            // Recorre el conjunto de resultados y muestra los servicios en la interfaz
            while (rs.next()){
                String titulo = rs.getString("tipoSS");  // Título del servicio
                String ubicacion = rs.getString("ubicacionSS");  // Ubicación del servicio
                String horario = rs.getString("horarioSS"); // Horario del servicio
                // Obtiene el panel que representa el servicio
                servicio = vista.getServicio(titulo, ubicacion, horario);
                // Carga el servicio en la interfaz
                vista.cargarSer(servicio);
            }
        }   catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la carga de los servicios
            e.printStackTrace();
        }
    }
}
