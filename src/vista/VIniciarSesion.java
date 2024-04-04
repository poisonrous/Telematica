package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.CIniciarSesion;

public class VIniciarSesion extends JFrame implements ActionListener, IIniciarSesion {

	private JTextField tUsuario, tRol;
	private JPasswordField tContrasena;
	private JButton bIniciar;
	private CIniciarSesion controlador;
	
	public VIniciarSesion() {
		
		
		super("Iniciar Sesi�n");
		this.setSize(400,550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		JPanel pPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		pPrincipal.setBackground(new java.awt.Color(255, 255, 255));
		
		reglas.gridx = 0;
		reglas.gridy = 0;
		tRol = new JTextField();
		tRol.setVisible(false);
		pPrincipal.add(tRol, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 1;
		reglas.insets = new Insets(10, 10, 10, 10);
	   
		JLabel lTitulo = new JLabel("Nombre del sistema");
		lTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pPrincipal.add(lTitulo, reglas);
        
        JPanel pUsuario = new JPanel();
        reglas.gridx = 1;
		reglas.gridy = 2;
		reglas.insets = new Insets(5, 10, 10, 10);
		JLabel lUsuario = new JLabel("Usuario");
		pUsuario.add(lUsuario);
		tUsuario = new JTextField(13);
		pUsuario.add(tUsuario);
		pPrincipal.add(pUsuario, reglas);
		
		JPanel pContrasena = new JPanel();
        reglas.gridx = 1;
		reglas.gridy = 3;
		reglas.insets = new Insets(5, 10, 10, 10);
		JLabel lContrasena = new JLabel("Contrase�a");
		pContrasena.add(lContrasena);
		tContrasena = new JPasswordField(13);
		pContrasena.add(tContrasena);
		pPrincipal.add(pContrasena, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 4;
		JLabel lOlvidoContrasena = new JLabel("�Olvid� su contrase�a?");
		lOlvidoContrasena.setFont(new Font("Arial", Font.ITALIC, 12));
		pPrincipal.add(lOlvidoContrasena, reglas);
		
		
		reglas.gridx = 1;
		reglas.gridy = 5;
		bIniciar = new JButton("Iniciar Sesi�n");
		bIniciar.setActionCommand(IIniciarSesion.IniciarSesion);
		pPrincipal.add(bIniciar, reglas);
		
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



	
