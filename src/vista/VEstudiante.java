package vista;

import modelo.Instanciar;
import modelo.OModelo;
import principal.Principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class VEstudiante extends JFrame {
    private final JButton bSolicitud, bSolicitudes, bServicios, bCartelera, bEventos, bSugerencias, bPublicacion, bContrasena, bSalir;
    private final JPanel pPrincipal;
    private final JScrollPane spPrincipal;
    private final JToolBar tbMenu;
    private final Principal principal = new Principal();

    public VEstudiante(OModelo usuario, Instanciar instanciar) {
        super("Telecomunícate");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        spPrincipal = new JScrollPane();
        spPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spPrincipal.setBounds(0, 0, 800, 800);
        
        pPrincipal = new JPanel();
        pPrincipal.setBackground(new Color(255, 255, 255));

        spPrincipal.setViewportView(pPrincipal);

        JPanel datosUsuario = new JPanel();
        
        JTextArea lNomApe = new JTextArea(usuario.getNombres() + " " + usuario.getApellidos());
        lNomApe.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lNomApe.setForeground(Color.BLACK);
        lNomApe.setPreferredSize(new Dimension(200, 50));
        lNomApe.setLineWrap(true);
        lNomApe.setWrapStyleWord(true);
        lNomApe.setEditable(false);
        lNomApe.setOpaque(false);
        lNomApe.setMargin(new Insets(10, 10, 10, 10));
        /*lNomApe.setFont(new Font("Open Sans", Font.BOLD, 14));
        lNomApe.setForeground(Color.BLACK);*/  //Por si se ve mejor así
        
        datosUsuario.add(lNomApe);
        

        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(Color.LIGHT_GRAY);
        tbMenu.setPreferredSize(new Dimension(200, 800));
        tbMenu.setFloatable(false);
        tbMenu.setOpaque(true);

        tbMenu.add(datosUsuario);

        JLabel lEstudiante = new JLabel("Estudiante");
        lEstudiante.setFont(new Font("Open Sans", Font.BOLD, 14));
        lEstudiante.setForeground(Color.BLACK);
        lEstudiante.setBackground(Color.LIGHT_GRAY);
        tbMenu.add(lEstudiante);

        bSolicitud = new JButton("Enviar solicitud");
        bSolicitud.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitud.setForeground(Color.WHITE);
        bSolicitud.setBackground(new Color(2, 152, 178));
        bSolicitud.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSolicitud());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitud);

        bSolicitudes = new JButton("Solicitudes enviadas");
        bSolicitudes.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitudes.setForeground(Color.WHITE);
        bSolicitudes.setBackground(new Color(2, 152, 178));
        bSolicitudes.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSolicitudes());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitudes);

        bSugerencias = new JButton("Enviar sugerencias");
        bSugerencias.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSugerencias.setForeground(Color.WHITE);
        bSugerencias.setBackground(new Color(2, 152, 178));
        bSugerencias.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSugerencia());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSugerencias);

        bPublicacion = new JButton("Publicar");
        bPublicacion.setFont(new Font("Open Sans", Font.BOLD, 14));
        bPublicacion.setForeground(Color.WHITE);
        bPublicacion.setBackground(new Color(2, 152, 178));
        bPublicacion.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarPublicacion());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bPublicacion);

        bCartelera = new JButton("Cartelera informativa");
        bCartelera.setFont(new Font("Open Sans", Font.BOLD, 14));
        bCartelera.setForeground(Color.WHITE);
        bCartelera.setBackground(new Color(2, 152, 178));
        bCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarCartelera());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bCartelera);

        bEventos = new JButton("Eventos");
        bEventos.setFont(new Font("Open Sans", Font.BOLD, 14));
        bEventos.setForeground(Color.WHITE);
        bEventos.setBackground(new Color(2, 152, 178));
        bEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarEventos());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bEventos);

        bServicios = new JButton("Servicios estudiantiles");
        bServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
        bServicios.setForeground(Color.WHITE);
        bServicios.setBackground(new Color(2, 152, 178));
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarServicios());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);

        bContrasena = new JButton("Cambiar contraseña");
        bContrasena.setFont(new Font("Open Sans", Font.BOLD, 14));
        bContrasena.setForeground(Color.WHITE);
        bContrasena.setBackground(new Color(2, 152, 178));
        bContrasena.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarCambioContrasena());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bContrasena);

        bSalir = new JButton("Cerrar sesión");
        bSalir.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSalir.setForeground(Color.WHITE);
        bSalir.setBackground(new Color(2, 152, 178));
        bSalir.addActionListener(e -> {
            principal.cerrarSesion();
        });
        tbMenu.add(bSalir);

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

        //Confirmar cerrado
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showOptionDialog(null,
                        "¿Estás seguro de que quieres salir? La sesión se cerrará si lo haces.", "Confirmar salida",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, null, new String[]{"Si", "No"}, "Si");
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
