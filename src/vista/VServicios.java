package vista;

import controlador.CServicios;

import javax.swing.*;
import java.awt.*;
 // Vista de servicios activos
    public class VServicios extends JPanel implements IServicios {
        private final JPanel pPrincipal;
        private final GridBagConstraints reglas;

        //  Constructor de la clase VServicios.
        public VServicios() {
            this.setPreferredSize(new Dimension(1085, 680));

            // Panel Principal
            pPrincipal = new JPanel(new GridBagLayout());
            pPrincipal.setPreferredSize(new Dimension(1085, 680));
            pPrincipal.setBackground(new Color(255, 255, 255));
            reglas = new GridBagConstraints();
            
            reglas.gridx = 1;
            reglas.gridy = 1;

            // Ícono y el título de la lista de servicios
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

            // Imagen del panel lateral
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


        // Inicia la vista de servicios
        @Override
        public void arrancar() {
            this.setVisible(true);
        }

     /**
      * Agrega un panel de servicio al panel principal de servicios.
      * @param servicio Panel que contiene la información de un servicio.
      */
     @Override
     public void cargarSer(JPanel servicio) {
         reglas.gridy++; // Incrementa la posición en Y para el nuevo servicio.
         pPrincipal.add(servicio, reglas); // Agrega el panel del servicio al panel principal.
     }

     /**
      * Establece el controlador para esta vista.
      *
      * @param controlador Controlador asociado a esta vista.
      */
     @Override
     public void setControlador(CServicios controlador) {
         // Método sin implementar ya que actualmente no se necesita un controlador.
     }

     /**
      * Crea y devuelve un panel que muestra la información de un servicio.
      * @param titulo    Título del servicio.
      * @param ubicacion Ubicación del servicio.
      * @param horario   Horario del servicio.
      * @return Panel que representa el servicio.
      */
     @Override
        public JPanel getServicio(String titulo, String ubicacion, String horario){
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(255, 255, 255));
         panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            GridBagConstraints reglas = new GridBagConstraints();
            
            
            reglas.anchor = GridBagConstraints.WEST;
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