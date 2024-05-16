package controlador;

import modelo.MSolicitudR;
import vista.ISolicitudCurso;
import vista.ISolicitudReporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controlador para la gestión de solicitudes de cursos.

public class CSolicitudCurso implements ActionListener {

    private final ISolicitudCurso vista;  // Vista de solicitud en curso
    private ISolicitudReporte vista2;  // Vista de solicitud de reporte
    private final MSolicitudR modulo;  // Modelo de solicitud de reporte

    /**
     * Constructor de la clase CSolicitudCurso.
     * @param vista Interfaz de usuario ISolicitudCurso.
     * @param modulo Modelo de solicitud de curso MSolicitudR.
     */
    public CSolicitudCurso(ISolicitudCurso vista,MSolicitudR modulo) {
        this.vista=vista;
        this.modulo=modulo;

    }

    /**
     * Maneja los eventos de acción generados en la vista.
     * @param e Evento de acción.
     */
    public void actionPerformed(ActionEvent e)  {
        if(e.getActionCommand().equals(vista.PARAMETROS))
            vista.probando();
            vista.limpiarTabla();
            // Se establece la consulta en la vista basada en los parámetros proporcionados por el usuario
            vista.setConsulta(modulo.getResultSet(vista.getTest(),vista.getEstado(),vista.getTipo(),vista.getCarrera()));
            vista.nuevatabla();  // Se actualiza la tabla en la vista con la nueva consulta
    }
        }
