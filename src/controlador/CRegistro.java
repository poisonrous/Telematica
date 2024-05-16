package controlador;

import modelo.Estudiante;
import modelo.MRegistro;
import vista.IRegistro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// Controlador para la gestión del registro de estudiantes.

public class CRegistro implements ActionListener {
    private IRegistro vista;  // Vista del registro de estudiantes
    private Estudiante estudiante;  // Modelo de estudiante
    private MRegistro modelo;  // Modelo que maneja la lógica del registro

    /**
     * Constructor de la clase CRegistro.
     * @param vista Interfaz de registro.
     * @param estudiante Objeto Estudiante.
     * @param modelo Objeto MRegistro.
     */
    public CRegistro(IRegistro vista, Estudiante estudiante, MRegistro modelo) {
        this.vista = vista;
        this.estudiante = estudiante;
        this.modelo = modelo;
    }

    /**
     * Método para manejar los eventos de vista.
     * @param e el evento de acción.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar el comando del evento y realizar la acción correspondiente

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

    /**
     * Método para buscar un estudiante por su cédula.
     */

    public void buscar() {
        if (vista.getCedula().isBlank()){

            UIManager UI=new UIManager();
            UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
            UI.put("OptionPane.background", new Color (255,255,255));
            UI.put("Panel.background", new Color (255,255,255));
            UI.put("Button.background", new Color (3,150,177));
            UIManager.put("Button.foreground", Color.white);



            JOptionPane.showMessageDialog(null,"Por favor introduzca una cédula");
        }
        else{
        estudiante = modelo.buscarEstudiante(vista.getCedula());
        if(estudiante != null) {
            // Si el estudiante existe, mostrar opción de modificar o registrar nuevo
            int confirmacion = JOptionPane.showConfirmDialog(null, "Ya hay un usuario registrado con la cédula " + vista.getCedula() +", ¿desea modificarlo?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmacion == JOptionPane.YES_OPTION) {
                vista.habilitarActualizar();
                vista.cargarDatos(estudiante.getNombre(), estudiante.getApellido(), estudiante.getSexo(), estudiante.getFechaNacimiento(), estudiante.getCorreo(), estudiante.getTelefono(), estudiante.getDireccion(), estudiante.getCondicionesMedicas(), estudiante.getCapacidadEspecial(), estudiante.isTrabaja(), estudiante.isForaneo(), estudiante.isFuera());
            } else {
                vista.limpiar();
            }
        }
        else {
            // Si el estudiante no existe, mostrar opción de registrar nuevo
            int confirmacion = JOptionPane.showConfirmDialog(null, "No hay un usuario registrado con la cédula " + vista.getCedula() +", ¿desea registrar uno nuevo?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmacion == JOptionPane.YES_OPTION) {
                vista.habilitarRegistro();
            } else {
                vista.limpiar();
            }
        }
        }
    }

    /**
     * Método para registrar un nuevo estudiante.
     */

    public void registrar() {
        armarEstudiante();  // Crear un objeto Estudiante con los datos de la vista
        // Verificar los campos obligatorios y el formato del correo electrónico

        UIManager UI=new UIManager();
        UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
        UI.put("OptionPane.background", new Color (255,255,255));
        UI.put("Panel.background", new Color (255,255,255));
        UI.put("Button.background", new Color (3,150,177));
        UIManager.put("Button.foreground", Color.white);



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
            // Registrar al estudiante en la base de datos
            JOptionPane.showMessageDialog(null, modelo.registrarEstudiante(estudiante));
            vista.limpiar();
        }
    }

    /**
     * Método para actualizar los datos de un estudiante.
     */

    public void actualizar() {
        armarEstudiante(); // Crear un objeto Estudiante con los datos de la vista
        // Verificar los campos obligatorios y el formato del correo electrónico

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
            // Actualizar los datos del estudiante en la base de datos
            armarEstudiante();
            JOptionPane.showMessageDialog(null, modelo.actualizarEstudiante(estudiante));
            vista.limpiar();
        }
    }

    /**
     * Método para construir el objeto Estudiante a partir de los datos ingresados en la vista.
     */
    private void armarEstudiante() {
        estudiante = new Estudiante(); // Crear un nuevo objeto Estudiante
        // Obtener los datos de la vista y asignarlos al estudiante
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
