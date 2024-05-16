package modelo;

// Clase MSugerencia es una sugerencia realizada por un usuario.
public class MSugerencia {
    private String titulo, descripcion, usuario, fecha, nombre, apellido, telefono, correo;

    // Constructor de la clase MSugerencia
    public MSugerencia() {}
    public MSugerencia(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el título de la sugerencia
     * @return El título de la sugerencia
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la sugerencia.
     * @param titulo El nuevo título de la sugerencia.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la sugerencia
     * @return La descripción de la sugerencia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la sugerencia.
     * @param descripcion La nueva descripción de la sugerencia.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Obtiene el nombre de usuario que realizó la sugerencia.
     * @return El nombre de usuario que realizó la sugerencia.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario que realizó la sugerencia.
     * @param usuario El nuevo nombre de usuario que realizó la sugerencia.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la fecha en que se realizó la sugerencia.
     * @return La fecha en que se realizó la sugerencia.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó la sugerencia.
     * @param fecha La nueva fecha en que se realizó la sugerencia.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre del usuario que realizó la sugerencia.
     * @return El nombre del usuario que realizó la sugerencia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario que realizó la sugerencia.
     * @param nombre El nuevo nombre del usuario que realizó la sugerencia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario que realizó la sugerencia.
     * @return El apellido del usuario que realizó la sugerencia.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario que realizó la sugerencia.
     * @param apellido El nuevo apellido del usuario que realizó la sugerencia.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono del usuario que realizó la sugerencia.
     * @return El teléfono del usuario que realizó la sugerencia.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario que realizó la sugerencia.
     * @param telefono El nuevo teléfono del usuario que realizó la sugerencia.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del usuario que realizó la sugerencia.
     * @return El correo electrónico del usuario que realizó la sugerencia.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario que realizó la sugerencia.
     * @param correo El nuevo correo electrónico del usuario que realizó la sugerencia.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
