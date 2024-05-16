package vista;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

// Vista de la publicacion
public class VPub extends JPanel implements IPub {
    private JPanel panel;
    public VPub() {
    }

    // Constructor de la clase VPub
    public JPanel getPublicacion(String titulo, String autor, String contenido, TemporalAccessor fecha){
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;

        // Etiqueta para el título de la publicación
        JLabel lTitulo = new JLabel(titulo);
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 14));
        panel.add(lTitulo, reglas);
        reglas.gridy++;
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas2 = new GridBagConstraints();
        reglas2.gridx = 1;
        reglas2.gridy = 1;
        reglas2.insets = new Insets(10, 10, 10, 10);

        // Etiqueta para el autor de la publicación
        JLabel lAutor = new JLabel(autor);
        lAutor.setFont(new Font("Open Sans", Font.BOLD, 12));
        datos.add(lAutor, reglas2);


        // Formatear la fecha de la publicación
        reglas2.gridx++;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        JLabel lFecha = new JLabel(formateador.format(fecha));
        lFecha.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lFecha.setForeground(Color.BLACK);
        datos.add(lFecha, reglas2);


        // Agregar el panel de datos a la publicación
        reglas.gridy++;
        panel.add(datos, reglas);

        // Agregar contenido de la publicación
        reglas.gridy++;
        reglas.anchor = GridBagConstraints.WEST;
        JTextArea taContenido = new JTextArea(contenido);
        taContenido.setFont(new Font("Open Sans", Font.ITALIC, 12));
        taContenido.setPreferredSize(new Dimension(400, 200));
        taContenido.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taContenido.setLineWrap(true);
        taContenido.setWrapStyleWord(true);
        panel.add(taContenido, reglas);
        return panel;
  
        
        
        

    }
    
}
