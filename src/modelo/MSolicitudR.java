package modelo;

import javax.swing.*;
import java.sql.ResultSet;

// Clase MSolicitudR ofrece métodos para manejar y obtener solicitudes.

public class MSolicitudR {

    private int Test;

    /**
     * Obtiene un conjunto de resultados de solicitudes según varios criterios de búsqueda.
     *
     * @param Test Valor que determina el tipo de búsqueda.
     * @param Estado Estado de la solicitud (opcional, puede ser "Pendiente", "Procesada" u otro estado definido).
     * @param Tipo Tipo de solicitud (opcional).
     * @param Carrera Carrera relacionada con la solicitud (opcional).
     * @return Un conjunto de resultados de las solicitudes que coinciden con los criterios de búsqueda.
     */
        public ResultSet getResultSet(Double Test, String Estado, String Tipo, String Carrera) {
          ResultSet rs = null;
            if (Test==1.0) // Determinar el tipo de búsqueda y construir la consulta SQL correspondiente
            {BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo, BorradoTiSo)= ('0', '0')");
            }
            else if (Test==1.5){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, NombreCa) = ('0' , '0', '"+Carrera+"' )");
            }
            else if (Test==10.0){
             BdConex bd= new BdConex();
               rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo) = ('0' , '0', '"+Tipo+"' )");
            }
            else if (Test==10.5){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo, NombreCa) = ('0' , '0', '"+Tipo+"', '"+Carrera+"' )");
            }
            else if (Test==3.0){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, EstadoSo) = (0 , 0,'"+Estado+"')");
            }
            else if (Test==3.5){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo, NombreCa) = ('0' , '0', '"+Tipo+"', '"+Carrera+"' )");
            }
            else if (Test>10.0){
                BdConex bd= new BdConex();
                rs= bd.consultar("SELECT solicitud.IdSo, solicitud.CedulaEs, NombreCa, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.EstadoSo, asignatura.NombreAsignaturaAs FROM solicitud LEFT JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo LEFT JOIN materia ON solicitud.MateriaSo = materia.IdMa LEFT JOIN asignatura ON materia.IdAs = asignatura.IdAs LEFT JOIN estudiante ON estudiante.CedulaEs = solicitud.CedulaEs LEFT JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE (BorradoSo , BorradoTiSo, tiposolicitud.TipoTiSo, EstadoSo, NombreCa) = (0 , 0, '"+Tipo+"', '"+Estado+"', '"+Carrera+"')");
            }

        return rs;}

    /**
     * Obtiene un conjunto de resultados de todas las solicitudes.
     * @return Un conjunto de resultados de todas las solicitudes.
     */
      public ResultSet getResultSet() {
            ResultSet rs = null;
            BdConex bd= new BdConex();
            rs= bd.consultar("SELECT CedulaEs, tipoTiSo, DescripcionSo, EstadoSo, FechaSo FROM solicitud INNER JOIN tiposolicitud ON tiposolicitud.IdTiSo = solicitud.IdTiSo WHERE BorradoSo = 0;");

        return rs;}
        public MSolicitudR() {}

    /**
     * Actualiza el estado de una solicitud específica.
     * @param idSo El ID de la solicitud que se va a actualizar.
     * @param Estado El nuevo estado de la solicitud.
     */
        public void actualizarSolicitud(String idSo, String Estado) {
            BdConex bd= new BdConex();
            bd.ejecutar("UPDATE solicitud SET EstadoSo = '"+Estado+"' WHERE IdSo = '"+idSo+"';");
            JOptionPane.showMessageDialog(null,"Estado actualizado exitosamente.");
        }

    /**
     *  Obtiene el valor del Test
     * @return El valor del Test
     */
    public int getTest() {
        return Test;
    }
}
