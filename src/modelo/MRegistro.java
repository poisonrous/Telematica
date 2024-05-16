package modelo;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

// Clase MRegistro ofrece métodos para buscar, registrar y actualizar información de estudiantes en la bd
public class MRegistro {

    /**
     * Busca un estudiante en la bd por su número de cédula.
     * @param cedula El número de cédula del estudiante a buscar.
     * @return Un objeto de tipo Estudiante con la información encontrada, o null si no se encuentra.
     */
    public Estudiante buscarEstudiante(String cedula) {
        ResultSet rs;
        BdConex bd = new BdConex();
        Estudiante est = new Estudiante();
        rs = bd.consultar("SELECT * FROM estudiante INNER JOIN carrera ON estudiante.IdCa = carrera.IdCa WHERE cedulaEs = '" + cedula + "'");
        try {
            if(rs.first()) {
                rs.beforeFirst();
                rs.next();
            est.setCedula(rs.getString("cedulaEs"));
            est.setNombre(rs.getString("nombresEs"));
            est.setApellido(rs.getString("apellidosEs"));
            est.setDireccion(rs.getString("direccionEs"));
            est.setTelefono(rs.getString("telefonoEs"));
            est.setCorreo(rs.getString("correoelectricoEs"));
            est.setFechaNacimiento(rs.getString("fechaEs"));
            est.setSexo(rs.getString("sexoEs"));
            est.setCondicionesMedicas(rs.getString("CondicionesMedicasEs"));
            est.setCapacidadEspecial(rs.getString("CapacidadesEspecialesEs"));
            est.setTrabaja(rs.getBoolean("trabajoEs"));
            est.setForaneo(rs.getBoolean("foraneoEs"));
            est.setFuera(rs.getBoolean("fuerapaisEs"));
            est.setCarrera(rs.getString("NombreCa"));} else {
                est = null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return est;
    }

    /**
     * Registra un nuevo estudiante en la base de datos.
     * @param est El objeto Estudiante que se va a registrar.
     * @return Un mensaje indicando el resultado del registro.
     */
    public String registrarEstudiante(Estudiante est) {
        ResultSet rs;
        BdConex bd = new BdConex();
        String mensaje = "";
        bd.abrirConexion();
        try {
            int a= bd.ejecutar("INSERT INTO usuario (cedulaUs, NombresUs, ApellidosUs, correoelectronicoUs, idRoUs) VALUES ('" + est.getCedula() + "', '" + est.getNombre() + "', '" + est.getApellido() + "', '" + est.getCorreo() + "', 1)");
            int b= bd.ejecutar("INSERT INTO contrasenna (ContrasennaEncriptadaCo, cedulaUs) VALUES ('" + est.getCedula() + "', '" + est.getCedula() + "')");
            rs = bd.consultar("SELECT IdCa FROM carrera WHERE NombreCa = '" + est.getCarrera() + "'");
            rs.beforeFirst();
            rs.next();
            String idCa = rs.getString("IdCa");
            int c= bd.ejecutar("INSERT INTO estudiante (cedulaEs, nombresEs, apellidosEs, direccionEs, telefonoEs, correoelectricoEs, fechaEs, sexoEs, CondicionesMedicasEs, CapacidadesEspecialesEs, trabajoEs, foraneoEs, fuerapaisEs, IdCa) VALUES ('" + est.getCedula() + "', '" + est.getNombre() + "', '" + est.getApellido() + "', '" + est.getDireccion() + "', '" + est.getTelefono() + "', '" + est.getCorreo() + "', '" + est.getFechaNacimiento() + "', '" + est.getSexo() + "', '" + est.getCondicionesMedicas() + "', '" + est.getCapacidadEspecial() + "', " + est.isTrabaja() + ", " + est.isForaneo() + ", " + est.isFuera() + ", " + idCa + ")");
            if (a==0 || b==0  || c==0 )
            {
                mensaje = "Error al registrar al estudiante";
                        }
            else {
                mensaje = "Estudiante registrado con Éxito.";
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bd.desconectar();
        return mensaje;
    }

    /**
     * Actualiza la información de un estudiante en la base de datos.
     * @param est El objeto Estudiante con la información actualizada.
     * @return Un mensaje indicando el resultado de la actualización.
     */
    public String actualizarEstudiante(Estudiante est) {
        ResultSet rs;
        BdConex bd = new BdConex();
        String mensaje = "";
        bd.abrirConexion();
        try {
            int a= bd.ejecutar("UPDATE usuario SET NombresUs = '" + est.getNombre() + "', ApellidosUs = '" + est.getApellido() + "', correoelectronicoUs = '" + est.getCorreo() + "' WHERE cedulaUs = '" + est.getCedula() + "'");
            rs = bd.consultar("SELECT IdCa FROM carrera WHERE NombreCa = '" + est.getCarrera() + "'");
            rs.beforeFirst();
            rs.next();
            String idCa = rs.getString("IdCa");
            int b= bd.ejecutar("UPDATE estudiante SET nombresEs = '" + est.getNombre() + "', apellidosEs = '" + est.getApellido() + "', direccionEs = '" + est.getDireccion() + "', telefonoEs = '" + est.getTelefono() + "', correoelectricoEs = '" + est.getCorreo() + "', fechaEs = '" + est.getFechaNacimiento() + "', sexoEs = '" + est.getSexo() + "', CondicionesMedicasEs = '" + est.getCondicionesMedicas() + "', CapacidadesEspecialesEs = '" + est.getCapacidadEspecial() + "', trabajoEs = " + est.isTrabaja() + ", foraneoEs = " + est.isForaneo() + ", fuerapaisEs = " + est.isFuera() + ", IdCa = " + idCa + " WHERE cedulaEs = '" + est.getCedula() + "'");
            if (a==0 || b==0)
            {
                mensaje = "Error al registrar al estudiante";
            }
            else {
                mensaje = "Estudiante registrado con Éxito.";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bd.desconectar();
        return mensaje;
    }
}
