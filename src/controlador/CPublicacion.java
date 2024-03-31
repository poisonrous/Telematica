package controlador;
import modelo.MCrudPublicacion;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPublicacion implements ActionListener {
    private IPublicacion vista;
    private IIniciarSesion vistaIniciarSesion;
    public CPublicacion(IPublicacion vista, IIniciarSesion vistaIniciarSesion){
        this.vista = vista;
        this.vistaIniciarSesion = vistaIniciarSesion;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
            MCrudPublicacion mCrudPublicacion = new MCrudPublicacion();
            if( mCrudPublicacion.crearPublicacion(vistaIniciarSesion.getUsuario(),vista.getTitulo(), vista.getDescripcion())>0) {
                JOptionPane.showMessageDialog(null, "Publicación enviada");
                vista.limpiar();
            }
        }
    }
}
