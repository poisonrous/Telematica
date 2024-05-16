package controlador;

import modelo.BdConex;
import modelo.MCrudServicio;
import modelo.Servicio;
import vista.IServicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// Controlador para la gestión de servicios.

public class CServicio implements ActionListener {
    private final IServicio vista;  // Vista de serivicio
    private final MCrudServicio modelo; // Modelo del CRUD de servicio

    /**
     * Constructor de CServicio.
     *
     * @param vista  Interfaz IServicio que interactúa con el usuario.
     * @param modelo Objeto MCrudServicio para realizar operaciones CRUD en la base de datos.
     */
    public CServicio(IServicio vista, MCrudServicio modelo){
        this.vista = vista;
        this.modelo = new MCrudServicio();
    }

    /**
     * Método para manejar los eventos de acciones en la vista.
     * @param e Evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(IServicio.ACTUALIZAR)){
            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);

            ImageIcon iconS = new ImageIcon("media/pregunta.png");

            int n = JOptionPane.showOptionDialog(null, "¿Está seguro de los datos ingresados?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconS, new Object[]{"Sí", "No"}, "Sí");
            if(n == JOptionPane.YES_OPTION)
            {if (vista.getCaso() == 1){
               PreparedStatement ps = null;
               ResultSet rs = null;
               BdConex conn = new BdConex();
               Connection con = conn.getConexion();
               try {
                   ps = con.prepareStatement("SELECT TipoSS FROM ServiciosSociales WHERE ServiciosSociales.TipoSS = '"+vista.getNombreServicio()+"'");
                   rs = ps.executeQuery();
                   rs.next();

                   UIManager UIS=new UIManager();
                   UIS.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
                   UIS.put("OptionPane.background", new Color (255,255,255));
                   UIS.put("Panel.background", new Color (255,255,255));
                   UIS.put("Button.background", new Color (3,150,177));
                   UIManager.put("Button.foreground", Color.white);



                   if (rs.getRow()>0) {JOptionPane.showMessageDialog(null, "Ya existe un servicio con ese nombre");}
                   else{
                   if (vista.getNombreServicio().isEmpty() || vista.getHorarioServicio().isEmpty() || vista.getUbicacionServicio().isEmpty()){
                       JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
                   }else{
                       modelo.crearServicio(vista.getNombreServicio(), vista.getHorarioServicio(), vista.getUbicacionServicio(), vista.getEstatusServicio());
                   }}
               } catch (Exception f) {
                   System.out.println(f);
               }

           } else if (vista.getCaso() == 2){
               if (vista.getNombreServicio().isEmpty() || vista.getHorarioServicio().isEmpty() || vista.getUbicacionServicio().isEmpty()){
                   JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
               }else{
                   modelo.modificarServicio(vista.getNombreServicio(), vista.getHorarioServicio(), vista.getUbicacionServicio(), vista.getEstatusServicio());
               }
           }
        } else JOptionPane.showMessageDialog(null,"No te preocupes, puedes seguir editando");} else if (comando.equals(IServicio.SELECCION)){
                Servicio servicio = modelo.buscarServicio(vista.getNombreServicio());
                vista.mostrarServicio(servicio.getHorarioServicio(), servicio.getUbicacionServicio(), servicio.getEstatusServicio());

        }
    }

    /**
     * Carga los servicios en la vista
     * @param vista Interfaz IServicio donde se cargarán los servicios.
     */
    public void cargarServicio(IServicio vista){
        Servicio modelo = new Servicio();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel<>(modelo.vectorServicio());
        ComboBoxModel cbm = dcbm;
        vista.cargarServicio(cbm);
    }

  /*  public void servicioSeleccion(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            String nombreServicio = vista.getNombreServicio();
            Servicio servicio = new Servicio();
            servicio = modelo.buscarServicio(nombreServicio);
            vista.mostrarServicio(servicio.getHorarioServicio(), servicio.getUbicacionServicio(), servicio.getEstatusServicio());
        }
    }*/
}
