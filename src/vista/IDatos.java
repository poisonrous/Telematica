package vista;

import controlador.CDatos;

import java.sql.ResultSet;

public interface IDatos {

    String DATOS = "datos";

    void setControlador (CDatos c);

    void mostrar(String tipoFN, String tipoF, ResultSet estudianteSo, ResultSet estudianteSu, String solicitudM, String sugerenciaM, float solicitudPercent, ResultSet materia);

    void llamar ();

    void regresar();

}
