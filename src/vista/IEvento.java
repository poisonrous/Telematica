package vista;

public interface IEvento {
    public static String PUBLICAR = "publicar";
    public void setControlador(controlador.CEvento c);
    public void arrancar();
    public void limpiar();
    public String getTitulo();
    public String getOrganizador();
    public String getDescripcion();
    public String getFecha();
    public String getHora();
    public String getLugar();
    public String getModalidad();
    public String getPrecio();
}
