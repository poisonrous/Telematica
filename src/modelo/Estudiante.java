package modelo;

import javax.swing.*;

public class Estudiante {
    private String cedula, nombre, apellido, sexo, fechaNacimiento, correo, telefono, direccion, condicionesMedicas, capacidadEspecial, carrera, idCarrera;
    private boolean trabaja, foraneo, fuera;

    public Estudiante(String cedula, String nombre, String apellido, String sexo, String fechaNacimiento, String correo, String telefono, String direccion, String condicionesMedicas, String capacidadEspecial, boolean trabaja, boolean foraneo, boolean fuera, String carrera, String idCarrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.condicionesMedicas = condicionesMedicas;
        this.capacidadEspecial = capacidadEspecial;
        this.trabaja = trabaja;
        this.foraneo = foraneo;
        this.fuera = fuera;
        this.carrera = carrera;
        this.idCarrera = idCarrera;
    }

    public Estudiante() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCondicionesMedicas() {
        return condicionesMedicas;
    }

    public void setCondicionesMedicas(String condicionesMedicas) {
        this.condicionesMedicas = condicionesMedicas;
    }

    public String getCapacidadEspecial() {
        return capacidadEspecial;
    }

    public void setCapacidadEspecial(String capacidadEspecial) {
        this.capacidadEspecial = capacidadEspecial;
    }

    public boolean isTrabaja() {
        return trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

    public boolean isForaneo() {
        return foraneo;
    }

    public void setForaneo(boolean foraneo) {
        this.foraneo = foraneo;
    }

    public boolean isFuera() {
        return fuera;
    }

    public void setFuera(boolean fuera) {
        this.fuera = fuera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

}
