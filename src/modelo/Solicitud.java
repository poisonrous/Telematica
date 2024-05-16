package modelo;

// Clase Solicitud representa una solicitud realizada por un usuario.
public class Solicitud {
    // Atributos
    private String tipo, materia, descripcion, usuario;
    private boolean estado;

    // Crea una nueva solicitud sin inicializar sus atributos.
    public Solicitud() {}

    /**
     * Constructor para crear una nueva solicitud con los valores especificados.
     * @param tipo El tipo de la solicitud.
     * @param materia La materia relacionada con la solicitud.
     * @param descripcion La descripción detallada de la solicitud.
     * @param usuario El usuario que realizó la solicitud.
     * @param estado El estado actual de la solicitud.
     */
    public Solicitud(String tipo, String materia, String descripcion, String usuario, boolean estado) {
        this.tipo = tipo;
        this.materia = materia;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.estado = estado;
    }

    /**
     * Devuelve el tipo de la solicitud.
     * @return El tipo de la solicitud.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la solicitud.
     * @param tipo El tipo de la solicitud.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la materia relacionada con la solicitud.
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

    /**
     * Devuelve la descripción de la solicitud.
     * @return La descripción de la solicitud.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la solicitud.
     * @param descripcion La descripción de la solicitud.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el usuario que realizó la solicitud.
     * @return El usuario que realizó la solicitud.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó la solicitud.
     * @param usuario El usuario que realizó la solicitud.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el estado actual de la solicitud.
     * @return true si la solicitud está activa, false si no.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la solicitud.
     * @param estado true para marcar la solicitud como activa, false para marcarla como inactiva.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
