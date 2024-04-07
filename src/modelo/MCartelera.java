package modelo;

import java.sql.ResultSet;
import modelo.BdConex;

public class MCartelera {
    public ResultSet getResultSet(){
        ResultSet rs = null;
        BdConex bd = new BdConex();
        rs= bd.consultar("SELECT * FROM publicacion INNER JOIN usuario ON publicacion.CedulaUs = usuario.CedulaUs WHERE borradoPu = '0' ORDER BY FechaPu DESC");;
        return rs;
    }
}
