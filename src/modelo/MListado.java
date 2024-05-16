package modelo;

import javax.swing.*;
import java.sql.ResultSet;

// Clase MListado ofrece métodos para ver materias y listados de estudiantes.
public class MListado {
    private BdConex bd;
    private ResultSet rs;

    /**
     * Obtiene un ComboBoxModel que contiene las materias de un profesor.
     * @param usuario El usuario del profesor.
     * @return El ComboBoxModel de las materias del profesor.
     */
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

    /**
     * Obtiene un ResultSet que contiene el listado de estudiantes para una materia específica.
     * @param materia La materia para la cual se desea obtener el listado.
     * @return El ResultSet con el listado de estudiantes.
     */
    public ResultSet getListado(Object materia) {
        String idMa = materia.toString();
        bd = new BdConex();
        rs = bd.consultar("SELECT * FROM estudiante INNER JOIN inscripcion ON estudiante.CedulaEs = inscripcion.CedulaEs WHERE inscripcion.IdMa = "+idMa);
        return rs;
    }
    /**
     * Obtiene un ResultSet que contiene el listado de estudiantes para todas las materias.
     * @return El ResultSet con el listado de estudiantes.
     */
    public ResultSet getBigListado (){
        bd = new BdConex();
        rs = bd.consultar("SELECT * FROM estudiante");
        return rs;
    }

}
