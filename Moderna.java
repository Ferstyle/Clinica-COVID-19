package Stock;

public class Moderna extends Vacuna { 

    private String proximaDosis;

    public Moderna(String fechaEntrada, String proximaDosis) 
    { 
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

