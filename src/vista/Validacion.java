package vista;


import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Validacion {



	public static void validarLetras (JTextField tx) {
		tx.addKeyListener(
		new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
		char car=e.getKeyChar();
		
		if (Character.isDigit(car)) {
			Toolkit.getDefaultToolkit().beep();
			e.consume();}
		}
		});
		
		}
		
		public static  void validarNumeros (JTextField tx) {
			Validacion.validarEspacio(tx);
			tx.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			char car=e.getKeyChar();
			
			if (!Character.isDigit(car) && !(8==e.VK_BACK_SPACE)) {
				Toolkit.getDefaultToolkit().beep();
				e.consume();
			}
			}
			});}

	public static  void validarNumeros (JTextField tx, int max) {
		Validacion.validarEspacio(tx);
		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				int tamanno=tx.getText().length();
				if(tamanno > max) {
					e.consume();
					String shortened = tx.getText().substring(0, max);
					tx.setText(shortened);
				}
				if (tamanno>=max) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				if (!Character.isDigit(car) && !(8==e.VK_BACK_SPACE)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});}
		
		public static void validarPrecio (JTextField tx) {
			tx.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
		/*		String precio = tx.getText();*/
				
				if ((!Character.isDigit(car))&&(!String.valueOf(car).equals("."))) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				
			/*if(precio.substring(precio.length()-1).equals(".")) {
					String[] p = precio.split(".");
					while(p[1].length()<2) {	
					}
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}*/
				}
				});
		}


		public static void validarLongitud (JTextField tx, int cantidad) {

				tx.addKeyListener(new KeyAdapter() {
				public void keyTyped (KeyEvent e) {
				int tamanno=tx.getText().length();
					if(tamanno > cantidad) {
						e.consume();
						String shortened = tx.getText().substring(0, cantidad);
						tx.setText(shortened);
					}
				if (tamanno>=cantidad) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				}
				});
	}

	public static void validarLongitud (JTextArea tx, int cantidad) {

		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped (KeyEvent e) {
				int tamanno=tx.getText().length();
				if(tamanno > cantidad) {
					e.consume();
					String shortened = tx.getText().substring(0, cantidad);
					tx.setText(shortened);
				}
				if (tamanno>=cantidad) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
	}
	public static void validarLongitud (JPasswordField tx, int cantidad) {

		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped (KeyEvent e) {
				int tamanno=tx.getText().length();
				if(tamanno > cantidad) {
					e.consume();
					String shortened = tx.getText().substring(0, cantidad);
					tx.setText(shortened);
				}

				if (tamanno>=cantidad) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
	}


	public static void validarEspacio (JTextField tx) {
		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped (KeyEvent e) {
				if(e.getKeyCode() == 32){
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
	}

}
