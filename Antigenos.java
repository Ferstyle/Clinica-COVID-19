package Stock;

public class Antigenos extends Prueba {
    private String masPruebas;
    private boolean tipo;

    public Antigenos(String fechaEntrada,String masPruebas, boolean Tipo) { 
        super(fechaEntrada); 
        this.masPruebas=masPruebas;
        this.tipo=tipo;
    } 

    public String getMasPruebas() { 

        return masPruebas="Puede realizarse otra prueba de Antígenos cuando desee.";

    } 
   
    public String Tipo(boolean Tipo) { 
        if(tipo) { 
            return "Rápida"; 
        }else { 
            return "Clásica"; 
        } 
    }
    
    public String toString() { 

        return ("Número de serie= " +getNumSerie()+ "\nFecha: "+getFecha()+
        "\nPrueba rápida o clásica: "+Tipo(tipo)+"\nPróxima prueba: "+getMasPruebas());
    } 
} 

