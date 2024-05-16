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

import javax.swing.*;

import controlador.CCambioContrasena;
// Vista para el cambio de contraseña
public class VCambioContrasena extends JPanel implements ActionListener, ICambioContrasena {

	
	private final JPasswordField tContrasenaActual;
    private final JPasswordField tNuevaContrasena;
    private final JPasswordField tConfirmarContrasena;
	private final JTextField tCodigo;
    private JTextField tUsuario;
	private final JButton bAceptar;
    private final JButton bCancelar;


	// Constructor de la clase VCambioContrasena.
	public VCambioContrasena(){
		this.setPreferredSize(new Dimension(1085, 680));
		this.setLayout(new BorderLayout());

		// Panel para el título
		JPanel pTitulo = new JPanel();
		pTitulo.setLayout(new BorderLayout());
		JLabel lTitulo = new JLabel("CAMBIO DE CONTRASEÑA");
		pTitulo.setBackground(new Color(255, 255, 255));
		lTitulo.setFont(new Font("Open Sans", Font.BOLD,20));
		lTitulo.setForeground(new Color(2, 152, 178));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		JLabel linstruccion = new JLabel("Debe tener entre 6 y 16 caracteres");
		linstruccion.setFont(new Font("Open Sans", Font.ITALIC,8));
		linstruccion.setForeground(new Color(2, 152, 178));
		linstruccion.setHorizontalAlignment(JLabel.CENTER);
		pTitulo.add(lTitulo, BorderLayout.NORTH);
		pTitulo.add(linstruccion, BorderLayout.SOUTH);
		this.add(pTitulo, BorderLayout.NORTH);
		
		
		//sur
		// Panel para los botones
		JPanel pBotones = new JPanel();
		pBotones.setBackground(new Color(255, 255, 255));
		bCancelar = new JButton("Cancelar");
		bCancelar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bCancelar.setForeground(Color.WHITE);
        bCancelar.setBackground(new Color(2, 152, 178));
		bCancelar.setActionCommand(ICambioContrasena.CANCELAR);
		pBotones.add(bCancelar);
		
		
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bAceptar.setForeground(Color.WHITE);
        bAceptar.setBackground(new Color(2, 152, 178));
		bAceptar.setActionCommand(ICambioContrasena.ACEPTAR);
	//	bAceptar.addActionListener(this);
		pBotones.add(bAceptar);
		
		
		this.add(pBotones, BorderLayout.SOUTH);

		// Panel principal con los campos de contraseña
		JPanel pPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 2));

		// Panel con la imagen
        JPanel pImagen = new JPanel(); 
		pImagen.setBackground(new Color(255, 255, 255));
		reglas.gridy = 0;
        reglas.weighty= 1.0;
        reglas.gridheight=1;
        
        JLabel lImagen = new JLabel();  
	    lImagen.setSize(350, 270);
	    ImageIcon imagen = new ImageIcon("media/contrasena.jpg");
	    Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
	    lImagen.setIcon(icono);
	    pImagen.add(lImagen);
	   // pPrincipal.add (pImagen);

		// Campo de contraseña actual
	    reglas.gridy = 1;
        reglas.weighty= 1.0;
        JPanel pCActual = new JPanel();
        pCActual.setBackground(new Color(255, 255, 255));
       // reglas.anchor = GridBagConstraints.WEST;
		JLabel lContrasenaActual = new JLabel("Contraseña Actual:   ");
		lContrasenaActual.setForeground(new Color(2, 152, 178));
		lContrasenaActual.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		pCActual.add(lContrasenaActual);
		tContrasenaActual = new JPasswordField();
		tContrasenaActual.setPreferredSize(new Dimension(200,30));
		Validacion.validarLongitud(tContrasenaActual,25);
		reglas.anchor = GridBagConstraints.EAST;
		pCActual.add(tContrasenaActual);
		pPrincipal.add(pCActual, reglas);
		
		tCodigo = new JTextField();
		tCodigo.setVisible(false);

		// Campo de contraseña nueva
		reglas.gridy = 2;
        reglas.weighty= 1.0;
        JPanel pCNueva = new JPanel();
        pCNueva.setBackground(new Color(255, 255, 255));
        //reglas.anchor = GridBagConstraints.WEST;
		JLabel lContrasenaNueva = new JLabel("Contraseña Nueva:   ");
		lContrasenaNueva.setFont(new Font("Open Sans", Font.BOLD, 14));
		lContrasenaNueva.setForeground(new Color(2, 152, 178));
		pCNueva.add(lContrasenaNueva);
		tNuevaContrasena = new JPasswordField();
		Validacion.validarLongitud(tNuevaContrasena,25);
		tNuevaContrasena.setPreferredSize(new Dimension(200,30));
		reglas.anchor = GridBagConstraints.EAST;
		pCNueva.add(tNuevaContrasena);
		pPrincipal.add(pCNueva, reglas);

		// Campo para confirmar la contraseña
		reglas.gridy = 3;
        reglas.weighty= 1.0;
        
        JPanel pCContra = new JPanel();
        pCContra.setBackground(new Color(255, 255, 255));
        //reglas.anchor = GridBagConstraints.WEST;
		JLabel lConfirmarContrasena = new JLabel("Confirmar Contraseña :   ");
		lConfirmarContrasena.setFont(new Font("Open Sans", Font.BOLD, 14));
		lConfirmarContrasena.setForeground(new Color(2, 152, 178));
		pCContra.add(lConfirmarContrasena);
		
		tConfirmarContrasena = new JPasswordField();
		tConfirmarContrasena.setPreferredSize(new Dimension(200,30));
		Validacion.validarLongitud(tConfirmarContrasena,25);
		pCContra.add(tConfirmarContrasena);
		pPrincipal.add(pCContra, reglas);
		
		this.add(pPrincipal, BorderLayout.CENTER);
		
	}


	/**
	 * Acción realizada al presionar un botón.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	if(e.getSource()==bCancelar) {
       System.exit(0);
	}
	}

	
  // Establece el controlador para esta vista.
	@Override
	public void setControlador(CCambioContrasena c) {
		// TODO Auto-generated method stub
		bAceptar.addActionListener(c);
		bCancelar.addActionListener(c);
	}

	// Muestra la ventana de cambio de contraseña.
	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
	}

	// Obtiene el ID de la contraseña.
	@Override
	public int getIdContrasena() {
		// TODO Auto-generated method stub
		
		try {
            return Integer.parseInt(tCodigo.getText());
        } catch (Exception e) {
        	
        	return 0;
        }
		
		
	}


// Verifica la contraseña actual.
	@Override
	public String verificarContrasena(String contrasena) {
		// TODO Auto-generated method stub
		return String.valueOf(tContrasenaActual.getPassword());	
		}


	// Obtiene la contraseña actual.
	@Override
	public String getContrasenaActual() {
		// TODO Auto-generated method stub
		return String.valueOf(tContrasenaActual.getPassword());
	}

	// Obtiene la nueva contraseña.
	@Override
	public String getNuevaContrasena() {
		// TODO Auto-generated method stub
		String contrasena = String.valueOf(tNuevaContrasena.getPassword());
		String contrasenaa = String.valueOf(tConfirmarContrasena.getPassword());
		if (contrasena.equals(contrasenaa)) {
			return String.valueOf(tNuevaContrasena.getPassword());
		} else return null;
	}

	// Realiza el cambio de contraseña.
	@Override
	public String cambiarContrasena() {
		// TODO Auto-generated method stub
		return null;
	}

	// Cancela la acción de cambio de contraseña.
	@Override
	public void cancelar() {
		tContrasenaActual.setText("");
		tNuevaContrasena.setText("");
		tConfirmarContrasena.setText("");
	}

	// Obtiene el nombre de usuario.
	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return tUsuario.getText();
	}

}
