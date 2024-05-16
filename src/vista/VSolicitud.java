package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import controlador.CSolicitud;
import modelo.BdConex;
import modelo.Materia;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

// Vista de solicitudes
public class VSolicitud extends JPanel implements ActionListener, ISolicitud, Printable {

    private JButton bEnviar, bImprimir, bRegresar;
    public JRadioButton rbAula, rbAcademico, rbInfraestructura, rbProfesor,rbDocente,rbAcoso, rbOtro;
    public ButtonGroup bgTipo;
    private JTextArea taDescripcion;
    private JComboBox cbMateria;
    private CSolicitud controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombre, lTelefono, lCorreo, lTipoS, lDescripcion, lFecha, lInformacion;

    // Constructor de VSolicitud
    public VSolicitud(){
    this.setPreferredSize(new Dimension(1085, 680));


        // Panel principal
        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setPreferredSize(new Dimension(1085, 680));
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));

		reglas.gridx = 1;
	    reglas.gridy = 1;
	    reglas.insets = new Insets(10, 10, 10, 10);
        // Título del sistema
        JLabel lTitulo = new JLabel("Sistema Telemática");
        lTitulo.setBackground(new Color(255, 255, 255));
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
       pPrincipal.add(lTitulo, reglas);

       JPanel pIconS = new JPanel();
       pIconS.setBackground(new Color(255, 255, 255));
       reglas.gridy = 2;
      
       JLabel lImagenSo = new JLabel();  
       lImagenSo.setSize(35, 35);
       ImageIcon iconS = new ImageIcon("media/problematica.png");
       Icon iconoSo = new ImageIcon(iconS.getImage().getScaledInstance(lImagenSo.getWidth(), lImagenSo.getHeight(), Image.SCALE_DEFAULT));
       lImagenSo.setIcon(iconoSo);
      pIconS.add(lImagenSo);
       JLabel lTipo = new JLabel("Envía tus Solicitudes");
       lTipo.setFont(new Font("Roboto", Font.BOLD, 16));
       pIconS.add(lTipo);
       pPrincipal.add(pIconS, reglas);

        // Panel del tipo de problema
        JPanel pTipo = new JPanel(new GridBagLayout());
        GridBagConstraints reglasTipo = new GridBagConstraints();
        pTipo.setBackground(new Color(255, 255, 255));
        reglasTipo.anchor = GridBagConstraints.WEST;

        // RadioButtons para los tipos de problema
        rbAula = new JRadioButton("Aula no asignada");
        rbAula.addActionListener(this);
        rbAula.setBackground(new Color(255, 255, 255));
        rbAula.setFont(new Font("Open Sans", Font.BOLD, 14));
        rbAula.setActionCommand(ISolicitud.MATERIA);
        pTipo.add(rbAula, reglasTipo);

        cbMateria = new JComboBox();
        pTipo.add(cbMateria, reglasTipo);
        cbMateria.setVisible(false);

        rbAcademico = new JRadioButton("Académico/administrativo");
        rbAcademico.addActionListener(this);
        rbAcademico.setBackground(new Color(255, 255, 255));
        rbAcademico.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 2;
        pTipo.add(rbAcademico, reglasTipo);
        
        rbInfraestructura = new JRadioButton("Fallas en infraestructura");
        rbInfraestructura.addActionListener(this);
        rbInfraestructura.setBackground(new Color(255, 255, 255));
        rbInfraestructura.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 3;
        pTipo.add(rbInfraestructura, reglasTipo);
        
        rbProfesor = new JRadioButton("Materia sin profesor");
        rbProfesor.addActionListener(this);
        rbProfesor.setBackground(new Color(255, 255, 255));
        rbProfesor.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 4;
        pTipo.add(rbProfesor, reglasTipo);
        
        rbDocente = new JRadioButton("Enseñanza del docente");
        rbDocente.addActionListener(this);
        rbDocente.setBackground(new Color(255, 255, 255));
        rbDocente.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 5;
        pTipo.add(rbDocente, reglasTipo);
        
        rbAcoso = new JRadioButton("Acoso");
        rbAcoso.addActionListener(this);
        rbAcoso.setBackground(new Color(255, 255, 255));
        rbAcoso.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 6;
        pTipo.add(rbAcoso, reglasTipo);
        
        rbOtro = new JRadioButton("Otro");
        rbOtro.addActionListener(this);
        rbOtro.setBackground(new Color(255, 255, 255));
        rbOtro.setFont(new Font("Open Sans", Font.BOLD, 14));
        reglasTipo.gridy = 7;
        pTipo.add(rbOtro, reglasTipo);

        // Agrupación de los RadioButtons
        bgTipo = new ButtonGroup();
        bgTipo.add(rbAula);
        bgTipo.add(rbAcademico);
        bgTipo.add(rbInfraestructura);
        bgTipo.add(rbProfesor);
        bgTipo.add(rbDocente);
        bgTipo.add(rbAcoso);
        bgTipo.add(rbOtro);
        reglas.gridy = 3;
        pPrincipal.add(pTipo, reglas);

        lInformacion= new JLabel("Aporta más información:");
        lInformacion.setFont(new Font("Open Sans", Font.BOLD, 16));
        reglas.gridy = 4;
        pPrincipal.add(lInformacion, reglas);

        // Área de texto para la descripción del problema
        taDescripcion = new JTextArea(); 
        taDescripcion.setPreferredSize(new Dimension(220, 200));
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        Validacion.validarLongitud(taDescripcion, 300);
        reglas.gridy = 5;
        pPrincipal.add(taDescripcion, reglas);

       /* cbMateria = new JComboBox();
        pPrincipal.add(cbMateria, reglas);
        cbMateria.setVisible(false);*/

        // Botón para enviar la solicitud
        bEnviar = new JButton("Enviar");
        bEnviar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bEnviar.setForeground(Color.WHITE);
        bEnviar.setBackground(new Color(2, 152, 178));
        bEnviar.setActionCommand(ISolicitud.ENVIAR);
        reglas.gridy = 6;
        reglas.gridx = 2;
        reglas.anchor = GridBagConstraints.WEST;
		    
        
        pPrincipal.add(bEnviar, reglas);
        pPrincipal.setVisible(true);
        
        JPanel pImagen = new JPanel(); 
        pImagen.setBackground(new Color(255, 255, 255));
    
      
        reglas.gridx = 2;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        reglas.gridheight = 5;
        
        reglas.anchor = GridBagConstraints.EAST;

        // Etiqueta para mostrar la imagen
        JLabel lImagen = new JLabel();  
        lImagen.setSize(500, 450);
        ImageIcon imagen = new ImageIcon("media/solucion.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
       // pPrincipal.add (pImagen, reglas);
        
        
       this.add(pPrincipal);

        // Creación de los paneles principal y de resultado
        pResultado = new JPanel(new GridBagLayout());
        pResultado.setBackground(new Color(255, 255, 255));
        pResultado.setVisible(false);
        GridBagConstraints reglasResultado = new GridBagConstraints();
       
        // Asignación de elementos a pPrincipal y a pResultado

        reglasResultado.gridx = 1;
        reglasResultado.gridy = 1;
        reglasResultado.insets = new Insets(10, 10, 10, 10);
        pResultado.add(lTitulo, reglasResultado);

        pDatos = new JPanel(new GridBagLayout());
        pDatos.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglasDatos = new GridBagConstraints();
        pDatos.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        reglasDatos.anchor = GridBagConstraints.WEST;
        
        
        
        reglasDatos.gridx = 0;
        reglasDatos.gridy = 0;
        reglasResultado.insets = new Insets(10, 10, 10, 10);
        JPanel pLogoUcla = new JPanel();
        pLogoUcla.setBackground(new Color(255, 255, 255));
        JLabel lLogoUcla = new JLabel();  
        lLogoUcla.setSize(75, 75);
        ImageIcon Logo = new ImageIcon("media/ucla.jpg");
        Icon LogoUcla = new ImageIcon(Logo.getImage().getScaledInstance(lLogoUcla.getWidth(), lLogoUcla.getHeight(), Image.SCALE_DEFAULT));
        lLogoUcla.setIcon(LogoUcla);
       pLogoUcla.add(lLogoUcla);
       pDatos.add(pLogoUcla, reglasDatos);
       
       reglasDatos.gridx = 1;
       reglasDatos.gridy = 0;
       //reglasDatos.fill = GridBagConstraints.HORIZONTAL;
       reglas.anchor = GridBagConstraints.EAST;
       JLabel layout = new JLabel("<html>REPÚBLICA BOLIVARIANA DE VENEZUELA <br>MINISTERIO DEL PODER POPULAR PARA LA <br>"
               + "EDUCACIÓN UNIVERSITARIA, CIENCIA Y TECNOLOGÍA <br>"
               + "UNIVERSIDAD CENTROCCIDENTAL 'LISANDRO ALVARADO' <br>"
               + "DECANATO DE CIENCIAS Y TECNOLOGÍA <br>"
               + "COORDINACIÓN DE INGENIERÍA TELEMÁTICA</html>");
       layout.setFont(new Font("Open Sans", Font.PLAIN, 10));
       pDatos.add(layout, reglasDatos);

       reglasDatos.gridx = 2;
       reglasDatos.gridy = 0;
       reglasResultado.insets = new Insets(10, 10, 10, 10);
       JPanel pLogoDcyt = new JPanel();
       pLogoDcyt.setBackground(new Color(255, 255, 255));
       JLabel lLogoDcyt = new JLabel();  
       lLogoDcyt.setSize(90, 90);
       ImageIcon LogoDcyt = new ImageIcon("media/LogoDcyt.png");
       Icon LogoDc = new ImageIcon(LogoDcyt.getImage().getScaledInstance(lLogoDcyt.getWidth(), lLogoDcyt.getHeight(), Image.SCALE_DEFAULT));
       lLogoDcyt.setIcon(LogoDc);
      pLogoDcyt.add(lLogoDcyt);
      pDatos.add(pLogoDcyt, reglasDatos);
      
      
      reglasDatos.gridx = 1;
      reglasDatos.gridy = 1;
      JLabel lSolicitud = new JLabel("SOLICITUD ENVIADA");
      lSolicitud.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lSolicitud.setFont(new Font("Open Sans", Font.BOLD, 14));
      pDatos.add(lSolicitud, reglasDatos);
      
      
        
        reglasDatos.gridx = 0;
        reglasDatos.gridy = 2;
        reglas.insets = new Insets(0, 0, 10, 0);
        JLabel lNombre2 = new JLabel("Nombre: ");
        
        lNombre2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lNombre2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lNombre2, reglasDatos);
       	
        reglasDatos.gridy = 3;
        reglas.insets = new Insets(0, 0, 10, 0);
        JLabel lTelefono2 = new JLabel("Teléfono: ");
        lTelefono2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lTelefono2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lTelefono2, reglasDatos);
       	
        reglasDatos.gridy = 4;
        reglas.insets = new Insets(0, 0, 10, 0);
        JLabel lCorreo2 = new JLabel("Correo Electrónico: ");
        lCorreo2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lCorreo2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lCorreo2, reglasDatos);
       	
        reglasDatos.gridy = 5;
        reglas.insets = new Insets(0, 0, 10, 0);
        JLabel lTipoR2 = new JLabel("Tipo: ");
        lTipoR2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lTipoR2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lTipoR2, reglasDatos);
       	
        reglasDatos.gridy = 6;
        reglas.insets = new Insets(0, 0, 10, 0);
        JLabel lDescri2 = new JLabel("Descripción: ");
        lDescri2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lDescri2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lDescri2, reglasDatos);
       	
        reglasDatos.gridy = 7;
        reglas.insets = new Insets(0, 0, 10, 10);
        JLabel lFechaC2 = new JLabel("Fecha de Creación: ");
        lFechaC2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lFechaC2.setFont(new Font("Open Sans", Font.BOLD, 14));
       	pDatos.add(lFechaC2, reglasDatos);
       	
       	
       	
       	reglasDatos.gridy = 8;
       	reglasDatos.gridwidth = GridBagConstraints.REMAINDER ;
       	reglasDatos.fill = GridBagConstraints.HORIZONTAL;
       	JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        pDatos.add(separator, reglasDatos);
       	
        reglasDatos.gridy = 9;
        reglas.insets = new Insets(0, 0, 10, 10);
        JLabel lSistema = new JLabel("Sistema Telecomunícate");
        lSistema.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lSistema.setFont(new Font("Open Sans", Font.BOLD, 11));
       	pDatos.add(lSistema, reglasDatos);
       	
       	reglasDatos.gridx = 1;
        reglasDatos.gridy = 9;
        reglas.insets = new Insets(0, 0, 10, 10);
        JLabel lDireccion2 = new JLabel("    AV. LAS INDUSTRIAS. NUCLEO OBELISCO. BARQUISIMETO-ESTADO LARA.");
        lDireccion2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        lDireccion2.setFont(new Font("Open Sans", Font.PLAIN, 11));
       	pDatos.add(lDireccion2, reglasDatos);

        /*lSolicitud = new JLabel("");
            reglasDatos.gridy = 1;
            pDatos.add(lSolicitud, reglasDatos);*/
         lNombre = new JLabel("");
         lNombre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridx = 1;
            reglasDatos.gridy = 2;
            pDatos.add(lNombre, reglasDatos);
            lTelefono = new JLabel("");
            lTelefono.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridy = 3;
            pDatos.add(lTelefono, reglasDatos);
         lCorreo = new JLabel("");
         lCorreo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridy = 4;
            pDatos.add(lCorreo, reglasDatos);
         lTipoS = new JLabel("");
         lTipoS.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridy = 5;
            pDatos.add(lTipoS, reglasDatos);
         lDescripcion = new JLabel("");
         lDescripcion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridy = 6;
            pDatos.add(lDescripcion, reglasDatos);
         lFecha = new JLabel("");
         lFecha.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            reglasDatos.gridy = 7;
            pDatos.add(lFecha, reglasDatos);
            
            
        //Botones inferiores post-creación
        reglasResultado.gridy = 3;
        pResultado.add(pDatos, reglasResultado);
        bImprimir= new JButton("Generar reporte de solicitud");
        bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bImprimir.setForeground(Color.WHITE);
        bImprimir.setBackground(new Color(2, 152, 178));
        bImprimir.addActionListener(this);
        reglasResultado.gridy = 4;
        pResultado.add(bImprimir, reglasResultado);

        bRegresar= new JButton("Regresar");
        bRegresar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bRegresar.setForeground(Color.WHITE);
        bRegresar.setBackground(new Color(2, 152, 178));
        bRegresar.addActionListener(this);
        reglasResultado.gridx = 1;
        reglasResultado.gridy = 5;
        pResultado.add(bRegresar, reglasResultado);


      //this.add(pResultado);

    }

    // Obtiene el tipo de solicitud seleccionado por el usuario
    @Override
    public void arrancar (){
        this.setVisible(true);
    }
    @Override
    public String getTipo(){
        if(rbAula.isSelected()){                //los tipos de solicitud son fijos; se asume que al agregar un nuevo tipo a la base de datos se corregirÃ¡ el cÃ³digo
            return "2";
        } else if(rbAcademico.isSelected()){
            return "1";
        } else if(rbInfraestructura.isSelected()){
            return "3";
        } else if(rbProfesor.isSelected()){
            return "4";
        } 
        else if(rbDocente.isSelected()){
            return "5";
        } 
        else if(rbAcoso.isSelected()){
            return "6";
        } 
        else if(rbOtro.isSelected()){
            return "7";
        }
        else {
            return "8";
        }
    }

        // Obtiene el nombre del tipo de solicitud seleccionado por el usuario
    @Override
    public String getTipoNombre() {
        //ESTO TIENE QUE CAMBIARSE PARA MANEJARLO COMO OBJETO TRAÍDO DESDE LA BASE DE DATOS
        if(rbAula.isSelected()){
            return "Aula no asignada";
        } else if(rbAcademico.isSelected()){
            return "Académico/administrativo";
        } else if(rbInfraestructura.isSelected()){
            return "Fallas en infraestructura";
        } else if(rbProfesor.isSelected()){
            return "Materia sin profesor";
        }
        else if(rbDocente.isSelected()){
            return "Enseñanza del docente";
        }
        else if(rbAcoso.isSelected()){
            return "Acoso";
        }
        else {
            return "Otro";
        }
    }

    // Obtiene la materia seleccionada por el usuario
    @Override
    public Object getMateria(){
        return cbMateria.getSelectedItem();
    }

    // Obtiene la descripción del problema ingresada por el usuario
    @Override
    public String getDescripcion(){
        return taDescripcion.getText();
    }

    // Obtiene la ruta de la imagen adjunta al problema
    @Override
    public String getImagen(){
        return null;
    }

        // Obtiene el usuario
    @Override
    public String getUsuario(){
        return null;
    }

    public void setControlador(CSolicitud c){
        controlador = c;
        bEnviar.addActionListener(c);
        rbAula.addActionListener(c);
    }

    // Acciones de botones
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        if (rbAula.isSelected()){ //solo cuando se seleccione el radio button de aula no asignada se mostrar¡ el combo box de materias y por tanto no es necesario el textfield
            cbMateria.setVisible(true);
            lInformacion.setVisible(false);
            taDescripcion.setVisible(false);
            taDescripcion.setText(""); //para que no se mantenga el texto que se haya escrito en el textfield y por tanto no se envÃ­e a la base de datos si la solicitud es de aula
        } else { //todas las demÃ¡s opciones requieren textfield pero no combobox
            cbMateria.setVisible(false);
            lInformacion.setVisible(true);
            taDescripcion.setVisible(true);
            cbMateria.removeAllItems(); //para que no se mantenga la materia seleccionada en el combobox y por tanto no se envÃ­e a la base de datos si la solicitud es de otro tipo
        }

        //Proceso de creación del PDF
        if(event.getSource()==bImprimir){
            String a ="";

            PreparedStatement ps = null;
            ResultSet rs = null;
            BdConex conn = new BdConex();
            Connection con = conn.getConexion();
            try {
                ps = con.prepareStatement("SELECT IdSo FROM solicitud where DescripcionSo = '"+lDescripcion.getText().replace("'","''")+"' and IdTiSo =  '"+ this.getTipo()+"' ");
                rs = ps.executeQuery();
                while (rs.next()) {
                    a=rs.getString("IdSo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ArrayList ALDescripcion = (ArrayList) Validacion.validarParrafo(lDescripcion.getText(), 20);
                PDDocument doc = new PDDocument();
                PDImageXObject plant = PDImageXObject.createFromFile("media/Plantilla.png", doc);
                PDPage reporte = new PDPage();
                doc.addPage(reporte);
                PDPageContentStream contentStream = new PDPageContentStream(doc, reporte);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD), 16);
                contentStream.drawImage(plant, 0, 0, reporte.getCropBox().getWidth(), reporte.getCropBox().getHeight());
                contentStream.beginText();
                contentStream.setLeading(16.0f);
                contentStream.newLineAtOffset(150, reporte.getCropBox().getHeight()-320);

                contentStream.showText("Nombre:      "+lNombre.getText());
                contentStream.newLine();
                contentStream.showText("Teléfono:    "+lTelefono.getText());
                contentStream.newLine();
                contentStream.showText("Correo Electrónico:      "+lCorreo.getText());
                contentStream.newLine();
                contentStream.showText("Tipo:     "+lTipoS.getText());
                contentStream.newLine();
                contentStream.showText("Descripción:     ");
                for (Object o : ALDescripcion) {
                    contentStream.showText(Validacion.validarError(o.toString()));
                    contentStream.newLine();
                    contentStream.showText("                         ");
                }
                contentStream.newLine();
                contentStream.showText("Fecha de creación: "+lFecha.getText());

                contentStream.endText();
                contentStream.close();
                Files.createDirectories(Paths.get(System.getProperty("user.home")+"/Desktop/telecomunícate"));
                doc.save(System.getProperty("user.home")+"/Desktop/telecomunícate/reporte" +a + ".pdf");
                doc.close();
                JOptionPane.showMessageDialog(null, "Su archivo se encuentra en el escritorio, carpeta telecomunícate");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

		if (event.getSource() == bRegresar) {
            taDescripcion.setText("");
            bgTipo.clearSelection();
			pResultado.setVisible(false);
			pPrincipal.setVisible(true);
		}
    }


    @Override
    public void cargarMaterias(String usuario) {
        // TODO Auto-generated method stub
        cbMateria.removeAllItems(); //hay antes para evitar que permanezcan cargadas materias de consultas anteriores (o se creen duplicados)
        String sql = "SELECT asignatura.NombreAsignaturaAs, materia.IdMa FROM asignatura INNER JOIN materia ON asignatura.IdAs = materia.IdAs INNER JOIN periodo ON materia.IdPe = periodo.IdPe INNER JOIN inscripcion ON materia.IdMa = inscripcion.IdMa WHERE periodo.VigenciaPe = 1 AND materia.BorradoMa = '0' AND inscripcion.CedulaEs = " + usuario;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = conn.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbMateria.addItem(new Materia(rs.getString("IdMa"),rs.getString("nombreAsignaturaAs"))); //aquÃ­ le estoy pidiendo que agregue cada materia que encuentre en la base de datos en coincidencia con la bÃºsqueda anterior
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Carga las materias disponibles en el ComboBox
    @Override
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String tipo, String descripcion, String fecha) {
        // TODO Auto-generated method stub
        //aquÃ­ se mostrarÃ¡ la pantalla de resultado
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
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        double marginLeft = 50.0;
        double marginTop = 50.0;
        double marginRight = 50.0;
        double marginBottom = 50.0;
        
        
        double paperWidth = pageFormat.getImageableWidth();
        double paperHeight = pageFormat.getImageableHeight();
        
        Graphics2D g2d = (Graphics2D) graphics;
        

        g2d.translate(pageFormat.getImageableX() + marginLeft, pageFormat.getImageableY() + marginTop);
        

        
       
        g2d.drawRect(0, 20, (int) (paperWidth - marginLeft - marginRight), (int) (paperHeight - marginTop - marginBottom - 20));
        
        pDatos.printAll(graphics);
       
        return Printable.PAGE_EXISTS;
    }
    
    
}