package controlador;
import modelo.MCartelera;
import vista.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

// Controlador para la funcionalidad de la cartelera.

public class CCartelera {
    private final ICartelera vista;  // Vista de la interfaz de cartelera
    private final IPub pub;     // Interfaz para las publicaciones
    private ResultSet rs;       // Resultado de la consulta a la base de datos
    private final MCartelera mCartelera;       // Modelo de la cartelera

    /**
     * Constructor de la clase CCartelera.
     * @param vista La vista de la cartelera.
     * @param pub La interfaz para las publicaciones.
     * @param mCartelera El modelo de la cartelera.
     */

    public CCartelera(ICartelera vista, IPub pub, MCartelera mCartelera) {
        this.vista = vista;
        this.pub = pub;
        this.mCartelera = mCartelera;
    }

    /**
     * Carga las publicaciones de la cartelera en la vista.
     */
    public void cargarCartelera() {
        JPanel articulo = null;  // Panel que contendrá la información de cada publicación
        rs = mCartelera.getResultSet();  // Obtiene el resultado de la consulta a la base de datos
        try {
            int i = 0;  // Contador para limitar el número de publicaciones cargadas
            while (rs.next() && i<10){  // Recorre el resultado de la consulta
                String titulo = rs.getString("tituloPu");  // Obtiene el título de la publicación
                String autor = rs.getString("NombresUs")+" "+rs.getString("ApellidosUs"); // Obtiene el autor de la publicación
                String contenido = rs.getString("descripcionPu"); // Obtiene el contenido de la publicación
                TemporalAccessor fecha = rs.getTimestamp("fechaPu").toLocalDateTime();  // Obtiene la fecha de la publicación
                articulo = pub.getPublicacion(titulo, autor, contenido, fecha);  // Obtiene el panel de la publicación
                vista.cargarPub(articulo);  // Carga el panel de la publicación en la vista
                i++;  // Incrementa el contador
            }
        }   catch (SQLException e) {
            e.printStackTrace();  // Maneja los errores de SQL
        }
       /* JPanel articulo = null;
        int i=0;
        while (i<5){
        articulo = pub.getPublicacion("Titulo","Autor","Contenido");
        vista.cargarPub(articulo);
        i++;
        }*/
    }
}
