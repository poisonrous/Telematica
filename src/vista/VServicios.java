package vista;

import controlador.CServicios;

import javax.swing.*;
import java.awt.*;

    public class VServicios extends JPanel implements IServicios {
        private JPanel pPrincipal;
        private GridBagConstraints reglas;
        public VServicios() {

            pPrincipal = new JPanel(new GridBagLayout());
            reglas = new GridBagConstraints();
            reglas.gridx = 1;
            reglas.gridy = 1;
            reglas.insets = new Insets(10, 10, 10, 10);
            JLabel lTitulo = new JLabel("Servicios Activos");
            lTitulo.setFont(new Font("Arial", Font.BOLD, 15));
            lTitulo.setHorizontalAlignment(JLabel.CENTER);
            pPrincipal.add(lTitulo, reglas);

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
            GridBagConstraints reglas = new GridBagConstraints();
            reglas.gridx = 1;
            reglas.gridy = 1;
            panel.add(new JLabel(titulo), reglas);
            reglas.gridy++;
            panel.add(new JLabel(ubicacion), reglas);
            reglas.gridy++;
            panel.add(new JLabel(horario), reglas);
            return panel;
        }
}
