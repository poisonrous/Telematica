package vista;

import controlador.CPubsPendientes;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class VPubsPendientes extends JPanel implements IPubsPendientes {
    private JPanel panel;
    private final JPanel pPrincipal;
    private final GridBagConstraints reglas;
    private CPubsPendientes controlador = new CPubsPendientes(this);

    public VPubsPendientes() {
        pPrincipal = new JPanel(new GridBagLayout());
        //pPrincipal.setPreferredSize(new Dimension(1085, 680));
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        JPanel pIconCar = new JPanel();
        pIconCar.setBackground(new Color(255, 255, 255));
        JLabel lImagenCar = new JLabel();
        lImagenCar.setSize(40, 40);
        ImageIcon icon = new ImageIcon("media/cartelera.png");
        Icon iconoCar = new ImageIcon(icon.getImage().getScaledInstance(lImagenCar.getWidth(), lImagenCar.getHeight(), Image.SCALE_DEFAULT));
        lImagenCar.setIcon(iconoCar);
        pIconCar.add(lImagenCar);
        JLabel lTitulo = new JLabel("PUBLICACIONES PENDIENTES DE APROBACIÓN");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconCar.add(lTitulo);

        pPrincipal.add(pIconCar, reglas);
        this.add(pPrincipal);
    }




    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void cargarPub(JPanel publicacion) {

        reglas.gridy++;
        pPrincipal.add(publicacion, reglas);

    }

    @Override
    public void setControlador(CPubsPendientes controlador) {

    }

    @Override
    public JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha) {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        JLabel lTitulo = new JLabel(titulo);
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 14));
        panel.add(lTitulo, reglas);
        reglas.gridy++;
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas2 = new GridBagConstraints();
        reglas2.gridx = 1;
        reglas2.gridy = 1;
        reglas2.insets = new Insets(10, 10, 10, 10);
        JLabel lAutor = new JLabel(autor);
        lAutor.setFont(new Font("Open Sans", Font.BOLD, 12));
        datos.add(lAutor, reglas2);
        reglas2.gridx++;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        JLabel lFecha = new JLabel(formateador.format(fecha));
        lFecha.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lFecha.setForeground(Color.BLACK);
        datos.add(lFecha, reglas2);
        reglas.gridy++;
        panel.add(datos, reglas);
        reglas.gridy++;
        reglas.anchor = GridBagConstraints.WEST;
        JTextArea taContenido = new JTextArea(contenido);
        taContenido.setFont(new Font("Open Sans", Font.ITALIC, 12));
        taContenido.setPreferredSize(new Dimension(400, 200));
        taContenido.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taContenido.setLineWrap(true);
        taContenido.setWrapStyleWord(true);
        panel.add(taContenido, reglas);
        JButton bAprobar = new JButton("Aprobar");
        bAprobar.addActionListener(e -> {
                    try {
                        controlador.aprobarPub();   //PENDIENTE BUSCAR EL IDPUB
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                });
        reglas.gridy++;
        panel.add(bAprobar, reglas);
        JButton bRechazar = new JButton("Rechazar");
        bRechazar.addActionListener(e -> {
                    try {
                        controlador.rechazarPub();  //PENDIENTE BUSCAR EL IDPUB
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                });
        reglas.gridy++;
        panel.add(bRechazar, reglas);
        return panel;
    }
}
