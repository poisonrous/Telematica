package vista;


import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
 // Clase que proporciona métodos para validar entradas en componentes de java swing
public class Validacion {

	/**
	 * M�todo para validar que solo se ingresen letras en un JTextField.
	 * @param tx JTextField a validar.
	 */
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

	 /**
	  * M�todo para validar que solo se ingresen n�meros en un JTextField.
	  * @param tx JTextField a validar.
	  */
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

	 /**
	  * M�todo para validar que solo se ingresen n�meros en un JTextField con una longitud m�xima.
	  * @param tx JTextField a validar.
	  * @param max Longitud m�xima permitida.
	  */
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

	 /**
	  * M�todo para validar que solo se ingresen precios en un JTextField.
	  * @param tx JTextField a validar.
	  */
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

	 /**
	  * M�todo para validar la longitud m�xima de un JTextField.
	  * @param tx JTextField a validar.
	  * @param cantidad Longitud m�xima permitida.
	  */
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

	 /**
	  * M�todo para validar la longitud m�xima de un JTextArea.
	  * @param tx JTextArea a validar.
	  * @param cantidad Longitud m�xima permitida.
	  */
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

	 /**
	  * M�todo para validar la longitud m�xima de un JPasswordField.
	  * @param tx JPasswordField a validar.
	  * @param cantidad Longitud m�xima permitida.
	  */
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

	 /**
	  * M�todo para validar la presencia de espacios en un JTextField.
	  * @param tx JTextField a validar.
	  */
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
	 /**
	  * M�todo para validar la longitud máxima de una linea, continuando con la misma en otra.
	  * @param tx JTextField a validar.
	  */
	 public static List<String> validarParrafo(String tx, int n) {
		 List<String> results = new ArrayList<>();
		 int length = tx.length(), g=0;

		 for (int i = 0; i < length; i += n) {

			 if (i+n+g < length){
			if (!tx.substring(i+n,Math.min(length,(i+2*n))).startsWith(" ")){
			i-=n;
			i++;
            g++;
			}
			else{
				results.add(tx.substring(i-g, Math.min(length, i + n)));
				g=0;
		}
			 }
			 else{
				 results.add(tx.substring(i-g, Math.min(length, i + n+g)));
			 }

		}

		 return results;
	 }
	 /**
	  * M�todo para validar la existencia de un carácter que causa errores en la librería PDFBox.
	  * @param tx JTextField a validar.
	  */
	 public static String validarError(String tx) {
		 StringBuilder b = new StringBuilder();
		 for (int i = 0; i < tx.length(); i++) {
			 if (WinAnsiEncoding.INSTANCE.contains(tx.charAt(i))) {
				 b.append(tx.charAt(i));
			 }
		 }
		 return b.toString();}
}
