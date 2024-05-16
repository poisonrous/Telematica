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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

import static vista.EExcel.exportToExcel;

// Vista del listado
public class VListado extends JPanel implements IListado, ActionListener {
    private JComboBox cbMaterias;
    private JTable listado, Blistado;
    private DefaultTableModel model, modelB;
    private JScrollPane spListado;
    private JButton bImprimir, bImprimir2;
    private CListado controlador;

    // Constructor de la clase VListado.
    public VListado() {
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Panel para el ícono y el título
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

        // Etiqueta del Subtítulo
        JLabel lSubTitulo = new JLabel("Seleccione la materia");
        lSubTitulo.setFont(new Font("Open Sans", Font.BOLD, 15));
        reglas.gridy++;
        pPrincipal.add(lSubTitulo, reglas);

        // ComboBox para seleccionar la materia
        cbMaterias = new JComboBox();
        cbMaterias.setBackground(new Color(255, 255, 255));
        cbMaterias.setFont(new Font("Open Sans", Font.PLAIN, 15));
        cbMaterias.setPreferredSize(new Dimension(200, 30));
        cbMaterias.addItemListener(new ItemListener(){

            // Método llamado cuando se selecciona una materia
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                materiaSeleccion(e);
            }
        });
        reglas.gridy++;
        pPrincipal.add(cbMaterias, reglas);

        // Tabla para mostrar el listado de estudiantes
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

        //Panel para los botones
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        // Botónes para imprimir los listado
        bImprimir = new JButton("Generar listado de materia");
        bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir.setForeground(Color.WHITE);
        bImprimir.setBackground(new Color(2, 152, 178));
        bImprimir.addActionListener(this);
        pBotones.add(bImprimir);
        bImprimir2 = new JButton("Generar listado general");
        bImprimir2.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir2.setForeground(Color.WHITE);
        bImprimir2.setBackground(new Color(2, 152, 178));
        bImprimir2.addActionListener(this);
        reglas.gridy++;
        pBotones.add(bImprimir2);
        pPrincipal.add(pBotones, reglas);

        this.add(pPrincipal); // Agrega el panel principal a este JPanel

        //tabla invisible para imprimir todos los estudiantes.
        Blistado = new JTable();
        modelB = new DefaultTableModel();
        modelB.addColumn("CÉDULA");
        modelB.addColumn("NOMBRES Y APELLIDOS");
        modelB.addColumn("CORREO");
        modelB.addColumn("TELÉFONO");
        Blistado.setModel(modelB);
    }

    @Override
    public void arrancar() {
        this.setVisible(true);
    }


        /**
         * Carga las materias disponibles en el ComboBox.
         * @param cbmMaterias El modelo de ComboBox con las materias
         */
    @Override
    public void cargarMaterias(ComboBoxModel cbmMaterias) {
        cbMaterias.removeAllItems();
        cbMaterias.setModel(cbmMaterias);
    }

        /**
         * Maneja el evento de selección de materia en el ComboBox.
         * @param e El evento de selección de materia
         */
    @Override
    public void materiaSeleccion(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) controlador.mostrarListado();

    }

        /**
         * Obtiene la materia seleccionada en el ComboBox.
         * @return La materia seleccionada
         */
    @Override
    public Object getMateriaSeleccion() {
        return cbMaterias.getSelectedItem();
    }


        /**
         * Establece el controlador para la vista de listado.
         * @param controlador El controlador CListado
         */
    @Override
    public void setControlador(CListado controlador) {
    this.controlador = controlador;
    }

        /**
         * Muestra el listado de estudiantes en la tabla.
         * @param materias El ResultSet con la información de los estudiantes
         */
    @Override
    public void mostrarListado(ResultSet materias) {
        model.setRowCount(0);
        if (cbMaterias.getSelectedIndex()!=0){
        try {
            while (materias.next()) {
                model.addRow(new Object[] {
                        materias.getString("CedulaEs"),
                        materias.getString("NombresEs") + " " + materias.getString("ApellidosEs"),
                        materias.getString("CorreoElectricoEs"),
                        materias.getString("TelefonoEs")

                });
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }

    /**
     * Genera el listado de todos los estudiantes en una tabla.
     */
    @Override
    public void mostrarBigListado(ResultSet materias) {
        modelB.setRowCount(0);
        try {
                while (materias.next()) {
                    modelB.addRow(new Object[] {
                            materias.getString("CedulaEs"),
                            materias.getString("NombresEs") + " " + materias.getString("ApellidosEs"),
                            materias.getString("CorreoElectricoEs"),
                            materias.getString("TelefonoEs")

                    });
                }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
         * Maneja el evento de clic en los botones de generar listados.
         * @param e El evento de acción
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bImprimir){
        try {
            if (cbMaterias.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Seleccione una de las materias");
            }
            else {
            Files.createDirectories(Paths.get(System.getProperty("user.home")+"/Desktop/telecomunícate"));
            exportToExcel(listado, System.getProperty("user.home") + "/Desktop/telecomunícate/Listado "+ this.getMateriaSeleccion() +".xlsx");
            JOptionPane.showMessageDialog(null, "Su archivo se encuentra en el escritorio, carpeta telecomunícate");
        }
            }
                 catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        }
        if (e.getSource()==bImprimir2){
            try {
                controlador.crearBigListado();
                Files.createDirectories(Paths.get(System.getProperty("user.home")+"/Desktop/telecomunícate"));
                exportToExcel(Blistado, System.getProperty("user.home") + "/Desktop/telecomunícate/Listado Telemática.xlsx");
                JOptionPane.showMessageDialog(null, "Su archivo se encuentra en el escritorio, carpeta telecomunícate");


            }  catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }



    }
}
