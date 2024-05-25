//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
import java.util.Scanner;
public class Problema_2_Ejecutor {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ArrayList<Problema_2_Estudiante> estudiantes = new ArrayList<>();
        boolean seguir1 = true, seguir2 = true;
        int contador1 = 1, contador2 = 1;
        do {
            System.out.println("Estudiante " + (contador1++));
            System.out.print("Nombre: ");
            String nombreEstudiante = tc.next();
            System.out.print("Edad: ");
            int edad = tc.nextInt();
            Problema_2_Estudiante estudiante = new Problema_2_Estudiante(nombreEstudiante, edad);
            while (seguir2) {
                System.out.print("Materia: " + (contador2++));
                String nombreMateria = tc.next();
                System.out.println("----Ingrese las notas----");
                System.out.print("|ACD(35%)|: ");
                double acd = tc.nextDouble();
                System.out.print("|APE(35%)|: ");
                double ape = tc.nextDouble();
                System.out.print("|AA(30%)|: ");
                double aa = tc.nextDouble();
                estudiante.agregarMateria(nombreMateria, acd, ape, aa);
                System.out.println("Nueva materia [si][no]");
                String continuar1 = tc.next();
                if (continuar1.equalsIgnoreCase("no")) {
                    seguir2 = false;
                }
            }
            estudiantes.add(estudiante);
            System.out.println("Nuevo estudiante [si][no]");
            String continuar2 = tc.next();
            seguir2 = true;
            if (continuar2.equalsIgnoreCase("no")) {
                seguir1 = false;
            }
        } while (seguir1);
        for (Problema_2_Estudiante estudiante : estudiantes) {
            estudiante.condicionDeMateria();
            System.out.println(estudiante);
        }
    }
}