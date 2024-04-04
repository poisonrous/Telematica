package vista;
import javax.swing.*;
import controlador.CSugerencia;
import vista.ISugerencia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VSugerencia extends JFrame implements ActionListener, ISugerencia, Printable {
    private CSugerencia controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombre, lTelefono, lCorreo, lSugerencia, lDescripcion, lFecha;
    private JTextField tfTitulo;
    private JTextArea taDescripcion;
    private JButton bEnviar, bImprimir;

    public VSugerencia() {
        super("Envío de sugerencias");
        this.setSize(800, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


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
        JLabel lTipo = new JLabel("Envía tus sugerencias");
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
        JLabel lInformacion = new JLabel("Descripción:");
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

        this.add(pPrincipal);

        //AQUÍ CREARÉ LA PANTALLA DE RESULTADO
        pResultado = new JPanel(new GridBagLayout());
        pResultado.setVisible(false);
        GridBagConstraints reglasResultado = new GridBagConstraints();
        reglasResultado.gridx = 1;
        reglasResultado.gridy = 1;
        reglasResultado.insets = new Insets(10, 10, 10, 10);
        pResultado.add(lTitulo, reglasResultado);
        JLabel lSolicitud = new JLabel("Sugerencia enviada");
        lSolicitud.setFont(new Font("Arial", Font.BOLD, 14));
        reglasResultado.gridy = 2;
        pResultado.add(lSolicitud, reglasResultado);;
        pDatos = new JPanel(new GridBagLayout());
        GridBagConstraints reglasDatos = new GridBagConstraints();
        reglasDatos.gridx = 1;
        reglasDatos.gridy = 1;
        pDatos.add(new JLabel("Nombre: "), reglasDatos);
        reglasDatos.gridy = 2;
        pDatos.add(new JLabel("Teléfono: "), reglasDatos);
        reglasDatos.gridy = 3;
        pDatos.add(new JLabel("Correo: "), reglasDatos);
        reglasDatos.gridy = 4;
        pDatos.add(new JLabel("Sugerencia: "), reglasDatos);
        reglasDatos.gridy = 5;
        pDatos.add(new JLabel("Descripción: "), reglasDatos);
        reglasDatos.gridy = 6;
        pDatos.add(new JLabel("Fecha de creación: "), reglasDatos);
        lNombre = new JLabel("");
        reglasDatos.gridx = 2;
        reglasDatos.gridy = 1;
        pDatos.add(lNombre, reglasDatos);
        lTelefono = new JLabel("");
        reglasDatos.gridy = 2;
        pDatos.add(lTelefono, reglasDatos);
        lCorreo = new JLabel("");
        reglasDatos.gridy = 3;
        pDatos.add(lCorreo, reglasDatos);
        lSugerencia = new JLabel("");
        reglasDatos.gridy = 4;
        pDatos.add(lSugerencia, reglasDatos);
        lDescripcion = new JLabel("");
        reglasDatos.gridy = 5;
        pDatos.add(lDescripcion, reglasDatos);
        lFecha = new JLabel("");
        reglasDatos.gridy = 6;
        pDatos.add(lFecha, reglasDatos);
        reglasResultado.gridy = 3;
        pResultado.add(pDatos, reglasResultado);

        bImprimir= new JButton("Imprimir");
        bImprimir.addActionListener(this);
        reglasResultado.gridy = 4;
        pResultado.add(bImprimir, reglasResultado);

    }

    public void arrancar() {
        this.setVisible(true);
    }

    public String getTitulo() {
        return this.tfTitulo.getText();
    }

    public String getDetalles() {
        return this.taDescripcion.getText();
    }

    public void setControlador(CSugerencia c) {

        controlador = c;
        bEnviar.addActionListener(c);
    }
    @Override
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha) {
        lNombre.setText(nombre + " " + apellido);
        lTelefono.setText(telefono);
        lCorreo.setText(correo);
        lSugerencia.setText(sugerencia);
        lDescripcion.setText(descripcion);
        lFecha.setText(fecha);
        pPrincipal.setVisible(false);
        pResultado.setVisible(true);
        this.add(pResultado);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==bImprimir){
            try {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this);
                job.printDialog();
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(VSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based (este código me lo robé, qué les digo)*/
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        pDatos.printAll(graphics);

        return PAGE_EXISTS;
    }
}