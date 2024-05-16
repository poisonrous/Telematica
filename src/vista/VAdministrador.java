package vista;

import controlador.CCartelera;
import modelo.Instanciar;
import modelo.MCartelera;
import modelo.OModelo;

import javax.swing.*;
import java.awt.*;

public class VAdministrador extends JFrame {
    //private final JButton bSolicitudes;
    //private final JButton bSugerencias;
    private final JButton bDatos;
    private final JButton bServicios;
    private final JButton bActualizarServicios;
    private final JButton bCartelera;
    private final JButton bActualizarCartelera;
    private final JButton bEventos;
    private final JButton bActualizarEventos;
    private final JButton bContrasena;
    private final JPanel pPrincipal;
    JScrollPane spPrincipal;
    private final JToolBar tbMenu;

    public VAdministrador(OModelo usuario, Instanciar instanciar) {
        super("Telecomun�cate");
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
        datosUsuario.setBackground(new Color(255, 255, 255));
        JLabel lNomApe = new JLabel(usuario.getNombres() + " " + usuario.getApellidos());
        lNomApe.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lNomApe.setForeground(Color.BLACK);
        
        /*lNomApe.setFont(new Font("Open Sans", Font.BOLD, 14));
        lNomApe.setForeground(Color.BLACK);*/  //Por si se ve mejor as�

        datosUsuario.add(lNomApe);

        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(Color.LIGHT_GRAY);
        
        tbMenu.setOpaque(true);

        tbMenu.add(datosUsuario);
                                                             //botones de otro color para diferenciar Administrador de Estudiante 

        bDatos = new JButton("Reportes-inicio");
        bDatos.setFont(new Font("Open Sans", Font.BOLD, 14));
        bDatos.setForeground(Color.WHITE);
        bDatos.setBackground(new Color(121, 87, 222));
        bDatos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarDatos());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bDatos);

        /*bSolicitudes = new JButton("Solicitudes");
        bSolicitudes.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitudes.setForeground(Color.WHITE);
        bSolicitudes.setBackground(new Color(121, 87, 222));*/
        
      /*  bSolicitud.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitud.setForeground(Color.WHITE);
        bSolicitud.setBackground(new Color(0, 125, 254));*/ //Por si no queda bien el color anterior
        
        
        /*bSolicitudes.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSolicitudCurso());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSolicitudes);

        bSugerencias = new JButton("Sugerencias");
        bSugerencias.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSugerencias.setForeground(Color.WHITE);
        bSugerencias.setBackground(new Color(121, 87, 222));
        bSugerencias.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSugerencias());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bSugerencias);*/

        bServicios = new JButton("Servicios");
        bServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
        bServicios.setForeground(Color.WHITE);
        bServicios.setBackground(new Color(121, 87, 222));
        
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarServicios());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);

        bActualizarServicios = new JButton("Actualizar servicios");
        bActualizarServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
        bActualizarServicios.setForeground(Color.WHITE);
        bActualizarServicios.setBackground(new Color(121, 87, 222));
        bActualizarServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarServicio());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarServicios);

        bCartelera = new JButton("Cartelera informativa");
        bCartelera.setFont(new Font("Open Sans", Font.BOLD, 14));
        bCartelera.setForeground(Color.WHITE);
        bCartelera.setBackground(new Color(121, 87, 222));
        bCartelera.addActionListener(e -> {

            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarCartelera());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bCartelera);

        bActualizarCartelera = new JButton("Actualizar cartelera");
        bActualizarCartelera.setFont(new Font("Open Sans", Font.BOLD, 14));
        bActualizarCartelera.setForeground(Color.WHITE);
        bActualizarCartelera.setBackground(new Color(121, 87, 222));
        bActualizarCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarPublicacion());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarCartelera);

        bEventos = new JButton("Eventos");
        bEventos.setFont(new Font("Open Sans", Font.BOLD, 14));
        bEventos.setForeground(Color.WHITE);
        bEventos.setBackground(new Color(121, 87, 222));
        bEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarEventos());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bEventos);

        bActualizarEventos = new JButton("Actualizar eventos");
        bActualizarEventos.setFont(new Font("Open Sans", Font.BOLD, 14));
        bActualizarEventos.setForeground(Color.WHITE);
        bActualizarEventos.setBackground(new Color(121, 87, 222));
        bActualizarEventos.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarEvento());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarEventos);

        bContrasena = new JButton("Cambiar contrase�a");
        bContrasena.setFont(new Font("Open Sans", Font.BOLD, 14));
        bContrasena.setForeground(Color.WHITE);
        bContrasena.setBackground(new Color(121, 87, 222));
        bContrasena.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarCambioContrasena());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bContrasena);

        this.add(tbMenu, BorderLayout.WEST);
        this.add(spPrincipal, BorderLayout.CENTER);
    }

}
