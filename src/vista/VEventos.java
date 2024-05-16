package vista;

//import controlador.CEventos;

import controlador.CEventos;

import javax.swing.*;
import java.awt.*;

// Vista para agregar un nuevos eventos
public class VEventos extends JPanel implements IEventos {
    private final JPanel pPrincipal;
    private final GridBagConstraints reglas;

    // Constructor de la vista de eventos
    public VEventos() {
        //this.setPreferredSize(new Dimension(1085, 680));
        // Crear el panel principal
        pPrincipal = new JPanel(new GridBagLayout());
        //pPrincipal.setPreferredSize(new Dimension(1085, 680));
        pPrincipal.setBackground(new Color(255, 255, 255));
        reglas = new GridBagConstraints();
        reglas.gridx = 1;
        reglas.gridy = 1;
        reglas.insets = new Insets(10, 10, 10, 10);

        // Panel para mostrar la imagen de fondo
        JPanel pIconEven = new JPanel();
        pIconEven.setBackground(new Color(255, 255, 255));
        JLabel lImagenEven = new JLabel();
        lImagenEven.setSize(55, 45);
        ImageIcon icon = new ImageIcon("media/eventosA.png");
        Icon iconoCar = new ImageIcon(icon.getImage().getScaledInstance(lImagenEven.getWidth(), lImagenEven.getHeight(), Image.SCALE_DEFAULT));
        lImagenEven.setIcon(iconoCar);
        // pIconEven.add(lImagenEven);
        JLabel lTitulo = new JLabel("Próximos Eventos");
        lTitulo.setFont(new Font("Open Sans", Font.BOLD, 20));
        pIconEven.add(lTitulo);
        pPrincipal.add(pIconEven, reglas);

        // Panel para mostrar la imagen de fondo
        JPanel pImagen = new JPanel();
        pImagen.setBackground(new Color(255, 255, 255));
        reglas.gridx = 3;
        reglas.gridy = 1;
        reglas.gridwidth = 1;
        reglas.gridheight = 5;

        reglas.anchor = GridBagConstraints.EAST;


        JLabel lImagen = new JLabel();
        lImagen.setSize(450, 450);
        ImageIcon imagen = new ImageIcon("media/EventosA.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT));
        lImagen.setIcon(icono);
        pImagen.add(lImagen);
        //pPrincipal.add (pImagen, reglas);

        // Agregar el panel principal al panel de la vista
        this.add(pPrincipal);

        reglas.gridheight = 1;
        reglas.gridx = 1;
        reglas.anchor = GridBagConstraints.WEST;
    }

    // Método para mostrar la vista de eventos
    @Override
    public void arrancar() {
        this.setVisible(true);
    }

    // Método para cargar un evento en la lista de eventos
    @Override
    public void cargarEve(JPanel evento) {
        reglas.gridy++;
        pPrincipal.add(evento, reglas);
    }

    // Método para establecer el controlador (aún no implementado)
    @Override
    public void setControlador(CEventos controlador) {
        //Por si algún día queremos agregar algún botón de "asistiré" o algo por el estilo
    }

    // Método para crear un panel que representa un evento
    @Override
    public JPanel getEvento(String titulo, String descripcion, String fecha, String hora, String lugar, String organizador, String modalidad, String precio) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints reglas = new GridBagConstraints();
        reglas.anchor = GridBagConstraints.WEST;
        reglas.gridx = 1;
        reglas.gridy = 1;

        // Etiqueta para el título del evento
        JLabel lTituloEven = new JLabel(titulo);
        lTituloEven.setFont(new Font("Roboto", Font.BOLD, 16));
        lTituloEven.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lTituloEven, reglas);


