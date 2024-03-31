package modelo;

import java.sql.ResultSet;

public class MCrudPublicacion {
    MPublicacion publicacion = new MPublicacion();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    public int crearPublicacion(String usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu) VALUES ('"+usuario+"', '"+titulo+"', '"+descripcion+"', CURDATE())";
        op=bd.ejecutar(sql);
        return op;
    }
}
