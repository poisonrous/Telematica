package controlador;

import modelo.MSolicitudR;
import vista.ISolicitudReporte;

import java.awt.event.ActionEvent;

// Controlador para la funcionalidad de gestión de reportes de solicitudes.

public class CSolicitudReporte {

    private final ISolicitudReporte vista; // Vista de solicitud de reporte
    private final MSolicitudR modulo; // Modulo de solicitud de reporte

    /**
     * Constructor de la clase CSolicitudReporte.
     * @param vista Interfaz de usuario ISolicitudReporte.
     * @param modulo Modelo de solicitudes MSolicitudR.
     */
    public CSolicitudReporte(ISolicitudReporte vista, MSolicitudR modulo) {
        this.vista=vista;
        this.modulo=modulo;

    }

    /**
     * Maneja los eventos de acción generados en la vista.
     * @param e Evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
            modulo.actualizarSolicitud(vista.getIdSo(), vista.getEstado());
        }
    }

