package vista;
import javax.swing.*;
import controlador.CSugerencia;
import vista.ISugerencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VSugerencia extends JPanel implements ActionListener, ISugerencia, Printable {
    private CSugerencia controlador;
    private JPanel pPrincipal, pResultado, pDatos;
    private JLabel lNombreUser, lTelefonoUser, lCorreoUser, lSugerenciaUser, lDescripcionUser, lFechaUser;
    private JTextField tfTitulo;
    private JTextArea taDescripcion;
    private JButton bEnviar, bImprimir;

    public VSugerencia() {
        this.setLayout(new BorderLayout());

        JPanel pTitulo = new JPanel();
        pTitulo.setBackground(new Color(255, 255, 255));
        JLabel lTitulo = new JLabel("TELECOMUNÍCATE", JLabel.CENTER);
        lTitulo.setFont(new Font("Roboto", Font.BOLD, 16));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        pTitulo.add(lTitulo);
        this.add(pTitulo, BorderLayout.NORTH);
        
        
        
      
      
        //CENTRO
        
        pPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 2));
        
        
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
        
        pPrincipal.add(tfTitulo, reglas);
        
      
        reglas.gridy = 3;
        reglas.weighty= 1.0;
        reglas.anchor = GridBagConstraints.WEST;
        JLabel lInformacion = new JLabel("Descripción:");
        lInformacion.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lInformacion, reglas);

        reglas.gridy = 4;
        reglas.weighty= 1.0;
        taDescripcion = new JTextArea();
        taDescripcion.setPreferredSize(new Dimension(220, 200));
        taDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taDescripcion.setLineWrap(true);
        taDescripcion.setWrapStyleWord(true);
        pPrincipal.add(taDescripcion, reglas);
        
        reglas.gridy = 5;
        reglas.gridx = 1;
        reglas.weighty= 1.0;
        
        bEnviar = new JButton("Enviar");
        bEnviar.setFont(new Font("Open Sans", Font.PLAIN, 15));
        bEnviar.setForeground(Color.WHITE);
        bEnviar.setBackground(new Color(0, 125, 254));
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
      pPrincipal.add (pImagen, reglas); 

      this.add(pPrincipal);
      
    //AQUÍ CREARÁ LA PANTALLA DE RESULTADO
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
          
          
          
          
      

      reglasResultado.gridy = 3;
      pResultado.add(pDatos, reglasResultado);
      bImprimir= new JButton("Imprimir");
      bImprimir.setFont(new Font("Open Sans", Font.PLAIN, 15));
      bImprimir.setForeground(Color.WHITE);
      bImprimir.setBackground(new Color(0, 125, 254));
      bImprimir.addActionListener(this);
      reglasResultado.gridy = 4;
      pResultado.add(bImprimir, reglasResultado);

    //this.add(pResultado);
    }

    public void arrancar() {
        this.setVisible(true);
    }

    public String getTitulo() {
        return this.tfTitulo.getText();
    }

    public String getDetalles() {
        return this.taDescripcion.getText();
    }

    public void setControlador(CSugerencia c) {

        controlador = c;
        bEnviar.addActionListener(c);
    }
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

    @Override
    public void actionPerformed(ActionEvent event) {
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
	