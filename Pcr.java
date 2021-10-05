package Stock;

public class Pcr extends Prueba {
    private String masPruebas;

    public Pcr(String fechaEntrada,String masPruebas) { 
        super(fechaEntrada); 
        this.masPruebas=masPruebas;
    } 

    public String getMasPruebas() { 

        return masPruebas="Puede realizarse otra prueba PCR dentro de 15 días.";

    } 

    public String toString() { 

        return ("Número de serie= " +getNumSerie()+ "\nFecha: "+getFecha()+"\nPróxima prueba: "+getMasPruebas());
    } 
} 

