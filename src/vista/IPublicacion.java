package vista;

import controlador.CPublicacion;
import controlador.CSugerencia;

public interface IPublicacion {
    public static String ENVIAR = "Enviar";
    public void arrancar();
    public void limpiar();
    public String getTitulo();
    public String getDescripcion();
    public void setControlador(CPublicacion c);
 //   public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
