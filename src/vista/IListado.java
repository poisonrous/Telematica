package vista;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;

 // Interfaz para la pantalla de listado de materias.

public interface IListado {     // Inicializa y muestra la pantalla de listado de materias.
    public void arrancar();

    /**
     * Carga las materias en un componente JComboBox.
     * @param cbmMaterias El modelo de ComboBox a cargar con las materias.
     */
    public void cargarMaterias(ComboBoxModel cbmMaterias);

    /**
     * M�todo invocado cuando se selecciona una materia en el ComboBox.
     * @param e El evento de selecci�n de un �tem.
     */
    public void materiaSeleccion(ItemEvent e);

    /**
     * Obtiene la materia seleccionada en el ComboBox.
     * @return El objeto que representa la materia seleccionada.
     */
    public Object getMateriaSeleccion();

    /**
     * Establece el controlador para esta interfaz.
     * @param controlador El controlador asociado a esta interfaz.
     */
    public void setControlador(controlador.CListado controlador);

    /**
     * Muestra el listado de materias en la interfaz.
     * @param materias El conjunto de resultados que contiene la informaci�n de las materias a mostrar.
     */
    public void mostrarListado(ResultSet materias);

    public void mostrarBigListado(ResultSet materias);
}
