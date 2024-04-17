package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MCrudPublicacion {
    MPublicacion publicacion = new MPublicacion();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    public int crearPublicacion(OModelo usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql;
        if(usuario.isAdmin()>0){
             sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu, estatusPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', CURRENT_TIMESTAMP, '1')";
        } else sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', CURRENT_TIMESTAMP)";
        op=bd.ejecutar(sql);
        return op;
    }

    public boolean checkDescripcion (String usuario, String descripcion){
        bd.abrirConexion();
        rs = bd.consultar("SELECT DISTINCT publicacion.DescripcionPu, publicacion.CedulaUs FROM publicacion WHERE BorradoPu = '0' AND  publicacion.CedulaUs = '"+usuario+"' AND publicacion.DescripcionPu = '"+descripcion.replace("'","''")+"'");
        try {
            rs.last();
            return rs.getRow()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkTitulo (String usuario, String titulo){
        bd.abrirConexion();
        rs = bd.consultar("SELECT DISTINCT publicacion.TituloPu, publicacion.CedulaUs FROM publicacion WHERE BorradoPu = '0' AND  publicacion.CedulaUs = '"+usuario+"' AND publicacion.TituloPu = '"+titulo.replace("'","''")+"'");
        try {
            rs.last();
            return rs.getRow()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
