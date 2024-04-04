package vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import controlador.CEvento;
import examples.TimeSelectionDemo;
import timeselector.TimeSelectionField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class VEvento extends JFrame implements ActionListener, IEvento {
    private JTextField tfTitulo, tfOrganizador, tfPrecio, tfLugar;
    private JTextArea taDescripcion;
    private JDateChooser dcFecha;
    private TimeSelectionField tsHora;
    private JRadioButton rbPresencial, rbVirtual, rbSemipresencial;
    private ButtonGroup bgModalidad;
    private JCheckBox cbGratuito;
    private JButton bPublicar;

    public VEvento(){

        super("Publicar Evento");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        JLabel lTitulo = new JLabel("Agregar Evento");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pPrincipal.add(lTitulo, reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Nombre: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Organizador: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Fecha: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Hora: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Lugar: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Precio: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Modalidad: "), reglas);
        reglas.gridy++;
        pPrincipal.add(new JLabel("Descripción: "), reglas);

        tfTitulo = new JTextField(20);
        reglas.gridx = 2;
        reglas.gridy = 2;
        pPrincipal.add(tfTitulo, reglas);
        tfOrganizador = new JTextField(20);
        reglas.gridy++;
        pPrincipal.add(tfOrganizador, reglas);
        dcFecha = new JDateChooser();
        reglas.gridy++;
        pPrincipal.add(dcFecha, reglas);
        tsHora = new TimeSelectionField();
        reglas.gridy++;
        pPrincipal.add(tsHora, reglas);
        tfLugar = new JTextField(20);
        reglas.gridy++;
        pPrincipal.add(tfLugar, reglas);
        tfPrecio = new JTextField(20);
        reglas.gridy++;
        pPrincipal.add(tfPrecio, reglas);
        cbGratuito = new JCheckBox("Gratuito");
        cbGratuito.addActionListener(this);
        reglas.gridx = 3;
        pPrincipal.add(cbGratuito, reglas);
        reglas.gridx = 2;
        rbPresencial = new JRadioButton("Presencial");
        rbVirtual = new JRadioButton("Virtual");
        rbSemipresencial = new JRadioButton("Semipresencial");
        bgModalidad = new ButtonGroup();
        bgModalidad.add(rbPresencial);
        bgModalidad.add(rbVirtual);
        bgModalidad.add(rbSemipresencial);
        rbPresencial.setSelected(true);
        JPanel pModalidad = new JPanel();
        pModalidad.add(rbPresencial);
        pModalidad.add(rbVirtual);
        pModalidad.add(rbSemipresencial);
        reglas.gridy++;
        pPrincipal.add(pModalidad, reglas);
        taDescripcion = new JTextArea(5, 20);
        reglas.gridy++;
        pPrincipal.add(taDescripcion, reglas);

        bPublicar = new JButton("Publicar");
        bPublicar.setActionCommand(IEvento.PUBLICAR);
        reglas.gridy++;
        pPrincipal.add(bPublicar, reglas);

        this.add(pPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cbGratuito.isSelected()){
            tfPrecio.setEnabled(false);
            tfPrecio.setText("0");
        } else {
            tfPrecio.setEnabled(true);
        }
    }

    @Override
    public void setControlador(CEvento c) {
        bPublicar.addActionListener(c);
    }

    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void limpiar(){
        tfTitulo.setText("");
        tfOrganizador.setText("");
        taDescripcion.setText("");
        dcFecha.setDate(null);
        tfLugar.setText("");
        tfPrecio.setText("");
        rbPresencial.setSelected(true);
        cbGratuito.setSelected(false);
    }

    @Override
    public String getTitulo() {
        return tfTitulo.getText();
    }

    @Override
    public String getOrganizador() {
        return tfOrganizador.getText();
    }

    @Override
    public String getDescripcion() {
        return taDescripcion.getText();
    }

    @Override
    public String getFecha() {
        DateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(dcFecha.getDate());
      //  return dcFecha.getDate().toString();
    }

    @Override
    public String getHora() {
        DateFormat formateador= new SimpleDateFormat("HH:mm:ss");
        return formateador.format(tsHora.getSelectedTime());
    }

    @Override
    public String getLugar() {
        return tfLugar.getText();
    }

    @Override
    public String getModalidad() {
        return rbPresencial.isSelected() ? "Presencial" : rbVirtual.isSelected() ? "Virtual" : "Semipresencial";
    }

    @Override
    public String getPrecio() {
        return tfPrecio.getText();
    }

}
