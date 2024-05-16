package modelo;

// La clase Modelo representa los datos de un usuario en el sistema
public class Modelo {

	private String usuario, nombres, apellidos, rol, contrasena;
	private int admin;

	/**
	 * Constructor de la clase Modelo.
	 * @param usuario El nombre de usuario.
	 * @param nombres Los nombres del usuario.
	 * @param apellidos Los apellidos del usuario.
	 * @param rol El rol del usuario.
	 * @param contrasena La contraseña del usuario.
	 * @param admin Un indicador de si el usuario es administrador (1) o no (0).
	 */
	public Modelo(String usuario, String nombres, String apellidos, String rol, String contrasena, int admin) {
		
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
		this.contrasena = contrasena;
		this.admin = admin;
	}


	// Constructor vacío de la clase Modelo
	public Modelo () {
		
	}

	/**
	 * Establece el nombre de usuario.
	 * @param usuario El nombre de usuario a establecer.
	 */
    public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el rol del usuario.
	 * @return El rol del usuario.
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Establece el rol del usuario.
	 * @return El rol del usuario.
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Obtiene el nombre de usuario.
	 * @return El nombre de usuario.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * @return La contraseña del usuario.
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Establece la contraseña del usuario.
	 * @param contrasena La contraseña a establecer.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Obtiene los nombres completos del usuario.
	 * @return Los nombres completos del usuario.
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece los nombres completos del usuario.
	 * @param nombres Los nombres completos a establecer.
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Obtiene los apellidos completos del usuario.
	 * @return Los apellidos completos del usuario.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos completos del usuario.
	 * @param apellidos Los apellidos completos a establecer.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	//Establece si el usuario es administrador.
	public int isAdmin() {
		return admin;}

	public void setAdmin(int admin) {this.admin = admin;}
	}
