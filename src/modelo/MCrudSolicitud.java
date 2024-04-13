package modelo;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Objects;

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
        String sql="INSERT INTO solicitud (CedulaEs, IdTiSo, DescripcionSo, FechaSo) VALUES ('"+usuario+"', '"+tipo+"', '"+descripcion+"', CURDATE())";
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
        String sql="INSERT INTO solicitud (CedulaEs, IdTiSo, MateriaSo, FechaSo) VALUES ('"+usuario+"', '"+tipo+"', '"+materia+"', CURDATE())";
        bd.ejecutar(sql);

    }

    public Object buscarSolicitud(String tipo, String descripcion, String usuario){
        mSolicitud = new MSolicitud();

        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, estudiante.TelefonoEs, usuario.CorreoElectronicoUs, tiposolicitud.TipoTiSo, solicitud.DescripcionSo, solicitud.FechaSo FROM estudiante INNER JOIN solicitud "+
                "ON estudiante.CedulaEs = solicitud.CedulaEs INNER JOIN usuario ON solicitud.CedulaEs = usuario.CedulaUs INNER JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo WHERE (usuario.CedulaUs, solicitud.IdTiSo, DescripcionSo) = ('"+usuario+"', '"+tipo+"', '"+descripcion+"')");
        try
        {
            // rs.beforeFirst(); NO SÉ QUÉ COÑOS HACE ESTO Y ME VOY A VOLVER LOCAAAAAAAA
            rs.next();
            mSolicitud.setNombre(rs.getString("NombresUs"));
            mSolicitud.setApellido(rs.getString("ApellidosUs"));
            mSolicitud.setTelefono(rs.getString("TelefonoEs"));
            mSolicitud.setCorreo(rs.getString("CorreoElectronicoUs"));
            mSolicitud.setTipoS(rs.getString("TipoTiSo"));
            mSolicitud.setDescripcion(rs.getString("DescripcionSo"));
            mSolicitud.setFecha(rs.getString("FechaSo"));

            if (Objects.equals(mSolicitud.getTelefono(), "")) mSolicitud.setTelefono("desconocido");
            if (Objects.equals(mSolicitud.getCorreo(), "")) mSolicitud.setCorreo("desconocido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la solicitud");
        }
        return mSolicitud;
    }

    public Object buscarSolicitudMateria(String tipo, String materia, String usuario){
        mSolicitud = new MSolicitud();

        rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, estudiante.TelefonoEs, usuario.CorreoElectronicoUs, tiposolicitud.TipoTiSo, asignatura.NombreAsignaturaAs, solicitud.FechaSo FROM estudiante INNER JOIN solicitud "+
                "ON estudiante.CedulaEs = solicitud.CedulaEs INNER JOIN usuario ON solicitud.CedulaEs = usuario.CedulaUs INNER JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo INNER JOIN materia on materia.IdMa = solicitud.MateriaSo INNER JOIN asignatura on materia.IdAs = asignatura.IdAs WHERE (usuario.CedulaUs, solicitud.IdTiSo, MateriaSo) = ('"+usuario+"', '"+tipo+"', '"+materia+"')");

       // rs=bd.consultar("SELECT usuario.NombresUs, usuario.ApellidosUs, estudiante.TelefonoEs, usuario.CorreoUs, tiposolicitud.TipoTiSo, asignatura.NombreAs, solicitud.FechaSo FROM solicitud INNER JOIN usuario ON solicitud.CedulaUs = usuario.CedulaUs INNER JOIN tiposolicitud ON solicitud.IdTiSo = tiposolicitud.IdTiSo INNER JOIN\tmateria ON solicitud.IdMa = materia.IdMa INNER JOIN asignatura " +
        //        "ON materia.IdAs = asignatura.idAs WHERE (cedulaUs, IdTiSo, MateriaSo) = ('"+usuario+"', '"+tipo+"', '"+materia+"') INNER JOIN estudiante ON estudiante.CedulaEs = usuario.CedulaUs ");
        try
        {
            // rs.beforeFirst(); NO SÉ QUÉ COÑOS HACE ESTO Y ME VOY A VOLVER LOCAAAAAAAA
            rs.next();
            mSolicitud.setNombre(rs.getString("NombresUs"));
            mSolicitud.setApellido(rs.getString("ApellidosUs"));
            mSolicitud.setTelefono(rs.getString("TelefonoEs"));
            mSolicitud.setCorreo(rs.getString("CorreoElectronicoUs"));
            mSolicitud.setTipoS(rs.getString("TipoTiSo"));
            mSolicitud.setMateria(rs.getString("NombreAsignaturaAs"));
            mSolicitud.setFecha(rs.getString("FechaSo"));
            if (Objects.equals(mSolicitud.getTelefono(), "")) mSolicitud.setTelefono("desconocido");
            if (Objects.equals(mSolicitud.getCorreo(), "")) mSolicitud.setCorreo("desconocido");
            //JOptionPane.showMessageDialog(null, "El nombre es: "+mSolicitud.getNombre()+"\nEl apellido es: "+mSolicitud.getApellido()+"\nEl teléfono es: "+mSolicitud.getTelefono()+"\nEl correo es: "+mSolicitud.getCorreo()+"\nEl tipo es: "+mSolicitud.getTipoS()+"\nLa materia es: "+mSolicitud.getMateria()+"\nLa fecha es: "+mSolicitud.getFecha());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la solicitud");
        }
        return mSolicitud;
    }

    public ResultSet getSolicitudes(String usuario){
        bd.abrirConexion();
        rs=bd.consultar("SELECT IdSo, tipoTiSo, DescripcionSo, EstadoSo, FechaSo FROM solicitud INNER JOIN tiposolicitud ON tiposolicitud.IdTiSo = solicitud.IdTiSo WHERE BorradoSo = 0 AND  solicitud.CedulaEs = "+usuario+" ORDER BY FechaSo ASC");
        return rs;
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
