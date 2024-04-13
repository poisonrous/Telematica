package vista;
import javax.swing.*;
import controlador.CPublicacion;
import java.awt.event.*;
import java.awt.*;


import controlador.CSugerencia;
import vista.IPublicacion;

public class VPublicacion extends JPanel implements ActionListener, IPublicacion {
    private CPublicacion controlador;
    private final JPanel pPrincipal;
    private JPanel pResultado;
    private JPanel pDatos;
    private JLabel lNombre, lTelefono, lCorreo, lSugerencia, lDescripcion, lFecha;
    private final JTextField tfTitulo;
    private final JTextArea taDescripcion;
    private final JButton bEnviar;
    private JButton bImprimir;

    public VPublicacion() {
        this.setPreferredSize(new Dimension(1085, 680));


        this.setLayout(new BorderLayout());
        
        JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Roboto", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        pTitulo.add(lTitulo);
        this.add(pTitulo, BorderLayout.NORTH);
        
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        
        bEnviar = new JButton("Enviar");
        bEnviar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bEnviar.setForeground(Color.WHITE);
        bEnviar.setBackground(new Color(0, 125, 254));
        bEnviar.setActionCommand(ENVIAR);
        bEnviar.addActionListener(this);
        pBotones.add(bEnviar);
        
        this.add(pBotones, BorderLayout.SOUTH);
      
        //CENTRO
        
        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 2));
        
        
        JPanel pIconMe = new JPanel();
        pIconMe.setBackground(new Color(255, 255, 255));
        reglas.gridy = 0;
        reglas.weighty= 1.0;
        reglas.gridheight=1;
        JLabel lImagenMe = new JLabel();  
        lImagenMe.setSize(30, 25);
        ImageIcon icon = new ImageIcon("media/megaphone.png");
        Icon iconoMe = new ImageIcon(icon.getImage().getScaledInstance(lImagenMe.getWidth(), lImagenMe.getHeight(), Image.SCALE_DEFAULT));
        lImagenMe.setIcon(iconoMe);
       pIconMe.add(lImagenMe);
        JLabel lTipo = new JLabel("Envía tus publicaciones");
        lTipo.setFont(new Font("Roboto", Font.BOLD, 16));
        pIconMe.add(lTipo);
        pPrincipal.add(pIconMe, reglas);
        
        
        
        reglas.gridy = 1;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lTituloPublicacion = new JLabel("Título:");
        lTituloPublicacion.setFont(new Font("Open Sans", Font.BOLD, 14));
         pPrincipal.add(lTituloPublicacion, reglas);

         reglas.gridy = 2;
         reglas.weighty= 1.0;
        tfTitulo = new JTextField();  
        tfTitulo.setPreferredSize(new Dimension(200, 35));
        tfTitulo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        pPrincipal.add(tfTitulo, reglas);
        
      
        reglas.gridy = 3;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lInformacion = new JLabel("Aporta más información:");
        lInformacion.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lInformacion, reglas);

        reglas.gridy = 4;
        reglas.weighty= 1.0;
        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(220, 200));
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        pPrincipal.add(taDescripcion, reglas);

       
      JPanel pImagen = new JPanel(); 
      pImagen.setBackground(new Color(255, 255, 255));
  
    
      reglas.gridx = 1;
      reglas.gridy = 1;
      reglas.gridwidth = 1;
      reglas.gridheight = 5;
      
      reglas.anchor = GridBagConstraints.EAST;
    
      
      
      JLabel lImagen = new JLabel();  
      lImagen.setSize(500, 450);
      ImageIcon imagen = new ImageIcon("media/recurso2.jpg");
      Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
      lImagen.setIcon(icono);
      pImagen.add(lImagen);
      pPrincipal.add (pImagen, reglas); 
      
      
        
        /*bImprimir = new JButton("Imprimir");
        bImprimir.addActionListener(this);
        reglas.gridy = 8;
        pPrincipal.add(bImprimir, reglas);*/

        this.add(pPrincipal);
    }

    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void limpiar() {
        tfTitulo.setText("");
        taDescripcion.setText("");
    }

    @Override
    public String getTitulo() {
        return tfTitulo.getText();
    }

    @Override
    public String getDescripcion() {
        return taDescripcion.getText();
    }

    @Override
    public void setControlador(CPublicacion c) {
        controlador = c;
        bEnviar.addActionListener(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* String comando = e.getActionCommand();
        if (comando.equals(ENVIAR)) {
            controlador.
        }*/
    }

   /* @Override
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha) {

    }*/
}