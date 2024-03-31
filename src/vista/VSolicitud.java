package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import controlador.CSolicitud;
import modelo.BdConex;
import modelo.Materia;

public class VSolicitud extends JFrame implements ActionListener, ISolicitud, Printable {

    private JButton bEnviar, bImprimir;
    public JRadioButton rbAula, rbAcademico, rbInfraestructura, rbProfesor, rbOtro;
    private JTextArea taDescripcion;
    private JComboBox cbMateria;
    private CSolicitud controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombre, lTelefono, lCorreo, lTipoS, lDescripcion, lFecha;
    public VSolicitud(){

        super("Envío de problemáticas");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();


        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        JLabel lTitulo = new JLabel("Sistema Telemática");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pPrincipal.add(lTitulo, reglas);

        JLabel lTipo = new JLabel("Tipo de problema");
        lTipo.setFont(new Font("Arial", Font.BOLD, 14));
        reglas.gridy = 2;
        pPrincipal.add(lTipo, reglas);

        JPanel pTipo = new JPanel(new GridBagLayout());
        GridBagConstraints reglasTipo = new GridBagConstraints();
        rbAula = new JRadioButton("Aula no asignada");
        rbAula.addActionListener(this);
        rbAula.setActionCommand(ISolicitud.MATERIA);
        pTipo.add(rbAula, reglasTipo);
        rbAcademico = new JRadioButton("Académico/administrativo");
        rbAcademico.addActionListener(this);
        reglasTipo.gridy = 2;
        pTipo.add(rbAcademico, reglasTipo);
        rbInfraestructura = new JRadioButton("Fallas en infraestructura");
        rbInfraestructura.addActionListener(this);
        reglasTipo.gridy = 3;
        pTipo.add(rbInfraestructura, reglasTipo);
        rbProfesor = new JRadioButton("Materia sin profesor");
        rbProfesor.addActionListener(this);
        reglasTipo.gridy = 4;
        pTipo.add(rbProfesor, reglasTipo);
        rbOtro = new JRadioButton("Otro");
        rbOtro.addActionListener(this);
        reglasTipo.gridy = 5;
        pTipo.add(rbOtro, reglasTipo);
        ButtonGroup bgTipo = new ButtonGroup();
        bgTipo.add(rbAula);
        bgTipo.add(rbAcademico);
        bgTipo.add(rbInfraestructura);
        bgTipo.add(rbProfesor);
        bgTipo.add(rbOtro);
        reglas.gridy = 3;
        pPrincipal.add(pTipo, reglas);

        JLabel lInformacion= new JLabel("Aporta más información");
        reglas.gridy = 4;
        pPrincipal.add(lInformacion, reglas);

        taDescripcion = new JTextArea(5, 20); //ya haré algo con esto después, porque se extiende indefinidamente y no salta de línea
      //  taDescripcion.setPreferredSize(new Dimension(200, 50));
        reglas.gridy = 5;
        pPrincipal.add(taDescripcion, reglas);

        cbMateria = new JComboBox();
        pPrincipal.add(cbMateria, reglas);
        cbMateria.setVisible(false);
        bEnviar = new JButton("Enviar");
        bEnviar.setActionCommand(ISolicitud.ENVIAR);
        reglas.gridy = 6;
        pPrincipal.add(bEnviar, reglas);
        pPrincipal.setVisible(true);
        this.add(pPrincipal);

        //AQUÍ CREARÉ LA PANTALLA DE RESULTADO
        pResultado = new JPanel(new GridBagLayout());
        pResultado.setVisible(false);
        GridBagConstraints reglasResultado = new GridBagConstraints();
        reglasResultado.gridx = 1;
        reglasResultado.gridy = 1;
        reglasResultado.insets = new Insets(10, 10, 10, 10);
        pResultado.add(lTitulo, reglasResultado);
        JLabel lSolicitud = new JLabel("Solicitud enviada");
        lSolicitud.setFont(new Font("Arial", Font.BOLD, 14));
        reglasResultado.gridy = 2;
        pResultado.add(lSolicitud, reglasResultado);;
        pDatos = new JPanel(new GridBagLayout());
        GridBagConstraints reglasDatos = new GridBagConstraints();
        reglasDatos.gridx = 1;
        reglasDatos.gridy = 1;
        pDatos.add(new JLabel("Nombre: "), reglasDatos);
        reglasDatos.gridy = 2;
        pDatos.add(new JLabel("Teléfono: "), reglasDatos);
        reglasDatos.gridy = 3;
        pDatos.add(new JLabel("Correo: "), reglasDatos);
        reglasDatos.gridy = 4;
        pDatos.add(new JLabel("Tipo: "), reglasDatos);
        reglasDatos.gridy = 5;
        pDatos.add(new JLabel("Descripción: "), reglasDatos);
        reglasDatos.gridy = 6;
        pDatos.add(new JLabel("Fecha de creación: "), reglasDatos);

        /* lSolicitud = new JLabel("");
            reglasDatos.gridy = 1;
            pDatos.add(lSolicitud, reglasDatos);*/
         lNombre = new JLabel("");
            reglasDatos.gridx = 2;
            reglasDatos.gridy = 1;
            pDatos.add(lNombre, reglasDatos);
         lTelefono = new JLabel("");
            reglasDatos.gridy = 2;
            pDatos.add(lTelefono, reglasDatos);
         lCorreo = new JLabel("");
            reglasDatos.gridy = 3;
            pDatos.add(lCorreo, reglasDatos);
         lTipoS = new JLabel("");
            reglasDatos.gridy = 4;
            pDatos.add(lTipoS, reglasDatos);
         lDescripcion = new JLabel("");
            reglasDatos.gridy = 5;
            pDatos.add(lDescripcion, reglasDatos);
         lFecha = new JLabel("");
            reglasDatos.gridy = 6;
            pDatos.add(lFecha, reglasDatos);

        reglasResultado.gridy = 3;
        pResultado.add(pDatos, reglasResultado);
        bImprimir= new JButton("Imprimir");
        bImprimir.addActionListener(this);
        reglasResultado.gridy = 4;
        pResultado.add(bImprimir, reglasResultado);

     //   this.add(pResultado);

    }
    @Override
    public void arrancar (){
        this.setVisible(true);
    }
    @Override
    public String getTipo(){
        if(rbAula.isSelected()){                //los tipos de solicitud son fijos; se asume que al agregar un nuevo tipo a la base de datos se corregirá el código
            return "1";
        } else if(rbAcademico.isSelected()){
            return "2";
        } else if(rbInfraestructura.isSelected()){
            return "3";
        } else if(rbProfesor.isSelected()){
            return "4";
        } else {
            return "5";
        }
    }
    @Override
    public Object getMateria(){
        return cbMateria.getSelectedItem();
    }
    @Override
    public String getDescripcion(){
        return taDescripcion.getText();
    }
    @Override
    public String getImagen(){
        return null;
    }
    @Override
    public String getUsuario(){
        return null;
    }

