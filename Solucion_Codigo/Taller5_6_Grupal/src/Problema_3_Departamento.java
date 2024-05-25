//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
public class Problema_3_Departamento {
    String nombreDepertamento, categoria;
    int numEmpleados;
    double produccionAnual;
    public Problema_3_Departamento(String nombreDepertamento, int numEmpleados, double produccionAnual) {
        this.nombreDepertamento = nombreDepertamento;
        this.numEmpleados = numEmpleados;
        this.produccionAnual = produccionAnual;
        asignarCategoria(numEmpleados, produccionAnual);
    }
    public void asignarCategoria(int numEmpleados, double produccionAnual) {
        if (numEmpleados <= 10 && produccionAnual <= 500000) {
            this.categoria = "C";
        } else if (numEmpleados <= 20 && produccionAnual <= 1000000) {
            this.categoria = "B";
        } else if (numEmpleados > 20 && produccionAnual > 1000000) {
            this.categoria = "A";
        }
    }
    @Override
    public String toString() {
        return "Departamento: " + nombreDepertamento + "\n" + "Numero de empleados: " + numEmpleados + "\n" + "Produccion Anual: " + produccionAnual + "\n" + "Categoria: " + categoria;
    }
}
