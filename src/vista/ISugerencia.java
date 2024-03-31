package vista;
import javax.swing.*;
import controlador.CSugerencia;

public interface ISugerencia {
    public static String ENVIAR = "Enviar";
    public void arrancar();
    public String getTitulo();
    public String getDetalles();
    public void setControlador(CSugerencia c);
    public void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
