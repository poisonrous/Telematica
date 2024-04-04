package controlador;
import modelo.OModelo;
import vista.ISugerencia;
import vista.IIniciarSesion;
import modelo.MSugerencia;
import modelo.MCrudSugerencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CSugerencia implements ActionListener {
    private ISugerencia vista;
    private OModelo usuario;

    public CSugerencia(ISugerencia vista, OModelo usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
           // JOptionPane.showMessageDialog(null, "El botón funciona");
          //  MSugerencia mSugerencia = new MSugerencia();
            MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
         //   mCrudSugerencia.crearSugerencia(vista.getTitulo(), vista.getDetalles(), vistaIniciarSesion.getUsuario());
            if( mCrudSugerencia.crearSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles())>0) {
                MSugerencia resultado = (MSugerencia) mCrudSugerencia.buscarSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles());
                vista.mostrarResultado(resultado.getNombre(),resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTitulo(), resultado.getDescripcion(), resultado.getFecha());
                JOptionPane.showMessageDialog(null, "Sugerencia enviada");
            }
        }
    }
}
