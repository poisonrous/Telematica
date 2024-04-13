package controlador;
import modelo.MCartelera;
import vista.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class CCartelera {
    private final ICartelera vista;
    private final IPub pub;
    private ResultSet rs;
    private final MCartelera mCartelera;

    public CCartelera(ICartelera vista, IPub pub, MCartelera mCartelera) {
        this.vista = vista;
        this.pub = pub;
        this.mCartelera = mCartelera;
    }

    public void cargarCartelera() {
        JPanel articulo = null;
        rs = mCartelera.getResultSet();
        try {
            int i = 0;
            while (rs.next() && i<10){
                String titulo = rs.getString("tituloPu");
                String autor = rs.getString("NombresUs")+" "+rs.getString("ApellidosUs");
                String contenido = rs.getString("descripcionPu");
                TemporalAccessor fecha = rs.getTimestamp("fechaPu").toLocalDateTime();
                articulo = pub.getPublicacion(titulo, autor, contenido, fecha);
                vista.cargarPub(articulo);
                i++;
            }
        }   catch (SQLException e) {
            e.printStackTrace();
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
