package vista;
import controlador.CCartelera;

import javax.swing.*;
import java.awt.*;


public class VCartelera extends JPanel implements ICartelera {
    private JPanel pPrincipal;
    private GridBagConstraints reglas;
    public VCartelera() {

        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
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
        pPrincipal.add(pIconCar, reglas);
       

        this.add(pPrincipal);
    }
    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void cargarPub(JPanel publicaion){
        reglas.gridy++;
        pPrincipal.add(publicaion, reglas);
    }

    @Override
    public void setControlador(CCartelera controlador) {
// TODO Auto-generated method stub
    }
}
