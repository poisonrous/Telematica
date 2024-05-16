package modelo;


// Clase MEvento representa un evento.
public class MEvento {
    // Atributos del evento
    private String titulo, organizador, descripcion, fecha, hora, lugar, modalidad, precio;

    // Constructor vacío de la clase MEvento.
    public MEvento() {}

    /**
     * Constructor de la clase MEvento.
     * @param titulo El título del evento.
     * @param organizador El organizador del evento.
     * @param descripcion La descripción del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param lugar El lugar del evento.
     * @param modalidad La modalidad del evento.
     * @param precio El precio del evento.
     */
    public MEvento(String titulo, String organizador, String descripcion, String fecha, String hora, String lugar, String modalidad, String precio) {
        this.titulo = titulo;
        this.organizador = organizador;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.modalidad = modalidad;
        this.precio = precio;
    }

    /**
     * Obtiene el título del evento.
     * @return El título del evento.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del evento.
     * @param titulo El título del evento a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el organizador del evento.
     * @return El organizador del evento.
     */
    public String getOrganizador() {
        return organizador;
    }

    /**
     * Establece el organizador del evento.
     * @param organizador El organizador del evento a establecer.
     */
    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    /**
     * Obtiene la descripción del evento.
     * @return La descripción del evento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     * @param descripcion La descripción del evento a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha del evento.
     * @return La fecha del evento.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento.
     * @param fecha La fecha del evento a establecer.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora del evento.
     * @return La hora del evento.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora del evento.
     * @param hora La hora del evento a establecer.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el lugar del evento.
     * @return El lugar del evento.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar del evento.
     * @param lugar El lugar del evento a establecer.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la modalidad del evento.
     * @return La modalidad del evento.
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Establece la modalidad del evento.
     * @param modalidad La modalidad del evento a establecer.
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * Obtiene el precio del evento.
     * @return El precio del evento.
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del evento.
     * @param precio El precio del evento a establecer.
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
