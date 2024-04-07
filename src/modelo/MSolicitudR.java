package modelo;

import javax.swing.*;
import java.sql.ResultSet;

public class MSolicitudR {

    private int Test;
        public ResultSet getResultSet(int Test, String Estado, String Tipo) {
          ResultSet rs = null;
            if (Test==1) {BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.idSo, solicitud.cedula, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.estado, asignatura.NombreAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo LEFT JOIN materia ON solicitud.materia = materia.idMA LEFT JOIN asignatura ON materia.idAs = asignatura.idAs");;
            }
            else if (Test==10){
             BdConex bd= new BdConex();
               rs= bd.consultar("SELECT solicitud.idSo, solicitud.cedula, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.estado, asignatura.NombreAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo LEFT JOIN materia ON solicitud.materia = materia.idMA LEFT JOIN asignatura ON materia.idAs = asignatura.idAs WHERE tiposolicitud.TipoSo = '" + Tipo + "'");
            }
            else if (Test==3){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.idSo, solicitud.cedula, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.estado, asignatura.NombreAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo LEFT JOIN materia ON solicitud.materia = materia.idMA LEFT JOIN asignatura ON materia.idAs = asignatura.idAs WHERE solicitud.estado = '"+Estado+"';");
            }
            else if (Test>10){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.idSo, solicitud.cedula, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.estado, asignatura.NombreAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo LEFT JOIN materia ON solicitud.materia = materia.idMA LEFT JOIN asignatura ON materia.idAs = asignatura.idAs WHERE tiposolicitud.TipoSo = '" + Tipo + "' AND solicitud.estado = '"+Estado+"';");
            }

        return rs;}

      public ResultSet getResultSet() {
            ResultSet rs = null;
            BdConex bd= new BdConex();
            rs= bd.consultar("SELECT cedula, tipoSo, descripcion, estado FROM solicitud, tiposolicitud WHERE tiposolicitud.TipoSo = ");

        return rs;}
        public MSolicitudR() {}

        public void actualizarSolicitud(String idSo, String Estado) {
            BdConex bd= new BdConex();
            bd.ejecutar("UPDATE solicitud SET estado = '"+Estado+"' WHERE idSo = '"+idSo+"';");
            JOptionPane.showMessageDialog(null,"Estado actualizado exitosamente.");
        }

        // Get/Set
    public int getTest() {
        return Test;
    }
}
