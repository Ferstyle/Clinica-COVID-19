package Stock;

public class Material { 
    private String fechaEntrada;  
    private double numSerie; 
    private static double serieSiguiente=1; 

    public Material (String fechaEntrada) { 
        this.fechaEntrada=fechaEntrada; 
        numSerie=serieSiguiente; 
        serieSiguiente++; 
    } 

    public double getNumSerie() { 
        return numSerie; 
    } 

    public String getFecha() {
        return fechaEntrada;
    }

    public String toString() { 
        return ("\nNúmero de serie= " +getNumSerie()+ "\nFecha tentativa de uso: "+getFecha());
    } 
}
 