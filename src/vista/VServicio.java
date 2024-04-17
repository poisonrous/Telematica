package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;


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

    public VServicio(){
        this.setPreferredSize(new Dimension(1085, 680));

        this.setLayout(new BorderLayout());

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
       

        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.anchor = GridBagConstraints.WEST;
        
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
        reglas.gridx = 3;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        pPrincipal.add(pIconSer, reglas);
        
        
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
        tNombre.setVisible(false);
        pPrincipal.add(tNombre, reglas);
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
        tHorario = new JTextField(20);
        Validacion.validarLongitud(tHorario,45);
        reglas.gridy = 3;
        pPrincipal.add(tHorario, reglas);
        tUbicacion = new JTextField(20);
        Validacion.validarLongitud(tUbicacion,45);
        reglas.gridy = 4;
        pPrincipal.add(tUbicacion, reglas);
        rbActivo = new JRadioButton("Activo");
       // reglas.anchor = GridBagConstraints.WEST;
        rbActivo.setBackground(new Color(255, 255, 255));
        rbActivo.setFont(new Font("Open Sans", Font.BOLD, 16));
        //rbActivo.setIcon(new ColorIcon(Color.GREEN, 10));
        
        rbInactivo = new JRadioButton("Inactivo");
        rbInactivo.setFont(new Font("Open Sans", Font.BOLD, 16));
        //rbInactivo.setIcon(new ColorIcon(Color.RED, 10));
        
        rbInactivo.setBackground(new Color(255, 255, 255));
        ButtonGroup bg = new ButtonGroup();
       
        bg.add(rbActivo);
        bg.add(rbInactivo);
        reglas.gridy = 5;
        //reglas.anchor = GridBagConstraints.EAST;
        
        pPrincipal.add(rbActivo, reglas);
       reglas.gridx = 3;
       reglas.anchor = GridBagConstraints.WEST;
        pPrincipal.add(rbInactivo, reglas);
        
        
        JPanel pImagen = new JPanel(); 
        pImagen.setBackground(new Color(255, 255, 255));
    
      
        reglas.gridx = 5;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        reglas.gridheight = 5;
        
        reglas.anchor = GridBagConstraints.EAST;
      
        
        
        JLabel lImagen = new JLabel();  
        lImagen.setSize(300, 300);
        ImageIcon imagen = new ImageIcon("media/servicios.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
        pPrincipal.add (pImagen, reglas); 
        
        this.add(pPrincipal);
    }

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

    
    static class ColorIcon implements Icon {
        private final Color color;
        private final int size;

        public ColorIcon(Color color, int size) {
            this.color = color;
            this.size = size;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(x, y, size, size);
        }

        public int getIconWidth() {
            return size;
        }

        public int getIconHeight() {
            return size;
        }
    
    
    }
    
    
    @Override
    public void arrancar() {
    this.setVisible(true);
    }

    @Override
    public void cargarServicio(ComboBoxModel cbmServicio) {
        cServicio.removeAllItems();
        cServicio.setModel(cbmServicio);
        cServicio.addItem("Otro");
    }

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
    @Override
    public void setControlador(CServicio controlador) {
        this.controlador = controlador;
        bActualizar.addActionListener(controlador);
    }
    @Override
    public int getCaso() {
        if(tNombre.isVisible()){
            return 1;
        } else {
            return 2;
        }
    }
    @Override
    public String getNombreServicio() {
        if(tNombre.isVisible()){
            return tNombre.getText();} else {
            return cServicio.getSelectedItem().toString();
        }
    }

    @Override
    public String getHorarioServicio() {
        return tHorario.getText();
    }

    @Override
    public String getUbicacionServicio() {
        return tUbicacion.getText();
    }

    @Override
    public String getEstatusServicio() {
        if(rbActivo.isSelected()){
            return "1";
        } else {
            return "0";
        }
    }
}
