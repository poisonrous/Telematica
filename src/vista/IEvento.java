package vista;

public interface IEvento {
    String PUBLICAR = "publicar";
    void setControlador(controlador.CEvento c);
    void arrancar();
    void limpiar();
    String getTitulo();
    String getOrganizador();
    String getDescripcion();
    String getFecha();
    String getHora();
    String getLugar();
    String getModalidad();
    String getPrecio();
}
