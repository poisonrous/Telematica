package vista;

import controlador.CSolicitudCurso;
import controlador.CSolicitudReporte;
import controlador.CSolicitudReporte;
import modelo.BdConex;
import vista.ISolicitudReporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.awt.GridBagConstraints.REMAINDER;

// Vista de solicitud de reporte
public class VSolicitudReporte extends JFrame implements ISolicitudReporte {

    private final JLabel  lNombre;
    private final JLabel lCedula;
    private final JLabel lTipo;
    private final JLabel lEstado;
    private final JLabel lMateria;
    private final JLabel lMateria2;
    private final JLabel lCarrera;

    private final JButton bCambiar;

    private final JTextField tDescripcion;
    private final boolean CHANGE=false;
    private ResultSet rs2;
    private CSolicitudReporte controlador;

    private final JComboBox cEstado;

    // Constructor de la clase VSolicitudReporte
    public VSolicitudReporte(){

        super("reporte seleccionado");
        this.setSize(500, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        Dimension dimcombo = new Dimension(150, 30);
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        // por ahora las grid X estan segmentadas debido a que las arregle del sistema basado en gridy que tenía, resolver cuando vaya a arreglar el resto.

        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Etiquetas para mostrar la información de la solicitud
        JLabel lNombre2 = new JLabel("Estudiante:");
        lNombre2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lNombre2,reglas);

        reglas.gridx = 2;
        lNombre = new JLabel();
        lNombre.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lNombre,reglas);

        reglas.gridx = 1;
        reglas.gridy = 2;
        JLabel lCedula2 = new JLabel("Cedula:");
        lCedula2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lCedula2,reglas);

        reglas.gridx = 2;
        lCedula = new JLabel();
        lCedula.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lCedula,reglas);

        reglas.gridx = 1;
        reglas.gridy = 3;
        JLabel lCarrera2 = new JLabel("Carrera:");
        lCarrera2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lCarrera2,reglas);

        reglas.gridx = 2;
        lCarrera = new JLabel();
        lCarrera.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lCarrera,reglas);

        reglas.gridx = 1;
        reglas.gridy = 4;
        JLabel lTipo2 = new JLabel("Tipo:");
        lTipo2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lTipo2,reglas);

        reglas.gridx = 2;
        lTipo = new JLabel();
        lTipo.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lTipo,reglas);

        reglas.gridx = 1;
        reglas.gridy = 5;
        JLabel lDescripcion2 = new JLabel("Descripci�n de la solicitud:");
        lDescripcion2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lDescripcion2,reglas);

        reglas.gridx = 1;
        reglas.gridy = 6;
        reglas.gridwidth = GridBagConstraints.REMAINDER;
        reglas.fill = GridBagConstraints.VERTICAL;
        tDescripcion = new JTextField();
        tDescripcion.setEditable(false);
        tDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
       
        pPrincipal.add(tDescripcion,reglas);

        reglas.gridx = 1;
        reglas.gridy = 7;
        JLabel lEstado2 = new JLabel("Estado:");
        lEstado2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lEstado2,reglas);

        reglas.gridx = 2;
        lEstado = new JLabel();
        lEstado.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lEstado,reglas);

        reglas.gridx = 1;
        reglas.gridy = 8;
        lMateria2 = new JLabel("Materia:");
        lMateria2.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lMateria2,reglas);
        lMateria2.setVisible(false);

        reglas.gridx = 2;
        lMateria = new JLabel("");
        lMateria.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lMateria,reglas);

        // Añadir los componentes al panel principal
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

        // Configuración del panel inferior
        JPanel pSur = new JPanel(new GridBagLayout());
        GridBagConstraints reglasSur = new GridBagConstraints();
        reglasSur.gridx = 1;
        reglasSur.gridy = 1;
        reglasSur.insets = new Insets(10, 10, 10, 10);
        JPanel pboton= new JPanel();
        bCambiar = new JButton("Actualizar");
       // if (!CHANGE){
        bCambiar.setActionCommand(ISolicitudReporte.CAMBIAR); // Asigna un comando al botón
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

        // ComboBox para seleccionar el estado de la solicitud
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

    // Método para manejar la selección de estado en el ComboBox
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


    // Setter para el resultado de la consulta a la base de datos
    @Override
    public void setConsulta(ResultSet rs) {
        this.rs2=rs;
    }


    // Setter del controlador
    @Override
    public void setControlador(CSolicitudReporte a) {
        this.controlador= a;
    }


    // Método para mostrar la información de la solicitud en la vista
    @Override
    public void llamar(String idSo) {
        BdConex bd= new BdConex();
        this.rs2= bd.consultar("SELECT estudiante.NombresEs, solicitud.IdSo, solicitud.cedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON solicitud.CedulaEs = estudiante.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE IdSo= '"+idSo+ "';");
    }
    //, asignatura.idAs, NombreAs,  asignatura, materia, and asignatura.idAs = materia.idAs and materia.idMa = solicitud.materia

    // Método para activar la vista y mostrar la información de la solicitud
    @Override
    public void activar() {
        /*{while (rs.next())*/

        try {   rs2.first();
            System.out.println(rs2.getString("NombresEs"));
        lNombre.setText(rs2.getString("NombresEs"));
        lCedula.setText(rs2.getString("CedulaEs"));
        lCarrera.setText(rs2.getString("NombreCa"));
        lTipo.setText(rs2.getString("TipoTiSo"));
        //if(rs2.getString("estado").equals("1")) lEstado.setText("Resuelta");
            /*else*/ lEstado.setText(rs2.getString("EstadoSo"));
        if(rs2.getString("NombreAsignaturaAs")!=null) tDescripcion.setText(rs2.getString("NombreAsignaturaAs"));
        else tDescripcion.setText(rs2.getString("descripcionSo"));
        //if(rs2.getString("EstadoSo").equals("1")) cEstado.setSelectedItem("Resuelta");
            /*  else*/ cEstado.setSelectedItem(rs2.getString("EstadoSo"));
            this.setVisible(true);
} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter para el estado seleccionado
    @Override
    public String getEstado() {
       return (String) cEstado.getSelectedItem();
    }

    // Getter para el ID de la solicitud
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
