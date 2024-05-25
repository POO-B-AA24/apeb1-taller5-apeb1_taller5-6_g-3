//AUTORES: Juan Diego Guerrero y Ricardo Espinosa
import java.util.ArrayList;
public class Problema_3_Empresa {
    String nombre, ruc, direccion;
    ArrayList<Problema_3_Departamento> departamento;
    public Problema_3_Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamento = new ArrayList<>();
    }
    public void agregarDepartamento(String nombre, int numEmpleados, double produccionAnual) {
        Problema_3_Departamento departamento = new Problema_3_Departamento(nombre, numEmpleados, produccionAnual);
        this.departamento.add(departamento);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa: ").append(nombre).append("\n");
        sb.append("RUC: ").append(ruc).append("\n");
        sb.append("Direccion: ").append(direccion).append("\n");
        sb.append("---Departamentos---\n");
        for (Problema_3_Departamento dep : departamento) {
            sb.append(dep).append("\n");
        }
        return sb.toString();
    }
}