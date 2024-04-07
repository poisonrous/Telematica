package modelo;
import java.sql.ResultSet;
import modelo.BdConex;
import modelo.MSugerencia;

import javax.swing.*;


public class MCrudSugerencia {

    MSugerencia mSugerencia = new MSugerencia();
    ResultSet rs=null;
    BdConex bd= new BdConex();

    public int crearSugerencia(String usuario, String titulo, String descripcion) {
        int op=0;
        bd.abrirConexion();
        String sql="INSERT INTO sugerencia (sugerencia.cedulaUs, tituloSu, descripcionSu, fechaSu) VALUES ('"+usuario+"', '"+titulo+"', '"+descripcion+"', CURDATE())";
        op=bd.ejecutar(sql);
        return op;
    }

    public Object buscarSugerencia(String usuario, String titulo, String descripcion){
        JOptionPane.showMessageDialog(null, "usuario: "+usuario+" titulo: "+titulo+" descripcion: "+descripcion);
        mSugerencia = new MSugerencia();
        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, estudiante.TelefonoEs, usuario.CorreoElectronicoUs, sugerencia.TituloSu, sugerencia.DescripcionSu, sugerencia.FechaSu FROM estudiante INNER JOIN usuario ON estudiante.CedulaEs = usuario.CedulaUs INNER JOIN sugerencia ON sugerencia.CedulaUs = usuario.CedulaUs WHERE (usuario.CedulaUs, TituloSu, DescripcionSu) = ('"+usuario+"', '"+titulo+"', '"+descripcion+"')");
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
