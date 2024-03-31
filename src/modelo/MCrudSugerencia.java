package modelo;
import java.sql.ResultSet;
import modelo.BdConex;
import modelo.MSugerencia;


public class MCrudSugerencia {

    MSugerencia mSugerencia = new MSugerencia();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    public int crearSugerencia(String usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql="INSERT INTO sugerencia (cedulaUs, tituloSu, descripcionSu, fechaSu) VALUES ('"+usuario+"', '"+titulo+"', '"+descripcion+"', CURDATE())";
        op=bd.ejecutar(sql);
        return op;
    }

        public Object buscarSugerencia(String usuario, String titulo, String descripcion){
        mSugerencia = new MSugerencia();
        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, usuario.telefonoUs, usuario.correoUs, sugerencia.tituloSu, sugerencia.descripcionSu, sugerencia.fechaSu FROM sugerencia INNER JOIN usuario ON sugerencia.cedulaUs = usuario.CedulaUs WHERE (usuario.cedulaUs, tituloSu, descripcionSu) = ('"+usuario+"', '"+titulo+"', '"+descripcion+"')");
        try
        {
            rs.next();
            mSugerencia.setNombre(rs.getString("NombresUs"));
            mSugerencia.setApellido(rs.getString("ApellidosUs"));
            mSugerencia.setTelefono(rs.getString("telefonoUs"));
            mSugerencia.setCorreo(rs.getString("correoUs"));
            mSugerencia.setTitulo(rs.getString("tituloSu"));
            mSugerencia.setDescripcion(rs.getString("descripcionSu"));
            mSugerencia.setFecha(rs.getString("fechaSu"));

        } catch (Exception e) {
            System.out.println("Error al mostrar los datos de la sugerencia");
        }
        return mSugerencia;
    }

    /*public int eliminarSugerencia(String titulo, String descripcion){
        int op=0;
        bd.abrirConexion();
        String sql="DELETE FROM sugerencia WHERE (titulo, descripcion) = ('"+titulo+"', '"+descripcion+"')";
        op=bd.ejecutar(sql);
        return op;
    }

    public int modificarSugerencia(String titulo, String descripcion){
        int op=0;
        bd.abrirConexion();
        String sql="UPDATE sugerencia SET descripcion = '"+descripcion+"' WHERE titulo = '"+titulo+"'";
        op=bd.ejecutar(sql);
        return op;
    }*/ //No se necesita modificar ni eliminar sugerencias

  /*  public void cerrarConexion(){
        bd.cerrarConexion();
    }*/

    public void setMSugerencia(MSugerencia mSugerencia){
        this.mSugerencia = mSugerencia;
    }

    public MSugerencia getMSugerencia(){
        return mSugerencia;
    }

    public ResultSet getRs(){
        return rs;
    }

    public void setRs(ResultSet rs){
        this.rs = rs;
    }

    public BdConex getBd(){
        return bd;
    }

    public void setBd(BdConex bd){
        this.bd = bd;
    }

}
