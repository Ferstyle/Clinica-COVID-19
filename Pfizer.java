package Stock;

public class Pfizer extends Vacuna {
    
    private String proximaDosis;
    
    public Pfizer(String fechaEntrada, String proximaDosis) { 
        super(fechaEntrada); 
        this.proximaDosis=proximaDosis;
    } 

    public String getProximaDosis() { 
        
        return proximaDosis="en 21 días";
        
   } 
    public String toString() { 
        
        return ("Número de serie= " +getNumSerie()+ "\nFecha: "+getFecha()+"\nPróxima dosis: "+getProximaDosis());
    } 
} 