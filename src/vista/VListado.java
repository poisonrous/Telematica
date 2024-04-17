package vista;

import controlador.CListado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class VListado extends JPanel implements IListado, ActionListener {
    private JComboBox cbMaterias;
    private JTable listado;
    private DefaultTableModel model;
    private JScrollPane spListado;
    private JButton bImprimir;
    private CListado controlador;

    public VListado() {
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints reglas = new GridBagConstraints();
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
        JLabel lTitulo = new JLabel("LISTADO DE ESTUDIANES");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconCar.add(lTitulo);
        pPrincipal.add(pIconCar, reglas);
        JLabel lSubTitulo = new JLabel("Seleccione la materia");
        lSubTitulo.setFont(new Font("Open Sans", Font.BOLD, 15));
        reglas.gridy++;
        pPrincipal.add(lSubTitulo, reglas);
        cbMaterias = new JComboBox();
        cbMaterias.setBackground(new Color(255, 255, 255));
        cbMaterias.setFont(new Font("Open Sans", Font.PLAIN, 15));
        cbMaterias.setPreferredSize(new Dimension(200, 30));
        cbMaterias.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                materiaSeleccion(e);
            }
        });
        reglas.gridy++;
        pPrincipal.add(cbMaterias, reglas);

        listado = new JTable();
        model = new DefaultTableModel();
        model.addColumn("CÉDULA");
        model.addColumn("NOMBRES Y APELLIDOS");
        model.addColumn("CORREO");
        model.addColumn("TELÉFONO");
        listado.setModel(model);
        spListado = new JScrollPane(listado);
        reglas.gridy++;
        pPrincipal.add(spListado, reglas);

        bImprimir = new JButton("Imprimir listado");
        bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir.setForeground(Color.WHITE);
        bImprimir.setBackground(new Color(2, 152, 178));
        bImprimir.addActionListener(this);
        reglas.gridy++;
        pPrincipal.add(bImprimir, reglas);

        this.add(pPrincipal);
    }

    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    @Override
    public void cargarMaterias(ComboBoxModel cbmMaterias) {
        cbMaterias.removeAllItems();
        cbMaterias.setModel(cbmMaterias);
    }

    @Override
    public void materiaSeleccion(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) controlador.mostrarListado();

    }

    @Override
    public Object getMateriaSeleccion() {
        return cbMaterias.getSelectedItem();
    }

    @Override
    public void setControlador(CListado controlador) {
    this.controlador = controlador;
    }

    @Override
    public void mostrarListado(ResultSet materias) {
        model.setRowCount(0);
        try {
            while (materias.next()) {
                model.addRow(new Object[] {
                        materias.getString("CedulaEs"),
                        materias.getString("NombresEs") + " " + materias.getString("ApellidosEs"),
                        materias.getString("CorreoElectricoEs"),
                        materias.getString("TelefonoEs")
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            listado.print();
        } catch (PrinterException ex) {
            throw new RuntimeException(ex);
        }
    }
}
