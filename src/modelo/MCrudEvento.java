package modelo;

import java.sql.ResultSet;

public class MCrudEvento {
    MEvento evento = new MEvento();
    BdConex bd = new BdConex();
    public int crearEvento(String titulo, String organizador, String descripcion, String fecha, String hora, String lugar, String modalidad, String precio) {
        int op = 0;
        bd.abrirConexion();
        String sql = "INSERT INTO evento (tituloEv, organizadorEv, descripcionEv, fechaEv, horaEv, lugarEv, modalidadEv, precioEv) VALUES ('" + titulo + "', '" + organizador + "', '" + descripcion + "', '" + fecha + "', '" + hora + "', '" + lugar + "', '" + modalidad + "', '" + precio + "')";
        op = bd.ejecutar(sql);
        return op;
    }
}
