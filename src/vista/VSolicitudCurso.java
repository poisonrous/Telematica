package vista;

import controlador.CSolicitudCurso;
import modelo.BdConex;
import modelo.Instanciar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static principal.Principal.instanciar;
import static vista.EExcel.exportToExcel;

// Vista de solicitud en curso
public class VSolicitudCurso extends JPanel implements ISolicitudCurso, ActionListener {

    private final JComboBox cTipo, cEstado, cCarrera;
    private final JScrollPane spTabla;
    private final VSolicitudReporte v1;
    private final JTable tabla;
    private final JPopupMenu popup;
    private final DefaultTableModel model;
    private final JButton bParametro, bImprimir, bRegresar;
    private CSolicitudCurso controlador;
    private ResultSet rs;
    private String ID;
    private Double test = 1.0, testS=1.0, testE=0.0, testC=0.0;

    // Constructor de la clase VSolicitudCurso
    public VSolicitudCurso(ISolicitudReporte v1){
        this.setPreferredSize(new Dimension(1085, 680));


        this.setLayout(new BorderLayout());

        this.v1 = (VSolicitudReporte) v1;

        // Título
		JPanel pTitulo = new JPanel();
        JLabel lTitulo = new JLabel("Lista de solicitudes");
        pTitulo.setBackground(new Color(255, 255, 255));
		lTitulo.setFont(new Font("Open Sans", Font.BOLD,15));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		pTitulo.add(lTitulo);
		this.add(pTitulo, BorderLayout.NORTH);

        // Proto tabla

        tabla = new JTable ();
       
       
        model= new DefaultTableModel();
        tabla.setModel(model);

        spTabla = new JScrollPane(tabla);


        //setup de la segunda ventana
        popup = new JPopupMenu();
        // Configuración de la ventana de reporte
        popup.add(new AbstractAction("Seleccione para detalles") {
            public void actionPerformed(ActionEvent e) {
                try {
                    rs.first();
                    for (int i=0; i<tabla.getSelectedRow();i++){rs.next();}
                    ID=rs.getString("idSo");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                    v1.llamar(ID);
                    v1.activar();

            }
        });

        tabla.setComponentPopupMenu(popup);
        this.add(spTabla, BorderLayout.CENTER);


        // Botones
        JPanel pSouth = new JPanel();
        pSouth.setBackground(new Color(255, 255, 255));
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));

        bRegresar = new JButton("Regresar");
        bRegresar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bRegresar.setForeground(Color.WHITE);
        bRegresar.setBackground(new Color(2, 152, 178));
        bRegresar.addActionListener(e -> {

        });

        JLabel saber = new JLabel("");
        bParametro = new JButton("Aplicar párametros de búsqueda:");
        bParametro.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bParametro.setForeground(Color.WHITE);
        bParametro.setBackground(new Color(2, 152, 178));
        
		bParametro.setActionCommand(ISolicitudCurso.PARAMETROS);
        bImprimir = new JButton("Generar reporte de solicitudes");
        bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir.setForeground(Color.WHITE);
        bImprimir.setBackground(new Color(2, 152, 178));
		bImprimir.addActionListener(this);
		//pBotones.add(bRegresar);
        pBotones.add(bImprimir);
        pBotones.add(bParametro);
		pSouth.add(pBotones, BorderLayout.SOUTH);


        // Combobox

