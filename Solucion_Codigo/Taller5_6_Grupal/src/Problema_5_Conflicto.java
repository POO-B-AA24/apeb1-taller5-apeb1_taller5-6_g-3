//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
public class Problema_5_Conflicto {
    public String nombreConflicto, fecha, estadoConflicto;
    public String[] paises;
    public ArrayList<Problema_5_Evento> eventos;
    public String[] primerMundo = {"Alemania", "Canada", "Estados Unidos", "Suiza", "China"};
    public Problema_5_Conflicto(String nombreConflicto, String[] paises, String fecha) {
        this.nombreConflicto = nombreConflicto;
        this.paises = paises;
        this.fecha = fecha;
        this.estadoConflicto = "Activo";
        this.eventos = new ArrayList<>();
    }
    public void agregarEvento(Problema_5_Evento evento) {
        eventos.add(evento);
        definirEstadoConflicto();
    }

    private void definirEstadoConflicto() {
        ArrayList<String> batallas = new ArrayList<>();
        for (Problema_5_Evento evento : eventos) {
            if (evento.getTipo().equals("Batalla")) {
                batallas.add(evento.getNombre());
            }
        }
        double porcentajeBatallas = (double) batallas.size() / paises.length;
        if (porcentajeBatallas >= 0.3) {
            estadoConflicto = "Hacer llamado a la ONU";
        } else if (porcentajeBatallas > 0.5) {
            estadoConflicto = "Guerra Mundial";
        }
        for (Problema_5_Evento evento : eventos) {
            for (String pais : primerMundo) {
                if ((paises).equals(pais) && evento.getNucleares()) {
                    evento.setNucleares(true);
                    break;
                }
            }
            if (evento.getNucleares()) {
                estadoConflicto = "Guerra Mundial";
                break;
            }
        }
        for (Problema_5_Evento evento : eventos) {
            if (evento.getPorcentaje() >= 50) {
                estadoConflicto = "Hacer llamado a la ONU";
                break;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conflicto{")
                .append("\nNombre: ").append(nombreConflicto)
                .append("\nPaises: ").append(String.join(", ", paises))
                .append("\nFecha: ").append(fecha)
                .append("\nCondicion: ").append(estadoConflicto)
                .append("\n---Eventos--- ");
        for (int i = 0; i < eventos.size(); i++) {
            sb.append(eventos.get(i).toString());
            if (i < eventos.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    public void mostrarInformacion() {
        System.out.println(toString());
    }
}