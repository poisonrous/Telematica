package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * La clase MCrudPublicacion se encarga del CRUD en las publicaciones en la base de datos.
 */
public class MCrudPublicacion {
    // Variables de instancia
    MPublicacion publicacion = new MPublicacion();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    /**
     * Crea una nueva publicación en la base de datos.
     * @param usuario Objeto OModelo que representa al usuario que realiza la publicación.
     * @param titulo Título de la publicación.
     * @param descripcion Descripción de la publicación.
     * @return Entero que indica el resultado de la operación (0 si falla, 1 si tiene éxito).
     */
    public int crearPublicacion(OModelo usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql;
        // Verifica si el usuario es administrador para determinar si se registra como publicación activa o inactiva
        if(usuario.isAdmin()>0){
             sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu, estatusPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', CURRENT_TIMESTAMP, '1')";
        } else sql="INSERT INTO publicacion (cedulaUs, tituloPu, descripcionPu, fechaPu) VALUES ('"+usuario.getUsuario()+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', CURRENT_TIMESTAMP)";
        op=bd.ejecutar(sql);
        return op;
    }

    /**
     * Verifica si una publicación con la misma descripción ya ha sido realizada por el usuario.
     * @param usuario Cédula del usuario.
     * @param descripcion Descripción de la publicación.
     * @return true si la descripción de la publicación ya existe para el usuario, false de lo contrario.
     */
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

    /**
     * Verifica si una publicación con el mismo título ya ha sido realizada por el usuario.
     * @param usuario Cédula del usuario.
     * @param titulo Título de la publicación.
     * @return true si el título de la publicación ya existe para el usuario, false de lo contrario.
     */
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