        reglas.gridy = 2;
        // Etiqueta para el organizador del evento
        JLabel lOrganizado = new JLabel("Organizado por " + organizador);
        lOrganizado.setFont(new Font("Open Sans", Font.BOLD, 14));
        lOrganizado.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lOrganizado, reglas);


        reglas.gridy = 3;
        // Etiqueta para el precio del evento
        JLabel lPrecio = new JLabel("Precio: ");
        lPrecio.setFont(new Font("Open Sans", Font.BOLD, 14));
        lPrecio.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lPrecio, reglas);

        reglas.gridy = 4;
        // Etiqueta para la fecha del evento
        JLabel lFecha = new JLabel("Fecha: ");
        lFecha.setFont(new Font("Open Sans", Font.BOLD, 14));
        lFecha.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lFecha, reglas);


        reglas.gridy = 5;
        // Etiqueta para la hora
        JLabel lHora = new JLabel("Hora: ");
        lHora.setFont(new Font("Open Sans", Font.BOLD, 14));
        lHora.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lHora, reglas);

        reglas.gridy = 6;
        // Etiqueta para la modalidad
        JLabel lModalidad = new JLabel("Modalidad: ");
        lModalidad.setFont(new Font("Open Sans", Font.BOLD, 14));
        lModalidad.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lModalidad, reglas);

        reglas.gridy = 7;
        // Etiqueta para el lugar
        JLabel lLugar = new JLabel("Lugar: ");
        lLugar.setFont(new Font("Open Sans", Font.BOLD, 14));
        lLugar.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lLugar, reglas);

        reglas.gridy = 8;
        // Etiqueta para la descripcion
        reglas.anchor = GridBagConstraints.NORTHWEST;
        JLabel lDescripcion = new JLabel("Descripción: ");
        lDescripcion.setFont(new Font("Open Sans", Font.BOLD, 14));
        lDescripcion.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lDescripcion, reglas);

        reglas.anchor = GridBagConstraints.WEST;


        reglas.gridx = 2;
        reglas.gridy = 3;
        // Etiqueta para el campo de precio
        JLabel stringPrecio = new JLabel(precio);
        stringPrecio.setFont(new Font("Open Sans", Font.BOLD, 14));
        stringPrecio.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(stringPrecio, reglas);

        reglas.gridy = 4;
        // Etiqueta para el campo de fecha
        JLabel lFechaE = new JLabel(fecha);
        lFechaE.setFont(new Font("Open Sans", Font.BOLD, 14));
        lFechaE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lFechaE, reglas);

        reglas.gridy = 5;
        // Etiqueta para el campo de hora
        JLabel lHoraE = new JLabel(hora);
        lHoraE.setFont(new Font("Open Sans", Font.BOLD, 14));
        lHoraE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lHoraE, reglas);

        reglas.gridy = 6;
        // Etiqueta para el campo de modalidad
        JLabel lModalidadE = new JLabel(modalidad);
        lModalidadE.setFont(new Font("Open Sans", Font.BOLD, 14));
        lModalidadE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lModalidadE, reglas);

        reglas.gridy = 7;
        // Etiqueta para el campo de lugar
        JLabel lLugarE = new JLabel(lugar);
        lLugarE.setFont(new Font("Open Sans", Font.BOLD, 14));
        lLugarE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lLugarE, reglas);

        reglas.gridy = 8;
        // Area de texto para la descripcion del evento
        JTextArea tDescripcionE = new JTextArea(descripcion);
        tDescripcionE.setFont(new Font("Open Sans", Font.BOLD, 14));
        tDescripcionE.setPreferredSize(new Dimension(200, 100));
        tDescripcionE.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tDescripcionE.setLineWrap(true);
        tDescripcionE.setWrapStyleWord(true);
        tDescripcionE.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(tDescripcionE, reglas);

        // Si el evento es gratuito, mostrar una etiqueta "GRATUITO" en lugar del precio
        if (precio.equals("0")) {
            if (precio.equals("0")) {
                lPrecio.setVisible(false);
                stringPrecio.setVisible(false);
                JLabel lGratis = new JLabel("GRATUITO");
                lGratis.setBackground(Color.GREEN);
                lGratis.setOpaque(true);
                reglas.gridx = 1;
                reglas.gridy = 3;
                reglas.gridwidth = 2;
                panel.add(lGratis, reglas);

            }

        }
        return panel; // Devolver el panel que representa el evento
    }
}
