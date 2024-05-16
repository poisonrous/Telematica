package modelo;

import javax.swing.*;
import java.sql.ResultSet;

// Clase MCrudSugerencia ofrece métodos para la gestión de sugerencias.
public class MCrudSugerencia {
    // Variables
    MSugerencia mSugerencia = new MSugerencia();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    /**
     * Crea una nueva sugerencia.
     * @param usuario La cédula del usuario que realiza la sugerencia.
     * @param titulo El título de la sugerencia.
     * @param descripcion La descripción de la sugerencia.
     * @return Un entero que indica si la operación fue exitosa (1) o no (0).
     */
    public int crearSugerencia(String usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql="INSERT INTO sugerencia (sugerencia.cedulaUs, tituloSu, descripcionSu, fechaSu) VALUES ('"+usuario+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', CURDATE())";
        op=bd.ejecutar(sql);
        return op;
    }

    /**
     * Obtiene la lista de sugerencias.
     * @return Un ResultSet que contiene la lista de sugerencias.
     */
    public ResultSet getSugestlist ( ){
            rs= bd.consultar("SELECT estudiante.NombresEs, estudiante.ApellidosEs, Estudiante.CedulaEs, sugerencia.TituloSu, sugerencia.DescripcionSu, sugerencia.FechaSu FROM estudiante INNER JOIN sugerencia ON estudiante.CedulaEs = sugerencia.CedulaUs WHERE (BorradoSu, BorradoEs)= ('0', '0')");
            return rs;}


    /**
     * Busca una sugerencia específica.
     * @param usuario La cédula del usuario que realizó la sugerencia.
     * @param titulo El título de la sugerencia.
     * @param descripcion La descripción de la sugerencia.
     * @return Un objeto de tipo MSugerencia con la información de la sugerencia encontrada, o un objeto vacío si no se encuentra.
     */
    public Object buscarSugerencia(String usuario, String titulo, String descripcion){
        mSugerencia = new MSugerencia();
        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, estudiante.TelefonoEs, usuario.CorreoElectronicoUs, sugerencia.TituloSu, sugerencia.DescripcionSu, sugerencia.FechaSu FROM estudiante INNER JOIN usuario ON estudiante.CedulaEs = usuario.CedulaUs INNER JOIN sugerencia ON sugerencia.CedulaUs = usuario.CedulaUs WHERE (usuario.CedulaUs, TituloSu, DescripcionSu, BorradoUs, BorradoSu) = ('"+usuario+"', '"+titulo.replace("'","''")+"', '"+descripcion.replace("'","''")+"', '0','0')");
        try
        {
            rs.next();
            mSugerencia.setNombre(rs.getString("NombresUs"));
            mSugerencia.setApellido(rs.getString("ApellidosUs"));
            mSugerencia.setTelefono(rs.getString("TelefonoEs"));
            mSugerencia.setCorreo(rs.getString("CorreoElectronicoUs"));
            mSugerencia.setTitulo(rs.getString("TituloSu"));
            mSugerencia.setDescripcion(rs.getString("DescripcionSu"));
            mSugerencia.setFecha(rs.getString("FechaSu"));

            if (mSugerencia.getTelefono() == null) mSugerencia.setTelefono("desconocido");
            if (mSugerencia.getCorreo() == null) mSugerencia.setTelefono("desconocido");

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

    /**
     * Establece un objeto MSugerencia.
     * @param mSugerencia El objeto MSugerencia a establecer.
     */
    public void setMSugerencia(MSugerencia mSugerencia){
        this.mSugerencia = mSugerencia;
    }

    /**
     * Obtiene el objeto MSugerencia.
     * @return El objeto MSugerencia.
     */
    public MSugerencia getMSugerencia(){
        return mSugerencia;
    }

    /**
     * Obtiene el ResultSet.
     * @return El ResultSet.
     */
    public ResultSet getRs(){
        return rs;
    }

    /**
     * Establece el ResultSet.
     * @param rs El ResultSet a establecer.
     */
    public void setRs(ResultSet rs){
        this.rs = rs;
    }


    /**
     * Obtiene el objeto BdConex.
     * @return El objeto BdConex.
     */
    public BdConex getBd(){
        return bd;
    }

    /**
     * Establece el objeto BdConex.
     * @param bd El objeto BdConex a establecer.
     */
    public void setBd(BdConex bd){
        this.bd = bd;
    }

}
