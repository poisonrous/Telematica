package controlador;
import modelo.MCrudPublicacion;
import modelo.OModelo;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPublicacion implements ActionListener {
    private IPublicacion vista;
    private OModelo usuario;
    public CPublicacion(IPublicacion vista, OModelo usuario){
        this.vista = vista;
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
            MCrudPublicacion mCrudPublicacion = new MCrudPublicacion();
            if( mCrudPublicacion.crearPublicacion(usuario.getUsuario(),vista.getTitulo(), vista.getDescripcion())>0) {
                JOptionPane.showMessageDialog(null, "Publicación enviada");
                vista.limpiar();
            }
        }
    }
}
