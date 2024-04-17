package modelo;

import java.sql.ResultSet;

public class MCrudEvento {
    MEvento evento = new MEvento();
    BdConex bd = new BdConex();
    public int crearEvento(String titulo, String organizador, String descripcion, String fecha, String hora, String lugar, String modalidad, String precio) {
        int op = 0;
        bd.abrirConexion();
        String sql = "INSERT INTO evento (tituloEv, organizadorEv, descripcionEv, fechaEv, horaEv, lugarEv, modalidadEv, precioEv) VALUES ('" + titulo.replace("'","''") + "', '" + organizador.replace("'","''") + "', '" + descripcion.replace("'","''") + "', '" + fecha + "', '" + hora + "', '" + lugar.replace("'","''") + "', '" + modalidad + "', '" + precio + "')";
        op = bd.ejecutar(sql);
        return op;
    }

    public ResultSet getResultSet() {
        ResultSet rs = null;
        bd.abrirConexion();
        String sql = "SELECT * FROM evento WHERE TIMESTAMP(FechaEv,HoraEv) > now() AND BorradoEv = 0 ORDER BY FechaEv ASC";
        rs = bd.consultar(sql);
        return rs;
    }
}
