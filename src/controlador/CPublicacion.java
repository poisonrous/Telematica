package controlador;
import modelo.MCrudPublicacion;
import modelo.OModelo;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPublicacion implements ActionListener {
    private final IPublicacion vista;
    private final OModelo usuario;
    public CPublicacion(IPublicacion vista, OModelo usuario){
        this.vista = vista;
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
            MCrudPublicacion mCrudPublicacion = new MCrudPublicacion();
            if (vista.getTitulo().length()<5){JOptionPane.showMessageDialog(null, "El titulo es muy corto, por favor hacerlo algo más grande");}
            else if  (vista.getDescripcion().length()<100){JOptionPane.showMessageDialog(null, "Es un poco corta, tratemos de alargarla ¿Sí?");}
            else if (mCrudPublicacion.checkDescripcion(usuario.getUsuario(), vista.getDescripcion())) {
                JOptionPane.showMessageDialog(null, "Ya has hecho una publicación con esa descripción");
            }
            else if (mCrudPublicacion.checkTitulo(usuario.getUsuario(), vista.getTitulo())) {
                JOptionPane.showMessageDialog(null, "Ya has hecho una publicación con ese titulo");
            }
            else{
                int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres enviar la publicación?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        new String[]{"Si", "No"}, "Si");
                if(n== JOptionPane.YES_OPTION){
                if( mCrudPublicacion.crearPublicacion(usuario,vista.getTitulo(), vista.getDescripcion())>0) {
                    if(usuario.isAdmin()>0){
                        JOptionPane.showMessageDialog(null, "Publicación enviada.");
                        vista.limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Publicación enviada, en espera de aprobación.");
                        vista.limpiar();
                    }
                vista.limpiar();
                }} else JOptionPane.showMessageDialog(null, "Publicación no enviada, puedes seguir editando.");
            }

            }
        }
    }

