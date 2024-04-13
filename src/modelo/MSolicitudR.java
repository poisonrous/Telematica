package modelo;

import javax.swing.*;
import java.sql.ResultSet;

public class MSolicitudR {

    private int Test;
        public ResultSet getResultSet(int Test, String Estado, String Tipo) {
          ResultSet rs = null;
            if (Test==1) {BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs WHERE (BorradoSo, BorradoTiSo)= ('0', '0')");
            }
            else if (Test==10){
             BdConex bd= new BdConex();
               rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo) = ('0' , '0', '"+Tipo+"' )");
            }
            else if (Test==3){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs WHERE (BorradoSo , BorradoTiSo, EstadoSo) = (0 , 0,'"+Estado+"')");
            }
            else if (Test>10){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo, EstadoSo) = (0 , 0, '"+Tipo+"', '"+Estado+"')");
            }

        return rs;}

      public ResultSet getResultSet() {
            ResultSet rs = null;
            BdConex bd= new BdConex();
            rs= bd.consultar("SELECT CedulaEs, tipoTiSo, DescripcionSo, EstadoSo, FechaSo FROM solicitud INNER JOIN tiposolicitud ON tiposolicitud.IdTiSo = solicitud.IdTiSo WHERE BorradoSo = 0;");

        return rs;}
        public MSolicitudR() {}

        public void actualizarSolicitud(String idSo, String Estado) {
            BdConex bd= new BdConex();
            bd.ejecutar("UPDATE solicitud SET EstadoSo = '"+Estado+"' WHERE IdSo = '"+idSo+"';");
            JOptionPane.showMessageDialog(null,"Estado actualizado exitosamente.");
        }

        // Get/Set
    public int getTest() {
        return Test;
    }
}
