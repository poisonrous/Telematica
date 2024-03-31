package controlador;
import vista.ISugerencia;
import vista.IIniciarSesion;
import modelo.MSugerencia;
import modelo.MCrudSugerencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CSugerencia implements ActionListener {
    private ISugerencia vista;
    private IIniciarSesion vistaIniciarSesion;

    public CSugerencia(ISugerencia vista, IIniciarSesion vistaIniciarSesion) {
        this.vista = vista;
        this.vistaIniciarSesion = vistaIniciarSesion;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {
           // JOptionPane.showMessageDialog(null, "El botón funciona");
          //  MSugerencia mSugerencia = new MSugerencia();
            MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
         //   mCrudSugerencia.crearSugerencia(vista.getTitulo(), vista.getDetalles(), vistaIniciarSesion.getUsuario());
            if( mCrudSugerencia.crearSugerencia(vistaIniciarSesion.getUsuario(),vista.getTitulo(), vista.getDetalles())>0) {
                MSugerencia resultado = (MSugerencia) mCrudSugerencia.buscarSugerencia(vistaIniciarSesion.getUsuario(),vista.getTitulo(), vista.getDetalles());
                vista.mostrarResultado(resultado.getNombre(),resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTitulo(), resultado.getDescripcion(), resultado.getFecha());
                JOptionPane.showMessageDialog(null, "Sugerencia enviada");
            }
        }
    }
}
