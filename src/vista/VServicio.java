package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

// Vista para el manejo de servicios.
public class VServicio extends JPanel implements ActionListener, IServicio{
    private final JButton bActualizar;
    private final JPanel pPrincipal;
    private final JComboBox cServicio;
    private final JTextField tNombre;
    private final JTextField tHorario;
    private final JTextField tUbicacion;
    private final JRadioButton rbActivo;
    private final JRadioButton rbInactivo;
    private CServicio controlador;

    // Constructor de la clase VServicio
    public VServicio(){
        this.setPreferredSize(new Dimension(1085, 680));

        this.setLayout(new BorderLayout());


        // Panel para los botones
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        bActualizar = new JButton("Actualizar");
        bActualizar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bActualizar.setForeground(Color.WHITE);
        bActualizar.setBackground(new Color(2, 152, 178));
        bActualizar.setActionCommand(IServicio.ACTUALIZAR);
        bActualizar.addActionListener(this);
        pBotones.add(bActualizar);
        this.add(pBotones, BorderLayout.SOUTH);

        // Panel principal
        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.anchor = GridBagConstraints.WEST;

        // Panel para la imagen del servicio
        JPanel pIconSer = new JPanel();
        pIconSer.setBackground(new Color(255, 255, 255));
        JLabel lImagenSe = new JLabel();  
        lImagenSe.setSize(40, 30);
        ImageIcon icon = new ImageIcon("media/servicio.png");
        Icon iconoSe = new ImageIcon(icon.getImage().getScaledInstance(lImagenSe.getWidth(), lImagenSe.getHeight(), Image.SCALE_DEFAULT));
        lImagenSe.setIcon(iconoSe);
        pIconSer.add(lImagenSe);
        JLabel lTitulo = new JLabel("SERVICIO");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconSer.add(lTitulo);
        reglas.gridx = 2;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        pPrincipal.add(pIconSer, reglas);

        // Componentes del formulario
        reglas.gridx = 1;
        reglas.gridy = 2;
        JLabel lServicio = new JLabel("Servicio: ");
        lServicio.setFont(new Font("Open Sans", Font.BOLD, 16));
        pPrincipal.add(lServicio, reglas);
        
        reglas.gridy = 3;
        JLabel lHorario = new JLabel("Horario: ");
        lHorario.setFont(new Font("Open Sans", Font.BOLD, 16));
        pPrincipal.add(lHorario, reglas);
        
        reglas.gridy = 4;
        JLabel lUbicacion = new JLabel("Ubicación: ");
        lUbicacion.setFont(new Font("Open Sans", Font.BOLD, 16));
        pPrincipal.add(lUbicacion, reglas);
        
        reglas.gridy = 5;
        JLabel lEstado= new JLabel("Estado: ");
        lEstado.setFont(new Font("Open Sans", Font.BOLD, 16));
        pPrincipal.add(lEstado, reglas);    
        tNombre = new JTextField(20);
        
        reglas.gridx = 2;
        reglas.gridy = 2;
        Validacion.validarLongitud(tNombre, 30);

        // Campo de texto para el nombre del servicio
        tNombre.setVisible(false);
        pPrincipal.add(tNombre, reglas);

        // ComboBox para seleccionar el servicio
        cServicio = new JComboBox();
        cServicio.setFont(new Font("Open Sans", Font.PLAIN, 16));
        cServicio.setBackground(new Color(255, 255, 255));
        cServicio.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                servicioSeleccion(e);
            }
        });
        cServicio.setActionCommand(IServicio.SELECCION);
        cServicio.addActionListener(this);
      //  cServicio.addItem("Otro");
        pPrincipal.add(cServicio, reglas);

       // Campo de texto para el horario del servicio
        tHorario = new JTextField(20);
        Validacion.validarLongitud(tHorario,45);
        reglas.gridy = 3;
        pPrincipal.add(tHorario, reglas);

        // Campo de texto para la ubicación del servicio
        tUbicacion = new JTextField(20);
        Validacion.validarLongitud(tUbicacion,45);
        reglas.gridy = 4;
        pPrincipal.add(tUbicacion, reglas);
        rbActivo = new JRadioButton("Activo");
       // reglas.anchor = GridBagConstraints.WEST;
        rbActivo.setBackground(new Color(255, 255, 255));
        rbActivo.setFont(new Font("Open Sans", Font.BOLD, 16));
        //rbActivo.setIcon(new ColorIcon(Color.GREEN, 10));

        // RadioButton y sus estados
        rbInactivo = new JRadioButton("Inactivo");
        rbInactivo.setFont(new Font("Open Sans", Font.BOLD, 16));
        //rbInactivo.setIcon(new ColorIcon(Color.RED, 10));
        
        rbInactivo.setBackground(new Color(255, 255, 255));
        ButtonGroup bg = new ButtonGroup();

        // Grupo de botones para los estados
        bg.add(rbActivo);
        bg.add(rbInactivo);
        reglas.gridy = 5;
        //reglas.anchor = GridBagConstraints.EAST;
        
        pPrincipal.add(rbActivo, reglas);
       reglas.gridx = 3;
       reglas.anchor = GridBagConstraints.WEST;
        pPrincipal.add(rbInactivo, reglas);

        // Panel para la imagen
        JPanel pImagen = new JPanel(); 
        pImagen.setBackground(new Color(255, 255, 255));
    
      
        reglas.gridx = 5;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        reglas.gridheight = 5;
        
        reglas.anchor = GridBagConstraints.EAST;

        // Etiqueta para la imagen
        JLabel lImagen = new JLabel();  
        lImagen.setSize(300, 300);
        ImageIcon imagen = new ImageIcon("media/servicios.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
       // pImagen.add(lImagen);
        pPrincipal.add (pImagen, reglas);
        // Adición del panel principal al panel de la vista
        this.add(pPrincipal);
    }

    /**
     * Maneja los eventos de los botones.
     * @param e Evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==cServicio){
        if (cServicio.getSelectedItem().toString().equals("Otro")){
            tNombre.setVisible(true);
            cServicio.setVisible(false);
        } else {
            controlador.actionPerformed(e);
        }
      }
    }

    // Constructor de la clase ColorIcon, ajusta color y tamaño
    static abstract class ColorIcon implements Icon {
        private final Color color;
        private final int size;

        public ColorIcon(Color color, int size) {
            this.color = color;
            this.size = size;
        }

        //  Pinta el ícono.
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(x, y, size, size);
        }

        // Asigna el ancho del icono
        public int getIconWidh() {
            return size;
        }

        // Asigna el alto del icono
        public int getIconHeight() {
            return size;
        }
    
    
    }
    
    // Inicia la vista
    @Override
    public void arrancar() {
    this.setVisible(true);
    }

    /**
     * Carga los servicios en el ComboBox.
     * @param cbmServicio Modelo del ComboBox.
     */
    @Override
    public void cargarServicio(ComboBoxModel cbmServicio) {
        cServicio.removeAllItems();
        cServicio.setModel(cbmServicio);
        cServicio.addItem("Otro");
    }

    /**
     * Maneja la selección de un servicio en el ComboBox.
     * @param e Evento de selección.
     */
    @Override
    public void servicioSeleccion(ItemEvent e) {
        if(cServicio.getSelectedItem().toString().equals("Otro")){
            tNombre.setVisible(true);
            cServicio.setVisible(false);
            tHorario.setText("");
            tUbicacion.setText("");
            rbActivo.setSelected(true);
        } else {
            tNombre.setVisible(false);
        }
    }

    /**
     * Muestra los detalles de un servicio.
     * @param horario Horario del servicio.
     * @param ubicacion Ubicación del servicio.
     * @param estatus Estatus del servicio.
     */
    @Override
    public void mostrarServicio(String horario, String ubicacion, String estatus) {
        tHorario.setText(horario);
        tUbicacion.setText(ubicacion);
        if(estatus.equals("1")){
            rbActivo.setSelected(true);
        } else {
            rbInactivo.setSelected(true);
        }
    }


    /**
     * Establece el controlador de la vista.
     * @param controlador Controlador de servicios.
     */
    @Override
    public void setControlador(CServicio controlador) {
        this.controlador = controlador;
        bActualizar.addActionListener(controlador);
    }

    /**
     * Obtiene el caso de uso.
     * @return Caso de uso.
     */
    @Override
    public int getCaso() {
        if(tNombre.isVisible()){
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Obtiene el nombre del servicio.
     * @return Nombre del servicio.
     */
    @Override
    public String getNombreServicio() {
        if(tNombre.isVisible()){
            return tNombre.getText();} else {
            return cServicio.getSelectedItem().toString();
        }
    }

    /**
     * Obtiene el horario del servicio.
     * @return Horario del servicio.
     */
    @Override
    public String getHorarioServicio() {
        return tHorario.getText();
    }

    /**
     * Obtiene la ubicación del servicio.
     * @return Ubicación del servicio.
     */
    @Override
    public String getUbicacionServicio() {
        return tUbicacion.getText();
    }

    /**
     * Obtiene el estatus del servicio.
     * @return Estatus del servicio.
     */
    @Override
    public String getEstatusServicio() {
        if(rbActivo.isSelected()){
            return "1";
        } else {
            return "0";
        }
    }
}
