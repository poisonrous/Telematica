package vista;
import javax.swing.*;
import controlador.CPublicacion;
import java.awt.event.*;
import java.awt.*;


import controlador.CSugerencia;
import vista.IPublicacion;

// Vista para enviar publicacion
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

    // Constructor de la clase VPublicacion
    public VPublicacion() {
        this.setPreferredSize(new Dimension(1085, 680));


        this.setLayout(new BorderLayout());

        // Panel del título
        JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Roboto", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        pTitulo.add(lTitulo);
      //  this.add(pTitulo, BorderLayout.NORTH);

        // Panel de los botones
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        
        bEnviar = new JButton("Enviar");
        bEnviar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bEnviar.setForeground(Color.WHITE);
        bEnviar.setBackground(new Color(2, 152, 178));
        bEnviar.setActionCommand(ENVIAR);
        bEnviar.addActionListener(this);
        pBotones.add(bEnviar);
        
        this.add(pBotones, BorderLayout.SOUTH);
      
        //CENTRO

        // Panel principal
        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 2));

        // Panel para la imagen
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
        JLabel lTipo = new JLabel("Envía tus Publicaciones");
        lTipo.setFont(new Font("Roboto", Font.BOLD, 16));
        pIconMe.add(lTipo);
        pPrincipal.add(pIconMe, reglas);

        // Panel para el título
        reglas.gridy = 1;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lTituloPublicacion = new JLabel("Título:");
        lTituloPublicacion.setFont(new Font("Open Sans", Font.BOLD, 14));
         pPrincipal.add(lTituloPublicacion, reglas);

        // Campo de texto para el título
         reglas.gridy = 2;
         reglas.weighty= 1.0;
        tfTitulo = new JTextField();  
        tfTitulo.setPreferredSize(new Dimension(200, 35));
        tfTitulo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        Validacion.validarLongitud(tfTitulo,45);
        
        pPrincipal.add(tfTitulo, reglas);

        // Panel para la descripción
        reglas.gridy = 3;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lInformacion = new JLabel("Aporta más información:");
        lInformacion.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lInformacion, reglas);

        // Área de texto para la descripción
        reglas.gridy = 4;
        reglas.weighty= 1.0;
        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(240, 210));
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        Validacion.validarLongitud(taDescripcion,500);
        pPrincipal.add(taDescripcion, reglas);

        // Panel para la imagen
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
      //pPrincipal.add (pImagen, reglas);
      
      
        
        /*bImprimir = new JButton("Imprimir");
        bImprimir.addActionListener(this);
        reglas.gridy = 8;
        pPrincipal.add(bImprimir, reglas);*/

        this.add(pPrincipal);
    }

    public void arrancar() {
        this.setVisible(true);
    } // Inicializa la vista

    // Limpia los campos de título y descripción.
    @Override
    public void limpiar() {
        tfTitulo.setText("");
        taDescripcion.setText("");
    }

    /**
     * Obtiene el título ingresado por el usuario.
     * @return El título de la publicación.
     */
    @Override
    public String getTitulo() {
        return tfTitulo.getText();
    }

    /**
     * Obtiene la descripción ingresada por el usuario.
     * @return La descripción de la publicación.
     */
    @Override
    public String getDescripcion() {
        return taDescripcion.getText();
    }

    /**
     * Establece el controlador para esta vista.
     * @param c El controlador asociado.
     */
    @Override
    public void setControlador(CPublicacion c) {
        controlador = c;
        bEnviar.addActionListener(c);
    }

    /**
     * Maneja los eventos de acción (por ejemplo, clic en botones).
     * @param e El evento de acción.
     */
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