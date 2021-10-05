package personas;

public class Paciente extends Persona{ 
    private double id; 
    private static double idSiguiente=1; 
    private boolean mayor65;
    private boolean resultado;
    private String numTelefono;

    public Paciente(String nombre,String apellido, String dni, boolean mayor65, boolean resultado,String numTelefono) { 
        super(nombre,apellido,dni); 
        this.mayor65=mayor65;
        this.resultado=resultado;
        this.numTelefono=numTelefono;
        id=idSiguiente; 
        idSiguiente++; 
    } 

    public String Prioridad(boolean mayor65) { 
        if(mayor65) { 
            return "Prioritario"; 
        }else { 
            return " Normal"; 
        } 
    } 

    public String Resultado(boolean resultado) { 
        if(resultado) { 
            return "Positivo, pasa a estar confinado."; 
        }else { 
            return "Negativo."; 
        } 
    } 

    public String getNumTelefono(){
        return numTelefono;
    }

    public double getId() { 
        return id; 
    } 

    public String toString() { 
        return ("Nombre:"+ getNombre() +"\nApellido:"+ getApellido() + "\nDni:" + getDni()+ "\nTipo de paciente:" 
            + Prioridad(mayor65) + "\nResultado de la prueba: " + Resultado(resultado)+ "\nNúmero de telefono: "+getNumTelefono());  
    } 
} 
