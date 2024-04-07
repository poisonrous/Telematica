package vista;
import javax.swing.*;
import java.awt.*;

public class VPub extends JPanel implements IPub {
    private JPanel panel;
    public VPub() {
    }

    public JPanel getPublicacion(String titulo, String autor, String contenido, String fecha){
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        panel.setOpaque(true);
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        JLabel lTitulo = new JLabel(titulo);
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 12));
        panel.add(lTitulo, reglas);
        reglas.gridy++;
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas2 = new GridBagConstraints();
        reglas2.gridx = 1;
        reglas2.gridy = 1;
        reglas2.insets = new Insets(10, 10, 10, 10);        
        JLabel lAutor = new JLabel(autor);
        lAutor.setFont(new Font("Open Sans", Font.BOLD, 12));
        datos.add(lAutor, reglas2);
        reglas2.gridx++;
        JLabel lFecha = new JLabel(fecha);
        lFecha.setFont(new Font("Open Sans", Font.BOLD, 12));
        datos.add(lFecha, reglas2);
        reglas.gridy++;
        panel.add(datos, reglas);
        reglas.gridy++;
        JLabel lContenido = new JLabel(contenido);
        lContenido.setFont(new Font("Open Sans", Font.BOLD, 12));
        panel.add(lContenido, reglas);
        return panel;
  
        
        
        

    }
    
}
