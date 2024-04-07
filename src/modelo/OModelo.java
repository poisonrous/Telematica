package modelo;

import principal.Principal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OModelo {
	//TODO FUNCIONA PERFECTO AQUÍ (cualquiera sea tu problema te aseguro que no está aquí)

	private Modelo cconsu = null;
	private Principal principal = null;
	
	public OModelo() {
		
	}
	
	public Modelo consultaUsuario(String usuario, String contrasena) {
		
		
		ResultSet  rs = null;
		BdConex bd = new BdConex();
		cconsu = new Modelo();
		principal = new Principal();
	
		rs = bd.consultar("SELECT * FROM usuario INNER JOIN contrasenna ON usuario.CedulaUs = contrasenna.cedulaUs INNER JOIN rolusuario ON usuario.IdRoUs = rolusuario.IdRoUs WHERE usuario.CedulaUs =  '"+ usuario+ "' AND contrasenna.ContrasennaEncriptadaCo = '"+contrasena+"'");
		
		
			try {
			rs.next();
			cconsu.setUsuario(rs.getString("cedulaUs"));
			cconsu.setNombres(rs.getString("NombresUs"));
			cconsu.setApellidos(rs.getString("ApellidosUs"));
			cconsu.setContrasena(rs.getString("ContrasennaEncriptadaCo"));
			cconsu.setRol(rs.getString("RolRoUs"));
			JOptionPane.showMessageDialog(null,"Bienvenid@, "+rs.getString("NombresUs")+" "+rs.getString("ApellidosUs"));
			}
			catch(SQLException e){
			 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
			 //e.printStackTrace();
		 }
			
			
			bd.desconectar();
		
		
		return cconsu;

		
		
	}

	public void cambiarContrasena(String usuario, String actualcon, String nuevacon){
		int op = 0;
		BdConex bd = new BdConex();
		op = bd.ejecutar("UPDATE contrasenna SET ContrasennaEncriptadaCo = '"+nuevacon+"' WHERE CedulaUs = '"+usuario+"' AND ContrasennaEncriptadaCo = '"+actualcon+"'");
		if(op>0)  JOptionPane.showMessageDialog(null,"Contraseña cambiada con éxito.");
		else JOptionPane.showMessageDialog(null,"Contraseña incorrecta.");
	}

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
	
}
