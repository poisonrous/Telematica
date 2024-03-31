package modelo;

public class Solicitud {
    private String tipo, materia, descripcion, usuario;
    private boolean estado;

    public Solicitud() {}
    public Solicitud(String tipo, String materia, String descripcion, String usuario, boolean estado) {
        this.tipo = tipo;
        this.materia = materia;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
