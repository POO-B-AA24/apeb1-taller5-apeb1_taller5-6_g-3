//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
public class Problema_2_Materia {
    public String nombreMateria, bandera;
    public double acd, ape, aa, sumatoria;
    public Problema_2_Materia(String nombreMateria, double acd, double ape, double aa) {
        this.nombreMateria = nombreMateria;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }
    public void verificarMateria() {
        this.sumatoria = (this.acd * 0.35) + (this.ape * 0.35) + (this.aa * 0.3);
        if (sumatoria >= 7) {
            bandera = "Aprobado";
        } else {
            bandera = "Desaprobada, debera rendir un examen de recuperacian sobre 3.5/10";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(nombreMateria)
                .append("\n---Notas---")
                .append("\nACD: ").append(acd)
                .append("\nAPE: ").append(ape)
                .append("\nAA: ").append(aa)
                .append("\nNota Final: ").append(sumatoria)
                .append("\nCondicion: ").append(bandera)
                .append("\n");
        return sb.toString();
    }
}