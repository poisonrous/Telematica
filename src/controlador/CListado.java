package controlador;

import modelo.MListado;
import modelo.Materia;
import modelo.OModelo;
import vista.IListado;

import java.awt.event.ItemEvent;
import java.util.Objects;

// Controlador para la funcionalidad de listado de materias

public class CListado {
    private IListado vista; // Vista para el listado de materia
    private MListado modelo; // Modelo para el listado de materia
    private OModelo usuario; // Modelo de usuario


    /**
     * Constructor de la clase CListado.
     * @param vista La vista para el listado de materias.
     * @param modelo El modelo para el listado de materias.
     * @param usuario El modelo de usuario.
     */
    public CListado(IListado vista, MListado modelo, OModelo usuario) {
        this.vista = vista;
        this.modelo = modelo;
        this.usuario = usuario;
    }
    /**
     * Carga las materias asociadas al usuario en la vista.
     */
    public void cargarMaterias() {
        // Obtiene las materias asociadas al usuario y las carga en la vista
        vista.cargarMaterias(modelo.getMaterias(usuario.getUsuario()));
    }
    /**
     * Muestra el listado de estudiantes inscritos en una materia seleccionada.
     */

    public void mostrarListado() {
        // Obtiene la materia seleccionada en la vista
        Materia materia = (Materia) vista.getMateriaSeleccion();

            // Obtiene y muestra el listado de estudiantes inscritos en la materia seleccionad
            vista.mostrarListado(modelo.getListado(materia.getIdMateria()));

    }

    /**
     * Carga a todos los estudiantes en una tabla.
     */
    public void crearBigListado() {
        // Genera la tabla temporal para
        vista.mostrarBigListado(modelo.getBigListado());

    }
}
