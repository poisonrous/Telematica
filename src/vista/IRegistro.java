package vista;
    // Interfaz para la pantalla de registro de estudiantes.
public interface IRegistro {
    public static final String BUSCAR = "Buscar";
    public static final String REGISTRAR = "Registrar";
    public static final String ACTUALIZAR = "Actualizar";
    public static final String CANCELAR = "Cancelar";

        /**
         * Establece el controlador para esta interfaz.
         * @param controlador El controlador asociado a esta interfaz.
         */
    void setControlador(controlador.CRegistro controlador);

    public void cargarMateria();    // Carga las materias en la interfaz.
    void arrancar();    // Inicializa y muestra la pantalla de registro.

        /**
         * Obtiene la cédula del estudiante.
         * @return La cédula del estudiante.
         */
    public String getCedula();

        /**
         * Obtiene el nombre del estudiante.
         * @return El nombre del estudiante.
         */
    public String getNombre();

        /**
         * Obtiene el apellido del estudiante.
         * @return El apellido del estudiante.
         */
    public String getApellido();

        /**
         * Obtiene el sexo del estudiante.
         * @return El sexo del estudiante.
         */
    public String getSexo();

        /**
         * Obtiene la fecha de nacimiento del estudiante.
         * @reurn La fecha de nacimiento del estudiante.
         */
    public String getFechaNacimiento();

        /**
         * Obtiene el correo electrónico del estudiante.
         * @return El correo electrónico del estudiante.
         */
    public String getCorreo();


        /**
         * Obtiene el número de teléfono del estudiante.
         * @return El número de teléfono del estudiante.
         */
   public String getTelefono();

        /**
         * Obtiene la dirección del estudiante.
         * @return La dirección del estudiante.
         */
   public String getDireccion();

        /**
         * Obtiene las condiciones médicas del estudiante
         * @return Las condiciones médicas del estudiante.
         */
   public String getCondicionesMedicas();

        /**
         * Obtiene la capacidad especial del estudiante.
         * @return La capacidad especial del estudiante.
         */
   public String getCapacidadEspecial();

        /**
         * Verifica si el estudiante trabaja.
         * @return true si el estudiante trabaja, false de lo contrario.
         */
   public boolean isTrabaja();

        /**
         * Verifica si el estudiante es foráneo.
         * @return true si el estudiante es foráneo, false de lo contrario.
         */
   public boolean isForaneo();

        /**
         * Verifica si el estudiante está fuera del país.
         * @return true si el estudiante está fuera del país, false de lo contrario.
         */
   public boolean isFuera();

        /**
         * Obtiene la carrera del estudiante.
         * @return La carrera del estudiante.
         */
    public String getCarrera();

        /**
         * Carga los datos del estudiante en la interfaz.
         * @param nombre            El nombre del estudiante.
         * @param apellido          El apellido del estudiante.
         * @param sexo              El sexo del estudiante.
         * @param fechaNacimiento   La fecha de nacimiento del estudiante.
         * @param correo            El correo electrónico del estudiante.
         * @param telefono          El número de teléfono del estudiante.
         * @param direccion         La dirección del estudiante.
         * @param condicionesMedicas    Las condiciones médicas del estudiante.
         * @param capacidadEspecial     La capacidad especial del estudiante.
         * @param trabaja           Indica si el estudiante trabaja.
         * @param foraneo           Indica si el estudiante es foráneo.
         * @param fuera             Indica si el estudiante está fuera del país.
         */
    void cargarDatos(String nombre, String apellido, String sexo, String fechaNacimiento, String correo, String telefono, String direccion, String condicionesMedicas, String capacidadEspecial, boolean trabaja, boolean foraneo, boolean fuera);
    void limpiar(); // Limpia los campos de la interfaz.
    void habilitarRegistro();   // Habilita el botón de registro.
    void habilitarActualizar();  //  Habilita el botón de actualización.//
}
