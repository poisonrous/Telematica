package modelo;

import javax.swing.*;
import java.sql.ResultSet;
import modelo.BdConex;
import modelo.MSolicitud;

public class MCrudSolicitud {
  // public String nombre, apellido, telefono, correo, tipoS, descripcion, fecha;
    MSolicitud mSolicitud = new MSolicitud(); //esto es de prueba
    ResultSet rs=null;
    BdConex bd= new BdConex();
    public int crearSolicitud(String tipo, String descripcion, String usuario) {
        int op=0;
        bd.abrirConexion();
        String sql="INSERT INTO solicitud (cedula, tipo, descripcion, fechaSo) VALUES ('"+usuario+"', '"+tipo+"', '"+descripcion+"', CURDATE())";
           op=bd.ejecutar(sql);
          /* if(op>0){
               rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, usuario.telefonoUs, usuario.correoUs, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.fechaSo FROM solicitud INNER JOIN usuario ON solicitud.cedula = usuario.CedulaUs INNER JOIN tiposolicitud " +
                       "ON solicitud.tipo = tiposolicitud.idTiSo WHERE (cedula, tipo, descripcion) = ('"+usuario+"', '"+tipo+"', '"+descripcion+"')");
           try
              {
               // rs.beforeFirst(); NO SÉ QUÉ COÑOS HACE ESTO Y ME VOY A VOLVER LOCAAAAAAAA
                rs.next();
                 nombre = rs.getString("NombresUs");
                 apellido = rs.getString("ApellidosUs");
                 telefono = rs.getString("telefonoUs");
                 correo = rs.getString("correoUs");
                 tipoS = rs.getString("tipoSo");
                 descripcion = rs.getString("descripcion");
                 fecha = rs.getString("fechaSo");
                //JOptionPane.showMessageDialog(null, "Solicitud enviada\nNombre: "+nombre+" "+apellido+"\nTelefono: "+telefono+"\nCorreo: "+correo+"\nTipo: "+tipoS+"\nDescripcion: "+descripcion+"\nFecha: "+fecha);
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la solicitud");
              }
              } else {
                JOptionPane.showMessageDialog(null, "Error al enviar la solicitud");
           }*/
         //   JOptionPane.showMessageDialog(null, "Solicitud enviada");
            //si no se selecciona materia, será por defecto nula
        return op;
    }

    public void crearSolicitudMateria(String tipo, String materia, String usuario) {
        bd.abrirConexion();
        String sql="INSERT INTO solicitud (cedula, tipo, materia, fechaSo) VALUES ('"+usuario+"', '"+tipo+"', '"+materia+"', CURDATE())";
        bd.ejecutar(sql);

    }

    public Object buscarSolicitud(String tipo, String descripcion, String usuario){
        mSolicitud = new MSolicitud();

        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, usuario.telefonoUs, usuario.correoUs, tiposolicitud.tipoSo, solicitud.descripcion, solicitud.fechaSo FROM solicitud INNER JOIN usuario ON solicitud.cedula = usuario.CedulaUs INNER JOIN tiposolicitud " +
                "ON solicitud.tipo = tiposolicitud.idTiSo WHERE (cedula, tipo, descripcion) = ('"+usuario+"', '"+tipo+"', '"+descripcion+"')");
        try
        {
            // rs.beforeFirst(); NO SÉ QUÉ COÑOS HACE ESTO Y ME VOY A VOLVER LOCAAAAAAAA
            rs.next();
            mSolicitud.setNombre(rs.getString("NombresUs"));
            mSolicitud.setApellido(rs.getString("ApellidosUs"));
            mSolicitud.setTelefono(rs.getString("telefonoUs"));
            mSolicitud.setCorreo(rs.getString("correoUs"));
            mSolicitud.setTipoS(rs.getString("tipoSo"));
            mSolicitud.setDescripcion(rs.getString("descripcion"));
            mSolicitud.setFecha(rs.getString("fechaSo"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la solicitud");
        }
        return mSolicitud;
    }

    public Object buscarSolicitudMateria(String tipo, String materia, String usuario){
        mSolicitud = new MSolicitud();

        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, usuario.telefonoUs, usuario.correoUs, tiposolicitud.tipoSo, asignatura.NombreAs, solicitud.fechaSo FROM solicitud INNER JOIN usuario ON solicitud.cedula = usuario.CedulaUs INNER JOIN tiposolicitud ON solicitud.tipo = tiposolicitud.idTiSo INNER JOIN\tmateria ON solicitud.materia = materia.idMA INNER JOIN asignatura " +
                "ON materia.idAs = asignatura.idAs WHERE (cedula, tipo, materia) = ('"+usuario+"', '"+tipo+"', '"+materia+"')");
        try
        {
            // rs.beforeFirst(); NO SÉ QUÉ COÑOS HACE ESTO Y ME VOY A VOLVER LOCAAAAAAAA
            rs.next();
            mSolicitud.setNombre(rs.getString("NombresUs"));
            mSolicitud.setApellido(rs.getString("ApellidosUs"));
            mSolicitud.setTelefono(rs.getString("telefonoUs"));
            mSolicitud.setCorreo(rs.getString("correoUs"));
            mSolicitud.setTipoS(rs.getString("tipoSo"));
            mSolicitud.setMateria(rs.getString("NombreAs"));
            mSolicitud.setFecha(rs.getString("fechaSo"));
            //JOptionPane.showMessageDialog(null, "El nombre es: "+mSolicitud.getNombre()+"\nEl apellido es: "+mSolicitud.getApellido()+"\nEl teléfono es: "+mSolicitud.getTelefono()+"\nEl correo es: "+mSolicitud.getCorreo()+"\nEl tipo es: "+mSolicitud.getTipoS()+"\nLa materia es: "+mSolicitud.getMateria()+"\nLa fecha es: "+mSolicitud.getFecha());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la solicitud");
        }
        return mSolicitud;
    }

       /* public int eliminarSolicitud(String tipo, String descripcion){
        int op=0;
        bd.abrirConexion();
        String sql="DELETE FROM solicitud WHERE (tipo, descripcion) = ('"+tipo+"', '"+descripcion+"')";
        op=bd.ejecutar(sql);
        return op;
    }

    public int eliminarSolicitudMateria(String tipo, String materia){
        int op=0;
        bd.abrirConexion();
        String sql="DELETE FROM solicitud WHERE (tipo, materia) = ('"+tipo+"', '"+materia+"')";
        op=bd.ejecutar(sql);
        return op;
    }*/ //esto no se usa porque no se pueden eliminar solicitudes, pero lo dejo por si acaso PENDIENTE AGREGAR MODIFICACIÓN (corresponde a Neri) Y ELIMINACIÓN LÓGICA

}
