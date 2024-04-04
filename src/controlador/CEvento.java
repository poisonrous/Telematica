package controlador;
import modelo.MCrudEvento;
import vista.IEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CEvento implements ActionListener {
    private IEvento vista;

    public CEvento(IEvento vista){
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(IEvento.PUBLICAR)) {
            MCrudEvento mCrudEvento = new MCrudEvento();
            if( mCrudEvento.crearEvento(vista.getTitulo(), vista.getOrganizador(), vista.getDescripcion(), vista.getFecha(), vista.getHora(), vista.getLugar(), vista.getModalidad(), vista.getPrecio())>0) {
                JOptionPane.showMessageDialog(null, "Evento publicado");
                vista.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al publicar evento");
            }
        }
    }
}
