package vista;

import controlador.CSolicitudes;

import javax.swing.*;
import java.awt.*;
// Vista de solicitudes
public class VSolicitudes extends JPanel implements ISolicitudes {

    private final JPanel pPrincipal;
    private final GridBagConstraints reglas;
    private int i = 0;

    // Constructor de VSolicitudes
    public VSolicitudes(){
       // this.setPreferredSize(new Dimension(1085, 680));
        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Panel para el icono y título "Solicitudes Enviadas"
        JPanel pIconEven = new JPanel();
        pIconEven.setBackground(new Color(255, 255, 255));
        JLabel lImagenEven = new JLabel();
        lImagenEven.setSize(55, 45);
        ImageIcon icon = new ImageIcon("media/eventosA.png");
        Icon iconoCar = new ImageIcon(icon.getImage().getScaledInstance(lImagenEven.getWidth(), lImagenEven.getHeight(), Image.SCALE_DEFAULT));
        lImagenEven.setIcon(iconoCar);
        pIconEven.add(lImagenEven);
        JLabel lTitulo = new JLabel("Solicitudes Enviadas");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconEven.add(lTitulo);
        pPrincipal.add(pIconEven, reglas);


        /*JPanel pImagen = new JPanel();
        pImagen.setBackground(new Color(255, 255, 255));


        reglas.gridx = 3;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        reglas.gridheight = 5;

        reglas.anchor = GridBagConstraints.EAST;



        JLabel lImagen = new JLabel();
        lImagen.setSize(450, 450);
        ImageIcon imagen = new ImageIcon("media/EventosA.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
        pPrincipal.add (pImagen, reglas);*/

        // Se añade el panel principal a esta vista
        this.add(pPrincipal);
    }

    // Inicia la vista de solicitudes
    @Override
    public void arrancar() {
        this.setVisible(true);
    }


    // Método para establecer el controlador
    @Override
    public void setControlador(CSolicitudes controlador) {
        // TODO Auto-generated method stub
    }

    // Método para cargar una solicitud en la vista
    @Override
    public void cargarSolicitud(JPanel solicitud) {
        if(i%2 == 0){
            reglas.gridx = 1;
            reglas.gridy++;
        } else {
            reglas.gridx = 3;
        }
        pPrincipal.add(solicitud,reglas);
        i++;
    }


    // Método para obtener una solicitud como un JPanel
    @Override
    public JPanel getSolicitud(String id, String tipo, String descripcion, String fecha, String status) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.anchor = GridBagConstraints.WEST;
        reglas.gridx = 1;
        reglas.gridy = 1;

        // Etiqueta con el ID de la solicitud
        JLabel lID = new JLabel("Solicitud #" + id);
        lID.setFont(new Font("Roboto", Font.BOLD, 16));
        lID.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lID, reglas);

        // Etiqueta con el ID de la solicitud
        reglas.gridy = 3;
        JLabel lStatus = new JLabel(status);
        lStatus.setFont(new Font("Open Sans", Font.BOLD, 14));
        lStatus.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lStatus.setOpaque(true);
        panel.add(lStatus, reglas);

        // Área de texto con la descripción de la solicitud
        reglas.gridy = 4;
        JTextArea tDescripcionE = new JTextArea(descripcion);
        tDescripcionE.setFont(new Font("Open Sans", Font.BOLD, 14));
        tDescripcionE.setPreferredSize(new Dimension(200, 200));
        tDescripcionE.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tDescripcionE.setLineWrap(true);
        tDescripcionE.setWrapStyleWord(true);
        tDescripcionE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(tDescripcionE, reglas);

        // Etiqueta con la fecha de la solicitud
        reglas.gridy = 5;
        JLabel lFecha = new JLabel("Enviada el "+fecha);
        lFecha.setFont(new Font("Open Sans", Font.BOLD, 14));
        lFecha.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lFecha, reglas);


        // Cambio de color de fondo según el estado de la solicitud
        if(status.equals("Pendiente")){
            lStatus.setBackground(Color.RED);
        } else lStatus.setBackground(Color.GREEN);
        return panel;
    }
}
