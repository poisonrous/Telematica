package vista;
import javax.swing.*;
import controlador.CSugerencia;

public interface ISugerencia {
    String ENVIAR = "Enviar";
    void arrancar();
    String getTitulo();
    String getDetalles();
    void setControlador(CSugerencia c);
    void mostrarResultado(String nombre, String apellido, String telefono, String correo, String sugerencia, String descripcion, String fecha);
}
