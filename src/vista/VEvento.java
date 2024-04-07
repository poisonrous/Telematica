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
public class VEvento extends JPanel implements ActionListener, IEvento {
    private JTextField tfTitulo, tfOrganizador, tfPrecio, tfLugar;
    private JTextArea taDescripcion;
    private JDateChooser dcFecha;
    private TimeSelectionField tsHora;
    private JRadioButton rbPresencial, rbVirtual, rbSemipresencial;
    private ButtonGroup bgModalidad;
    private JCheckBox cbGratuito;
    private JButton bPublicar;

    public VEvento(){

        this.setLayout(new BorderLayout());

        JPanel pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        JPanel pIconE = new JPanel();
        pIconE.setBackground(new Color(255, 255, 255));
        JLabel lImagenE = new JLabel();  
        lImagenE.setSize(35, 35);
        ImageIcon iconE = new ImageIcon("media/evento.png");
        Icon iconoE = new ImageIcon(iconE.getImage().getScaledInstance(lImagenE.getWidth(), lImagenE.getHeight(), Image.SCALE_DEFAULT));
        lImagenE.setIcon(iconoE);
       pIconE.add(lImagenE);
        JLabel lTipo = new JLabel("Agregar Evento");
        lTipo.setFont(new Font("Open Sans", Font.BOLD, 16));
        pIconE.add(lTipo);
        pPrincipal.add(pIconE, reglas);
        
        
        
        reglas.gridy++;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lNombre = new JLabel("Nombre:");
        lNombre.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lNombre, reglas);
        reglas.gridy++;
        JLabel lOrganizador = new JLabel("Organizador:");
        lOrganizador.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lOrganizador, reglas);
        reglas.gridy++;
        JLabel lFecha = new JLabel("Fecha:");
        lFecha.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lFecha, reglas);
        reglas.gridy++;
        JLabel lHora = new JLabel("Hora:");
        lHora.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lHora, reglas);
        reglas.gridy++;
        JLabel lLugar = new JLabel("Lugar:");
        lLugar.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lLugar, reglas);
        reglas.gridy++;
        JLabel lPrecio = new JLabel("Precio:");
        lPrecio.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lPrecio, reglas);
        reglas.gridy++;
        JLabel lModalidad = new JLabel("Modalidad:");
        lModalidad.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lModalidad, reglas);
        reglas.gridy++;
        JLabel lDescripcion = new JLabel("Descripción:");
        lDescripcion.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lDescripcion, reglas);

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
        tsHora.setBackground(new Color(255, 255, 255));
        reglas.gridy++;
        pPrincipal.add(tsHora, reglas);
        tfLugar = new JTextField(20);
        reglas.gridy++;
        pPrincipal.add(tfLugar, reglas);
        tfPrecio = new JTextField(20);
        reglas.gridy++;
        pPrincipal.add(tfPrecio, reglas);
        cbGratuito = new JCheckBox("Gratuito");
        cbGratuito.setFont(new Font("Open Sans", Font.BOLD, 14));
        cbGratuito.setBackground(new Color(255, 255, 255));
        cbGratuito.addActionListener(this);
        reglas.gridx = 3;
        pPrincipal.add(cbGratuito, reglas);
        reglas.gridx = 2;
        rbPresencial = new JRadioButton("Presencial");
        rbPresencial.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbPresencial.setBackground(new Color(255, 255, 255));
        rbVirtual = new JRadioButton("Virtual");
        rbVirtual.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbVirtual.setBackground(new Color(255, 255, 255));
        rbSemipresencial = new JRadioButton("Semipresencial");
        rbSemipresencial.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbSemipresencial.setBackground(new Color(255, 255, 255));
        bgModalidad = new ButtonGroup();
        bgModalidad.add(rbPresencial);
        bgModalidad.add(rbVirtual);
        bgModalidad.add(rbSemipresencial);
        rbPresencial.setSelected(true);
        JPanel pModalidad = new JPanel();
        pModalidad.setBackground(new Color(255, 255, 255));
        pModalidad.add(rbPresencial);
        pModalidad.add(rbVirtual);
        pModalidad.add(rbSemipresencial);
        reglas.gridy++;
        pPrincipal.add(pModalidad, reglas);
        taDescripcion = new JTextArea(5, 20);
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        reglas.gridy++;
        pPrincipal.add(taDescripcion, reglas);
        
        JPanel pImagen = new JPanel();
        pImagen.setBackground(new Color(255, 255, 255));
    
        reglas.gridy++;
      
        
        
        JLabel lImagen = new JLabel();  
        lImagen.setSize(350, 240);
        ImageIcon imagen = new ImageIcon("media/eventos.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
        //pPrincipal.add (pImagen, reglas);

        bPublicar = new JButton("Publicar");
        bPublicar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bPublicar.setForeground(Color.WHITE);
        bPublicar.setBackground(new Color(0, 125, 254));
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
