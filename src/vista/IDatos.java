package vista;

import controlador.CDatos;

import java.sql.ResultSet;

 // Interfaz que define los métodos necesarios para la vista de los datos.
public interface IDatos {
    // Constante del evento de visualización de datos.
    String DATOS = "datos";

     /**
      * Establece el controlador para esta interfaz.
      * @param c el controlador CDatos
      */
    void setControlador (CDatos c);

     /**
      * Muestra los datos en la interfaz.
      *
      * @param tipoFN el tipo de formulario que se está mostrando ("nuevo" o "editar")
      * @param tipoF el tipo de formulario específico ("estudiante", "solicitud", "sugerencia", etc.)
      * @param estudianteSo el ResultSet que contiene los datos de los estudiantes
      * @param estudianteSu el ResultSet que contiene los datos de los estudiantes
      * @param solicitudM el mensaje de la solicitud
      * @param sugerenciaM el mensaje de la sugerencia
      * @param solicitudPercent el porcentaje de solicitud
      * @param materia el ResultSet que contiene los datos de la materia
      */
    void mostrar(String tipoFN, String tipoF, ResultSet estudianteSo, ResultSet estudianteSu, String solicitudM, String sugerenciaM, float solicitudPercent, ResultSet materia);

    void llamar (); // Llama a la función específica de esta vista.

    void regresar();   // Regresa a la vista anterior

}
