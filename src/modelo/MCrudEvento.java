package modelo;

import java.sql.ResultSet;

// Clase MCrudEvento se encarga de realizar operaciones CRUD y los eventos en la base de datos.
public class MCrudEvento {
    // Variables
    MEvento evento = new MEvento();
    BdConex bd = new BdConex();

    /**
     * Crea un nuevo evento en la base de datos.
     * @param titulo Título del evento.
     * @param organizador Nombre del organizador del evento.
     * @param descripcion Descripción del evento.
     * @param fecha Fecha del evento en formato "YYYY-MM-DD".
     * @param hora Hora del evento en formato "HH:MM:SS".
     * @param lugar Lugar del evento.
     * @param modalidad Modalidad del evento.
     * @param precio Precio del evento.
     * @return Entero que indica el resultado de la operación (0 si falla, 1 si tiene éxito).
     */
    public int crearEvento(String titulo, String organizador, String descripcion, String fecha, String hora, String lugar, String modalidad, String precio) {
        int op = 0;
        bd.abrirConexion();
        String sql = "INSERT INTO evento (tituloEv, organizadorEv, descripcionEv, fechaEv, horaEv, lugarEv, modalidadEv, precioEv) VALUES ('" + titulo.replace("'","''") + "', '" + organizador.replace("'","''") + "', '" + descripcion.replace("'","''") + "', '" + fecha + "', '" + hora + "', '" + lugar.replace("'","''") + "', '" + modalidad + "', '" + precio + "')";
        op = bd.ejecutar(sql);
        return op;
    }

    /**
     * Obtiene un ResultSet con la lista de eventos activos y no borrados de la base de datos.
     * @return ResultSet que contiene la lista de eventos activos.
     */
    public ResultSet getResultSet() {
        ResultSet rs = null;
        bd.abrirConexion();
        String sql = "SELECT * FROM evento WHERE TIMESTAMP(FechaEv,HoraEv) > now() AND BorradoEv = 0 ORDER BY FechaEv ASC";
        rs = bd.consultar(sql);
        return rs;
    }
}
