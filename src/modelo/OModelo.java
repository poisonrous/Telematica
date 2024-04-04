package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OModelo {
	//TODO FUNCIONA PERFECTO AQUÍ (cualquiera sea tu problema te aseguro que no está aquí)

	private Modelo cconsu = null;
	
	public OModelo() {
		
	}
	
	public Modelo consultaUsuario(String usuario, String contrasena) {
		
		
		ResultSet  rs = null;
		BdConex bd = new BdConex();
		cconsu = new Modelo();
	
		rs = bd.consultar("SELECT * FROM usuario INNER JOIN contrasenna ON usuario.CedulaUs = contrasenna.cedulaUs INNER JOIN roleusuario ON usuario.RolUs = roleusuario.idRo WHERE usuario.CedulaUs =  '"+ usuario+ "' AND contrasenna.contrasennaCo = '"+contrasena+"'");
		
		
			try {
			rs.next();
			cconsu.setUsuario(rs.getString("cedulaUs"));
			cconsu.setContrasena(rs.getString("contrasennaCo"));
			cconsu.setRol(rs.getString("nombreRo"));
			}
			catch(SQLException e){
			 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
			 //e.printStackTrace();
		 }
			
			
			bd.desconectar();
		
		
		return cconsu;

		
		
	}

	public String getUsuario() {
		// TODO Auto-generated method stub
		return cconsu.getUsuario();
	}

	public String getRol() {
		// TODO Auto-generated method stub
		return cconsu.getRol();
	}
	
}
