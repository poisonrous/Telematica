package vista;
import javax.swing.*;
import controlador.CSugerencia;
import modelo.BdConex;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import vista.ISugerencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

// Vista de sugerencias
public class VSugerencia extends JPanel implements ActionListener, ISugerencia, Printable {
    private CSugerencia controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombreUser, lTelefonoUser, lCorreoUser, lSugerenciaUser, lDescripcionUser, lFechaUser;
    private JTextField tfTitulo;
    private JTextArea taDescripcion;
    private JButton bEnviar, bImprimir, bRegresar;

    // Constructor de la clase VSugerencias
    public VSugerencia() {
        this.setPreferredSize(new Dimension(1085, 680));

        this.setLayout(new BorderLayout());

        // Configuración del panel principal
        JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Roboto", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel para el título
        pTitulo.add(lTitulo);
        this.add(pTitulo, BorderLayout.NORTH);
        
        
        
      
      
        //CENTRO
        // Panel central para la interfaz de envío de sugerencias
        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 2));

        // Icono y título de la sección de sugerencias
        JPanel pIconSu = new JPanel();
        pIconSu.setBackground(new Color(255, 255, 255));
        reglas.gridy = 0;
        reglas.weighty= 1.0;
        reglas.gridheight=1;
        JLabel lImagenSu = new JLabel();  
        lImagenSu.setSize(35, 35);
        ImageIcon icon = new ImageIcon("media/sugerencias.png");
        Icon iconoSu = new ImageIcon(icon.getImage().getScaledInstance(lImagenSu.getWidth(), lImagenSu.getHeight(), Image.SCALE_DEFAULT));
        lImagenSu.setIcon(iconoSu);
       pIconSu.add(lImagenSu);
        JLabel lTipo = new JLabel("Envía tus Sugerencias");
        lTipo.setFont(new Font("Roboto", Font.BOLD, 16));
        pIconSu.add(lTipo);
        pPrincipal.add(pIconSu, reglas);


        // Campos para ingresar título y descripción de la sugerencia
        reglas.gridy = 1;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lTituloPublicacion = new JLabel("Título:");
        lTituloPublicacion.setFont(new Font("Open Sans", Font.BOLD, 14));
         pPrincipal.add(lTituloPublicacion, reglas);

         reglas.gridy = 2;
         reglas.weighty= 1.0;
        tfTitulo = new JTextField();  
        tfTitulo.setPreferredSize(new Dimension(200, 35));
        tfTitulo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        Validacion.validarLongitud(tfTitulo,45);
        
        pPrincipal.add(tfTitulo, reglas);


        reglas.gridy = 3;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lInformacion = new JLabel("Aporta más información:");
        lInformacion.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lInformacion, reglas);

        reglas.gridy = 4;
        reglas.weighty= 1.0;
        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(220, 200));
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        Validacion.validarLongitud(taDescripcion,300);
        pPrincipal.add(taDescripcion, reglas);
        
        reglas.gridy = 5;
        reglas.gridx = 1;
        reglas.weighty= 1.0;
        
        bEnviar = new JButton("Enviar");
        bEnviar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bEnviar.setForeground(Color.WHITE);
        bEnviar.setBackground(new Color(2, 152, 178));
        bEnviar.setActionCommand(ENVIAR);
        bEnviar.addActionListener(this);
        pPrincipal.add(bEnviar, reglas);
       
      JPanel pImagen = new JPanel(); 
      pImagen.setBackground(new Color(255, 255, 255));
  
    
      reglas.gridx = 1;
      reglas.gridy = 0;
      reglas.gridwidth = 1;
      reglas.gridheight = 5;
      
      reglas.anchor = GridBagConstraints.EAST;
    
      
      
      JLabel lImagen = new JLabel();  
      lImagen.setSize(500, 450);
      ImageIcon imagen = new ImageIcon("media/recursoSuge.jpg");
      Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
      lImagen.setIcon(icono);
      pImagen.add(lImagen);
      //pPrincipal.add (pImagen, reglas);

      this.add(pPrincipal);

        // Panel para mostrar el resultado de la sugerencia enviada
      pResultado = new JPanel(new GridBagLayout());
      pResultado.setBackground(new Color(255, 255, 255));
      pResultado.setVisible(false);
      GridBagConstraints reglasResultado = new GridBagConstraints();
     
      
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
    JLabel lSolicitud = new JLabel("SUGERENCIA ENVIADA");
    lSolicitud.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    lSolicitud.setFont(new Font("Open Sans", Font.BOLD, 14));
    pDatos.add(lSolicitud, reglasDatos);
    
    
      
      reglasDatos.gridx = 0;
      reglasDatos.gridy = 2;
      reglas.insets = new Insets(0, 0, 10, 0);
      JLabel lNombre = new JLabel("Nombre: ");
      
      lNombre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lNombre.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lNombre, reglasDatos);
     	
      reglasDatos.gridy = 3;
      reglas.insets = new Insets(0, 0, 10, 0);
      JLabel lTelefono = new JLabel("Teléfono: ");
      lTelefono.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lTelefono.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lTelefono, reglasDatos);
     	
      reglasDatos.gridy = 4;
      reglas.insets = new Insets(0, 0, 10, 0);
      JLabel lCorreo = new JLabel("Correo Electrónico: ");
      lCorreo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lCorreo.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lCorreo, reglasDatos);
     	
      reglasDatos.gridy = 5;
      reglas.insets = new Insets(0, 0, 10, 0);
      JLabel lSuge = new JLabel("Sugerencia: ");
      lSuge.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lSuge.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lSuge, reglasDatos);
     	
      reglasDatos.gridy = 6;
      reglas.insets = new Insets(0, 0, 10, 0);
      JLabel lDescri = new JLabel("Descripción: ");
      lDescri.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lDescri.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lDescri, reglasDatos);
     	
      reglasDatos.gridy = 7;
      reglas.insets = new Insets(0, 0, 10, 10);
      JLabel lFechaC = new JLabel("Fecha de Creación: ");
      lFechaC.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lFechaC.setFont(new Font("Open Sans", Font.BOLD, 14));
     	pDatos.add(lFechaC, reglasDatos);
     	
     	
     	
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
      JLabel lDireccion = new JLabel("    AV. LAS INDUSTRIAS. NUCLEO OBELISCO. BARQUISIMETO-ESTADO LARA.");
      lDireccion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
      lDireccion.setFont(new Font("Open Sans", Font.PLAIN, 11));
     	pDatos.add(lDireccion, reglasDatos);

      /*lSolicitud = new JLabel("");
          reglasDatos.gridy = 1;
          pDatos.add(lSolicitud, reglasDatos);*/
       lNombreUser = new JLabel("");
       lNombreUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridx = 1;
          reglasDatos.gridy = 2;
          pDatos.add(lNombreUser, reglasDatos);
          lTelefonoUser = new JLabel("");
          lTelefonoUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridy = 3;
          pDatos.add(lTelefonoUser, reglasDatos);
       lCorreoUser = new JLabel("");
       lCorreoUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridy = 4;
          pDatos.add(lCorreoUser, reglasDatos);
       lSugerenciaUser = new JLabel("");
       lSugerenciaUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridy = 5;
          pDatos.add(lSugerenciaUser, reglasDatos);
       lDescripcionUser = new JLabel("");
       lDescripcionUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridy = 6;
          pDatos.add(lDescripcionUser, reglasDatos);
       lFechaUser = new JLabel("");
       lFechaUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
          reglasDatos.gridy = 7;
          pDatos.add(lFechaUser, reglasDatos);



      //Botones inferiores post-creación
      reglasResultado.gridy = 3;
      pResultado.add(pDatos, reglasResultado);
      bImprimir= new JButton("Generar reporte de sugerencia");
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

    public void arrancar() {
        this.setVisible(true);
    } // Iniciar la vista

    // Métodos para obtener el título y descripción de la sugerencia ingresada por el usuario
    public String getTitulo() {
        return this.tfTitulo.getText();
    }

    // Métodos para obtener el detaller y descripción de la sugerencia ingresada por el usuario
    public String getDetalles() {
        return this.taDescripcion.getText();
    }

    // Setter para el controlador
    public void setControlador(CSugerencia c) {

        controlador = c;
        bEnviar.addActionListener(c);
    }

    // Método para mostrar el resultado de la sugerencia enviada
    @Override
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha) {
        lNombreUser.setText(nombre + " " + apellido);
        lTelefonoUser.setText(telefono);
        lCorreoUser.setText(correo);
        lSugerenciaUser.setText(sugerencia);
        lDescripcionUser.setText(descripcion);
        lFechaUser.setText(fecha);
        pPrincipal.setVisible(false);
        pResultado.setVisible(true);
        this.add(pResultado);
    }

    // Método para mostrar el resultado de la sugerencia enviada
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==bImprimir){
            String a ="";

            PreparedStatement ps = null;
            ResultSet rs = null;
            BdConex conn = new BdConex();
            Connection con = conn.getConexion();
            try {
                ps = con.prepareStatement("SELECT IdSu FROM sugerencia where DescripcionSu = '"+lDescripcionUser.getText().replace("'","''")+"'");
                rs = ps.executeQuery();
                while (rs.next()) {
                    a=rs.getString("IdSu");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ArrayList ALDescripcion = (ArrayList) Validacion.validarParrafo(lDescripcionUser.getText(), 20);

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

                contentStream.showText("Nombre:      "+lNombreUser.getText());
                contentStream.newLine();
                contentStream.showText("Teléfono:    "+lTelefonoUser.getText());
                contentStream.newLine();
                contentStream.showText("Correo Electrónico:      "+lCorreoUser.getText());
                contentStream.newLine();
                contentStream.showText("Sugerencia:      "+lSugerenciaUser.getText());
                contentStream.newLine();
                contentStream.showText("Descripción:  ");
                for (Object o : ALDescripcion) {
                    contentStream.showText(Validacion.validarError(o.toString()));
                    contentStream.newLine();
                    contentStream.showText("                         ");
                }
                contentStream.newLine();
                contentStream.showText("Fecha de creación: "+lFechaUser.getText());

                contentStream.endText();
                contentStream.close();
                Files.createDirectories(Paths.get(System.getProperty("user.home")+"/Desktop/telecomunícate"));
                doc.save(System.getProperty("user.home")+"/Desktop/telecomunícate/Sugerencia" +a + ".pdf");
                doc.close();
                JOptionPane.showMessageDialog(null, "Su archivo se encuentra en el escritorio, carpeta telecomunícate");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // Acción para regresar a la pantalla principal de envío de sugerencias
		if (event.getSource() == bRegresar) {
            tfTitulo.setText("");
            taDescripcion.setText("");
			pResultado.setVisible(false);
			pPrincipal.setVisible(true);
		}
    }

    // Método para imprimir el contenido de la sugerencia
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
	