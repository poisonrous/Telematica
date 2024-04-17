package vista;

import modelo.Instanciar;
import modelo.OModelo;
import principal.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class VProfesor extends JFrame {
    private JButton bRegistro, bListado, bDatos, bSolicitudes, bSugerencias, bServicios, bActualizarServicios, bCartelera, bActualizarCartelera, bPubsPendientes, bEventos, bActualizarEventos, bContrasena, bSalir;
    private JPanel pPrincipal;
    JScrollPane spPrincipal;
    private JToolBar tbMenu;
    private Principal principal = new Principal();

    public VProfesor(OModelo usuario, Instanciar instanciar) {
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
       // datosUsuario.setBackground(new Color(255, 255, 255));
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

        if(usuario.isAdmin()>0){
            JLabel lAdmin = new JLabel("Administrador");
            lAdmin.setFont(new Font("Open Sans", Font.BOLD, 14));
            lAdmin.setForeground(Color.BLACK);
            lAdmin.setBackground(Color.LIGHT_GRAY);
            tbMenu.add(lAdmin);

            bRegistro = new JButton("Registro de estudiantes");
            bRegistro.setFont(new Font("Open Sans", Font.BOLD, 14));
            bRegistro.setForeground(Color.WHITE);
            bRegistro.setBackground(new Color(2, 152, 178));
            bRegistro.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarRegistro());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bRegistro);

            bDatos = new JButton("Reportes");
            bDatos.setFont(new Font("Open Sans", Font.BOLD, 14));
            bDatos.setForeground(Color.WHITE);
            bDatos.setBackground(new Color(2, 152, 178));
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
            bSolicitudes.setBackground(new Color(2, 152, 178));
            bSolicitudes.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarSolicitudCurso());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bSolicitudes);

            bSugerencias = new JButton("Sugerencias");
            bSugerencias.setFont(new Font("Open Sans", Font.BOLD, 14));
            bSugerencias.setForeground(Color.WHITE);
            bSugerencias.setBackground(new Color(2, 152, 178));
            bSugerencias.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarSugerencias());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bSugerencias);*/

            bActualizarServicios = new JButton("Actualizar servicios");
            bActualizarServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
            bActualizarServicios.setForeground(Color.WHITE);
            bActualizarServicios.setBackground(new Color(2, 152, 178));
            bActualizarServicios.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarServicio());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bActualizarServicios);

            bActualizarEventos = new JButton("Actualizar eventos");
            bActualizarEventos.setFont(new Font("Open Sans", Font.BOLD, 14));
            bActualizarEventos.setForeground(Color.WHITE);
            bActualizarEventos.setBackground(new Color(2, 152, 178));
            bActualizarEventos.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarEvento());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bActualizarEventos);

            bPubsPendientes = new JButton("Publicaciones pendientes");
            bPubsPendientes.setFont(new Font("Open Sans", Font.BOLD, 14));
            bPubsPendientes.setForeground(Color.WHITE);
            bPubsPendientes.setBackground(new Color(2, 152, 178));
            bPubsPendientes.addActionListener(e -> {
                pPrincipal.removeAll();
                pPrincipal.add((JPanel) instanciar.llamarPubsPendientes());
                pPrincipal.revalidate();
                pPrincipal.repaint();
            });
            tbMenu.add(bPubsPendientes);
        }

        JLabel lProfesor = new JLabel("Profesor");
        lProfesor.setFont(new Font("Open Sans", Font.BOLD, 14));
        lProfesor.setForeground(Color.BLACK);
        tbMenu.add(lProfesor);

        bListado = new JButton("Listado de estudiantes");
        bListado.setFont(new Font("Open Sans", Font.BOLD, 14));
        bListado.setForeground(Color.WHITE);
        bListado.setBackground(new Color(2, 152, 178));
        bListado.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarListado());
            pPrincipal.revalidate();
            pPrincipal.repaint();
                });
        tbMenu.add(bListado);
                                                             //botones de otro color para diferenciar Administrador de Estudiante

       /* bServicios = new JButton("Servicios");
        bServicios.setFont(new Font("Open Sans", Font.BOLD, 14));
        bServicios.setForeground(Color.WHITE);
        bServicios.setBackground(new Color(2, 152, 178));
        bServicios.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarServicios());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bServicios);*/

        bActualizarCartelera = new JButton("Publicar");
        bActualizarCartelera.setFont(new Font("Open Sans", Font.BOLD, 14));
        bActualizarCartelera.setForeground(Color.WHITE);
        bActualizarCartelera.setBackground(new Color(2, 152, 178));
        bActualizarCartelera.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarPublicacion());
            pPrincipal.revalidate();
            pPrincipal.repaint();
        });
        tbMenu.add(bActualizarCartelera);

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
