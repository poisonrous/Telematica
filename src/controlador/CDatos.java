package controlador;
import modelo.*;
import vista.IDatos;

import java.awt.event.ActionEvent;

// Controlador para la funcionalidad de datos.



public class CDatos {
    private final IDatos vista;     // Vista de los datos
    private final MDatos modulo;    // Modelo de los datos
    public CDatos (IDatos vista, MDatos modulo) {
        this.vista=vista;
        this.modulo=modulo;
    }

    /**
     * Maneja los eventos de acción generados por la vista.
     * @param e El evento de acción.
     */

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vista.DATOS))    //// Verifica si la acción es del tipo DATOS
            modulo.rellenar();      // Llama al método rellenar del modelo para cargar los datos
        // Muestra los datos en la vista
            vista.mostrar(modulo.getTipoFN(),modulo.getTipoF(),modulo.getEstudianteSo(),modulo.getEstudianteSu(),modulo.getSolicitudM(),modulo.getSugerenciaM(),modulo.getSolicitudPercent(), modulo.getMaterias());
    }
    }

