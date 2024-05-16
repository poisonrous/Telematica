package controlador;
import modelo.MCrudPublicacion;
import modelo.OModelo;
import vista.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controlador para la funcionalidad de publicación.

public class CPublicacion implements ActionListener {
    private final IPublicacion vista;  // Vista de la publicación
    private final OModelo usuario;     // Modelo de usuario

    /**
     * Constructor de la clase CPublicacion.
     * @param vista La vista de la publicación.
     * @param usuario El modelo de usuario.
     */
    public CPublicacion(IPublicacion vista, OModelo usuario){
        this.vista = vista;
        this.usuario = usuario;
    }

    /**
     * Maneja los eventos de acción generados por la vista.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(ISugerencia.ENVIAR)) {  // Si se hace clic en el botón de enviar publicación
            MCrudPublicacion mCrudPublicacion = new MCrudPublicacion();  // Instancia del modelo para manejar las publicaciones

            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);


            // Verifica la longitud del título y muestra un mensaje si es muy corto
            if (vista.getTitulo().length()<5){JOptionPane.showMessageDialog(null, "El titulo es muy corto, por favor hacerlo algo más grande");}

            // Verifica la longitud de la descripción y muestra un mensaje si es muy corta
            else if  (vista.getDescripcion().length()<100){JOptionPane.showMessageDialog(null, "Es un poco corta, tratemos de alargarla ¿Sí?");}

            // Verifica si el usuario ya ha hecho una publicación con esa descripción y muestra un mensaje
            else if (mCrudPublicacion.checkDescripcion(usuario.getUsuario(), vista.getDescripcion())) {
                JOptionPane.showMessageDialog(null, "Ya has hecho una publicación con esa descripción");
            }

            // Verifica si el usuario ya ha hecho una publicación con ese título y muestra un mensaje
            else if (mCrudPublicacion.checkTitulo(usuario.getUsuario(), vista.getTitulo())) {
                JOptionPane.showMessageDialog(null, "Ya has hecho una publicación con ese titulo");
            }

            else{

                UIManager UIAD=new UIManager();
                UIAD.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UIAD.put("OptionPane.background", new Color (255,255,255));
                UIAD.put("Panel.background", new Color (255,255,255));
                UIAD.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);
                ImageIcon iconA = new ImageIcon("media/advertencia.png");

                // Pregunta al usuario si está seguro de enviar la publicación
                int n = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres enviar la publicación?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, iconA,
                        new String[]{"Si", "No"}, "Si");

                if(n== JOptionPane.YES_OPTION){ // Si el usuario confirma el envío
                    // Crea la publicación y muestra un mensaje de éxito
                    if( mCrudPublicacion.crearPublicacion(usuario,vista.getTitulo(), vista.getDescripcion())>0) {
                         if(usuario.isAdmin()>0){   // Si el usuario es administrador
                        JOptionPane.showMessageDialog(null, "Publicación enviada.");
                        vista.limpiar();
                    } else {  // Si el usuario no es administrador
                        JOptionPane.showMessageDialog(null, "Publicación enviada, en espera de aprobación.");
                        vista.limpiar();
                    }
                vista.limpiar();
                }} else JOptionPane.showMessageDialog(null, "Publicación no enviada, puedes seguir editando.");  // Si el usuario cancela el envío, muestra un mensaje
            }

            }
        }
    }

