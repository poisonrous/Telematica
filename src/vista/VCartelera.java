package vista;
import controlador.CCartelera;

import javax.swing.*;
import java.awt.*;

// Vista de la cartelera informativa
public class VCartelera extends JPanel implements ICartelera {
    private final JPanel pPrincipal;
    private final GridBagConstraints reglas;
    public VCartelera() {

       // this.setPreferredSize(new Dimension(1085, 680));
        // Constructor de la clase VCartelera.
        pPrincipal = new JPanel(new GridBagLayout());
        //pPrincipal.setPreferredSize(new Dimension(1085, 680));
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reglas = new GridBagConstraints();

        // Se establecen las reglas de disposición para el primer componente
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Se crea un panel para el icono de la cartelera y el título
        JPanel pIconCar = new JPanel();
        pIconCar.setBackground(new Color(255, 255, 255));
        JLabel lImagenCar = new JLabel();  
        lImagenCar.setSize(40, 40);
        ImageIcon icon = new ImageIcon("media/cartelera.png");
        Icon iconoCar = new ImageIcon(icon.getImage().getScaledInstance(lImagenCar.getWidth(), lImagenCar.getHeight(), Image.SCALE_DEFAULT));
        lImagenCar.setIcon(iconoCar);
        pIconCar.add(lImagenCar);
        JLabel lTitulo = new JLabel("CARTELERA INFORMATIVA");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconCar.add(lTitulo);

        // Se añade el panel del icono y título a la cartelera
        pPrincipal.add(pIconCar, reglas);
        this.add(pPrincipal);
    }

    //  Muestra la ventana de la cartelera.
    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    // Carga una publicación en la cartelera.
    @Override
    public void cargarPub(JPanel publicaion){
        reglas.gridy++;
        pPrincipal.add(publicaion, reglas);
    }

    // Establece el controlador para esta vista.
    @Override
    public void setControlador(CCartelera controlador) {
// TODO Auto-generated method stub
    }
}
