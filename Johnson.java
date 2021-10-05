package Stock;

public class Johnson extends Vacuna { 
    private String proximaDosis;

    public Johnson(String fechaEntrada,String proximaDosis) { 
        super(fechaEntrada); 
        this.proximaDosis=proximaDosis;
    } 

    public String getProximaDosis() { 

        return proximaDosis="No necesita más dosis";
    } 

    public String toString() { 

        return ("Número de serie= " +getNumSerie()+ "\nFecha: "+getFecha()+"\nPróxima dosis: "+getProximaDosis());
    } 
} 

