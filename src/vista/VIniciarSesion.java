package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.CIniciarSesion;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.UIManager.getIcon;

// Vista de inicio de sesión
public class VIniciarSesion extends JFrame implements ActionListener, IIniciarSesion {

	private JTextField tUsuario, tRol;
	private JPasswordField tContrasena;
	private JButton bIniciar;
	private CIniciarSesion controlador;



    //  Constructor de la clase VIniciarSesion.
	public VIniciarSesion() {

        super("Telecomunícate"); // Título de la ventana
        int n;
        this.setSize(700, 500); // Tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Comportamiento al cerrar
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Panel para el título
		JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        /*JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);*/
        ImageIcon titulo = new ImageIcon("media/int.png");
        JLabel lTitulo = new JLabel();
        lTitulo.setSize(170, 33);
        Icon icon = new ImageIcon(titulo.getImage().getScaledInstance(lTitulo.getWidth(), lTitulo.getHeight(), Image.SCALE_DEFAULT));
        lTitulo.setIcon(icon);
        pTitulo.add(lTitulo);
        pTitulo.add(lTitulo);
        this.add(pTitulo, BorderLayout.NORTH);

        // Panel principal con diseño GridBagLayout
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));

        // Campo de texto oculto para el rol
        reglas.gridx = 0;
        reglas.gridy = 0;
        tRol = new JTextField();
        tRol.setVisible(false);
        pPrincipal.add(tRol, reglas);

        // Panel para la imagen de inicio de sesión
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        JPanel pIniSesion = new JPanel();
       pIniSesion.setBackground(new Color(255, 255, 255));
        reglas.anchor = GridBagConstraints.WEST;
        reglas.gridy = 0;
        reglas.weighty= 1.0;
        reglas.gridheight=1;
        JLabel lIniSesion = new JLabel("Iniciar Sesión");
        lIniSesion.setFont(new Font("Roboto", Font.BOLD, 25));
        pIniSesion.add(lIniSesion);
        pPrincipal.add(pIniSesion,reglas);



       /* JLabel lImagenMe = new JLabel();
        lImagenMe.setSize(200, 170);
        ImageIcon logo = new ImageIcon("media/login3.png");
        Icon iconoMe = new ImageIcon(logo.getImage().getScaledInstance(lImagenMe.getWidth(), lImagenMe.getHeight(), Image.SCALE_DEFAULT));
        lImagenMe.setIcon(iconoMe);
        //pIconMe.add(lImagenMe);
        pPrincipal.add(pIconMe, reglas);
*/
        // Panel para el campo de usuario
        JPanel pUsuario = new JPanel();
        pUsuario.setBackground(new Color(255, 255, 255));
        reglas.gridx = 1;
        reglas.gridy = 2;
        reglas.weighty=1.5;
       // reglas.insets = new Insets(5, 10, 10, 10);
        JLabel lUsuario = new JLabel("Usuario: ");
        lUsuario.setFont(new Font("Open Sans", Font.BOLD, 16));
        //reglas.anchor = GridBagConstraints.WEST;

        pUsuario.add(lUsuario);
        tUsuario = new JTextField();
        tUsuario.setPreferredSize(new Dimension(200,30));
        Validacion.validarNumeros(tUsuario);
        pUsuario.add(tUsuario);
        reglas.anchor = GridBagConstraints.EAST;
        pPrincipal.add(pUsuario, reglas);

        // Panel para el campo de contraseña
        JPanel pContrasena = new JPanel();
        pContrasena.setBackground(new Color(255, 255, 255));
        reglas.gridx = 1;
		reglas.gridy = 3;
        reglas.weighty=1.0;

		//reglas.insets = new Insets(5, 10, 10, 10);
		JLabel lContrasena = new JLabel("Contraseña: ");
		lContrasena.setFont(new Font("Open Sans", Font.BOLD, 16));

		pContrasena.add(lContrasena);
		tContrasena = new JPasswordField();
		tContrasena.setPreferredSize(new Dimension(200,30));
		tContrasena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   bIniciar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

		pContrasena.add(tContrasena);
		pPrincipal.add(pContrasena, reglas);


        // Etiqueta para recuperar contraseña
		/*reglas.gridx = 1;
		reglas.gridy = 4;

		JLabel lOlvidoContrasena = new JLabel("¿Olvidó su contraseña?", JLabel.CENTER);
		lOlvidoContrasena.setFont(new Font("Open Sans", Font.ITALIC, 13));

		pPrincipal.add(lOlvidoContrasena, reglas);
*/
        // Botón para iniciar sesión
		reglas.gridx = 1;
		reglas.gridy = 5;
		bIniciar = new JButton("Iniciar Sesión");
		bIniciar.setFont(new Font("Open Sans", Font.PLAIN, 15));
		bIniciar.setForeground(Color.WHITE);
		bIniciar.setBackground(new Color(2, 152, 178));
		bIniciar.setBorder(new EmptyBorder(10, 10, 10, 10));

		bIniciar.setActionCommand(IIniciarSesion.IniciarSesion);
		pPrincipal.add(bIniciar, reglas);

        // Panel para la imagen del logotipo
		 JPanel pImagen = new JPanel();
		 pImagen.setBackground(new Color(255, 255, 255));;
         pImagen.setOpaque(true);

	     // pImagen.setBackground(new Color(2, 152, 178));


	      reglas.gridx = 2;
	      reglas.gridy = 0;
	      reglas.gridwidth = 1;
	      reglas.gridheight = 5;
	      reglas.weighty= 20.0;

	      reglas.anchor = GridBagConstraints.EAST;



	      JLabel lImagen = new JLabel();
	      lImagen.setSize(300, 300);
	      ImageIcon imagen = new ImageIcon("media/logo.png");
	      Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
	      lImagen.setIcon(icono);
         // lImagen.setOpaque(true);
	      pImagen.add(lImagen);
	      pPrincipal.add (pImagen, reglas);

		this.add(pPrincipal);



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


                int confirmed = JOptionPane.showOptionDialog(null, "¿Estás seguro de que quieres salir?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, PLAIN_MESSAGE, icon,
                        new String[]{"Si", "No"}, "Si");

                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        });






	}


    /**
     * Establece el controlador para esta vista.
     * @param c El controlador asociado.
     */
	@Override
	public void setControlador(CIniciarSesion c) {
		// TODO Auto-generated method stub
		controlador = c;
		bIniciar.addActionListener(c);
	}

    // Inicializa la vista
    @Override
    public void arrancar() {
        // TODO Auto-generated method stub

        this.setVisible(true);
    }

    @Override
    public void cerrar() {
        this.setVisible(false);
    }

    // Limpia los campos de nombre de usuario y contraseña.
    @Override
    public void limpiar() {
        // TODO Auto-generated method stub
        tUsuario.setText("");
        tContrasena.setText("");
    }

    /**
     * Obtiene el nombre de usuario ingresado por el usuario.
     * @return El nombre de usuario.
     */
    @Override
    public String getUsuario() {
        // TODO Auto-generated method stub
        return tUsuario.getText();
    }

    /**
     * Obtiene la contraseña ingresada por el usuario.
     * @return La contraseña.
     */
    @Override
    public String getContrasena() {
        // TODO Auto-generated method stub
        return String.valueOf(tContrasena.getPassword());
    }


    /**
     * Maneja los eventos de acción (por ejemplo, clic en botones).
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        tUsuario.setText("");
        tContrasena.setText("");
    }



    @Override
    public void inicioEstudiante() {
        // TODO Auto-generated method stub
        this.setVisible(true);
    }



    @Override
    public void inicioAdmin() {
        // TODO Auto-generated method stub
        this.setVisible(true);
    }





    @Override
    public String getRol() {
        // TODO Auto-generated method stub
        return tRol.getText();
    }





    @Override
    public String consultaUsuario(String usuario, String contrasena) {
        // TODO Auto-generated method stub
        return null;
    }







    }




