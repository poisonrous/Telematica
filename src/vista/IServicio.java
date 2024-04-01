package vista;

import controlador.CServicio;

import javax.swing.*;
import java.awt.event.ItemEvent;

public interface IServicio {
    public static String ACTUALIZAR = "Actualizar";
    public static String SELECCION = "Seleccion";
    public void arrancar();
    public void cargarServicio(ComboBoxModel cbmServicio);
    public void servicioSeleccion(ItemEvent e);
    public void mostrarServicio(String horario, String ubicacion, String estatus);

    public void setControlador(CServicio controlador);
    public int getCaso();

    public String getNombreServicio();
    public String getHorarioServicio();
    public String getUbicacionServicio();
    public String getEstatusServicio();
}
