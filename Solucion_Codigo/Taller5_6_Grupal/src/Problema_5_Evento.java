//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
public class Problema_5_Evento {
    public String nombre, fecha, lugar, tipo, descripcion;
    public int porcentaje;
    public boolean nucleares;
    public Problema_5_Evento(String nombre, String fecha, String lugar, String tipo, String descripcion, boolean nucleares, int porcentaje) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nucleares = nucleares;
        this.porcentaje = porcentaje;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public String getLugar() {
        return lugar;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setNucleares(boolean nucleares) {
        this.nucleares = nucleares;
    }
    public boolean getNucleares() {
        return nucleares;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\nNombre: ").append(nombre)
                .append("\nFecha: ").append(fecha)
                .append("\nUbicacion: ").append(lugar)
                .append("\nTipo: ").append(tipo)
                .append("\nDescripcion: ").append(descripcion);
        return sb.toString();
    }
    public void mostrarInformacion() {
        System.out.println(toString());
    }
}