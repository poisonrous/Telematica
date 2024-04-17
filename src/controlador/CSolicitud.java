package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import modelo.OModelo;
import vista.VIniciarSesion;
import vista.VSolicitud;
import vista.IIniciarSesion;
import vista.ISolicitud;
import modelo.MCrudSolicitud;
import modelo.MSolicitud;
import modelo.Materia;

import javax.swing.*;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class CSolicitud implements ActionListener{
    private final ISolicitud vista;
    private final OModelo usuario;

    public CSolicitud(ISolicitud vista, OModelo usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
       if(comando.equals(ISolicitud.MATERIA)) {
            vista.cargarMaterias(usuario.getUsuario());
            //se cargará la lista de materias que en relación al usuario que haya iniciado sesión
        }
        if (comando.equals(ISolicitud.ENVIAR)) {
            if (Objects.equals(vista.getTipo(), "8")) {
                JOptionPane.showMessageDialog(null, "¿Olvidaste seleccionar una opción? A todos nos pasa");
            }
            else {
            MCrudSolicitud mCrudSolicitud = new MCrudSolicitud();
            Materia materia = (Materia) vista.getMateria();
            int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que deseas enviar una solicitud de tipo "+vista.getTipoNombre()+"?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, null,
                    new String[]{"Si", "No"}, "Si");
            if (n == JOptionPane.YES_OPTION) {
            if(materia == null) {
                if (vista.getDescripcion().length()<30){JOptionPane.showMessageDialog(null, "¿Podrías darnos algo más de información?");}
                else if (mCrudSolicitud.checkSolicitud(usuario.getUsuario(), vista.getDescripcion())) {
                    JOptionPane.showMessageDialog(null, "Ya has hecho una solicitud con esa descripción");
                }
                else {
                if(mCrudSolicitud.crearSolicitud(vista.getTipo(), vista.getDescripcion(), usuario.getUsuario())>0);{
                //aquí debería haber un método que busque el registro que se acaba de hacer y almacene los valores en algún lugar
               // mCrudSolicitud.buscarSolicitud(vista.getTipo(), vista.getDescripcion(), vistaIniciarSesion.getUsuario());
                MSolicitud resultado = (MSolicitud) mCrudSolicitud.buscarSolicitud(vista.getTipo(), vista.getDescripcion(), usuario.getUsuario());
                vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getDescripcion(), resultado.getFecha());
                //vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getDescripcion(), resultado.getFecha());
                //JOptionPane.showMessageDialog(null, "Solicitud enviada");
                } }
            } else {

                if (mCrudSolicitud.checkMateria(String.valueOf(vista.getMateria()), usuario.getUsuario())){
                    JOptionPane.showMessageDialog(null, "Ya había reportado previamente la falta de aula para "+vista.getMateria());
                }
                else {
                        mCrudSolicitud.crearSolicitudMateria(vista.getTipo(), materia.getIdMateria(), usuario.getUsuario());
                        MSolicitud resultado = (MSolicitud) mCrudSolicitud.buscarSolicitudMateria(vista.getTipo(), materia.getIdMateria(), usuario.getUsuario());
                        vista.mostrarResultado(resultado.getNombre(), resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTipoS(), resultado.getMateria(), resultado.getFecha());
                        JOptionPane.showMessageDialog(null, "Solicitud enviada");
                }
            }
}
 else JOptionPane.showMessageDialog(null, "Solicitud no enviada, puedes seguir editando.");

    }
}}}
