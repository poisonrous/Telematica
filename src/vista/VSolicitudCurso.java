package vista;

import controlador.CSolicitudCurso;
import modelo.BdConex;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VSolicitudCurso extends JPanel implements ISolicitudCurso, ActionListener {

    private JComboBox cTipo, cEstado;
    private JScrollPane spTabla;
    private VSolicitudReporte v1;
    private JTable tabla;
    private JPopupMenu popup;
    private DefaultTableModel model;
    private JButton bParametro, bImprimir;
    private CSolicitudCurso controlador;
    private ResultSet rs;
    private String ID;
    private int test = 1, testS=1, testE=0;
    
    public VSolicitudCurso(ISolicitudReporte v1){

        this.v1 = (VSolicitudReporte) v1;

        this.setLayout(new BorderLayout());

        // título
        JLabel lTitulo = new JLabel("Lista de solicitudes");
		lTitulo.setFont(new Font("Arial", Font.BOLD,15));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lTitulo, BorderLayout.NORTH);

        // Proto tabla

        tabla = new JTable ();
        model= new DefaultTableModel();
        tabla.setModel(model);

        spTabla = new JScrollPane(tabla);


        //setup de la segunda ventana
        popup = new JPopupMenu();
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

        //cosas de botones
        JPanel pSouth = new JPanel();
        JPanel pBotones = new JPanel();

        JLabel saber = new JLabel("");
        bParametro = new JButton("Aplicar parámetros de búsqueda:");
		bParametro.setActionCommand(ISolicitudCurso.PARAMETROS);
        bImprimir = new JButton("Imprimir resultados");
		bImprimir.addActionListener(this);
		pBotones.add(bImprimir);
        pBotones.add(bParametro);
		pSouth.add(pBotones, BorderLayout.SOUTH);


        // cosas de combobox

        Dimension dimcombo = new Dimension(150, 30);
        JPanel pCombo = new JPanel();
        cTipo = new JComboBox();
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
        cEstado.setPreferredSize(dimcombo);
        cEstado.addItem("Todos");
        cEstado.addItem("Resuelta");
        cEstado.addItem("Pendiente");
        cEstado.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                estadoSeleccion(e);
            }
        });
        cEstado.setPreferredSize(dimcombo);
        pCombo.add(cTipo);
        pCombo.add(cEstado);
        pSouth.add(pCombo, BorderLayout.NORTH);
        this.add(pSouth, BorderLayout.SOUTH);

    }

    // Oídos combobox
    public void tipoSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getStateChange()==ItemEvent.SELECTED)
            if (cTipo.getSelectedItem() == "Todos") {
            testS = 1;
        }
            else {
            testS = 10;
        }
    }

    public void estadoSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getStateChange()==ItemEvent.SELECTED)
            if (cEstado.getSelectedItem() == "Todos"){
                testE=0;
            }
            else {
                testE=2;
            }
    }

    public void probando() { test=testE+testS;
    }
    @Override
    public void setControlador(CSolicitudCurso a) {
        controlador = a;
        bParametro.addActionListener(a);
    }

    @Override
    public void cargarEstado(ComboBoxModel cbEstado) {cEstado.setModel(cbEstado);
    }
    @Override
    public void cargarTipo(ComboBoxModel cbTipo) {
        cTipo.setModel(cbTipo);

    }
    public void limpiarTabla() {
        int filas=tabla.getRowCount();
        for(int i=0; i<filas;i++)
            model.removeRow(0);
    }
    //Getter tipo
    public Object getTipo() {
        return cTipo.getSelectedItem();
    }
    //Get + Set Estado

    public String getEstado() {
        if (cEstado.getSelectedItem().equals("Resuelta")){
            return "1";
        }
        else if (cEstado.getSelectedItem().equals("Pendiente")){
            return "0";
        }
        else {
            return null;
        }
    }

    /*public void setEstado() {
        return null;
    }*/

    @Override
    public void setConsulta(ResultSet rs) {
        this.rs=rs;
    }

    // Metodos de arreglo/inicio
    @Override
    public void mostrar() {
        // prepara la tabla
        model.addColumn("Usuario");
        model.addColumn("Tipo");
        model.addColumn("Descripción");
        model.addColumn("Estado");
        // llena el combobox
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();
        try {
            ps = con.prepareStatement("SELECT tiposolicitud.tipoSo FROM tiposolicitud");
            rs = ps.executeQuery();
            while (rs.next()) {
                cTipo.addItem(rs.getString("tipoSo"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void desplegar() {
        // TODO Auto-generated method stub
        controlador.actionPerformed(new ActionEvent(this, 1, ISolicitudCurso.PARAMETROS));
        nuevatabla();
    }

    @Override
    public void nuevatabla() {
        Object[] fila;
            try {
                while (rs.next()) {
                    fila = new Object[4];

                    fila[0] = rs.getObject("cedula");
                    fila[1] = rs.getObject("tipoSo");
                    if(rs.getObject("NombreAs")!=null)
                        fila[2] = rs.getObject("NombreAs");
                    else fila[2] = rs.getObject("descripcion");
                 //   fila[2] = rs.getObject("descripcion");
                    if (rs.getObject("estado").equals("1"))
                        fila[3] = "Resuelta";
                    else if (rs.getObject("estado").equals("0"))
                        fila[3] = "Pendiente";
                    model.addRow(fila);
                }} catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    //Preliminar
    public void activar () {
        this.setVisible(true);
    }

    @Override
    public int getTest() {
        return test;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            tabla.print();
        } catch (PrinterException ex) {
            throw new RuntimeException(ex);
        }
    }
}



