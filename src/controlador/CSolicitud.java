package controlador;

import java.awt.*;
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

// Controlador para la gestión de solicitudes.

public class CSolicitud implements ActionListener{
    private final ISolicitud vista;  // Vista de solicitud
    private final OModelo usuario;  // Modelo de usuario

    /**
     * Constructor de la clase CSolicitud.
     * @param vista Vista de usuario ISolicitud.
     * @param usuario Modelo de usuario OModelo.
     */
    public CSolicitud(ISolicitud vista, OModelo usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }

    /**
     * Maneja los eventos de acción generados en la vista.
     * @param e Evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
       if(comando.equals(ISolicitud.MATERIA)) {
            vista.cargarMaterias(usuario.getUsuario());
           // Carga la lista de materias relacionadas con el usuario que ha iniciado sesión.
        }
        if (comando.equals(ISolicitud.ENVIAR)) {
            if (Objects.equals(vista.getTipo(), "8")) {
                JOptionPane.showMessageDialog(null, "¿Olvidaste seleccionar una opción? A todos nos pasa");
            }
            else {
            MCrudSolicitud mCrudSolicitud = new MCrudSolicitud();
            Materia materia = (Materia) vista.getMateria();

                UIManager UI=new UIManager();
                UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UI.put("OptionPane.background", new Color (255,255,255));
                UI.put("Panel.background", new Color (255,255,255));
                UI.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);

                ImageIcon iconSO = new ImageIcon("media/advertencia.png");

            int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que deseas enviar una solicitud de tipo "+vista.getTipoNombre()+"?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, iconSO,
                    new String[]{"Si", "No"}, "Si");
            if (n == JOptionPane.YES_OPTION) {
            if(materia == null) {

                UIManager UISO=new UIManager();
                UISO.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UISO.put("OptionPane.background", new Color (255,255,255));
                UISO.put("Panel.background", new Color (255,255,255));
                UISO.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);


                if (vista.getDescripcion().length()<30){JOptionPane.showMessageDialog(null, "¿Podrías darnos algo más de información?");}
                else if (mCrudSolicitud.checkSolicitud(usuario.getUsuario(), vista.getDescripcion())) {
                    JOptionPane.showMessageDialog(null, "Ya has hecho una solicitud con esa descripción");
                }
                else {
                if(mCrudSolicitud.crearSolicitud(vista.getTipo(), vista.getDescripcion(), usuario.getUsuario())>0);
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


    }
        else JOptionPane.showMessageDialog(null, "Solicitud no enviada, puedes seguir editando.");
}
}
