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
        super("Envío de sugerencia");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();

        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        JLabel lTitulo = new JLabel("Sistema Telemática");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pPrincipal.add(lTitulo, reglas);

        JLabel lTipo = new JLabel("Envía tus sugerencias");
        lTipo.setFont(new Font("Arial", Font.BOLD, 14));
        reglas.gridy = 2;
        pPrincipal.add(lTipo, reglas);

        JLabel lTituloSugerencia = new JLabel("Título:");
        reglas.gridy = 3;
        pPrincipal.add(lTituloSugerencia, reglas);

        tfTitulo = new JTextField();
        tfTitulo.setPreferredSize(new Dimension(200, 30));
        reglas.gridy = 4;
        pPrincipal.add(tfTitulo, reglas);

        JLabel lInformacion = new JLabel("Aporta más información:");
        reglas.gridy = 5;
        pPrincipal.add(lInformacion, reglas);

        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(200, 100)); //pensar cómo hacer que salte de línea y no se extienda indefinidamente
        reglas.gridy = 6;
        pPrincipal.add(taDescripcion, reglas);

        bEnviar = new JButton("Enviar");
        bEnviar.setActionCommand(ISugerencia.ENVIAR);
        bEnviar.setPreferredSize(new Dimension(100, 30));
        reglas.gridy = 7;
        pPrincipal.add(bEnviar, reglas);

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