        Dimension dimcombo = new Dimension(150, 30);
        JPanel pCombo = new JPanel();
        pCombo.setBackground(new Color(255, 255, 255));
        cTipo = new JComboBox();
        cTipo.setBackground(new Color(255, 255, 255));
        cTipo.setFont(new Font("Open Sans", Font.PLAIN, 15));
        cTipo.setPreferredSize(dimcombo);
        cTipo.addItem("Todos");
        cTipo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                tipoSeleccion(e);
            }
        });
        cTipo.setPreferredSize(dimcombo);

        cEstado = new JComboBox();
        cEstado.setBackground(new Color(255, 255, 255));
        cEstado.setFont(new Font("Open Sans", Font.PLAIN, 15));
        cEstado.setPreferredSize(dimcombo);
        cEstado.addItem("Todos");
        cEstado.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                estadoSeleccion(e);
            }
        });
        cEstado.setPreferredSize(dimcombo);

        cCarrera = new JComboBox();
        cCarrera.setBackground(new Color(255, 255, 255));
        cCarrera.setFont(new Font("Open Sans", Font.PLAIN, 15));
        cCarrera.setPreferredSize(dimcombo);
        cCarrera.addItem("Todas");
        cEstado.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                carreraSeleccion(e);
            }
        });
        cCarrera.setPreferredSize(dimcombo);

        pCombo.add(cTipo);
        pCombo.add(cEstado);
        pCombo.add(cCarrera);
        pSouth.add(pCombo, BorderLayout.NORTH);
        this.add(pSouth, BorderLayout.SOUTH);

    }

    // Método para manejar la selección de tipo de solicitud en el combobox
    public void tipoSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getStateChange()==ItemEvent.SELECTED)
            if (cTipo.getSelectedItem() == "Todos") {
            testS = 1.0;
        }
            else {
            testS = 10.0;
        }
    }


    // Método para manejar la selección de estado en el combobox
    public void estadoSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getStateChange()==ItemEvent.SELECTED)
            if (cEstado.getSelectedItem() == "Todos"){
                testE=0.0;
            }
            else {
                testE=2.0;
            }
    }

    // Método para manejar la selección de carrera en el combobox
    public void carreraSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getStateChange()==ItemEvent.SELECTED)
            if (cEstado.getSelectedItem() == "Todos"){
                testC=0.0;
            }
            else {
                testC=0.5;
            }
    }


    // Método para actualizar la variable de prueba
    public void probando() { test=testE+testS;
    }


    // Setter del controlador
    @Override
    public void setControlador(CSolicitudCurso a) {
        controlador = a;
        bParametro.addActionListener(a);
    }

    // Método para limpiar la tabla
    public void limpiarTabla() {
        int filas=tabla.getRowCount();
        for(int i=0; i<filas;i++)
            model.removeRow(0);
    }

    // Getter del tipo de solicitud
    public String getTipo() {
        return (String) cTipo.getSelectedItem();
    }
    //Get + Set Estado

    // Getter del estado
    public String getEstado() {
        return (String) cEstado.getSelectedItem();
    }

    // Getter de la carrera
    public String getCarrera() {
        return (String) cCarrera.getSelectedItem();
    }


    //Setter del resultado de la cosnulta en la bd
    @Override
    public void setConsulta(ResultSet rs) {
        this.rs=rs;
    }

    // Metodos de arreglo/inicio
    @Override
    public void mostrar() {
        // prepara la tabla
        model.addColumn("Usuario");
        model.addColumn("Carrera");
        model.addColumn("Tipo");
        model.addColumn("Descripción");
        model.addColumn("Estado");
        // llena el combobox
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = conn.getConexion();
        try {
            ps = con.prepareStatement("SELECT tiposolicitud.TipoTiSo FROM tiposolicitud");
            rs = ps.executeQuery();
            while (rs.next()) {
                cTipo.addItem(rs.getString("TipoTiSo"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ps = con.prepareStatement("SELECT DISTINCT EstadoSo FROM solicitud");
            rs = ps.executeQuery();
            while (rs.next()) {
                cEstado.addItem(rs.getString("EstadoSo"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ps = con.prepareStatement("SELECT NombreCa FROM carrera");
            rs = ps.executeQuery();
            while (rs.next()) {
                cCarrera.addItem(rs.getString("NombreCa"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Método para desplegar la vista
    @Override
    public void desplegar() {
        // TODO Auto-generated method stub
        controlador.actionPerformed(new ActionEvent(this, 1, ISolicitudCurso.PARAMETROS));
        nuevatabla();
    }

    // Método para actualizar la tabla
    @Override
    public void nuevatabla() {
        Object[] fila;
            try {
                while (rs.next()) {
                    fila = new Object[5];

                    fila[0] = rs.getString("CedulaEs");
                    fila[1] = rs.getString("NombreCa");
                    fila[2] = rs.getString("TipoTiSo");
                    if(rs.getObject("NombreAsignaturaAs")!=null)
                        fila[3] = rs.getString("NombreAsignaturaAs");
                    else fila[3] = rs.getString("DescripcionSo");
                    fila[4] = rs.getString("EstadoSo");
                    model.addRow(fila);
                }} catch (SQLException e) {
                e.printStackTrace();
            }
    }


    // Método para activar la vista
    @Override
    //Preliminar
    public void activar () {
        this.setVisible(true);
    }

    // Getter para la variable de prueba
    @Override
    public Double getTest() {
        return test;
    }

    // Método para manejar acciones, específicamente usado para imprimir un excel de la tabla
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Date now = Date.from(Instant.now().truncatedTo( ChronoUnit.SECONDS));
            String fecha = DateFormat.getDateTimeInstance(DateFormat.SHORT, 0).format(now).substring(0, Math.min(DateFormat.getDateTimeInstance(DateFormat.SHORT, 0).format(now).length(), 8));

            Files.createDirectories(Paths.get(System.getProperty("user.home")+"/Desktop/telecomunícate"));
            exportToExcel(tabla, System.getProperty("user.home") + "/Desktop/telecomunícate/Reportes "+ fecha +".xlsx");
            JOptionPane.showMessageDialog(null, "Su archivo se encuentra en el escritorio, carpeta telecomunícate");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}



