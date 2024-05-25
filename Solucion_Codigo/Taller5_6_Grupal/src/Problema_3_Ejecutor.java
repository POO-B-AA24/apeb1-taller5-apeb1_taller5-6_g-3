//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
import java.util.Scanner;
public class Problema_3_Ejecutor {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ArrayList<Problema_3_Empresa> empresaLista = new ArrayList<>();
        int contador = 1;
        boolean seguir = true;
        System.out.println("--Empresa--");
        System.out.print("Nombre: ");
        String nombreEmpresa = tc.next();
        System.out.print("Ruc: "); 
        String ruc = tc.next();
        System.out.print("Direccion: ");
        String direccion = tc.next();
        Problema_3_Empresa empresa = new Problema_3_Empresa(nombreEmpresa, ruc, direccion);
        do {
            tc.nextLine();
            System.out.println("Departamento " + (contador++));
            System.out.print("Nombre: ");
            String nombreDepartamento = tc.next();
            System.out.print("Numero de empleados: ");
            int numEmpleados = tc.nextInt();
            System.out.print("Produccion Anual: ");
            double produccion = tc.nextDouble();
            empresa.agregarDepartamento(nombreDepartamento, numEmpleados, produccion);
            System.out.println("Nuevo departamento [si][no]");
            String continuar1 = tc.next();
            if (continuar1.equalsIgnoreCase("no")) {
                seguir = false;
            }
        } while (seguir);
        empresaLista.add(empresa);
        for (Problema_3_Empresa emp : empresaLista) {
            System.out.println(emp);
        }
        tc.close();
    }
}
