package vista;
import controlador.CEventos;

import javax.swing.JPanel;

public interface IEventos {
    void arrancar();
    void cargarEve(JPanel evento);
    void setControlador(CEventos controlador);
    JPanel getEvento(String titulo, String descripcion, String fecha, String hora, String lugar, String organizador, String modalidad, String precio);

}
