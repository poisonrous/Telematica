package controlador;

import modelo.MListado;
import modelo.Materia;
import modelo.OModelo;
import vista.IListado;

import java.awt.event.ItemEvent;

public class CListado {
    private IListado vista;
    private MListado modelo;
    private OModelo usuario;

    public CListado(IListado vista, MListado modelo, OModelo usuario) {
        this.vista = vista;
        this.modelo = modelo;
        this.usuario = usuario;
    }

    public void cargarMaterias() {
        vista.cargarMaterias(modelo.getMaterias(usuario.getUsuario()));
    }

    public void mostrarListado() {
        Materia materia = (Materia) vista.getMateriaSeleccion();
        vista.mostrarListado(modelo.getListado(materia.getIdMateria()));
    }

}
