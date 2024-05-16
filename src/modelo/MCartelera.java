package modelo;

import java.sql.ResultSet;
import modelo.BdConex;

// Clase MCartelera y métodos para acceder a la cartelera de publicaciones.
public class MCartelera {

    /**
     * Recibe un ResultSet con las publicaciones aprobadas y activas
     * @return ResultSet que contiene la lista de publicaciones activas.
     */
    public ResultSet getResultSet(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM publicacion INNER JOIN usuario ON publicacion.CedulaUs = usuario.CedulaUs WHERE borradoPu = '0' AND estatusPu = '1' ORDER BY FechaPu DESC");
        return rs;
    }

    /**
     * Obtiene un ResultSet con las publicaciones pendientes de aprobación.
     * @return ResultSet que contiene la lista de publicaciones pendientes.
     */
    public ResultSet getPubsPendientes(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM publicacion INNER JOIN usuario ON publicacion.CedulaUs = usuario.CedulaUs WHERE borradoPu = '0' AND estatusPu = '0' ORDER BY FechaPu DESC");
        return rs;}


    /**
     * Aprueba una publicación en la cartelera.
     * @param idPub ID de la publicación a aprobar.
     * @return Entero que indica el resultado de la operación (0 si falla, 1 si tiene éxito).
     */
    public int aprobarPub(int idPub){
        BdConex bd = new BdConex();
        return bd.ejecutar("UPDATE publicacion SET estatusPu = '1' WHERE idPu = '"+idPub+"'");
    }

    /**
     * Rechaza una publicación en la cartelera.
     * @param idPub ID de la publicación a rechazar.
     * @return Entero que indica el resultado de la operación (0 si falla, 1 si tiene éxito).
     */
    public int rechazarPub(int idPub){
        BdConex bd = new BdConex();
        return bd.ejecutar("UPDATE publicacion SET borradoPu = '1' WHERE idPu = '"+idPub+"'");
    }
}
