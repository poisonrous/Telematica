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

// Vista para agregar un nuevo evento.
public class VEvento extends JPanel implements ActionListener, IEvento {
    // Campos de texto para ingresar los datos del evento
    private final JTextField tfTitulo;
    private final JTextField tfOrganizador;
    private final JTextField tfPrecio;
    private final JTextField tfLugar;
    private final JTextArea taDescripcion;

    // Selector de fecha y hora
    private final JDateChooser dcFecha;
    private final TimeSelectionField tsHora;

    // Radio botones para la modalidad de eventos
    private final JRadioButton rbPresencial;
    private final JRadioButton rbVirtual;
    private final JRadioButton rbSemipresencial;
    private final ButtonGroup bgModalidad;

    // Casilla de verificación para eventos gratuitos
    private final JCheckBox cbGratuito;

    // Botón para publicar el evento
    private final JButton bPublicar;

    // Constructor de la vista de evento.
    public VEvento(){
        this.setPreferredSize(new Dimension(1300, 800));


        this.setLayout(new BorderLayout());

        JPanel pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Panel para el icono y el título del formulario
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


        // Campos de entrada de datos del evento
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

        // Campos de entrada de datos del evento

        tfTitulo = new JTextField(20);  // Cuadro de texto para el título
        Validacion.validarLongitud(tfTitulo,45);  // Validación de longitud máxima
        reglas.gridy = 2;
        reglas.gridx = 2;
        pPrincipal.add(tfTitulo, reglas);
        tfOrganizador = new JTextField(20);  // Cuadro de texto para el título
        Validacion.validarLongitud(tfOrganizador,45);  // Validación de longitud máxima
        reglas.gridy++;
        pPrincipal.add(tfOrganizador, reglas);
        dcFecha = new JDateChooser();  // Selector de fecha
        reglas.gridy++;
        pPrincipal.add(dcFecha, reglas);
        tsHora = new TimeSelectionField();  // Selector de hora
        tsHora.setBackground(new Color(255, 255, 255));
        reglas.gridy++;
        pPrincipal.add(tsHora, reglas);
        tfLugar = new JTextField(20);  // Cuadro de texto para el título
        Validacion.validarLongitud(tfLugar,100); // Validación de longitud máxima
        reglas.gridy++;
        pPrincipal.add(tfLugar, reglas);
        tfPrecio = new JTextField(20);  // Cuadro de texto para el precio
        Validacion.validarNumeros(tfPrecio); // Validación para permitir solo números
        reglas.gridy++;
        pPrincipal.add(tfPrecio, reglas);
        cbGratuito = new JCheckBox("Gratuito"); // Casilla de verificación para eventos gratuitos
        cbGratuito.setFont(new Font("Open Sans", Font.BOLD, 14));
        cbGratuito.setBackground(new Color(255, 255, 255));
        cbGratuito.addActionListener(this);
        reglas.gridx = 3;
        pPrincipal.add(cbGratuito, reglas);

        // Botones para la modalidad de eventos
        reglas.gridx = 2;
        rbPresencial = new JRadioButton("Presencial"); // Modalidad Presencial
        rbPresencial.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbPresencial.setBackground(new Color(255, 255, 255));
        rbVirtual = new JRadioButton("Virtual"); // Modalidad Virtual
        rbVirtual.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbVirtual.setBackground(new Color(255, 255, 255));
        rbSemipresencial = new JRadioButton("Semipresencial"); // Modalidad Semipresencial
        rbSemipresencial.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbSemipresencial.setBackground(new Color(255, 255, 255));

        // Grupo de botones para la modalidad
        bgModalidad = new ButtonGroup();
        bgModalidad.add(rbPresencial);
        bgModalidad.add(rbVirtual);
        bgModalidad.add(rbSemipresencial);
        rbPresencial.setSelected(true); // Seleccionar por defecto la modalidad presencial

        // Panel para agrupar los radio botones de modalidad
        JPanel pModalidad = new JPanel();
        pModalidad.setBackground(new Color(255, 255, 255));
        pModalidad.add(rbPresencial);
        pModalidad.add(rbVirtual);
        pModalidad.add(rbSemipresencial);
        reglas.gridy++;
        pPrincipal.add(pModalidad, reglas);

        // Área de texto para la descripción del evento
        taDescripcion = new JTextArea(5, 20);
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);

        // Validación de longitud máxima
        Validacion.validarLongitud(taDescripcion,600);
        reglas.gridy++;
        pPrincipal.add(taDescripcion, reglas);

        // Panel para mostrar la imagen del evento (aquí debería ir la lógica de carga de imagen)
        JPanel pImagen = new JPanel();
        pImagen.setBackground(new Color(255, 255, 255));
        reglas.gridy++;

        // Panel para mostrar la imagen del evento
        JLabel lImagen = new JLabel();
        lImagen.setSize(350, 240);
        ImageIcon imagen = new ImageIcon("media/eventos.jpg"); // Cargar imagen desde un archivo
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
        //pPrincipal.add (pImagen, reglas);

        // Botón para publicar el evento
        bPublicar = new JButton("Publicar");
        bPublicar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bPublicar.setForeground(Color.WHITE);
        bPublicar.setBackground(new Color(2, 152, 178));
        bPublicar.setActionCommand(IEvento.PUBLICAR);
        reglas.gridy++;
        pPrincipal.add(bPublicar, reglas);

        // Agregar el panel principal al panel de la vista
        this.add(pPrincipal);
    }

    // Método para manejar los eventos de la interfaz gráfica.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (cbGratuito.isSelected()){
            tfPrecio.setEnabled(false);
            tfPrecio.setText("0");
        } else {
            tfPrecio.setEnabled(true);
        }
    }

    // Método para establecer el controlador para la vista
    @Override
    public void setControlador(CEvento c) {
        bPublicar.addActionListener(c);
    }

    // Método para mostrar la vista
    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    // Método para limpiar todos los campos de la vista
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

    // Métodos para obtener los datos ingresados en la vista
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
        try {
        DateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(dcFecha.getDate());
    } catch (Exception f) {
        System.out.println(f);
        JOptionPane.showMessageDialog(null, "La fecha no puede quedar vacia");
        return null;
    }

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
