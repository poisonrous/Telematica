package vista;

import modelo.Instanciar;
import modelo.OModelo;
import principal.Principal;
import javax.swing.*;
import java.awt.*;

public class VEstudiante extends JFrame {
    private final JButton bSolicitud, bSolicitudes, bServicios, bCartelera, bEventos, bSugerencias, bPublicacion, bContrasena, bSalir;
    private final JPanel pPrincipal;
    private final JScrollPane spPrincipal;
    private final JToolBar tbMenu;
    private final Principal principal = new Principal();

    public VEstudiante(OModelo usuario, Instanciar instanciar) {
        super("Telecomunícate");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        spPrincipal = new JScrollPane();
        spPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spPrincipal.setBounds(0, 0, 800, 800);
        
        pPrincipal = new JPanel();
        pPrincipal.setBackground(new Color(255, 255, 255));

        spPrincipal.setViewportView(pPrincipal);

        JPanel datosUsuario = new JPanel();
        
        JLabel lNomApe = new JLabel(usuario.getNombres() + " " + usuario.getApellidos());
        lNomApe.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lNomApe.setForeground(Color.BLACK);
        
        /*lNomApe.setFont(new Font("Open Sans", Font.BOLD, 14));
        lNomApe.setForeground(Color.BLACK);*/  //Por si se ve mejor así
        
        datosUsuario.add(lNomApe);
        

        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(Color.LIGHT_GRAY);
        tbMenu.setOpaque(true);

        tbMenu.add(datosUsuario);

        bSolicitud = new JButton("Enviar solicitud");
        bSolicitud.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitud.setForeground(Color.WHITE);
        bSolicitud.setBackground(new Color(0, 125, 254));
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
        bSolicitudes.setBackground(new Color(0, 125, 254));
        bSolicitudes.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSolicitudes());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitudes);
        bServicios = new JButton("Servicios estudiantiles");
        bServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
        bServicios.setForeground(Color.WHITE);
        bServicios.setBackground(new Color(0, 125, 254));
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarServicios());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);
        bCartelera = new JButton("Cartelera informativa");
        bCartelera.setFont(new Font("Open Sans", Font.BOLD, 14));
        bCartelera.setForeground(Color.WHITE);
        bCartelera.setBackground(new Color(0, 125, 254));
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
        bEventos.setBackground(new Color(0, 125, 254));
        bEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarEventos());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bEventos);
        bSugerencias = new JButton("Enviar sugerencias");
        bSugerencias.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSugerencias.setForeground(Color.WHITE);
        bSugerencias.setBackground(new Color(0, 125, 254));
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
        bPublicacion.setBackground(new Color(0, 125, 254));
        bPublicacion.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarPublicacion());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bPublicacion);

        bContrasena = new JButton("Cambiar contraseña");
        bContrasena.setFont(new Font("Open Sans", Font.BOLD, 14));
        bContrasena.setForeground(Color.WHITE);
        bContrasena.setBackground(new Color(0, 125, 254));
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
        bSalir.setBackground(new Color(0, 125, 254));
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
    }
}
