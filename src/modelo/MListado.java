package modelo;

import javax.swing.*;
import java.sql.ResultSet;

public class MListado {
    private BdConex bd;
    private ResultSet rs;
    public ComboBoxModel getMaterias(String usuario) {
        /* bd = new BdConex();
        rs = bd.consultar("SELECT * FROM materia INNER JOIN asignatura ON materia.IdAs = asignatura.IdAs INNER JOIN periodo ON materia.IdPe = periodo.IdPe WHERE periodo.VigenciaPe = 1 AND CedulaPr = " + usuario);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                model.addElement(rs.getString("NombreAsignaturaAs"));
            }
        } catch (Exception e) {
            e.printStackTrace();
    }*/
        Materia materia = new Materia();
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(materia.vectorMateriaProfesor(usuario));
        ComboBoxModel cbmMaterias = model;
    return cbmMaterias;
    }

    public ResultSet getListado(Object materia) {
        String idMa = materia.toString();
        bd = new BdConex();
        rs = bd.consultar("SELECT * FROM estudiante INNER JOIN inscripcion ON estudiante.CedulaEs = inscripcion.CedulaEs WHERE inscripcion.IdMa = "+idMa);
        return rs;
    }

}
