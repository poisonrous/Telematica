package vista;

import controlador.CPublicacion;
import controlador.CSugerencia;

public interface IPublicacion {
    String ENVIAR = "Enviar";
    void arrancar();
    void limpiar();
    String getTitulo();
    String getDescripcion();
    void setControlador(CPublicacion c);
 //   public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
