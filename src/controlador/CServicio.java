package controlador;

import modelo.BdConex;
import modelo.MCrudServicio;
import modelo.Servicio;
import vista.IServicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CServicio implements ActionListener {
    private final IServicio vista;
    private final MCrudServicio modelo;

    public CServicio(IServicio vista, MCrudServicio modelo){
        this.vista = vista;
        this.modelo = new MCrudServicio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(IServicio.ACTUALIZAR)){
            int n = JOptionPane.showOptionDialog(null, "¿Está seguro de los datos ingresados?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");
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
