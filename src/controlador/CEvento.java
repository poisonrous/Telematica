package controlador;
import modelo.BdConex;
import modelo.MCrudEvento;
import vista.IEvento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Controlador para la funcionalidad de eventos.

public class CEvento implements ActionListener {
    private final IEvento vista;      // Vista de evento

    /**
     * Constructor de la clase CEvento.
     * @param vista La vista de eventos.
     */

    public CEvento(IEvento vista){
        this.vista = vista;
    }

    /**
     * Maneja los eventos de acción generados por la vista.
     * @param e El evento de acción.
     */

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();  // Obtiene el comando del evento
        if(comando.equals(IEvento.PUBLICAR)) {  // Verifica si el comando es PUBLICAR
            // Muestra un diálogo de confirmación al usuario

            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);

            ImageIcon icon = new ImageIcon("media/informacion.png");

            int n = JOptionPane.showOptionDialog(null, "Por favor echa una última mirada a los datos ingresados", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, new Object[]{"Todo bien", "Seguir editando"}, "Todo bien" );

            if(n == JOptionPane.YES_OPTION) {  // Si el usuario confirma
                MCrudEvento mCrudEvento = new MCrudEvento();  // Crea una instancia del modelo de CRUD de eventos

                // Verifica si algún campo está vacío
            if (vista.getTitulo().isEmpty() || vista.getOrganizador().isEmpty() || vista.getDescripcion().isEmpty()|| vista.getLugar().isEmpty() || vista.getModalidad().isEmpty()){
                UIManager UIE=new UIManager();
                UIE.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UIE.put("OptionPane.background", new Color (255,255,255));
                UIE.put("Panel.background", new Color (255,255,255));
                UIE.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);


                JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
            }
            else{
                // Intenta crear un evento utilizando los datos de la vista
            if( mCrudEvento.crearEvento(vista.getTitulo(), vista.getOrganizador(), vista.getDescripcion(), vista.getFecha(), vista.getHora(), vista.getLugar(), vista.getModalidad(), vista.getPrecio())>0) {
                JOptionPane.showMessageDialog(null, "Evento publicado");
                vista.limpiar();        // Limpia los campos de la vista después de publicar el evento
            } else {
                JOptionPane.showMessageDialog(null, "Error al publicar evento");
            } }}
        }
    }
}
