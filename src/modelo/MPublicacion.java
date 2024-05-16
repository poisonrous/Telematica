package modelo;

// Clase MPublicacion representa una publicación realizada por un usuario en el sistema.
public class MPublicacion {
    private String usuario, nombre, apellido, titulo, descripcion, fecha;

    // Constructor de la clase MPublicacion, para crear objetos sin datos iniciales
    public MPublicacion() {}

    /**
     * Constructor de la clase MPublicacion.
     * @param usuario Nombre de usuario del autor de la publicación.
     * @param nombre Nombre del autor de la publicación.
     * @param apellido Apellido del autor de la publicación.
     * @param titulo Título de la publicación.
     * @param descripcion Descripción de la publicación.
     * @param fecha Fecha de la publicación.
     */
    public MPublicacion(String usuario, String nombre, String apellido, String titulo, String descripcion, String fecha) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre de usuario del autor de la publicación.
     * @return El nombre de usuario del autor.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del autor de la publicación.
     * @param usuario El nombre de usuario a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el nombre del autor de la publicación.
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor de la publicación.
     * @param nombre El nombre del autor a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del autor de la publicación.
     * @return El apellido del autor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del autor de la publicación.
     * @param apellido El apellido del autor a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el título de la publicación.
     * @return El título de la publicación.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     * @param titulo El título de la publicación a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la publicación.
     * @return La descripción de la publicación.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la publicación.
     * @param descripcion La descripción de la publicación a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de la publicación.
     * @return La fecha de la publicación.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la publicación.
     * @param fecha La fecha de la publicación a establecer.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
