package vista;

import controlador.CSugerencias;

import javax.swing.*;
import java.awt.*;

public class VSugerencias extends JPanel implements ISugerencias {
    private final JPanel pPrincipal;
    private final GridBagConstraints reglas;
    public VSugerencias() {

        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        JLabel lTitulo = new JLabel("Sugerencias del cuerpo estudiantil");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 15));
        //lTitulo.setHorizontalAlignment(JLabel.CENTER);
        pPrincipal.add(lTitulo, reglas);
        this.add(pPrincipal);

        reglas.anchor = GridBagConstraints.WEST;
    }

    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void cargarSugest(JPanel sugerencia){
        reglas.gridy++;
        pPrincipal.add(sugerencia,reglas);
    }

    @Override
    public void setControlador(CSugerencias controlador){

    }

    @Override
    public JPanel getSugest(String titulo, String estudiante, String cedula, String fecha, String descripcion){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.anchor = GridBagConstraints.WEST;
        reglas.gridx = 1;
        reglas.gridy = 1;
        JLabel lSugerenciaS = new JLabel("Sugerencia: ");
        lSugerenciaS.setFont(new Font("Open Sans", Font.BOLD, 14));
        lSugerenciaS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lSugerenciaS, reglas);
        reglas.gridy = 2;
        JLabel lEstudiante = new JLabel("Estudiante: ");
        lEstudiante.setFont(new Font("Open Sans", Font.BOLD, 14));
        lEstudiante.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lEstudiante, reglas);
        reglas.gridy = 3;
        JLabel lCedula = new JLabel("Cédula: ");
        lCedula.setFont(new Font("Open Sans", Font.BOLD, 14));
        lCedula.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lCedula, reglas);
        reglas.gridy = 4;
        JLabel lFecha = new JLabel("Realizada el: ");
        lFecha.setFont(new Font("Open Sans", Font.BOLD, 14));
        lFecha.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lFecha, reglas);
        reglas.gridy = 5;
        reglas.anchor = GridBagConstraints.NORTHWEST;
        JLabel lDescripcion = new JLabel("Descripción: ");
        lDescripcion.setFont(new Font("Open Sans", Font.BOLD, 14));
        lDescripcion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lDescripcion, reglas);

        reglas.anchor = GridBagConstraints.WEST;

        reglas.gridx = 2;
        reglas.gridy = 1;
        JLabel lTituloS = new JLabel(titulo);
        lTituloS.setFont(new Font("Open Sans", Font.BOLD, 14));
        lTituloS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lTituloS, reglas);
        reglas.gridy = 2;
        JLabel lEstudianteS = new JLabel(estudiante);
        lEstudianteS.setFont(new Font("Open Sans", Font.BOLD, 14));
        lEstudianteS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lEstudianteS, reglas);
        reglas.gridy = 3;
        JLabel lCedulaS = new JLabel(cedula);
        lCedulaS.setFont(new Font("Open Sans", Font.BOLD, 14));
        lCedulaS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lCedulaS, reglas);
        reglas.gridy = 4;
        JLabel lFechaS = new JLabel(fecha);
        lFechaS.setFont(new Font("Open Sans", Font.BOLD, 14));
        lFechaS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lFechaS, reglas);
        reglas.gridy = 5;
        JTextArea tDescripcion = new JTextArea(descripcion);
        tDescripcion.setFont(new Font("Open Sans", Font.BOLD, 14));
        tDescripcion.setPreferredSize(new Dimension(200, 100));
        tDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tDescripcion.setLineWrap(true);
        tDescripcion.setWrapStyleWord(true);
        tDescripcion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(tDescripcion, reglas);

        return panel;
    }


}
