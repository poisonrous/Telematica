package vista;

import com.toedter.calendar.JDateChooser;
import controlador.CRegistro;
import modelo.BdConex;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

// Vista del registro de estudiante
public class VRegistro extends JPanel implements IRegistro {

    private JButton bBuscar, bRegistrar, bActualizar, bCancelar;
    private JTextField tCedula, tNombre, tApellido, tCorreo, tTelefono, tDireccion, tCondicioneMedica, tCapacidadEspecial;
    private JRadioButton rMasculino, rFemenino;
    private ButtonGroup grupoSexo;
    private JCheckBox cTrabajo, cForaneo, cFuera;
    private JDateChooser dcFechaNacimiento;
    private JComboBox cCarrera;

    // Constructor de la clase VRegistro
    public VRegistro() {
        this.setPreferredSize(new Dimension(1085, 680));
        this.setLayout(new BorderLayout());

        // Panel para el título
        JPanel pTitulo = new JPanel();
        JLabel lTitulo = new JLabel("REGISTRO DE ESTUDIANTES");
        pTitulo.setBackground(new Color(255, 255, 255));
        lTitulo.setFont(new Font("Open Sans", Font.BOLD,20));
        lTitulo.setForeground(new Color(2, 152, 178));
        lTitulo.setHorizontalAlignment(JLabel.CENTER);
        pTitulo.add(lTitulo);
        this.add(pTitulo, BorderLayout.NORTH);

        // Panel para botones
        JPanel pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new Font("Open Sans", Font.BOLD, 15));
        bCancelar.setForeground(Color.WHITE);
        bCancelar.setBackground(new Color(2, 152, 178));
        bCancelar.setActionCommand(IRegistro.CANCELAR);
        pBotones.add(bCancelar);


        bRegistrar = new JButton("Registrar");
        bRegistrar.setFont(new Font("Open Sans", Font.BOLD, 15));
        bRegistrar.setForeground(Color.WHITE);
        bRegistrar.setBackground(new Color(2, 152, 178));
        bRegistrar.setActionCommand(IRegistro.REGISTRAR);
        bRegistrar.setEnabled(false);
        pBotones.add(bRegistrar);
        bActualizar = new JButton("Actualizar");
        bActualizar.setFont(new Font("Open Sans", Font.BOLD, 15));
        bActualizar.setForeground(Color.WHITE);
        bActualizar.setBackground(new Color(2, 152, 178));
        bActualizar.setActionCommand(IRegistro.ACTUALIZAR);
        pBotones.add(bActualizar);
        bActualizar.setVisible(false);
        this.add(pBotones, BorderLayout.SOUTH);

        // Panel para el formulario de registro
        JPanel pFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.insets = new Insets(9, 10, 10, 10);

        pFormulario.setBackground(new Color(255, 255, 255));

        // Componentes del formulario: etiquetas y campos de texto
        JLabel lCedula = new JLabel("Cédula:");
        lCedula.setFont(new Font("Open Sans", Font.BOLD, 15));
        lCedula.setForeground(new Color(2, 152, 178));
        reglas.anchor = GridBagConstraints.WEST;
        reglas.gridx = 1;
        reglas.gridy = 1;
        pFormulario.add(lCedula, reglas);

