package controlador;
import modelo.BdConex;
import modelo.MCrudEvento;
import vista.IEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CEvento implements ActionListener {
    private final IEvento vista;

    public CEvento(IEvento vista){
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(IEvento.PUBLICAR)) {
            int n = JOptionPane.showOptionDialog(null, "Por favor echa una última mirada a los datos ingresados", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Todo bien", "Seguir editando"}, "Todo bien" );

            if(n == JOptionPane.YES_OPTION) {MCrudEvento mCrudEvento = new MCrudEvento();
            if (vista.getTitulo().isEmpty() || vista.getOrganizador().isEmpty() || vista.getDescripcion().isEmpty()|| vista.getLugar().isEmpty() || vista.getModalidad().isEmpty()){
                JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
            }
            else{
            if( mCrudEvento.crearEvento(vista.getTitulo(), vista.getOrganizador(), vista.getDescripcion(), vista.getFecha(), vista.getHora(), vista.getLugar(), vista.getModalidad(), vista.getPrecio())>0) {
                JOptionPane.showMessageDialog(null, "Evento publicado");
                vista.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al publicar evento");
            } }}
        }
    }
}
