package controlador;

import modelo.Estudiante;
import modelo.MRegistro;
import vista.IRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CRegistro implements ActionListener {
    private IRegistro vista;
    private Estudiante estudiante;
    private MRegistro modelo;

    public CRegistro(IRegistro vista, Estudiante estudiante, MRegistro modelo) {
        this.vista = vista;
        this.estudiante = estudiante;
        this.modelo = modelo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(IRegistro.BUSCAR)) {
            buscar();
        } else if(e.getActionCommand().equals(IRegistro.CANCELAR)) {
            vista.limpiar();
        }
        if (e.getActionCommand().equals(IRegistro.REGISTRAR)) {
            registrar();
        }
        if (e.getActionCommand().equals(IRegistro.ACTUALIZAR)) {
            actualizar();
        }
    }


    public void buscar() {
        if (vista.getCedula().isBlank()){
            JOptionPane.showMessageDialog(null,"Por favor introduzca una cédula");
        }
        else{
        estudiante = modelo.buscarEstudiante(vista.getCedula());
        if(estudiante != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "Ya hay un usuario registrado con la cédula " + vista.getCedula() +", ¿desea modificarlo?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmacion == JOptionPane.YES_OPTION) {
                vista.habilitarActualizar();
                vista.cargarDatos(estudiante.getNombre(), estudiante.getApellido(), estudiante.getSexo(), estudiante.getFechaNacimiento(), estudiante.getCorreo(), estudiante.getTelefono(), estudiante.getDireccion(), estudiante.getCondicionesMedicas(), estudiante.getCapacidadEspecial(), estudiante.isTrabaja(), estudiante.isForaneo(), estudiante.isFuera());
            } else {
                vista.limpiar();
            }
        }
        else {
            int confirmacion = JOptionPane.showConfirmDialog(null, "No hay un usuario registrado con la cédula " + vista.getCedula() +", ¿desea registrar uno nuevo?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmacion == JOptionPane.YES_OPTION) {
                vista.habilitarRegistro();
            } else {
                vista.limpiar();
            }
        }
        }
    }

    public void registrar() {
        armarEstudiante();
        if (estudiante.getNombre().isBlank())
        {
        JOptionPane.showMessageDialog(null,"El campo nombre esta vacio");
        }
        else if  (estudiante.getApellido().isBlank()){
            JOptionPane.showMessageDialog(null,"El campo apellido esta vacio");
        }
        else if  (estudiante.getDireccion().isBlank()){
            JOptionPane.showMessageDialog(null,"El campo dirección esta vacio");
        }
        else if  (estudiante.getCorreo().isBlank() || !estudiante.getCorreo().contains("@") || !estudiante.getCorreo().contains(".")){
            JOptionPane.showMessageDialog(null,"Por favor agregar un correo apropiado");
        }
        else{
            JOptionPane.showMessageDialog(null, modelo.registrarEstudiante(estudiante));
            vista.limpiar();
        }
    }

    public void actualizar() {
        armarEstudiante();
        if (estudiante.getNombre().isBlank())
        {
            JOptionPane.showMessageDialog(null,"El campo nombre esta vacio");
        }
        else if  (estudiante.getApellido().isBlank()){
            JOptionPane.showMessageDialog(null,"El campo apellido esta vacio");
        }
        else if  (estudiante.getDireccion().isBlank()){
            JOptionPane.showMessageDialog(null,"El campo dirección esta vacio");
        }
        else if  (estudiante.getCorreo().isBlank() || !estudiante.getCorreo().contains("@") || !estudiante.getCorreo().contains(".")){
            JOptionPane.showMessageDialog(null,"Por favor agregar un correo apropiado");
        }
        else{
            armarEstudiante();
            JOptionPane.showMessageDialog(null, modelo.actualizarEstudiante(estudiante));
            vista.limpiar();
        }
    }

    private void armarEstudiante() {
        estudiante = new Estudiante();
        estudiante.setCedula(vista.getCedula().replace("'","''"));
        estudiante.setNombre(vista.getNombre().replace("'","''"));
        estudiante.setApellido(vista.getApellido().replace("'","''"));
        estudiante.setSexo(vista.getSexo().replace("'","''"));
        estudiante.setFechaNacimiento(vista.getFechaNacimiento().replace("'","''"));
        estudiante.setCorreo(vista.getCorreo().replace("'","''"));
        estudiante.setTelefono(vista.getTelefono().replace("'","''"));
        estudiante.setDireccion(vista.getDireccion().replace("'","''"));
        estudiante.setCondicionesMedicas(vista.getCondicionesMedicas().replace("'","''"));
        estudiante.setCapacidadEspecial(vista.getCapacidadEspecial().replace("'","''"));
        estudiante.setTrabaja(vista.isTrabaja());
        estudiante.setForaneo(vista.isForaneo());
        estudiante.setFuera(vista.isFuera());
        estudiante.setCarrera(vista.getCarrera());
    }
}
