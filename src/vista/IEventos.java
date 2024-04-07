package vista;
import controlador.CEventos;

import javax.swing.JPanel;

public interface IEventos {
    public void arrancar();
    public void cargarEve(JPanel evento);
    public void setControlador(CEventos controlador);
    public JPanel getEvento(String titulo, String descripcion, String fecha, String hora, String lugar, String organizador, String modalidad, String precio);

}
