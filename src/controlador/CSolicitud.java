package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VIniciarSesion;
import vista.VSolicitud;
import vista.IIniciarSesion;
import vista.ISolicitud;
import modelo.MCrudSolicitud;
import modelo.MSolicitud;
import modelo.Materia;

import javax.swing.*;

public class CSolicitud implements ActionListener{
    private ISolicitud vista;
    private IIniciarSesion vistaIniciarSesion;

    public CSolicitud(ISolicitud vista, IIniciarSesion vistaIniciarSesion) {
        this.vista = vista;
        this.vistaIniciarSesion = vistaIniciarSesion;
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
       if(comando.equals(ISolicitud.MATERIA)) {
            vista.cargarMaterias(vistaIniciarSesion.getUsuario());
            //se cargará la lista de materias que en relación al usuario que haya iniciado sesión
        }
        if (comando.equals(ISolicitud.ENVIAR)) {
            MCrudSolicitud mCrudSolicitud = new MCrudSolicitud();
            Materia materia = (Materia) vista.getMateria();
            if(materia == null) {
                if(mCrudSolicitud.crearSolicitud(vista.getTipo(), vista.getDescripcion(), vistaIniciarSesion.getUsuario())>0);
                //aquí debería haber un método que busque el registro que se acaba de hacer y almacene los valores en algún lugar
               // mCrudSolicitud.buscarSolicitud(vista.getTipo(), vista.getDescripcion(), vistaIniciarSesion.getUsuario());
                MSolicitud resultado = (MSolicitud) mCrudSolicitud.buscarSolicitud(vista.getTipo(), vista.getDescripcion(), vistaIniciarSesion.getUsuario());
                vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getDescripcion(), resultado.getFecha());
                //vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getDescripcion(), resultado.getFecha());
                //JOptionPane.showMessageDialog(null, "Solicitud enviada");
            } else {
                  mCrudSolicitud.crearSolicitudMateria(vista.getTipo(), materia.getIdMateria(), vistaIniciarSesion.getUsuario());
                  MSolicitud resultado = (MSolicitud) mCrudSolicitud.buscarSolicitudMateria(vista.getTipo(), materia.getIdMateria(), vistaIniciarSesion.getUsuario());
                  vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getDescripcion(), resultado.getFecha());
            }
}
}
}