    public void setControlador(CSolicitud c){
        controlador = c;
        bEnviar.addActionListener(c);
        rbAula.addActionListener(c);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        if (rbAula.isSelected()){ //solo cuando se seleccione el radio button de aula no asignada se mostrará el combo box de materias y por tanto no es necesario el textfield
            cbMateria.setVisible(true);
            taDescripcion.setVisible(false);
            taDescripcion.setText(""); //para que no se mantenga el texto que se haya escrito en el textfield y por tanto no se envíe a la base de datos si la solicitud es de aula
        } else { //todas las demás opciones requieren textfield pero no combobox
            cbMateria.setVisible(false);
            taDescripcion.setVisible(true);
            cbMateria.removeAllItems(); //para que no se mantenga la materia seleccionada en el combobox y por tanto no se envíe a la base de datos si la solicitud es de otro tipo
        }
        if(event.getSource()==bImprimir){
            try {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this);
                job.printDialog();
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(VSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void cargarMaterias(String usuario) {
        // TODO Auto-generated method stub
        cbMateria.removeAllItems(); //hay antes para evitar que permanezcan cargadas materias de consultas anteriores (o se creen duplicados)
        String sql = "SELECT asignatura.NombreAs, materia.idMA FROM asignatura INNER JOIN materia ON asignatura.idAs = materia.idAs INNER JOIN periodo ON materia.idPe = periodo.idPe INNER JOIN inscripcion ON materia.idMA = inscripcion.idMa WHERE periodo.estatusPe = 1 AND inscripcion.CedulaUs = " + usuario;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbMateria.addItem(new Materia(rs.getString("idMA"),rs.getString("nombreAs"))); //aquí le estoy pidiendo que agregue cada materia que encuentre en la base de datos en coincidencia con la búsqueda anterior
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String tipo, String descripcion, String fecha) {
        // TODO Auto-generated method stub
        //aquí se mostrará la pantalla de resultado
        pPrincipal.setVisible(false);
        pResultado.setVisible(true);
        this.add(pResultado);
        lNombre.setText(nombre + " " + apellido);
        lTelefono.setText(telefono);
        lCorreo.setText(correo);
        lTipoS.setText(tipo);
        lFecha.setText(fecha);
        lDescripcion.setText(descripcion);
        //JOptionPane.showMessageDialog(null, "Nombre: "+nombre+" "+apellido+"\nTelefono: "+telefono+"\nCorreo: "+correo+"\nTipo: "+tipo+"\nDescripcion: "+descripcion+"\nFecha: "+fecha);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based (este código me lo robé, qué les digo)*/
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        pDatos.printAll(graphics);

        return PAGE_EXISTS;
    }
}
