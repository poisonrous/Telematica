package vista;

import modelo.Instanciar;
import modelo.OModelo;
import principal.Principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

// Vista para la interfaz principal de un estudiante.
public class VEstudiante extends JFrame {
    private final JButton bSolicitud, bSolicitudes, bServicios, bCartelera, bEventos, bSugerencias, bPublicacion, bContrasena, bSalir;
    private final JPanel pPrincipal;
    private final JScrollPane spPrincipal;
    private final JToolBar tbMenu;
    private final Principal principal = new Principal();

    /**
     * Constructor de la vista del estudiante.
     * @param usuario El modelo del usuario.
     * @param instanciar Objeto para instanciar las vistas.
     */
    public VEstudiante(OModelo usuario, Instanciar instanciar) {
        super("Telecomunícate");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel de desplazamiento
        spPrincipal = new JScrollPane();
        spPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spPrincipal.setBounds(0, 0, 800, 800);

        // Panel principal
        pPrincipal = new JPanel();
        pPrincipal.setBackground(new Color(255, 255, 255));

        // Asignando el panel principal al panel de desplazamiento
        spPrincipal.setViewportView(pPrincipal);

        // Panel de datos del usuario
        JPanel datosUsuario = new JPanel();

        // Etiqueta para mostrar el nombre del usuario
        JLabel lImagenSu = new JLabel();
        lImagenSu.setSize(45, 45);
        ImageIcon icon = new ImageIcon("media/usuarios.png");
        Icon iconoSu = new ImageIcon(icon.getImage().getScaledInstance(lImagenSu.getWidth(), lImagenSu.getHeight(), Image.SCALE_DEFAULT));
        lImagenSu.setIcon(iconoSu);
        datosUsuario.add(lImagenSu);

        JTextArea lNomApe = new JTextArea(usuario.getNombres() + " " + usuario.getApellidos());
        lNomApe.setFont(new Font("Open Sans", Font.ITALIC, 14));
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

        // Barra de herramientas del menú
        tbMenu = new JToolBar(JToolBar.VERTICAL);
        tbMenu.setBackground(new Color(255,255,255));
        tbMenu.setPreferredSize(new Dimension(200, 800));
        tbMenu.setFloatable(false);
        tbMenu.setOpaque(true);

        // Agregando datos del usuario al menú
        tbMenu.add(datosUsuario);

        // Etiqueta de tipo de usuario
        JLabel lEstudiante = new JLabel("Estudiante");
        lEstudiante.setFont(new Font("Open Sans", Font.BOLD, 14));
        lEstudiante.setForeground(Color.BLACK);
        lEstudiante.setBackground(Color.LIGHT_GRAY);
        tbMenu.add(lEstudiante);



        // Botones del menú y sus acciones
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

        // Botón para solicitud
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

        // Botón para sugerencias
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

        // Botón para publicar
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

        // Botón para cartelera
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

        // Botón para eventos
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

        // Botón para servicios
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

        // Botón para cambiar contraseña
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

        // Botón para cerrar la sesión
        bSalir = new JButton("Cerrar sesión");
        bSalir.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSalir.setForeground(Color.WHITE);
        bSalir.setBackground(new Color(255, 75, 75));
        bSalir.addActionListener(e -> {
            principal.cerrarSesion();
        });
        tbMenu.add(bSalir);

        //posición de los botones a la izquierda para visualizarlos mejor
       JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(lEstudiante);
        leftPanel.add(bSolicitud);
        leftPanel.add(bSolicitudes);
        leftPanel.add(bSugerencias);
        leftPanel.add(bPublicacion);
        leftPanel.add(bCartelera);
        leftPanel.add(bEventos);
        leftPanel.add(bServicios);
        leftPanel.add(bContrasena);
        leftPanel.add(bSalir);
       tbMenu.add(leftPanel, BorderLayout.WEST);

       /* JPanel pPantalla = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(5, 10, 10, 10);
        pPantalla.add(tbMenu, reglas);
        reglas.gridx = 2;
        pPantalla.add(pPrincipal,reglas);
        this.add(pPantalla);*/

        // Agregando componentes al frame
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

                ImageIcon iconC = new ImageIcon("media/advertencia.png");

                int confirmed = JOptionPane.showOptionDialog(null,
                        "¿Estás seguro de que quieres salir? La sesión se cerrará si lo haces.", "Confirmar salida",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, iconC, new String[]{"Si", "No"}, "Si");
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
