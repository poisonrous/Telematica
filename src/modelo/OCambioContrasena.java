package modelo;

import javax.swing.*;

public class OCambioContrasena {

	public boolean  verificarContrasena(MCambioContrasena cons) {
		// TODO Auto-generated method stub
		
		int op =0;
		BdConex bd = new BdConex();
		boolean correcto=false;
		bd.abrirConexion();
		JOptionPane.showMessageDialog(null, cons.getConfirmarContrasena()+cons.getUsuario()+cons.getContrasenaActual());
	    op=bd.ejecutar("UPDATE contrasenna c INNER JOIN usuario u ON u.idCont = c.idCont SET c.contrasennaIncriptadaCon = '" 
		+cons.getConfirmarContrasena()+"' WHERE u.nombreUsuario = '" + cons.getUsuario()+ "' AND c.contrasennaIncriptadaCon= '" +cons.getContrasenaActual());
		
		//op = bd.ejecutar(" UPDATE contrasenna SET contrasennaIncriptadaCon = '"+cons.getConfirmarContrasena()+"'");
		
		if(op>0)
			correcto=true;
		bd.desconectar();
		return correcto;
		
	}

		
	
}
