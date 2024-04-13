package modelo;

import java.sql.ResultSet;
import modelo.BdConex;

public class MCartelera {
    public ResultSet getResultSet(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM publicacion INNER JOIN usuario ON publicacion.CedulaUs = usuario.CedulaUs WHERE borradoPu = '0' AND estatusPu = '1' ORDER BY FechaPu DESC");
        return rs;
    }

    public ResultSet getPubsPendientes(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM publicacion INNER JOIN usuario ON publicacion.CedulaUs = usuario.CedulaUs WHERE borradoPu = '0' AND estatusPu = '0' ORDER BY FechaPu DESC");
        return rs;}

    public int aprobarPub(int idPub){
        BdConex bd = new BdConex();
        return bd.ejecutar("UPDATE publicacion SET estatusPu = '1' WHERE idPu = '"+idPub+"'");
    }

    public int rechazarPub(int idPub){
        BdConex bd = new BdConex();
        return bd.ejecutar("UPDATE publicacion SET borradoPu = '1' WHERE idPu = '"+idPub+"'");
    }
}
