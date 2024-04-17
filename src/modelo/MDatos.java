package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MDatos {

    private String tipoFN, tipoF, solicitudM, sugerenciaM;

    private float solicitudPercent;
    private ResultSet materias, estudianteSo, estudianteSu ;
    public void rellenar () {
        float solicitudResu, solicitudPendi;


        ResultSet rs = null;
        BdConex bd= new BdConex();

        rs = bd.consultar("SELECT solicitud.IdTiSo FROM solicitud WHERE BorradoSo = '0'");
        try {
            rs.last();
            tipoFN = String.valueOf(rs.getRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs= bd.consultar("SELECT TipoTiSo FROM tiposolicitud INNER JOIN solicitud ON tiposolicitud.IdTiSo = solicitud.IdTiSo WHERE BorradoSo = '0' GROUP BY solicitud.IdTiSo ORDER BY COUNT(*) DESC LIMIT 1;");
        try {
            rs.first();
            this.tipoF = rs.getString("TipoTiSo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.estudianteSo= bd.consultar("SELECT NombresEs, ApellidosEs, estudiante.CedulaEs FROM estudiante INNER JOIN solicitud ON estudiante.CedulaEs = solicitud.CedulaEs WHERE BorradoSo = '0' GROUP BY solicitud.CedulaEs ORDER BY COUNT(*) DESC LIMIT 1;");
        this.estudianteSu= bd.consultar("SELECT NombresEs, ApellidosEs, estudiante.CedulaEs FROM estudiante INNER JOIN sugerencia ON estudiante.CedulaEs = sugerencia.CedulaUs WHERE BorradoSu = '0' GROUP BY sugerencia.CedulaUs ORDER BY COUNT(*) DESC LIMIT 1;");

        rs= bd.consultar("select FechaSo from solicitud WHERE year(FechaSo)=year(NOW()) AND month(FechaSo) = month(NOW()) AND BorradoSo = '0';");
        try {
            rs.last();
            this.solicitudM = String.valueOf(rs.getRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs= bd.consultar("select FechaSu from sugerencia WHERE year(FechaSu)=year(NOW()) AND month(FechaSu) = month(NOW()) AND BorradoSu = '0';");
        try {
            rs.last();
            this.sugerenciaM = String.valueOf(rs.getRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs= bd.consultar("select BorradoSo from solicitud WHERE EstadoSo = 'Resuelta' AND BorradoSo = '0';");
        try {
            rs.last();
            solicitudResu = rs.getRow();
        } catch (SQLException e) {
            solicitudResu=0;
            throw new RuntimeException(e);
        }

        rs= bd.consultar("select BorradoSo from solicitud WHERE BorradoSo = '0';");
        try {
            rs.last();
            solicitudPendi = rs.getRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        solicitudPercent = (solicitudResu/solicitudPendi)*100;

    }

    public ResultSet getMaterias (){
        BdConex bd= new BdConex();
        this.materias = bd.consultar("SELECT DISTINCT NombreAsignaturaAs FROM asignatura LEFT JOIN materia ON materia.IdAs=asignatura.IdAs LEFT JOIN solicitud ON materia.IdMa=solicitud.MateriaSo WHERE (BorradoSo, BorradoMa) = ('0', '0')");

        return this.materias;
    }

    public String getTipoFN() {
        return tipoFN;
    }

    public String getTipoF() {
        return tipoF;
    }

    public ResultSet getEstudianteSo() {
        return estudianteSo;
    }

    public ResultSet getEstudianteSu() {
        return estudianteSu;
    }

    public String getSolicitudM() {
        return solicitudM;
    }

    public String getSugerenciaM() {
        return sugerenciaM;
    }

    public float getSolicitudPercent() {
        return solicitudPercent;
    }
}
