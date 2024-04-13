package vista;

import controlador.CSolicitudCurso;
import modelo.BdConex;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class VSolicitudCurso extends JPanel implements ISolicitudCurso, ActionListener {

    private final JComboBox cTipo;
    private final JComboBox cEstado;
    private final JScrollPane spTabla;
    private final VSolicitudReporte v1;
    private final JTable tabla;
    private final JPopupMenu popup;
    private final DefaultTableModel model;
    private final JButton bParametro;
    private final JButton bImprimir;
    private CSolicitudCurso controlador;
    private ResultSet rs;
    private String ID;
    private int test = 1, testS=1, testE=0;
    
    public VSolicitudCurso(ISolicitudReporte v1){
        this.setPreferredSize(new Dimension(1085, 680));


        this.setLayout(new BorderLayout());

        this.v1 = (VSolicitudReporte) v1;

        // título
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
        pSouth.setBackground(new Color(255, 255, 255));
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));

        JLabel saber = new JLabel("");
        bParametro = new JButton("Aplicar par�metros de b�squeda:");
        bParametro.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bParametro.setForeground(Color.WHITE);
        bParametro.setBackground(new Color(0, 125, 254));
        
		bParametro.setActionCommand(ISolicitudCurso.PARAMETROS);
        bImprimir = new JButton("Imprimir resultados");
        bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir.setForeground(Color.WHITE);
        bImprimir.setBackground(new Color(0, 125, 254));
		bImprimir.addActionListener(this);
		pBotones.add(bImprimir);
        pBotones.add(bParametro);
		pSouth.add(pBotones, BorderLayout.SOUTH);


        // cosas de combobox

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
        /*if (*/ return (String) cEstado.getSelectedItem(); /* {
          return "1";
        }
        else if (Objects.equals(cEstado.getSelectedItem(), "Pendiente")){
            return "0";
        }
        else {
            return null;
        }*/
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

                    fila[0] = rs.getObject("CedulaEs");
                    fila[1] = rs.getObject("TipoTiSo");
                    if(rs.getObject("NombreAsignaturaAs")!=null)
                        fila[2] = rs.getObject("NombreAsignaturaAs");
                    else fila[2] = rs.getObject("DescripcionSo");
                 //   fila[2] = rs.getObject("descripcion");
                 //   if (rs.getObject("EstadoSo").equals("1"))
                    fila[3] = rs.getObject("EstadoSo");
                   // else if (rs.getObject("estado").equals("0"))
                    //    fila[3] = "Pendiente";
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



