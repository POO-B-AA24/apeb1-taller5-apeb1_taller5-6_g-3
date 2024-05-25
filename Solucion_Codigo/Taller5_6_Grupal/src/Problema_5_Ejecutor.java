//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.Scanner;
public class Problema_5_Ejecutor {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        boolean nucleares;
        System.out.print("Nombre del conflicto: ");
        String nombreConflicto = tc.nextLine();
        System.out.print("Fecha del conflicto (AAAA-MM-DD): ");
        String fecha = tc.nextLine();
        System.out.print("Numero de paises involucrados: ");
        int contador = tc.nextInt();
        tc.nextLine();
        String[] paisesInvolucrados = new String[contador];
        for (int i = 0; i < contador; i++) {
            System.out.print("Nombre del pais " + (i + 1) + ": ");
            paisesInvolucrados[i] = tc.nextLine();
        }
        Problema_5_Conflicto conflicto = new Problema_5_Conflicto(nombreConflicto, paisesInvolucrados, fecha);
        boolean nuevoEvento = true;
        while (nuevoEvento) {
            System.out.print("Nombre del evento: ");
            String nombreEvento = tc.nextLine();
            System.out.print("Fecha del evento (AAAA-MM-DD): ");
            String fechaEvento = tc.nextLine();
            System.out.print("Ubicacion: ");
            String ubicacionEvento = tc.nextLine();
            System.out.print("Tipo de evento (Batalla - Tratado de Paz - Reunion Diplomatica): ");
            String tipo = tc.nextLine();
            System.out.print("Descripcion: ");
            String descripcion = tc.nextLine();
            System.out.print("Uso de armas nucleares [si][no]: ");
            String opcion = tc.next();
            nucleares = opcion.equals("si") ? true : false;
            System.out.print("Porcentaje de bajas en el evento: ");
            int porcentajes = tc.nextInt();
            tc.nextLine();
            Problema_5_Evento evento = new Problema_5_Evento(nombreEvento, fechaEvento, ubicacionEvento, tipo, descripcion, nucleares, porcentajes);
            conflicto.agregarEvento(evento);
            System.out.print("Nuevo evento [si][no]: ");
            String respuesta = tc.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                nuevoEvento = false;
            }
        }
        conflicto.mostrarInformacion();
        System.out.println(conflicto);
        tc.close();
    }
}
