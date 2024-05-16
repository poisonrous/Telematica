package modelo;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase MSolicitud es una solicitud que hace un usuario para participación en eventos o actividades.
public class MSolicitud {
    private String tipo, materia, descripcion, usuario, fecha, nombre, apellido, telefono, correo, tipoS;
    private boolean estado;

    // Constructor vacío de la clase MSolicitud
    public MSolicitud() {}

    /**
     * Constructor de la clase MSolicitud con parámetros.
     *
     * @param tipo Tipo de solicitud.
     * @param materia Materia relacionada con la solicitud.
     * @param descripcion Descripción de la solicitud.
     * @param usuario Usuario que realiza la solicitud.
     * @param fecha Fecha de la solicitud.
     * @param estado Estado de la solicitud.
     * @param nombre Nombre del usuario que realiza la solicitud.
     * @param apellido Apellido del usuario que realiza la solicitud.
     * @param telefono Teléfono del usuario que realiza la solicitud.
     * @param correo Correo electrónico del usuario que realiza la solicitud.
     * @param tipoS Tipo específico de solicitud.
     */
    public MSolicitud(String tipo, String materia, String descripcion, String usuario, String fecha, boolean estado, String nombre, String apellido, String telefono, String correo, String tipoS) {
        this.tipo = tipo;
        this.materia = materia;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoS = tipoS;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el tipo de la solicitud.
     * @return El tipo de la solicitud.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la solicitud
     * @param tipo El tipo de la solicitud.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la materia relacionada con la solicitud
     * @return La materia relacionada con la solicitud.
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Establece la materia relacionada con la solicitud.
     * @param materia La materia relacionada con la solicitud.
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }


    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la descripción detallada de la solicitud.
     * @return La descripción detallada de la solicitud.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador del usuario que realiza la solicitud
     * @return El identificador del usuario que realiza la solicitud
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el identificador del usuario que realiza la solicitud.
     * @param usuario El identificador del usuario que realiza la solicitud.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el estado de la solicitud
     * @return true si la solicitud está pendiente, false si está procesada.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la solicitud
     * @param estado true si la solicitud está pendiente, false si está procesada.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha en la que se realiza la solicitud
     * @return La fecha en la que se realiza la solicitud
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realiza la solicitud
     * @param fecha La fecha en la que se realiza la solicitud.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre del usuario que realiza la solicitud.
     * @return El nombre del usuario que realiza la solicitud.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del usuario que realiza la solicitud.
     * @return El apellido del usuario que realiza la solicitud.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el número de teléfono del usuario que realiza la solicitud.
     * @return El número de teléfono del usuario que realiza la solicitud.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del usuario que realiza la solicitud.
     * @return El correo electrónico del usuario que realiza la solicitud.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el tipo específico de la solicitud.
     * @return El tipo específico de la solicitud.
     */
    public String getTipoS() {
        return tipoS;
    }

    /**
     * Establece el nombre del usuario que realiza la solicitud.
     * @param nombre El nombre del usuario que realiza la solicitud.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del usuario que realiza la solicitud
     * @param apellido El apellido del usuario que realiza la solicitud.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el número de teléfono del usuario que realiza la solicitud.
     * @param telefono El número de teléfono del usuario que realiza la solicitud.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece el correo electrónico del usuario que realiza la solicitud.
     * @param correo El correo electrónico del usuario que realiza la solicitud.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Establece el tipo específico de la solicitud.
     * @param tipo El tipo específico de la solicitud.
     */
    public void setTipoS(String tipo) {
        this.tipoS = tipo;
    }

}
