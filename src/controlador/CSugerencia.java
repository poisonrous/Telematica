package controlador;
import modelo.MSolicitud;
import modelo.OModelo;
import vista.ISugerencia;
import vista.IIniciarSesion;
import modelo.MSugerencia;
import modelo.MCrudSugerencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;


// Controlador para la gestión de sugerencias.

public class CSugerencia implements ActionListener {
    private final ISugerencia vista; // Vista de sugerencia
    private final OModelo usuario;  //Modelo de usuario

    /**
     * Constructor de la clase CSugerencia.
     * @param vista Interfaz de usuario ISugerencia.
     * @param usuario Modelo de usuario OModelo.
     */
    public CSugerencia(ISugerencia vista, OModelo usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }

    /**
     * Maneja los eventos de acción generados en la vista.
     * @param e Evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        // Verifica si se ha presionado el botón de enviar sugerencia
        if(comando.equals(ISugerencia.ENVIAR)) {
            // Instancia del modelo de CRUD de sugerencias
            MCrudSugerencia mCrudSugerencia = new MCrudSugerencia();
            // Verifica si el título es demasiado corto
            if (vista.getTitulo().length()<5){JOptionPane.showMessageDialog(null, "El titulo es muy corto, por favor hacerlo algo más grande");}
            else {
                UIManager UI=new UIManager();
                UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UI.put("OptionPane.background", new Color (255,255,255));
                UI.put("Panel.background", new Color (255,255,255));
                UI.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);

                ImageIcon icon = new ImageIcon("media/advertencia.png");

                // Muestra un cuadro de diálogo para confirmar el envío de la sugerencia
                int n = JOptionPane.showOptionDialog(null, "¿Estás seguro de que deseas enviar esta sugerencia?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, icon,
                        new String[]{"Si", "No"}, "Si");
                if(n== JOptionPane.YES_OPTION){
                    // Crea la sugerencia en la base de datos
            if( mCrudSugerencia.crearSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles())>0) {
                // Busca la sugerencia recién creada
                    MSugerencia resultado = (MSugerencia) mCrudSugerencia.buscarSugerencia(usuario.getUsuario(),vista.getTitulo(), vista.getDetalles());
                // Muestra los detalles de la sugerencia enviada
                vista.mostrarResultado(resultado.getNombre(),resultado.getApellido(), resultado.getTelefono(), resultado.getCorreo(), resultado.getTitulo(), resultado.getDescripcion(), resultado.getFecha());

                UIManager UIS=new UIManager();
                UIS.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UIS.put("OptionPane.background", new Color (255,255,255));
                UIS.put("Panel.background", new Color (255,255,255));
                UIS.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);
                ImageIcon iconSE = new ImageIcon("media/advertencia.png");

                    JOptionPane.showMessageDialog(null, "Sugerencia enviada");
                }
                } else JOptionPane.showMessageDialog(null, "Sugerencia no enviada, puedes seguir editando.");
            }
        }
    }
}
