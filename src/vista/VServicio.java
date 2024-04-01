package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VServicio extends JFrame implements ActionListener, IServicio{
    private JButton bActualizar;
    private JPanel pPrincipal;
    private JComboBox cServicio;
    private JTextField tNombre, tHorario, tUbicacion;
    private JRadioButton rbActivo, rbInactivo;
    private CServicio controlador;

    public VServicio(){
        super("Servicio");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();

        JLabel lTitulo = new JLabel("Servicio");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        reglas.gridx = 2;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        pPrincipal.add(lTitulo, reglas);
        reglas.gridx = 1;
        reglas.gridy = 2;
        pPrincipal.add(new JLabel("Servicio"), reglas);
        reglas.gridy = 3;
        pPrincipal.add(new JLabel("Horario"), reglas);
        reglas.gridy = 4;
        pPrincipal.add(new JLabel("Ubicacion"), reglas);
        reglas.gridy = 5;
        pPrincipal.add(new JLabel("Estado"), reglas);
        tNombre = new JTextField(20);
        reglas.gridx = 2;
        reglas.gridy = 2;
        tNombre.setVisible(false);
        pPrincipal.add(tNombre, reglas);
        cServicio = new JComboBox();
        cServicio.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                servicioSeleccion(e);
            }
        });
        cServicio.setActionCommand(IServicio.SELECCION);
      //  cServicio.addItem("Otro");
        pPrincipal.add(cServicio, reglas);
        tHorario = new JTextField(20);
        reglas.gridy = 3;
        pPrincipal.add(tHorario, reglas);
        tUbicacion = new JTextField(20);
        reglas.gridy = 4;
        pPrincipal.add(tUbicacion, reglas);
        rbActivo = new JRadioButton("Activo");
        rbInactivo = new JRadioButton("Inactivo");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbActivo);
        bg.add(rbInactivo);
        reglas.gridy = 5;
        pPrincipal.add(rbActivo, reglas);
        reglas.gridx = 3;
        pPrincipal.add(rbInactivo, reglas);
        bActualizar = new JButton("Actualizar");
        bActualizar.setActionCommand(IServicio.ACTUALIZAR);
        bActualizar.addActionListener(this);
        reglas.gridx = 2;
        reglas.gridy = 6;
        pPrincipal.add(bActualizar, reglas);
        this.add(pPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==cServicio){
        if (cServicio.getSelectedItem().toString().equals("Otro")){
            tNombre.setVisible(true);
            cServicio.setVisible(false);
        }
    }
    }

    @Override
    public void arrancar() {
    this.setVisible(true);
    }

    @Override
    public void cargarServicio(ComboBoxModel cbmServicio) {
        cServicio.removeAllItems();
        cServicio.setModel(cbmServicio);
        cServicio.addItem("Otro");
    }

    @Override
    public void servicioSeleccion(ItemEvent e) {
        if(cServicio.getSelectedItem().toString().equals("Otro")){
            tNombre.setVisible(true);
            cServicio.setVisible(false);
        } else {
            tNombre.setVisible(false);
        }
    }
    @Override
    public void mostrarServicio(String horario, String ubicacion, String estatus) {
        tHorario.setText(horario);
        tUbicacion.setText(ubicacion);
        if(estatus.equals("1")){
            rbActivo.setSelected(true);
        } else {
            rbInactivo.setSelected(true);
        }
    }
    @Override
    public void setControlador(CServicio controlador) {
        this.controlador = controlador;
        bActualizar.addActionListener(controlador);
    }
    @Override
    public int getCaso() {
        if(tNombre.isVisible()){
            return 1;
        } else {
            return 2;
        }
    }
    @Override
    public String getNombreServicio() {
        if(tNombre.isVisible()){
            return tNombre.getText();} else {
            return cServicio.getSelectedItem().toString();
        }
    }

    @Override
    public String getHorarioServicio() {
        return tHorario.getText();
    }

    @Override
    public String getUbicacionServicio() {
        return tUbicacion.getText();
    }

    @Override
    public String getEstatusServicio() {
        if(rbActivo.isSelected()){
            return "1";
        } else {
            return "0";
        }
    }
}
