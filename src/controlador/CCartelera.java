package controlador;
import modelo.MCartelera;
import vista.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCartelera {
    private ICartelera vista;
    private IPub pub;
    private ResultSet rs;
    private MCartelera mCartelera;

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
                String fecha = rs.getString("fechaPu");
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
