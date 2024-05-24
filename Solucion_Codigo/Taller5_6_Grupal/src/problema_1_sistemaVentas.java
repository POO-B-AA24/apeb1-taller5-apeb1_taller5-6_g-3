//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//EJECUTOR
public class problema_1_sistemaVentas {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("**********RICKY&JUANDI-STORE***************");
        int numeroCompra = 1;
        int seguir = 0;
        do {
            System.out.println("BIENVENIDO - COMPRA #" + numeroCompra);
            ArrayList<Producto> producto = new ArrayList<>();
            CarritoDeCompras carrito = new CarritoDeCompras();
            System.out.println("SE TE ASIGNO UN CARRITO, cuentanos, cuantos productos deseas comprar?");
            int compra = tc.nextInt();
            for (int i = 0; i < compra; i++) {
                producto.add(new Producto(generarProductos(), generarPrecio(), generarCant()));
                carrito.agregarProducto(producto.get(i));
            }
            carrito.mostrarDetalleCompra();
            carrito.calcularTotal();
            System.out.println("El total de tu compra es de:  $" + carrito.getTotal());
            System.out.println("Ingresa el pago para culminar la compra");
            double pago = tc.nextDouble();
            carrito.realizarPago(pago);
            System.out.println("Deseas hacer otra compra? (1 -> SI  | 2 -> NO)");
            seguir = tc.nextInt();
            if (seguir == 1) {
                numeroCompra++;
            } else if (seguir == 2) {
                System.out.println("GRACIAS POR VISITAR RICKY&JUANDI-STORE, VUELVE PRONTO");
            } else {
                System.out.println("OPCION INCORRECTA - PROGRAMA CULMINADO");
            }
        } while (seguir == 1);
    }
    //METODO PARA GENERAR LOS NOMBRES DE LOS PRODUCTOS ALEATORIOS
    public static String generarProductos() {
        Random aleatorio = new Random();
        String productos[] = {"Manzanas", "Peritas", "Naranjas", "Toronjas", "Uvitas", "Mandarinas", "Sandias", "Mangos", "Melones", "Bananas"};
        int indiceAleatorio = aleatorio.nextInt(((productos.length-1) - 0) + 1) + 0;
        return productos[indiceAleatorio];
    }
    
    //METODO PARA GENERAR LAS UNIDADES DE LOS PRODUCTOS ALEATORIOS
    public static int generarCant() {
        Random aleatorio = new Random();
        //GENERO NUMEROS ALEATORIOS ENTRE 1 Y 10
        int numero = aleatorio.nextInt((10 - 1) + 1) + 1;
        return numero;
    }
    
    //METODO PARA GENERAR LOS PRECIOS DE LOS PRODUCTOS ALEATORIOS
    public static double generarPrecio() {
        Random aleatorio = new Random();
        //GENERO NUMEROS ALEATORIOS DOBLES ENTRE 1 Y 200
        double numero = 1 + (200 - 1) * aleatorio.nextDouble();
        return numero;
    }
}

//CLASE BASE 1
class Producto {

    //ATRIBUTOS
    private String nombre;
    private double precio;
    private int cantidad;

    //CONSTRUCTOR
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //NO NECESITA TOSTRING NI OTROS METODOS
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

//CLASE BASE 2 (PRINCIPAL)
class CarritoDeCompras {

    //ATRIBUTOS
    private ArrayList<Producto> productos; //ARRAYLIST DE OBJETOS TIPO PRODUCTO
    private double total;

    //CONSTRUCTOR
    public CarritoDeCompras() {
        productos = new ArrayList<>(); //INICIALIZAR EL ARRAYLIST
    }

    //METODOS ESPECIALES
    public void agregarProducto(Producto producto) {
        productos.add(producto); //EL PARAMETRO SE LO AGREGA AL ARRAYLIST
    }

    public void calcularTotal() {
        for (int i = 0; i < productos.size(); i++) { //SE MULTIPLICA EL PRECIO POR LA CANTIDAD DE CADA POSICION (OBJETO)
            this.total += productos.get(i).getPrecio() * productos.get(i).getCantidad();
        }
    }

    public void realizarPago(double montoPagado) {
        if (this.total >= 1000) {
            this.total = this.total * 0.9;
            System.out.println("El total supera los $1000, has recibido un descuento del 10%");
            System.out.println("Saldo a cobrar: " + this.total);
        }
        if (montoPagado >= total) {
            System.out.println("Pago realizado con exito. Gracias por su compra");
            System.out.println("Cambio: $" + (montoPagado - this.total));
        } else {
            System.out.println("Pago insuficiente. Faltan: $" + (this.total - montoPagado));
            System.out.println("El guardia arremetera contra usted si no paga");
        }
    }

    public void mostrarDetalleCompra() { //TOSTRING
        System.out.println("DETALLE DE LA COMPRA: (PRODUCTOS GENERADOS ALEATORIOS)");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("PRODUCTO: " + productos.get(i).getNombre() + "\t\tUNIDADES: " + productos.get(i).getCantidad() + "\t\tPRECIO POR UNIDAD: $" + productos.get(i).getPrecio());
        }
    }

    //GETTERS Y SETTERS NECESARIOS
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
