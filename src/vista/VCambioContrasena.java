package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.CCambioContrasena;

public class VCambioContrasena extends JFrame implements ActionListener, ICambioContrasena {

	
	private JPasswordField tContrasenaActual, tNuevaContrasena, tConfirmarContrasena;
	private JTextField tCodigo, tUsuario;
	private JButton bAceptar, bCancelar;
	
	
	
	public VCambioContrasena(){
		
		
		super("Cambio de Contrasena de acceso");
		this.setSize(400,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
	
	
		JLabel lTitulo = new JLabel("CAMBIO DE CONTRASE�A");
		lTitulo.setFont(new Font("Arial", Font.BOLD,20));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lTitulo, BorderLayout.NORTH);
		
		
		
		//sur
		
		JPanel pBotones = new JPanel();
		bCancelar = new JButton("Cancelar");
		bCancelar.setActionCommand(ICambioContrasena.CANCELAR);
		pBotones.add(bCancelar);
		
		
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setActionCommand(ICambioContrasena.ACEPTAR);
	//	bAceptar.addActionListener(this);
		pBotones.add(bAceptar);
		
		
		this.add(pBotones, BorderLayout.SOUTH);
		
		JPanel pPrincipal = new JPanel(new GridLayout(4,2,5,5));
		
		JPanel pCon = new JPanel();
		pCon.add(new JLabel("Contrase�a Actual:") );
		tCodigo = new JTextField();
		tCodigo.setVisible(false);
		
		pCon.add(tCodigo);
		pPrincipal.add(pCon);
		
		tContrasenaActual = new JPasswordField(10);
		pPrincipal.add(tContrasenaActual);
		
		pPrincipal.add(new JLabel("Nueva Contrase�a:") );
		tNuevaContrasena = new JPasswordField(15);
	
		pPrincipal.add(tNuevaContrasena);
		
		pPrincipal.add(new JLabel("Confirmar Contrase�a:") );
		tConfirmarContrasena = new JPasswordField(15);
		pPrincipal.add(tConfirmarContrasena);
		
		tUsuario = new JTextField();
		tUsuario.setVisible(false);
		pPrincipal.add(tUsuario);
		
		
		this.add(pPrincipal);
		
		
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	
		
	}

	

	@Override
	public void setControlador(CCambioContrasena c) {
		// TODO Auto-generated method stub
		bAceptar.addActionListener(c);
		bCancelar.addActionListener(c);
	}


	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
	}


	@Override
	public int getIdContrasena() {
		// TODO Auto-generated method stub
		
		try {
            return Integer.parseInt(tCodigo.getText());
        } catch (Exception e) {
        	
        	return 0;
        }
		
		
	}



	@Override
	public String verificarContrasena(String contrasena) {
		// TODO Auto-generated method stub
		return String.valueOf(tContrasenaActual.getPassword());	
		}



	@Override
	public String getContrasenaActual() {
		// TODO Auto-generated method stub
		return String.valueOf(tContrasenaActual.getPassword());
	}


	@Override
	public String getNuevaContrasena() {
		// TODO Auto-generated method stub
		return String.valueOf(tNuevaContrasena.getPassword());
	}



	@Override
	public String getConfirmarContrasena() {
		// TODO Auto-generated method stub
		return String.valueOf(tConfirmarContrasena.getPassword());
	}



	@Override
	public String cambiarContrasena() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return tUsuario.getText();
	}

}
