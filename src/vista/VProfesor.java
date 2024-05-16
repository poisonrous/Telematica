package vista;

import modelo.Instanciar;
import modelo.OModelo;
import principal.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

// Vista de profesor
public class VProfesor extends JFrame {
    private JButton bRegistro, bListado, bDatos, bSolicitudes, bSugerencias, bServicios, bActualizarServicios, bCartelera, bActualizarCartelera, bPubsPendientes, bEventos, bActualizarEventos, bContrasena, bSalir;
    private JPanel pPrincipal;
    JScrollPane spPrincipal;
    private JToolBar tbMenu;
    private Principal principal = new Principal();

    // Constructor de la clase VProfesor.
    public VProfesor(OModelo usuario, Instanciar instanciar) {
        super("Telecomunícate");
        this.setSize(950, 750);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        // Ajuste del JScrollPane principal
        spPrincipal = new JScrollPane();
        spPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spPrincipal.setBounds(0, 0, 800, 800);

        // Ajustes del JPanel principal
        pPrincipal = new JPanel();
        pPrincipal.setBackground(new Color(255, 255, 255));

        spPrincipal.setViewportView(pPrincipal);

        // Panel de datos del usuario
        JPanel datosUsuario = new JPanel();
       // datosUsuario.setBackground(new Color(255, 255, 255));
        JLabel lImagenSu = new JLabel();
        lImagenSu.setSize(45, 45);
        ImageIcon icon = new ImageIcon("media/usuarios.png");
        Icon iconoSu = new ImageIcon(icon.getImage().getScaledInstance(lImagenSu.getWidth(), lImagenSu.getHeight(), Image.SCALE_DEFAULT));
        lImagenSu.setIcon(iconoSu);
        datosUsuario.add(lImagenSu);

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


        // Barra de herramientas (Toolbar) para el menú
        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(new Color(255,255,255));
        tbMenu.setPreferredSize(new Dimension(200, 800));
        tbMenu.setFloatable(false);
        tbMenu.setOpaque(true);

        tbMenu.add(datosUsuario);

        // Menú para administradores
        if(usuario.isAdmin()>0){

            // Etiqueta de Administrador
            JLabel lAdmin = new JLabel("Administrador");
            lAdmin.setFont(new Font("Open Sans", Font.BOLD, 14));

            lAdmin.setForeground(Color.BLACK);
            lAdmin.setBackground(Color.LIGHT_GRAY);
            tbMenu.add(lAdmin);

            // Botón para el registro de estudiantes
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

            // Botón para ver los reportes
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

            // Botón para actualizar los servicios
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
            // Botón para actualizar los eventos
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

            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            leftPanel.add(lAdmin);
            leftPanel.add(bRegistro);
            leftPanel.add(bDatos);
            leftPanel.add(bActualizarServicios);
            leftPanel.add(bPubsPendientes);
            leftPanel.add(bActualizarEventos);
            tbMenu.add(leftPanel, BorderLayout.WEST);
        }

        // Menú para profesores
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

        // Botón para ver la cartelera informativa
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
        // Botón para ver los eventos
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


        // Botón para cambiar la contraseña
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

        // Botón para cerrar sesión
        bSalir = new JButton("Cerrar sesión");
        bSalir.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSalir.setForeground(Color.WHITE);
        bSalir.setBackground(new Color(255, 75, 75));
        bSalir.addActionListener(e -> {
            principal.cerrarSesion();
        });
        tbMenu.add(bSalir);

        JPanel leftPanel2 = new JPanel();
        leftPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel2.add(lProfesor);
        leftPanel2.add(bListado);
        leftPanel2.add(bActualizarCartelera);
        leftPanel2.add(bEventos);
        leftPanel2.add(bCartelera);
        leftPanel2.add(bContrasena);
        leftPanel2.add(bSalir);

        tbMenu.add(leftPanel2, BorderLayout.WEST);


        // Agregar componentes al frame
        this.add(tbMenu, BorderLayout.WEST);
        this.add(spPrincipal, BorderLayout.CENTER);

        //Confirmar cerrado
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                UI.put("OptionPane.background", new Color (255,255,255));
                UI.put("Panel.background", new Color (255,255,255));
                UI.put("Button.background", new Color (3,150,177));
                UIManager.put("Button.foreground", Color.white);

                ImageIcon icon = new ImageIcon("media/advertencia.png");


                int confirmed = JOptionPane.showOptionDialog(null,
                        "¿Estás seguro de que quieres salir? La sesión se cerrará si lo haces.", "Confirmar salida",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, icon, new String[]{"Si", "No"}, "Si");
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

}