        JLabel lCarrera = new JLabel("Carrera:");
        lCarrera.setFont(new Font("Open Sans", Font.BOLD, 15));
        lCarrera.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lCarrera, reglas);

        JLabel lNombre = new JLabel("Nombre:");
        lNombre.setFont(new Font("Open Sans", Font.BOLD, 15));
        lNombre.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lNombre, reglas);

        JLabel lApellido = new JLabel("Apellido:");
        lApellido.setFont(new Font("Open Sans", Font.BOLD, 15));
        lApellido.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lApellido, reglas);

        JLabel lSexo = new JLabel("Sexo:");
        lSexo.setFont(new Font("Open Sans", Font.BOLD, 15));
        lSexo.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lSexo, reglas);

        JLabel lFechaNacimiento = new JLabel("Fecha de nacimiento:");
        lFechaNacimiento.setFont(new Font("Open Sans", Font.BOLD, 15));
        lFechaNacimiento.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lFechaNacimiento, reglas);

        JLabel lCorreo = new JLabel("Correo:");
        lCorreo.setFont(new Font("Open Sans", Font.BOLD, 15));
        lCorreo.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lCorreo, reglas);

        JLabel lTelefono = new JLabel("Teléfono:");
        lTelefono.setFont(new Font("Open Sans", Font.BOLD, 15));
        lTelefono.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lTelefono, reglas);

        JLabel lDireccion = new JLabel("Dirección:");
        lDireccion.setFont(new Font("Open Sans", Font.BOLD, 15));
        lDireccion.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lDireccion, reglas);

        JLabel lCondicionesMedicas = new JLabel("Condiciones médicas:");
        lCondicionesMedicas.setFont(new Font("Open Sans", Font.BOLD, 15));
        lCondicionesMedicas.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lCondicionesMedicas, reglas);

        JLabel lCapacidadEspecial = new JLabel("Capacidad especial:");
        lCapacidadEspecial.setFont(new Font("Open Sans", Font.BOLD, 15));
        lCapacidadEspecial.setForeground(new Color(2, 152, 178));
        reglas.gridy++;
        pFormulario.add(lCapacidadEspecial, reglas);

        // Componentes del formulario: checkboxes
        JPanel pCondiciones = new JPanel();
        pCondiciones.setBackground(new Color(255, 255, 255));
        cTrabajo = new JCheckBox("Estudiante trabaja");
        cTrabajo.setFont(new Font("Open Sans", Font.BOLD, 15));
        cTrabajo.setBackground(new Color(255, 255, 255));
        cForaneo = new JCheckBox("Estudiante foráneo");
        cForaneo.setFont(new Font("Open Sans", Font.BOLD, 15));
        cForaneo.setBackground(new Color(255, 255, 255));
        cFuera = new JCheckBox("Fuera del país");
        cFuera.setFont(new Font("Open Sans", Font.BOLD, 15));
        cFuera.setBackground(new Color(255, 255, 255));
        pCondiciones.add(cTrabajo);
        pCondiciones.add(cForaneo);
        pCondiciones.add(cFuera);
        reglas.gridy++;
        reglas.gridwidth = 3;
        pFormulario.add(pCondiciones, reglas);

      // Campos del registro
        tCedula = new JTextField();
        tCedula.setPreferredSize(new Dimension(200, 30));
        Validacion.validarNumeros(tCedula);
        reglas.gridx = 2;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        pFormulario.add(tCedula, reglas);

        cCarrera = new JComboBox();
        cCarrera.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        pFormulario.add(cCarrera, reglas);

        /*JTextField tCarrera = new JTextField();
        tCarrera.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        pFormulario.add(tCarrera, reglas);*/


        tNombre = new JTextField();
        tNombre.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarLetras(tNombre);
        tNombre.setEnabled(false);
        pFormulario.add(tNombre, reglas);

        tApellido = new JTextField();
        tApellido.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarLetras(tApellido);
        tApellido.setEnabled(false);
        pFormulario.add(tApellido, reglas);

        grupoSexo = new ButtonGroup();
        rMasculino = new JRadioButton("Masculino");
        rMasculino.setFont(new Font("Open Sans", Font.BOLD, 15));
        rMasculino.setBackground(new Color(255, 255, 255));
        rFemenino = new JRadioButton("Femenino");
        rFemenino.setFont(new Font("Open Sans", Font.BOLD, 15));
        rFemenino.setBackground(new Color(255, 255, 255));
        grupoSexo.add(rMasculino);
        grupoSexo.add(rFemenino);
        JPanel pSexo = new JPanel();
        pSexo.setBackground(new Color(255, 255, 255));
        pSexo.add(rMasculino);
        pSexo.add(rFemenino);
        reglas.gridy++;
        rFemenino.setEnabled(false);
        rMasculino.setEnabled(false);
        pFormulario.add(pSexo, reglas);

        dcFechaNacimiento = new JDateChooser();
        dcFechaNacimiento.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        dcFechaNacimiento.setEnabled(false);
        pFormulario.add(dcFechaNacimiento, reglas);

        tCorreo = new JTextField();
        tCorreo.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarLongitud(tCorreo, 45);
        tCorreo.setEnabled(false);
        pFormulario.add(tCorreo, reglas);

        tTelefono = new JTextField();
        tTelefono.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarNumeros(tTelefono, 11);
        tTelefono.setEnabled(false);
        pFormulario.add(tTelefono, reglas);

        tDireccion = new JTextField();
        tDireccion.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarLongitud(tDireccion,100);
        tDireccion.setEnabled(false);
        pFormulario.add(tDireccion, reglas);

        tCondicioneMedica = new JTextField();
        tCondicioneMedica.setPreferredSize(new Dimension(200, 30));
        reglas.gridy++;
        Validacion.validarLongitud(tCondicioneMedica,300);
        tCondicioneMedica.setEnabled(false);
        pFormulario.add(tCondicioneMedica, reglas);

        tCapacidadEspecial = new JTextField();
        tCapacidadEspecial.setPreferredSize(new Dimension(200, 30));
        Validacion.validarLongitud(tCapacidadEspecial,45);
        reglas.gridy++;
        tCapacidadEspecial.setEnabled(false);
        pFormulario.add(tCapacidadEspecial, reglas);

        bBuscar = new JButton("Buscar");
        bBuscar.setActionCommand(IRegistro.BUSCAR);
        bBuscar.setFont(new Font("Open Sans", Font.BOLD, 15));
        bBuscar.setForeground(Color.WHITE);
        bBuscar.setBackground(new Color(2, 152, 178));
        reglas.gridx = 3;
        reglas.gridy = 1;
        pFormulario.add(bBuscar, reglas);

        this.add(pFormulario, BorderLayout.CENTER);

    }

    /**
     * Método para establecer el controlador para la vista de registro.
     * @param controlador Controlador del registro.
     */
    @Override
    public void setControlador(CRegistro controlador) {
        bBuscar.addActionListener(controlador);
        bRegistrar.addActionListener(controlador);
        bActualizar.addActionListener(controlador);
        bCancelar.addActionListener(controlador);
    }

    // Carga las carreras desde la bd y las añade al JComboBox cCarrera.
    @Override
    public void cargarMateria() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = conn.getConexion();
        try {
            ps = con.prepareStatement("SELECT * FROM carrera");
            rs = ps.executeQuery();
            while (rs.next()) {
                cCarrera.addItem(rs.getString("NombreCa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hace visible la vista de registro.
    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    /**
     * Obtiene la cédula ingresada en el campo de texto.
     * @return La cédula ingresada.
     */
    @Override
    public String getCedula() {
        return tCedula.getText();
    }

    /**
     * Obtiene el nombre ingresado en el campo de texto.
     * @return El nombre ingresado.
     */
    @Override
    public String getNombre() {
        return tNombre.getText();
    }

    /**
            * Obtiene el apellido ingresado en el campo de texto.
     * @return El apellido ingresado.
     */
    @Override
    public String getApellido() {
        return tApellido.getText();
    }

    /**
     * Obtiene el sexo seleccionado (Masculino o Femenino).
     * @return El sexo seleccionado.
     */
    @Override
    public String getSexo() {
        return rMasculino.isSelected() ? "M" : "F";
    }

    /**
     * Obtiene la fecha de nacimiento ingresada en el campo de fecha.
     * @return La fecha de nacimiento en formato "yyyy-MM-dd".
     */
    @Override
    public String getFechaNacimiento() {return dcFechaNacimiento.getDateFormatString(); }
        // Código para obtener la fecha de nacimiento en el formato deseado


    /**
     * Obtiene el correo electrónico ingresado en el campo de texto.
     * @return El correo electrónico ingresado.
     */
    /**
     * Obtiene el correo electrónico ingresado en el campo de texto.
     * @return El correo electrónico ingresado.
     */
    @Override
    public String getCorreo() {
        return tCorreo.getText();
    }

    /**
     * Obtiene el teléfono ingresado en el campo de texto.
     * @return El teléfono ingresado.
     */
    @Override
    public String getTelefono() {
        return tTelefono.getText();
    }

    /**
     * Obtiene la dirección ingresada en el campo de texto.
     * @return La dirección ingresada.
     */
    @Override
    public String getDireccion() {
        return tDireccion.getText();
    }

    /**
     * Obtiene las condiciones médicas ingresadas en el campo de texto.
     * @return Las condiciones médicas ingresadas.
     */
    @Override
    public String getCondicionesMedicas() {
        return tCondicioneMedica.getText();
    }

    /**
     * Obtiene la capacidad especial ingresada en el campo de texto.
     * @return La capacidad especial ingresada.
     */
    @Override
    public String getCapacidadEspecial() {
        return tCapacidadEspecial.getText();
    }

    /**
     * Verifica si el estudiante trabaja.
     * @return true si el estudiante trabaja, false de lo contrario.
     */
    @Override
    public boolean isTrabaja() {
        return cTrabajo.isSelected();
    }

    /**
     * Verifica si el estudiante es foráneo.
     * @return true si el estudiante es foráneo, false de lo contrario.
     */
    @Override
    public boolean isForaneo() {
        return cForaneo.isSelected();
    }

    /**
     * Verifica si el estudiante está fuera del país.
     * @return true si el estudiante está fuera del país, false de lo contrario.
     */
    @Override
    public boolean isFuera() {
        return cFuera.isSelected();
    }

    /**
     * Obtiene la carrera seleccionada en el JComboBox.
     * @return La carrera seleccionada.
     */
    @Override
    public String getCarrera() {
        return cCarrera.getSelectedItem().toString();
    }

    /**
     * Carga los datos del estudiante en los campos correspondientes de la vista para actualizar la información.
     * @param nombre Nombre del estudiante.
     * @param apellido Apellido del estudiante.
     * @param sexo Sexo del estudiante.
     * @param fechaNacimiento Fecha de nacimiento del estudiante.
     * @param correo Correo electrónico del estudiante.
     * @param telefono Teléfono del estudiante.
     * @param direccion Dirección del estudiante.
     * @param condicionesMedicas Condiciones médicas del estudiante.
     * @param capacidadEspecial Capacidad especial del estudiante.
     * @param trabaja Booleano que indica si el estudiante trabaja.
     * @param foraneo Booleano que indica si el estudiante es foráneo.
     * @param fuera Booleano que indica si el estudiante está fuera del país.
     */
    @Override
    public void cargarDatos(String nombre, String apellido, String sexo, String fechaNacimiento, String correo, String telefono, String direccion, String condicionesMedicas, String capacidadEspecial, boolean trabaja, boolean foraneo, boolean fuera) {
        tNombre.setText(nombre);
        tApellido.setText(apellido);
        if (sexo.equals("M")) {
            rMasculino.setSelected(true);
        } else {
            rFemenino.setSelected(true);
        }
        tCorreo.setText(correo);
        tTelefono.setText(telefono);
        tDireccion.setText(direccion);
        tCondicioneMedica.setText(condicionesMedicas);
        tCapacidadEspecial.setText(capacidadEspecial);
        cTrabajo.setSelected(trabaja);
        cForaneo.setSelected(foraneo);
        cFuera.setSelected(fuera);
        dcFechaNacimiento.setDate(java.sql.Date.valueOf(fechaNacimiento));
    }

    // Limpia todos los campos de la vista
    @Override
    public void limpiar() {
        bRegistrar.setVisible(true);
        bActualizar.setVisible(false);
        bRegistrar.setEnabled(false);
        tCedula.setEnabled(true);
        tNombre.setEnabled(false);
        tApellido.setEnabled(false);
        rMasculino.setEnabled(false);
        rFemenino.setEnabled(false);
        tCorreo.setEnabled(false);
        tTelefono.setEnabled(false);
        tDireccion.setEnabled(false);
        tCondicioneMedica.setEnabled(false);
        tCapacidadEspecial.setEnabled(false);
        cTrabajo.setEnabled(false);
        cForaneo.setEnabled(false);
        cFuera.setEnabled(false);
        dcFechaNacimiento.setEnabled(false);
        tCedula.setText("");
        tNombre.setText("");
        tApellido.setText("");
        grupoSexo.clearSelection();
        tCorreo.setText("");
        tTelefono.setText("");
        tDireccion.setText("");
        tCondicioneMedica.setText("");
        tCapacidadEspecial.setText("");
        cTrabajo.setSelected(false);
        cForaneo.setSelected(false);
        cFuera.setSelected(false);
        dcFechaNacimiento.setDate(null);
    }

    // Habilita los campos de la vista para registro
    @Override
    public void habilitarRegistro() {
        this.cargarMateria();
        bRegistrar.setEnabled(true);
        bActualizar.setVisible(false);
        tCedula.setEnabled(false);
        tNombre.setEnabled(true);
        tApellido.setEnabled(true);
        rMasculino.setEnabled(true);
        rFemenino.setEnabled(true);
        rFemenino.setSelected(true);
        tCorreo.setEnabled(true);
        tTelefono.setEnabled(true);
        tDireccion.setEnabled(true);
        tCondicioneMedica.setEnabled(true);
        tCapacidadEspecial.setEnabled(true);
        cTrabajo.setEnabled(true);
        cForaneo.setEnabled(true);
        cFuera.setEnabled(true);
        dcFechaNacimiento.setEnabled(true);

    }

    // Habilita los campos de la vista para actualización
    @Override
    public void habilitarActualizar() {
        this.cargarMateria();
        bActualizar.setVisible(true);
        bRegistrar.setEnabled(false);
        bRegistrar.setVisible(false);
        tCedula.setEnabled(false);
        tNombre.setEnabled(true);
        tApellido.setEnabled(true);
        rMasculino.setEnabled(true);
        rFemenino.setEnabled(true);
        tCorreo.setEnabled(true);
        tTelefono.setEnabled(true);
        tDireccion.setEnabled(true);
        tCondicioneMedica.setEnabled(true);
        tCapacidadEspecial.setEnabled(true);
        cTrabajo.setEnabled(true);
        cForaneo.setEnabled(true);
        cFuera.setEnabled(true);
        dcFechaNacimiento.setEnabled(true);
    }
}
