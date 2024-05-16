package vista;

import controlador.CSolicitudCurso;

import javax.swing.*;
import java.sql.ResultSet;
    // Interfaz para la creación de una publicación.
public interface ISolicitudCurso {
    // Constante para una accion de un boton
    String SELECT = "select";
    String PARAMETROS = "parametros";

        /**
         * Establece el controlador de la interfaz de solicitud de curso.
         * @param a El controlador de la solicitud de curso.
         */
    void setControlador(CSolicitudCurso a);

        /**
         * Obtiene el estado de la solicitud de curso.
         * @return El estado de la solicitud.
         */
    String getEstado();


        /**
         * Obtiene el tipo de la solicitud de curso.
         * @return El tipo de la solicitud.
         */
    String getTipo();


        /**
         * Obtiene el tipo de la solicitud de curso.
         * @return El tipo de la solicitud.
         */
    String getCarrera();


    //void setEstado();
        /**
         * Establece la consulta en la interfaz de solicitud de curso.
         * @param rs El conjunto de resultados de la consulta.
         */
    void setConsulta(ResultSet rs);
    void mostrar(); // Muestra la interfaz de solicitud de curso.
    void desplegar () ;  // Despliega la interfaz de solicitud de curso.
    void activar();  // Activa la interfaz de solicitud de curso.

        /**
         * Obtiene el valor de prueba.
         * @return El valor de prueba.
         */
    Double getTest();  //

    // Método de prueb
    void probando();

    // Crea una nueva tabla en la interfaz de solicitud
    void nuevatabla();

    // Limpia la tabla en la interfaz de solicitud de curso
    void limpiarTabla();

}
