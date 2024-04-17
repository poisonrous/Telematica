package controlador;
import modelo.MSolicitud;
import modelo.OModelo;
import vista.ISugerencia;
import vista.IIniciarSesion;
import modelo.MSugerencia;
import modelo.MCrudSugerencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class CSugerencia implements ActionListener {
    private final ISugerencia vista;
    private final OModelo usuario;

    public CSugerencia(ISugerencia vista, OModelo usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
            MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
            if (vista.getTitulo().length()<5){JOptionPane.showMessageDialog(null, "El titulo es muy corto, por favor hacerlo algo más grande");}
            else {
                int n = JOptionPane.showOptionDialog(null, "¿Estás seguro de que deseas enviar esta sugerencia?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, null,
                        new String[]{"Si", "No"}, "Si");
                if(n== JOptionPane.YES_OPTION){
            if( mCrudSugerencia.crearSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles())>0) {

                    MSugerencia resultado = (MSugerencia) mCrudSugerencia.buscarSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles());
                    vista.mostrarResultado(resultado.getNombre(),resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTitulo(), resultado.getDescripcion(), resultado.getFecha());
                    JOptionPane.showMessageDialog(null, "Sugerencia enviada");
                }
                } else JOptionPane.showMessageDialog(null, "Sugerencia no enviada, puedes seguir editando.");
            }
        }
    }
}
