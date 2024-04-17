package vista;

public interface IRegistro {
    public static final String BUSCAR = "Buscar";
    public static final String REGISTRAR = "Registrar";
    public static final String ACTUALIZAR = "Actualizar";
    public static final String CANCELAR = "Cancelar";

    void setControlador(controlador.CRegistro controlador);
    public void cargarMateria();
    void arrancar();
    public String getCedula();
    public String getNombre();
    public String getApellido();
    public String getSexo();
    public String getFechaNacimiento();
    public String getCorreo();
    public String getTelefono();
    public String getDireccion();
    public String getCondicionesMedicas();
    public String getCapacidadEspecial();
    public boolean isTrabaja();
    public boolean isForaneo();
    public boolean isFuera();
    public String getCarrera();

    void cargarDatos(String nombre, String apellido, String sexo, String fechaNacimiento, String correo, String telefono, String direccion, String condicionesMedicas, String capacidadEspecial, boolean trabaja, boolean foraneo, boolean fuera);
    void limpiar();
    void habilitarRegistro();
    void habilitarActualizar();
}
