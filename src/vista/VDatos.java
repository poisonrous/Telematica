package vista;

import controlador.CDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import static java.lang.Float.parseFloat;
import static principal.Principal.instanciar;

// Vista de datos de reportes.
public class VDatos extends JPanel implements IDatos {

    private CDatos controlador;
    private final JPanel pPrincipal, pBotones;
    private final GridBagConstraints reglas;

    private JLabel lConteoMes, lConteoEstuSo, lConteoEstuSu, lSoliC, lSugeC, lMaterias, lMate;
    private JButton bSolicitudes, bSugerencias;

    // Constructor de la vista
    public VDatos (){

        this.setBackground(new Color(255, 255, 255));
        this.setLayout(new BorderLayout());

        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(new Color(255, 255, 255));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);
        JLabel lTitulo = new JLabel("Datos de reportes");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pPrincipal.add(lTitulo, reglas);



        // si no funciona añadirlos a pPrincipal luego
        // Botón para mostrar la lista de solicitudes
        pBotones = new JPanel();
        pBotones.setBackground(new Color(255, 255, 255));
        bSolicitudes = new JButton(" Lista de solicitudes");
        bSolicitudes.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSolicitudes.setForeground(Color.WHITE);
        bSolicitudes.setBackground(new Color(2, 152, 178));

      /*
        bSolicitud.setBackground(new Color(2, 152, 178));*/ //Por si no queda bien el color anterior

