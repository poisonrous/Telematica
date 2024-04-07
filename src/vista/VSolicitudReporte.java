package vista;

import controlador.CSolicitudReporte;
import modelo.BdConex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VSolicitudReporte extends JFrame implements ISolicitudReporte {

    private JLabel  lNombre, lCedula, lTipo, lEstado, lMateria, lMateria2;
    private JButton bCambiar;

    private JTextField tDescripcion;
    private boolean CHANGE=false;
    private ResultSet rs2;
    private CSolicitudReporte controlador;

    private JComboBox cEstado;
    public VSolicitudReporte(){

        super("reporte seleccionado");
        this.setSize(500, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        Dimension dimcombo = new Dimension(150, 30);
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        // por ahora las grid X estan segmentadas debido a que las arregle del sistema basado en gridy que tenía, resolver cuando vaya a arreglar el resto.

        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        JLabel lNombre2 = new JLabel("Estudiante:");
        pPrincipal.add(lNombre2,reglas);

        reglas.gridx = 2;
        lNombre = new JLabel();
        pPrincipal.add(lNombre,reglas);

        reglas.gridx = 1;
        reglas.gridy = 2;
        JLabel lCedula2 = new JLabel("Cedula:");
        pPrincipal.add(lCedula2,reglas);

        reglas.gridx = 2;
        lCedula = new JLabel();
        pPrincipal.add(lCedula,reglas);

        reglas.gridx = 1;
        reglas.gridy = 3;
        JLabel lTipo2 = new JLabel("Tipo:");
        pPrincipal.add(lTipo2,reglas);

        reglas.gridx = 2;
        lTipo = new JLabel();
        pPrincipal.add(lTipo,reglas);

        reglas.gridx = 1;
        reglas.gridy = 4;
        JLabel lDescripcion2 = new JLabel("Descripción de la solicitud:");
        pPrincipal.add(lDescripcion2,reglas);

        reglas.gridx = 1;
        reglas.gridy = 5;
        reglas.gridwidth = GridBagConstraints.REMAINDER;
        reglas.fill = GridBagConstraints.VERTICAL;
        tDescripcion = new JTextField();
        tDescripcion.setEditable(false);
        pPrincipal.add(tDescripcion,reglas);

        reglas.gridx = 1;
        reglas.gridy = 6;
        JLabel lEstado2 = new JLabel("Estado:");
        pPrincipal.add(lEstado2,reglas);

        reglas.gridx = 2;
        lEstado = new JLabel();
        pPrincipal.add(lEstado,reglas);

        reglas.gridx = 1;
        reglas.gridy = 7;
        lMateria2 = new JLabel("Materia:");
        pPrincipal.add(lMateria2,reglas);
        lMateria2.setVisible(false);

        reglas.gridx = 2;
        lMateria = new JLabel("");
        pPrincipal.add(lMateria,reglas);

        this.add(pPrincipal, BorderLayout.CENTER);


       /* JPanel pBuscar= new JPanel();
        tDato= new JTextField(15);
        tDato.setPreferredSize(dimcombo);
        lElegido = new JLabel (":");
        pBuscar.add(lElegido);
        pBuscar.add(tDato);
        bBuscar=new JButton("Buscar");
        bBuscar.setActionCommand(ITest.CONSULTA);
        pBuscar.add(bBuscar);
        this.add(pBuscar, BorderLayout.NORTH);*/

        JPanel pSur = new JPanel(new GridBagLayout());
        GridBagConstraints reglasSur = new GridBagConstraints();
        reglasSur.gridx = 1;
        reglasSur.gridy = 1;
        reglasSur.insets = new Insets(10, 10, 10, 10);
        JPanel pboton= new JPanel();
        bCambiar = new JButton("Actualizar");
       // if (!CHANGE){
        bCambiar.setActionCommand(ISolicitudReporte.CAMBIAR);
        bCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.actionPerformed(e);
            }
        });
      /*  else {bCambiar.setActionCommand(ISolicitudReporte.CAMBIARPLUS);
        }*/
            pboton.add(bCambiar, BorderLayout.WEST);
            pSur.add(pboton, reglasSur);

        cEstado = new JComboBox();
        cEstado.setPreferredSize(dimcombo);
        cEstado.addItem("Resuelta");
        cEstado.addItem("Pendiente");
        cEstado.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                estadoSeleccion(e);
            }
        });
        pboton.add(cEstado);
        this.add(pSur, BorderLayout.SOUTH );

    }


    public void estadoSeleccion(ItemEvent e) {
        // TODO Auto-generated method stub
        /*if(e.getStateChange()==ItemEvent.SELECTED)
            if (cEstado.getSelectedItem() == lEstado.getText()){
                JOptionPane.showMessageDialog(null,"La solicitud ya se considera" +lEstado.getText());
            }
            else {
                controlador.actionPerformed(new ActionEvent(this, 1, ISolicitudReporte.CAMBIAR));
            }*/
    }

    @Override
    public void setConsulta(ResultSet rs) {
        this.rs2=rs;
    }

    @Override
    public void setControlador(CSolicitudReporte a) {
        this.controlador= a;
    }

    @Override
    public void llamar(String idSo) {
        BdConex bd= new BdConex();
        this.rs2= bd.consultar("SELECT usuario.NombresUs, solicitud.idSo, solicitud.cedula, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.estado, asignatura.NombreAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo LEFT JOIN materia ON solicitud.materia = materia.idMA LEFT JOIN asignatura ON materia.idAs = asignatura.idAs LEFT JOIN usuario ON solicitud.cedula = usuario.CedulaUs WHERE idSo= '"+idSo+ "';");
    }
    //, asignatura.idAs, NombreAs,  asignatura, materia, and asignatura.idAs = materia.idAs and materia.idMa = solicitud.materia
    @Override
    public void activar() {
        /*{while (rs.next())*/



        try {   rs2.first();
            System.out.println(rs2.getString("NombresUs"));
        lNombre.setText(rs2.getString("NombresUs"));
        lCedula.setText(rs2.getString("cedula"));
        lTipo.setText(rs2.getString("tipoSo"));
        if(rs2.getString("estado").equals("1")) lEstado.setText("Resuelta");
            else lEstado.setText("Pendiente");
        if(rs2.getString("NombreAs")!=null) tDescripcion.setText(rs2.getString("NombreAs"));
        else tDescripcion.setText(rs2.getString("descripcion"));
        if(rs2.getString("estado").equals("1")) cEstado.setSelectedItem("Resuelta");
            else cEstado.setSelectedItem("Pendiente");
            this.setVisible(true);
} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getEstado() {
        if(cEstado.getSelectedItem().equals("Resuelta")) return "1";
        else return "0";
    }

    @Override
    public String getIdSo() {
        String idSo = "";
        try {
            idSo = rs2.getString("idSo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idSo;
    }
}
