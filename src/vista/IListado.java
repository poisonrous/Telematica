package vista;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;

public interface IListado {
    public void arrancar();
    public void cargarMaterias(ComboBoxModel cbmMaterias);
    public void materiaSeleccion(ItemEvent e);
    public Object getMateriaSeleccion();
    public void setControlador(controlador.CListado controlador);
    public void mostrarListado(ResultSet materias);
}
