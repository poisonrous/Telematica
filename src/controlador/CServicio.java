package controlador;

import modelo.MCrudServicio;
import modelo.Servicio;
import vista.IServicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

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
           if (vista.getCaso() == 1){
               if (vista.getNombreServicio().length() == 0 || vista.getHorarioServicio().length() == 0 || vista.getUbicacionServicio().length() == 0){
                   JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
               }else{
                   modelo.crearServicio(vista.getNombreServicio(), vista.getHorarioServicio(), vista.getUbicacionServicio(), vista.getEstatusServicio());
               }
           } else {
               if (vista.getNombreServicio().length() == 0 || vista.getHorarioServicio().length() == 0 || vista.getUbicacionServicio().length() == 0){
                   JOptionPane.showMessageDialog(null, "Uno o más de los campos están vacíos.");
               }else{
                   modelo.modificarServicio(vista.getNombreServicio(), vista.getHorarioServicio(), vista.getUbicacionServicio(), vista.getEstatusServicio());
               }
           }
        } else if (comando.equals(IServicio.SELECCION)){
                Servicio servicio = modelo.buscarServicio(vista.getNombreServicio());
                vista.mostrarServicio(servicio.getHorarioServicio(), servicio.getUbicacionServicio(), servicio.getEstatusServicio());
            //}
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
