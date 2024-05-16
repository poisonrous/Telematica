package vista;

import controlador.CSolicitudReporte;

import java.sql.ResultSet;
    // Interfaz para la gestión de reportes de solicitudes.
public interface ISolicitudReporte {
    // Constantes para acciones de botones
    String CAMBIAR = "cambiar";
    String CAMBIARPLUS = "cambiarplus";

        /**
         * Establece el resultado de la consulta en la interfaz.
         * @param rs El conjunto de resultados de la consulta.
         */
        void setConsulta(ResultSet rs);

        /**
         * Establece el controlador de la interfaz de reporte de solicitudes.
         * @param controlador El controlador de reporte de solicitudes.
         */
        void setControlador(CSolicitudReporte a);

        /**
         * Llama al método de activación.
         * @param idSo El ID de la solicitud.
         */
    void llamar(String idSo);
    void activar(); // Activa la interfaz.


        /**
         * Obtiene el estado de la solicitud.
         * @return El estado de la solicitud.
         */
    String getEstado(); //

        /**
         * Obtiene el ID de la solicitud.
         * @return El ID de la solicitud.
         */
    String getIdSo();



}
