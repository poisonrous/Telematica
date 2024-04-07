package vista;

import controlador.*;
import modelo.*;

import javax.swing.*;
import java.awt.*;

public class VEstudiante extends JFrame {
    private VSolicitud solicitud;
    private VServicios servicios;
    private VCartelera cartelera;
    private VEventos eventos;
    private VSugerencia sugerencia;
    private VPublicacion publicacion;
    private VCambioContrasena cambioContrasena;
    private OModelo usuario;
    private JButton bSolicitud, bServicios, bCartelera, bEventos, bSugerencias, bPublicacion, bContrasena;
    private JPanel pPrincipal;
    private JScrollPane spPrincipal;
    private JToolBar tbMenu;

    public VEstudiante(OModelo usuario, ICartelera cartelera, ISolicitud solicitud, IServicios servicios, IEventos eventos, ISugerencia sugerencia, IPublicacion publicacion, ICambioContrasena cambioContrasena) {
        super("Telecomunícate");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        spPrincipal = new JScrollPane();
        spPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spPrincipal.setBounds(0, 0, 800, 800);

        pPrincipal = new JPanel();

        spPrincipal.setViewportView(pPrincipal);

        JPanel datosUsuario = new JPanel();
        datosUsuario.add(new JLabel(usuario.getNombres() + " " + usuario.getApellidos()));

        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(Color.LIGHT_GRAY);
        tbMenu.setOpaque(true);

        tbMenu.add(datosUsuario);

        bSolicitud = new JButton("Enviar solicitud");
        bSolicitud.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) solicitud);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitud);
        bServicios = new JButton("Servicios estudiantiles");
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) servicios);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);
        bCartelera = new JButton("Cartelera informativa");
        bCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) cartelera);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bCartelera);
        bEventos = new JButton("Eventos");
        bEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) eventos);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bEventos);
        bSugerencias = new JButton("Enviar sugerencias");
        bSugerencias.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) sugerencia);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSugerencias);
        bPublicacion = new JButton("Publicar");
        bPublicacion.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) publicacion);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bPublicacion);

        bContrasena = new JButton("Cambiar contraseña");
        bContrasena.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) cambioContrasena);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bContrasena);

       /* JPanel pPantalla = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(5, 10, 10, 10);
        pPantalla.add(tbMenu, reglas);
        reglas.gridx = 2;
        pPantalla.add(pPrincipal,reglas);
        this.add(pPantalla);*/

        this.add(tbMenu, BorderLayout.WEST);
        this.add(spPrincipal, BorderLayout.CENTER);
    }
}
