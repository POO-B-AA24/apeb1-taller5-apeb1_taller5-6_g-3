//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
public class Problema_2_Estudiante {
    public String nombreEstudiante;
    public int edad;
    public ArrayList<Problema_2_Materia> materias;
    public Problema_2_Estudiante(String nombre, int edad) {
        this.nombreEstudiante = nombre;
        this.edad = edad;
        this.materias = new ArrayList<>();
    }
    public void agregarMateria(String nombreMateria, double acd, double ape, double aa) {
        Problema_2_Materia materia = new Problema_2_Materia(nombreMateria, acd, ape, aa);
        this.materias.add(materia);
    }
    public void condicionDeMateria() {
        for (Problema_2_Materia materia : this.materias) {
            materia.verificarMateria();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\nEstudiante")
                .append("\nNombre: ")
                .append(nombreEstudiante)
                .append("\nEdad: ")
                .append(edad)
                .append("\n");
        for (Problema_2_Materia materia : materias) {
            sb.append(materia)
                    .append("\n");
        }
        return sb.toString();
    }
}