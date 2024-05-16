package vista;

// Interfaz que define los métodos para la gestión de eventos.
public interface IEvento {

    String PUBLICAR = "publicar";  // Constante para identificar el evento de publicar un evento.

    /**
     * Establece el controlador para esta interfaz.
     * @param c el controlador CEvento
     */
    void setControlador(controlador.CEvento c);
    void arrancar();  // Inicializa y muestra la vista de gestión de eventos.
    void limpiar();  // Limpia los campos de entrada de la vista.

    /**
     * Obtiene el título del evento ingresado por el usuario.
     * @return el título del evento
     */
    String getTitulo();  // Obtiene el título del evento ingresado por el usuario

    /**
     * Obtiene el nombre del organizador del evento ingresado por el usuario.
     * @return el nombre del organizador
     */
    String getOrganizador();

    /**
     * Obtiene la descripción del evento ingresada por el usuario
     * @return la descripción del evento
     */
    String getDescripcion();


    /**
     * Obtiene la fecha del evento ingresada por el usuario.
     * @return la fecha del evento
     */
    String getFecha();

    /**
     * Obtiene la hora del evento ingresada por el usuario.
     * @return la hora del evento
     */
    String getHora();

    /**
     * Obtiene el lugar del evento ingresado por el usuario
     * @return el lugar del evento
     */
    String getLugar();

    /**
     * Obtiene la modalidad del evento ingresada por el usuario.
     * @return la modalidad del evento
     */
    String getModalidad();

    /**
     * Obtiene el precio del evento ingresado por el usuario.
     * @return el precio del evento
     */
    String getPrecio();
}
