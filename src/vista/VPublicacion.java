package vista;
import javax.swing.*;
import controlador.CPublicacion;
import java.awt.event.*;
import java.awt.*;

import controlador.CSugerencia;
import vista.IPublicacion;

public class VPublicacion extends JFrame implements ActionListener, IPublicacion {
    private CPublicacion controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombre, lTelefono, lCorreo, lSugerencia, lDescripcion, lFecha;
    private JTextField tfTitulo;
    private JTextArea taDescripcion;
    private JButton bEnviar, bImprimir;

    public VPublicacion() {
        super("Envío de publicación");
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

        JLabel lTipo = new JLabel("Envía tus publicaciones");
        lTipo.setFont(new Font("Arial", Font.BOLD, 14));
        reglas.gridy = 2;
        pPrincipal.add(lTipo, reglas);

        JLabel lTituloPublicacion = new JLabel("Título:");
        reglas.gridy = 3;
        pPrincipal.add(lTituloPublicacion, reglas);

        tfTitulo = new JTextField();
        tfTitulo.setPreferredSize(new Dimension(200, 30));
        reglas.gridy = 4;
        pPrincipal.add(tfTitulo, reglas);

        JLabel lInformacion = new JLabel("Aporta más información:");
        reglas.gridy = 5;
        pPrincipal.add(lInformacion, reglas);

        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(200, 100));
        reglas.gridy = 6;
        pPrincipal.add(taDescripcion, reglas);

        bEnviar = new JButton("Enviar");
        bEnviar.setActionCommand(ENVIAR);
        bEnviar.addActionListener(this);
        reglas.gridy = 7;
        pPrincipal.add(bEnviar, reglas);

       /* bImprimir = new JButton("Imprimir");
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