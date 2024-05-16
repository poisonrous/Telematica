package modelo;

import java.sql.PreparedStatement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import modelo.BdConex;


public class Materia {
    private String idMateria, nombreMateria;

    public Materia(String idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

    public Materia() {

    }

    public String getIdMateria() {
        if (idMateria == null) {
            return "";
        }
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return nombreMateria;
    }

    public Vector<Materia> vectorMateriaProfesor(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Materia> materias = new Vector<Materia>();
        Materia materia = null;
        materia = new Materia(); //Está es la de relleno, si se termina usando este vector para otra cosa retirar.
        materia.setIdMateria("0");
        materia.setNombreMateria("Seleccionar una materia");
        materias.add(materia);
        try {
            ps = con.prepareStatement("SELECT * FROM materia INNER JOIN asignatura ON materia.IdAs = asignatura.IdAs INNER JOIN periodo ON materia.IdPe = periodo.IdPe WHERE periodo.VigenciaPe = 1 AND CedulaPr = " + usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getString("IdMa"));
                materia.setNombreMateria(rs.getString("NombreAsignaturaAs"));
                materias.add(materia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return materias;
    }

}