        bSolicitudes.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSolicitudCurso());
            pPrincipal.revalidate();
            pPrincipal.repaint();
            pBotones.setVisible(false);
        });
        pBotones.add(bSolicitudes);

        // Botón para mostrar la lista de sugerencias
        bSugerencias = new JButton ("Lista de sugerencias");
        bSugerencias.setFont(new Font("Open Sans", Font.BOLD, 14));
        bSugerencias.setForeground(Color.WHITE);
        bSugerencias.setBackground(new Color(2, 152, 178));
        bSugerencias.addActionListener(e -> {
            pPrincipal.removeAll();
            pPrincipal.add((JPanel) instanciar.llamarSugerencias());
            pPrincipal.revalidate();
            pPrincipal.repaint();
            pBotones.setVisible(false);
        });
        pBotones.add(bSugerencias);

        this.add(pPrincipal, BorderLayout.CENTER);
        this.add(pBotones, BorderLayout.SOUTH);


}


    /**
     * Muestra los datos de los reportes.
     *
     * @param tipoFN         El tipo de solicitud más frecuente.
     * @param tipoF          El nombre del tipo de solicitud más frecuente.
     * @param estudianteSo   El ResultSet con información del estudiante con más solicitudes.
     * @param estudianteSu   El ResultSet con información del estudiante con más sugerencias.
     * @param solicitudM     El número total de solicitudes en el mes.
     * @param sugerenciaM    El número total de sugerencias en el mes.
     * @param solicitudPercent El porcentaje de solicitudes resueltas.
     * @param materia        El ResultSet con información de las materias sin aula.
     */
    @Override
    public void mostrar(String tipoFN, String tipoF, ResultSet estudianteSo, ResultSet estudianteSu, String solicitudM, String sugerenciaM, float solicitudPercent, ResultSet materia) {
        // Configuración del diseño de la interfaz
        reglas.gridy++;
        reglas.anchor = GridBagConstraints.WEST;

        // Etiqueta para mostrar el tipo de solicitud más frecuente
        lConteoMes = new JLabel("Teniendo "+tipoFN+" solicitudes activas, la mayoria de las solicitudes son del tipo "+tipoF+".");
        lConteoMes.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lConteoMes, reglas);

        // Etiqueta para mostrar el estudiante con más solicitudes
        reglas.gridy++;
        try {
            estudianteSo.first();
            lConteoEstuSo = new JLabel(estudianteSo.getString("NombresEs")+" "+estudianteSo.getString("ApellidosEs")+" (V-"+ estudianteSo.getString("CedulaEs") +") es la persona con más solicitudes.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lConteoEstuSo.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lConteoEstuSo, reglas);

        // Etiqueta para mostrar el estudiante con más sugerencias
        reglas.gridy++;
        try {
            estudianteSu.first();
            lConteoEstuSu = new JLabel(estudianteSu.getString("NombresEs")+" "+estudianteSu.getString("ApellidosEs")+" (V-"+ estudianteSo.getString("CedulaEs") +") es la persona con más sugerencias.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lConteoEstuSu.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lConteoEstuSu, reglas);


        // Etiqueta para mostrar el número total de solicitudes
        reglas.gridy++;
        lSoliC = new JLabel("Ha habido un total de " +solicitudM+" solicitudes durante este mes.");
        lSoliC.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lSoliC, reglas);

        // Etiqueta para mostrar el porcentaje de solicitudes resueltas
        reglas.gridy++;
        lSugeC = new JLabel("Ha habido un total de " +sugerenciaM+" sugerencias durante este mes.");
        lSugeC.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lSugeC, reglas);

        // Etiqueta para mostrar el porcentaje de solicitudes resueltas
        reglas.gridy++;
        DecimalFormat df = new DecimalFormat("#.##");
        lMate = new JLabel("Se han resuelto "+df.format(solicitudPercent)+"% de las solicitudes realizadas.");
        lMate.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lMate, reglas);

        // Etiqueta para mostrar las materias sin aula
       reglas.gridy++;
        try {
            materia.last();
            if (materia.getRow()==1){
            lMaterias = new JLabel("Hay "+materia.getRow()+" materia sin aula, referente a la siguiente materia:");
                try {
                    materia.beforeFirst();
                    while (materia.next()) {
                        lMaterias = new JLabel(lMaterias.getText()+ " "+materia.getString("NombreAsignaturaAs"));
                    }} catch (SQLException e) {
                    lMaterias = new JLabel("");
                    e.printStackTrace();
                }
            }
            else if (materia.getRow()==0) {lMaterias = new JLabel("");}
            else   {lMaterias = new JLabel("Hay "+materia.getRow()+" materias sin aula:");

            if (materia.getRow()==2){
                try {int i=0;
                    materia.beforeFirst();
                    while (i<1){
                    materia.next();
                    i++;
                    lMaterias = new JLabel(lMaterias.getText()+ " "+materia.getString("NombreAsignaturaAs")+" y ");
                    }
                    while (materia.next()) {
                        lMaterias = new JLabel(lMaterias.getText()+ " "+materia.getString("NombreAsignaturaAs") + " ");
                   System.out.println("yo");
                    }
                } catch (SQLException e) {
                    lMaterias = new JLabel("");
                    e.printStackTrace();
                }
            }
            else {
                try {int i=0,y=materia.getRow();
                    materia.beforeFirst();
                    while (i<y-1){
                        materia.next();
                        i++;
                        lMaterias = new JLabel(lMaterias.getText()+ " "+materia.getString("NombreAsignaturaAs")+", ");

                    }
                    while (materia.next()) {
                        lMaterias = new JLabel(lMaterias.getText()+ " "+materia.getString("NombreAsignaturaAs")+" ");
                    }
                } catch (SQLException e) {
                    lMaterias = new JLabel("");
                    e.printStackTrace();
                }
            }
        }} catch (SQLException e) {
            throw new RuntimeException(e);
        }

        lMaterias.setFont(new Font("Open Sans", Font.BOLD, 14));
        pPrincipal.add(lMaterias, reglas);

    }

    // Llama al controlador para realizar una acción.
    @Override
    public void llamar() {
        controlador.actionPerformed(new ActionEvent(this, 1, IDatos.DATOS));
    }

    // Regresa a la vista principal de datos.
    @Override
    public void regresar() {
        pPrincipal.removeAll();
        pPrincipal.add(new VDatos());
        pPrincipal.revalidate();
        pPrincipal.repaint();
        pBotones.setVisible(true);
    }

    /**
     * Establece el controlador de esta vista.
     * @param c El controlador.
     */
    @Override
    public void setControlador(CDatos c) {
        this.controlador =c;
    }
}
