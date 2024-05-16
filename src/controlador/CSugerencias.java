package controlador;

import modelo.MCrudSugerencia;
import vista.ISugerencias;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

// Controlador para la gestión de sugerencias.

public class CSugerencias {
    private final ISugerencias vista; // Vista de sugerencias
    private final MCrudSugerencia mCrudSugerencia; // Modelo de CRUD de sugerencias
    private ResultSet rs; // Resultado de la consulta a la base de datos


    /**
     * Constructor de la clase CSugerencias.
     * @param vista Interfaz de usuario ISugerencias.
     * @param mCrudSugerencia Modelo de CRUD de sugerencias MCrudSugerencia.
     */
    public CSugerencias(ISugerencias vista, MCrudSugerencia mCrudSugerencia) {
        this.vista = vista;
        this.mCrudSugerencia = mCrudSugerencia;
    }

    /**
     * Carga las sugerencias en la vista
     */
    public void cargarSugerencias()  {
        JPanel evento = null; // Panel para mostrar cada sugerencia
        rs = mCrudSugerencia.getSugestlist(); // Obtiene el conjunto de resultados de las sugerencias
        try
        {
            // Itera sobre cada fila del conjunto de resultados
            while (rs.next()){
                // Obtiene los datos de la sugerencia de la fila actual
                String titulo = rs.getString("TituloSu");
                String estudiante = rs.getString("NombresEs") + " "+ rs.getString("ApellidosEs");
                String cedula = rs.getString("CedulaEs");
                String fecha = rs.getString("FechaSu");
                String descripcion = rs.getString("DescripcionSu");
                // Crea un panel con los datos de la sugerencia
                evento = vista.getSugest(titulo, estudiante, cedula, fecha, descripcion);
                // Agrega el panel al panel principal en la vista
                vista.cargarSugest(evento);
            }
        }   catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la carga de los servicios
            e.printStackTrace();
        }
    }

}
