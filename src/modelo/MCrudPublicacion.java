package modelo;

import java.sql.ResultSet;

public class MCrudPublicacion {
    MPublicacion publicacion = new MPublicacion();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    public int crearPublicacion(OModelo usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql;
        if(usuario.getRol().equals("Admin")){
             sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu, estatusPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo+"', '"+descripcion+"', CURRENT_TIMESTAMP, '1')";
        } else sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo+"', '"+descripcion+"', CURRENT_TIMESTAMP)";
        op=bd.ejecutar(sql);
        return op;
    }
}
