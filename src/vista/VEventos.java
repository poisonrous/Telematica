package vista;

import controlador.CEventos;

import javax.swing.*;
import java.awt.*;

public class VEventos extends JPanel implements IEventos {
    private JPanel pPrincipal;
    private GridBagConstraints reglas;
    public VEventos() {

        pPrincipal = new JPanel(new GridBagLayout());
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        JLabel lTitulo = new JLabel("Próximos Eventos");
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
    public void cargarEve(JPanel evento){
        reglas.gridy++;
        pPrincipal.add(evento,reglas);
    }

    @Override
    public void setControlador(CEventos controlador){

    }

    @Override
    public JPanel getEvento(String titulo, String descripcion, String fecha, String hora, String lugar, String organizador, String modalidad, String precio){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        panel.add(new JLabel("Evento: "),reglas);
        reglas.gridy = 2;
        panel.add(new JLabel("Organizador: "), reglas);
        JLabel lPrecio = new JLabel("Precio: ");
        reglas.gridy = 3;
        panel.add(lPrecio, reglas);
        reglas.gridy = 4;
        panel.add(new JLabel("Fecha: "), reglas);
        reglas.gridy = 5;
        panel.add(new JLabel("Hora: "), reglas);
        reglas.gridy = 6;
        panel.add(new JLabel("Modalidad: "), reglas);
        reglas.gridy = 7;
        panel.add(new JLabel("Lugar: "), reglas);
        reglas.gridy = 8;
        panel.add(new JLabel("Descripción: "), reglas);

        reglas.gridx = 2;
        reglas.gridy = 1;
        panel.add(new JLabel(titulo), reglas);
        reglas.gridy = 2;
        panel.add(new JLabel(organizador), reglas);
        JLabel stringPrecio = new JLabel(precio);
        reglas.gridy = 3;
        panel.add(stringPrecio, reglas);
        reglas.gridy = 4;
        panel.add(new JLabel(fecha), reglas);
        reglas.gridy = 5;
        panel.add(new JLabel(hora), reglas);
        reglas.gridy = 6;
        panel.add(new JLabel(modalidad), reglas);
        reglas.gridy = 7;
        panel.add(new JLabel(lugar), reglas);
        reglas.gridy = 8;
        panel.add(new JLabel(descripcion), reglas);

        if(precio.equals("0")){
            lPrecio.setVisible(false);
            stringPrecio.setVisible(false);
            JLabel lGratis = new JLabel("GRATUITO");
            lGratis.setBackground(Color.GREEN);
            lGratis.setOpaque(true);
            reglas.gridx = 1;
            reglas.gridy = 3;
            reglas.gridwidth = 2;
            panel.add(lGratis, reglas);
        }
        return panel;
    }
}
