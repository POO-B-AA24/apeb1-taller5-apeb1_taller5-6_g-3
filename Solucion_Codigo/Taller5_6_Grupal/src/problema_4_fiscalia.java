import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//EJECUTOR
public class problema_4_fiscalia {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("***********FISCALIA ECUATORIANA****************");
        int numeroCaso = 1;
        int seguir = 0;
        do {
            System.out.println("BIENVENIDO - INGRESA EL CASO #" + numeroCaso);
            System.out.println("Ingresa el nombre del caso:");
            String nombreCaso = tc.next();
            System.out.println("Ingresa la fecha de inicio (DD//MM//AAA):");
            String fechaCaso = tc.next();
            System.out.println("Ingresa los dias transcurridos:");
            int diasCaso = tc.nextInt();
            System.out.println("Ingresa cualquier detalle adicional del caso:");
            String detalleCaso = tc.next();
            Caso caso = new Caso(nombreCaso, fechaCaso,diasCaso, detalleCaso);
            System.out.println("QUIERES AGREGAR PERSONAS AL CASO? (1 -> SI | 2 -> NO)");
            int agregarPersonas = tc.nextInt();
            if(agregarPersonas == 1){
                ArrayList<Persona> persona = new ArrayList<>();
                System.out.println("CUANTAS PERSONAS DESEAS AGREGAR?");
                int numPersonas = tc.nextInt();
                for (int i = 0; i < numPersonas; i++) {
                    persona.add(new Persona(generarPersonas(), generarEdad(), generarSentencia(),generarOcupacion(),generarNivImplicacion()));
                    persona.get(i).verificarReduccionPena();
                    caso.agregarPersona(persona.get(i));
                }
            }
            caso.actualizarEstado();
            //MOSTRAR INFORMACION EN CONSOLA
            System.out.println(caso);
            System.out.println("\nPERSONAS IMPLICADAS:(GENERADAS ALEATORIAMENTE)");
            for (Persona persona : caso.getPersonasImplicadas()) {
                System.out.println(persona);
            }
            System.out.println("DESEAS REGISTRAR OTRO CASO? (1 -> SI | 2 -> NO)");
            seguir = tc.nextInt();
            if (seguir == 1)
                numeroCaso++;
            else if (seguir == 2)
                System.out.println("GRACIAS POR VISITAR LA APP DE LA FISCALIA ECUATORIANA, QUE LA JUSTICIA PREVALEZCA");
            else
                System.out.println("OPCION INCORRECTA - PROGRAMA CULMINADO");
        }while(seguir == 1);
    }
    
    public static String generarPersonas(){
        Random aleatorio = new Random();
        String[] personas = {"Ricardo Espinosa", "Juan Guerrero", "Manuel Garcia", "Ambar Jimenez", "Roberto Gomez", "Luisa Espinoza", "Marco Swift", "Pedro Lopez", "Benito Martinez", "Kanye West"};
        int indiceAleatorio = aleatorio.nextInt(((personas.length-1) - 0) + 1) + 0;
        return personas[indiceAleatorio];
    }
    public static int generarEdad() {
        Random aleatorio = new Random();
        //GENERO NUMEROS ALEATORIOS ENTRE 18 Y 90
        int numero = aleatorio.nextInt((90 - 18) + 1) + 18;
        return numero;
    }
    public static int generarSentencia() {
        Random aleatorio = new Random();
        //GENERO NUMEROS ALEATORIOS ENTRE 1 Y 90 (3 meses)
        int numero = aleatorio.nextInt((90 - 1) + 1) + 1;
        return numero;
    }
    public static String generarOcupacion(){
        Random aleatorio = new Random();
        String[] ocupaciones = {"Informatico", "Abogado", "Periodista", "Empleado Publico", "Medico", "Docente", "Doctor", "Artista", "Empresario", "Estudiante"};
        int indiceAleatorio = aleatorio.nextInt(((ocupaciones.length-1) - 0) + 1) + 0;
        return ocupaciones[indiceAleatorio];
    }
    public static String generarNivImplicacion(){
        Random aleatorio = new Random();
        String[] implicacion = {"Acusado", "Testigo", "Inocente", "Victima", "Implicado"};
        int indiceAleatorio = aleatorio.nextInt(((implicacion.length-1) - 0) + 1) + 0;
        return implicacion[indiceAleatorio];
    }
}

//CLASE BASE 1 (PRINCIPAL)
class Caso{
    //ATRIBUTOS
    private String nombreCaso;
    private String fechaInicio;
    private int diasTranscurridos;
    private String estado;
    private String detallesAdicionales;
    private ArrayList<Persona> personasImplicadas;
    
    //CONSTRUCTOR
    public Caso(String nombreCaso, String fechaInicio, int diasTransurridos, String detallesAdicionales) {
        this.nombreCaso = nombreCaso;
        this.fechaInicio = fechaInicio;
        this.diasTranscurridos = diasTransurridos;
        this.estado = "Iniciado";
        this.detallesAdicionales = detallesAdicionales;
        this.personasImplicadas = new ArrayList<>();
    }
    
    //METODOS ESPECIALES
    @Override
    public String toString() {
        return "NOMBRE DEL CASO: " + nombreCaso + "\nFECHA DE INICIO: " + fechaInicio + "\nESTADO: " + estado + "\nDETALLES: " + detallesAdicionales;
    }
    
    public void actualizarEstado() { //CAMBIAR EL ESTADO DEL CASO SEGUN LOS DIAS TRANSCURRIDOS  
        if (this.diasTranscurridos > 14)
            this.estado = "Urgente";
        else if (diasTranscurridos > 7)
            this.estado = "Alerta";
    }
    
    //SETTERS Y GETTERS
    public String getNombreCaso() {
        return nombreCaso;
    }

    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public void setDetallesAdicionales(String detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }

    public ArrayList<Persona> getPersonasImplicadas() {
        return personasImplicadas;
    }

    public void agregarPersona(Persona persona) {
        personasImplicadas.add(persona);
    }
}

//CLASE BASE 2 
class Persona{
    //ATRIBUTOS
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;
    private int sentencia; //Meses
    private String estadoPersona;
    
    //CONSTRUCTOR
    public Persona(String nombre, int edad, int sentencia, String ocupacion, String nivelImplicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.sentencia = sentencia;
        this.estadoPersona = "Persona con proceso en orden";
    }
    
    //METODOS ESPECIALES
    @Override
    public String toString() {
        return "NOMBRE: " + nombre + ", EDAD: " + edad + ", OCUPACION: " + ocupacion + ", NIV DE IMPLICACION: " + nivelImplicacion + "\nESTADO: " + estadoPersona;
    }
    
    public void verificarReduccionPena(){ //VERIFICAR REDUCCION DE PENA Y FIANZA
        if(this.nivelImplicacion.equalsIgnoreCase("acusado"))
            this.estadoPersona = "Esta persona puede acogerse a reduccion de pena si decide colaborar confesando la verdad"+verificarPagoFianza();
    }
    public String verificarPagoFianza(){
        if(this.sentencia > 12)
            return "\nEsta persona puede acogerse a pagar fianza si es que colabora con informacion util (Fianza no mayor al 50% del danio economico)";
        return "";
    }
    
    //SETTERS Y GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNivelImplicacion() {
        return nivelImplicacion;
    }

    public void setNivelImplicacion(String nivelImplicacion) {
        this.nivelImplicacion = nivelImplicacion;
    }
}