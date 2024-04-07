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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.CIniciarSesion;

public class VIniciarSesion extends JFrame implements ActionListener, IIniciarSesion {

	private JTextField tUsuario, tRol;
	private JPasswordField tContrasena;
	private JButton bIniciar;
	private CIniciarSesion controlador;
	
	public VIniciarSesion() {
		
		
		super("Iniciar Sesión");
		this.setSize(650,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		pTitulo.add(lTitulo);
		this.add(pTitulo, BorderLayout.NORTH);
		
		JPanel pPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		pPrincipal.setBackground(new Color(255, 255, 255));
		
		reglas.gridx = 0;
		reglas.gridy = 0;
		tRol = new JTextField();
		tRol.setVisible(false);
		pPrincipal.add(tRol, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 1;
		reglas.insets = new Insets(10, 10, 10, 10);
	   
		JPanel pIconMe = new JPanel();
        pIconMe.setBackground(new Color(255, 255, 255));
        reglas.gridy = 0;
        reglas.weighty= 1.0;
        reglas.gridheight=1;
        JLabel lImagenMe = new JLabel();  
        lImagenMe.setSize(200, 170);
        ImageIcon icon = new ImageIcon("media/login3.png");
        Icon iconoMe = new ImageIcon(icon.getImage().getScaledInstance(lImagenMe.getWidth(), lImagenMe.getHeight(), Image.SCALE_DEFAULT));
        lImagenMe.setIcon(iconoMe);
       pIconMe.add(lImagenMe);
       pPrincipal.add(pIconMe, reglas);
       
		
        
        JPanel pUsuario = new JPanel();
        pUsuario.setBackground(new Color(255, 255, 255));;
        reglas.gridx = 1;
		reglas.gridy = 2;
		reglas.insets = new Insets(5, 10, 10, 10);
		JLabel lUsuario = new JLabel("Usuario: ");
		lUsuario.setFont(new Font("Open Sans", Font.BOLD, 16));
		//reglas.anchor = GridBagConstraints.WEST;
		
		pUsuario.add(lUsuario);
		tUsuario = new JTextField();
		tUsuario.setPreferredSize(new Dimension(200,30));
		pUsuario.add(tUsuario);
		reglas.anchor = GridBagConstraints.EAST;
		pPrincipal.add(pUsuario, reglas);
		
		JPanel pContrasena = new JPanel();
		pContrasena.setBackground(new Color(255, 255, 255));
        reglas.gridx = 1;
		reglas.gridy = 3;
		reglas.insets = new Insets(5, 10, 10, 10);
		JLabel lContrasena = new JLabel("Contraseña: ");
		lContrasena.setFont(new Font("Open Sans", Font.BOLD, 16));
	
		pContrasena.add(lContrasena);
		tContrasena = new JPasswordField();
		tContrasena.setPreferredSize(new Dimension(200,30));
		
		pContrasena.add(tContrasena);
		pPrincipal.add(pContrasena, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 4;
		
		JLabel lOlvidoContrasena = new JLabel("¿Olvidó su contraseña?", JLabel.CENTER);
		lOlvidoContrasena.setFont(new Font("Open Sans", Font.ITALIC, 13));
		
		pPrincipal.add(lOlvidoContrasena, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 5;
		bIniciar = new JButton("Iniciar Sesión");
		bIniciar.setFont(new Font("Open Sans", Font.PLAIN, 15));
		bIniciar.setForeground(Color.WHITE);
		bIniciar.setBackground(new Color(0, 125, 254));
		bIniciar.setBorder(new EmptyBorder(10, 10, 10, 10));
	
		bIniciar.setActionCommand(IIniciarSesion.IniciarSesion);
		pPrincipal.add(bIniciar, reglas);
		
		 JPanel pImagen = new JPanel(); 
		 //pImagen.setBackground(new Color(255, 255, 255));;
		 
	      pImagen.setBackground(new Color(0, 125, 254));
	  
	    
	      reglas.gridx = 2;
	      reglas.gridy = 0;
	      reglas.gridwidth = 1;
	      reglas.gridheight = 5;
	      reglas.weighty= 20.0;
	      
	      reglas.anchor = GridBagConstraints.EAST;
	    
	      
	      
	      JLabel lImagen = new JLabel();  
	      lImagen.setSize(250, 300);
	      ImageIcon imagen = new ImageIcon("media/recurso3.jpg");
	      Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
	      lImagen.setIcon(icono);
	      pImagen.add(lImagen);
	      pPrincipal.add (pImagen, reglas); 
		
		this.add(pPrincipal);
		
     
	
     
		
	}
	
	
	
	
	
	@Override
	public void setControlador(CIniciarSesion c) {
		// TODO Auto-generated method stub
		controlador = c;
		bIniciar.addActionListener(c);
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
	}

	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
	    return tUsuario.getText();
	}

	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return String.valueOf(tContrasena.getPassword());
	}





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

