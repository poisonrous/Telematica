package controlador;
import modelo.*;
import vista.IDatos;

import java.awt.event.ActionEvent;

public class CDatos {
    private final IDatos vista;
    private final MDatos modulo;
    public CDatos (IDatos vista, MDatos modulo) {
        this.vista=vista;
        this.modulo=modulo;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vista.DATOS))
            modulo.rellenar();
            vista.mostrar(modulo.getTipoFN(),modulo.getTipoF(),modulo.getEstudianteSo(),modulo.getEstudianteSu(),modulo.getSolicitudM(),modulo.getSugerenciaM(),modulo.getSolicitudPercent(), modulo.getMaterias());
    }
    }

