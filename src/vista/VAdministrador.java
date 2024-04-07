package vista;

import modelo.OModelo;

import javax.swing.*;
import java.awt.*;

public class VAdministrador extends JFrame {
    private OModelo usario;
    private VSolicitudReporte solicitudReporte;
    private VSolicitudCurso solicitudCurso;
    private VServicios servicios;
    private VServicio servicio;
    private VCartelera cartelera;
    private VPublicacion publicacion;
    private VEventos eventos;
    private VEvento evento;
    private VCambioContrasena cambioContrasena;
    private JButton bSolicitudes, bServicios, bActualizarServicios, bCartelera, bActualizarCartelera, bEventos, bActualizarEventos, bContrasena;
    private JPanel pPrincipal;
    JScrollPane spPrincipal;
    private JToolBar tbMenu;

    public VAdministrador(OModelo usuario, ISolicitudReporte solicitudReporte, ISolicitudCurso solicitudCurso, IServicios servicios, IServicio servicio, ICartelera cartelera, IPublicacion publicacion, IEventos eventos, IEvento evento, ICambioContrasena cambioContrasena) {
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

        bSolicitudes = new JButton("Solicitudes");
        bSolicitudes.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) solicitudCurso);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitudes);

        bServicios = new JButton("Servicios");
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) servicios);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);

        bActualizarServicios = new JButton("Actualizar servicios");
        bActualizarServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) servicio);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarServicios);

        bCartelera = new JButton("Cartelera informativa");
        bCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) cartelera);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bCartelera);

        bActualizarCartelera = new JButton("Actualizar cartelera");
        bActualizarCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) publicacion);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarCartelera);

        bEventos = new JButton("Eventos");
        bEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) eventos);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bEventos);

        bActualizarEventos = new JButton("Actualizar eventos");
        bActualizarEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) evento);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarEventos);

        bContrasena = new JButton("Cambiar contraseña");
        bContrasena.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) cambioContrasena);
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bContrasena);

        this.add(tbMenu, BorderLayout.WEST);
        this.add(spPrincipal, BorderLayout.CENTER);
    }

}
