package controlador;

import modelo.MSolicitudR;
import vista.ISolicitudCurso;
import vista.ISolicitudReporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CSolicitudCurso implements ActionListener {

    private final ISolicitudCurso vista;
    private ISolicitudReporte vista2;
    private final MSolicitudR modulo;

    public CSolicitudCurso(ISolicitudCurso vista,MSolicitudR modulo) {
        this.vista=vista;
        this.modulo=modulo;

    }

    public void actionPerformed(ActionEvent e)  {
        if(e.getActionCommand().equals(vista.PARAMETROS))
            vista.probando();
            vista.limpiarTabla();
            vista.setConsulta(modulo.getResultSet(vista.getTest(),vista.getEstado(),vista.getTipo().toString()));
            vista.nuevatabla();
        }
    }