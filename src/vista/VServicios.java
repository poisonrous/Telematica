package vista;

import controlador.CServicios;

import javax.swing.*;
import java.awt.*;

    public class VServicios extends JPanel implements IServicios {
        private JPanel pPrincipal;
        private GridBagConstraints reglas;
        public VServicios() {

            pPrincipal = new JPanel(new GridBagLayout());
            pPrincipal.setBackground(new Color(255, 255, 255));
            reglas = new GridBagConstraints();
            
            reglas.gridx = 1;
            reglas.gridy = 1;
            reglas.insets = new Insets(10, 10, 10, 10);
            JPanel pIconSer = new JPanel();
            pIconSer.setBackground(new Color(255, 255, 255));
            JLabel lImagenSer = new JLabel();  
            lImagenSer.setSize(70, 55);
            ImageIcon icon = new ImageIcon("media/serviActivo.png");
            Icon iconoSer = new ImageIcon(icon.getImage().getScaledInstance(lImagenSer.getWidth(), lImagenSer.getHeight(), Image.SCALE_DEFAULT));
            lImagenSer.setIcon(iconoSer);
           pIconSer.add(lImagenSer);
            JLabel lServicios = new JLabel("Servicios Activos");
            lServicios.setFont(new Font("Open Sans", Font.BOLD, 16));
            pIconSer.add(lServicios);
            pPrincipal.add(pIconSer, reglas);
            
            JPanel pImagen = new JPanel(); 
            pImagen.setBackground(new Color(255, 255, 255));
        
          
            reglas.gridx = 3;
            reglas.gridy = 1;
            reglas.gridwidth = 1;
            reglas.gridheight = 5;
            
            reglas.anchor = GridBagConstraints.EAST;
          
            
            
            JLabel lImagen = new JLabel();  
            lImagen.setSize(450, 450);
            ImageIcon imagen = new ImageIcon("media/ServicioAct.jpg");
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
            lImagen.setIcon(icono);
            pImagen.add(lImagen);
            pPrincipal.add (pImagen, reglas); 

            reglas.gridx = 1;
            reglas.gridheight = 1;
            
            this.add(pPrincipal);
        }

        @Override
        public void arrancar() {
            this.setVisible(true);
        }

        @Override
        public void cargarSer(JPanel servicio){
            reglas.gridy++;
            pPrincipal.add(servicio, reglas);
        }

        @Override
        public void setControlador(CServicios controlador) {
            // TODO Auto-generated method stub
        }

        @Override
        public JPanel getServicio(String titulo, String ubicacion, String horario){
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(255, 255, 255));
            GridBagConstraints reglas = new GridBagConstraints();
            
            
            
            reglas.gridx = 1;
            reglas.gridy = 1;
            JLabel lTitulo = new JLabel(titulo);
            lTitulo.setFont(new Font("Open Sans", Font.BOLD, 14));
            panel.add(lTitulo, reglas);
            
            reglas.gridy++;
            JLabel lUbicacion = new JLabel(ubicacion);
            lUbicacion.setFont(new Font("Open Sans", Font.PLAIN, 12));
            lUbicacion.setForeground(Color.black);
            panel.add(lUbicacion,reglas);
            
            reglas.gridy++;
            JLabel lHorario = new JLabel(horario);
            lHorario.setFont(new Font("Open Sans", Font.ITALIC, 12));
            panel.add(lHorario,reglas);
            


            return panel;
            
            
            
            
            
            
            
            
            
          
            
        }
}