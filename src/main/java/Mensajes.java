public class Mensajes {
    private int idMensaje;
    private String mensaje;
    private String authorMensaje;
    private String fechaMensaje;

    public Mensajes(){ }

    public Mensajes(int idMensaje, String mensaje, String authorMensaje, String fechaMensaje) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.authorMensaje = authorMensaje;
        this.fechaMensaje = fechaMensaje;
    }
    public Mensajes(String mensaje, String authorMensaje, String fechaMensaje) {
        this.mensaje = mensaje;
        this.authorMensaje = authorMensaje;
        this.fechaMensaje = fechaMensaje;
    }

    public String String() {
        return "\nID: " + this.idMensaje +
               "\nMensaje: " + this.mensaje +
               "\nAutor: " + this.authorMensaje +
               "\nFecha: " + this.fechaMensaje;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAuthorMensaje() {
        return authorMensaje;
    }

    public void setAuthorMensaje(String authorMensaje) {
        this.authorMensaje = authorMensaje;
    }

    public String getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(String fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }
}
