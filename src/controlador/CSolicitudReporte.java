package controlador;

import modelo.MSolicitudR;
import vista.ISolicitudReporte;

import java.awt.event.ActionEvent;

public class CSolicitudReporte {

    private ISolicitudReporte vista;
    private MSolicitudR modulo;
    public CSolicitudReporte(ISolicitudReporte vista, MSolicitudR modulo) {
        this.vista=vista;
        this.modulo=modulo;

    }

    public void actionPerformed(ActionEvent e) {
            modulo.actualizarSolicitud(vista.getIdSo(), vista.getEstado());
        }
    }

