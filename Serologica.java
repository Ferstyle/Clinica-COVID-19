package Stock;

public class Serologica extends Prueba {

    private String masPruebas;

    public Serologica(String fechaEntrada,String masPruebas) { 
        super(fechaEntrada); 
        this.masPruebas=masPruebas;
    } 

    public String getMasPruebas() { 

        return masPruebas="Puede realizarse otra prueba serológica dentro de 6 meses.";

    } 

    public String toString() { 

        return ("Número de serie= " +getNumSerie()+ "\nFecha: "+getFecha()+"\nPróxima prueba: "+getMasPruebas());
    } 
} 

