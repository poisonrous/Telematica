package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;

public interface IServicio {
    String ACTUALIZAR = "Actualizar";
    String SELECCION = "Seleccion";
    void arrancar();
    void cargarServicio(ComboBoxModel cbmServicio);
    void servicioSeleccion(ItemEvent e);
    void mostrarServicio(String horario, String ubicacion, String estatus);

    void setControlador(CServicio controlador);
    int getCaso();

    String getNombreServicio();
    String getHorarioServicio();
    String getUbicacionServicio();
    String getEstatusServicio();
}
