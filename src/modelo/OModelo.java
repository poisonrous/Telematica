package modelo;

import principal.Principal;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

// Clase OModelo se encarga de las operaciones relacionadas con el modelo de usuario.
public class OModelo {
	//TODO FUNCIONA PERFECTO AQUÍ (cualquiera sea tu problema te aseguro que no está aquí)

	private Modelo cconsu = null; // Objeto Modelo para almacenar los datos del usuario
	private Principal principal = null; // Referencia a la clase Principal

	// Constructor de la clase OModelo.
	public OModelo() {
		
	}

	/**
	 * Realiza la consulta para iniciar sesión de un usuario
	 * @param usuario    El nombre de usuario.
	 * @param contrasena La contraseña del usuario.
	 * @return El objeto Modelo con los datos del usuario, si la autenticación es exitosa; de lo contrario, null.
	 */
	public Modelo consultaUsuario(String usuario, String contrasena) {
		ResultSet  rs = null;
		BdConex bd = new BdConex();
		cconsu = new Modelo();
		principal = new Principal();

		// Consulta para la autenticación del usuario
		rs = bd.consultar("SELECT * FROM usuario INNER JOIN contrasenna ON usuario.CedulaUs = contrasenna.cedulaUs INNER JOIN rolusuario ON usuario.IdRoUs = rolusuario.IdRoUs WHERE usuario.CedulaUs =  '"+ usuario+ "' AND contrasenna.ContrasennaEncriptadaCo = '"+contrasena.replace("'","''")+"'");
		
		
			try {
				// Si se encontró un usuario
			rs.next();
				// Se establecen los datos del usuario en el objeto Modelo
			cconsu.setUsuario(rs.getString("cedulaUs"));
			cconsu.setNombres(rs.getString("NombresUs"));
			cconsu.setApellidos(rs.getString("ApellidosUs"));
			cconsu.setContrasena(rs.getString("ContrasennaEncriptadaCo"));
			cconsu.setRol(rs.getString("RolRoUs"));
			cconsu.setAdmin(rs.getInt("AdminUs"));

				// Mensaje de bienvenida

				UIManager UI=new UIManager();
				UI.put("OptionPane.messageFont", new Font("Open Sans", Font.BOLD, 14));
				UI.put("OptionPane.background", new Color (255,255,255));
				UI.put("Panel.background", new Color (255,255,255));
				UI.put("Button.background", new Color (3,150,177));
				UIManager.put("Button.foreground", Color.white);



			JOptionPane.showMessageDialog(null,"Bienvenid@, "+rs.getString("NombresUs")+" "+rs.getString("ApellidosUs"));
			//if(cconsu.getRol().equals("Estudiante")) principal.pantallaEstudiante();
			/*else if(cconsu.getRol().equals("Administrador")) principal.pantallaAdministrador();
			else if(cconsu.getRol().equals("Docente")) principal.pantallaDocente();
			else if(cconsu.getRol().equals("Personal")) principal.pantallaPersonal();
			else if(cconsu.getRol().equals("Invitado")) principal.pantallaInvitado();
			else JOptionPane.showMessageDialog(null,"Rol no encontrado.");*/
			}
			catch(SQLException e){
				// Se maneja cualquier error de SQL
			 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
			 //e.printStackTrace();
		 }
			
			
			bd.desconectar();
		
		
		return cconsu;

		
		
	}

	/**
	 * Cambia la contraseña de un usuario.
	 * @param usuario    El nombre de usuario.
	 * @param actualcon  La contraseña actual del usuario.
	 * @param nuevacon   La nueva contraseña del usuario.
	 */
	public void cambiarContrasena(String usuario, String actualcon, String nuevacon){
		int op = 0;
		BdConex bd = new BdConex();
		// Se ejecuta la actualización de la contraseña en la base de datos
		op = bd.ejecutar("UPDATE contrasenna SET ContrasennaEncriptadaCo = '"+nuevacon.replace("'","''")+"' WHERE CedulaUs = '"+usuario+"' AND ContrasennaEncriptadaCo = '"+actualcon.replace("'","''")+"'");
		// Si se realizó la actualización correctamente
		if(op>0)  JOptionPane.showMessageDialog(null,"Contraseña cambiada con éxito.");
		// Si la contraseña actual no coincide
		else JOptionPane.showMessageDialog(null,"Contraseña incorrecta.");
	}

	// Métodos getter para obtener los datos del usuario
	public String getUsuario() {
		// TODO Auto-generated method stub
		return cconsu.getUsuario();
	}

	public String getNombres(){
		return cconsu.getNombres();
	}

	public String getApellidos(){
		return cconsu.getApellidos();
	}

	public String getRol() {
		// TODO Auto-generated method stub
		return cconsu.getRol();
	}

	public int isAdmin() {
		return cconsu.isAdmin();
	}
	
}
