package personas;

public abstract class Persona{ 
    private String nombre; 
    private String apellido;
    private String dni;

    public Persona(String nombre, String apellido, String dni){ 
        this.nombre=nombre; 
        this.apellido=apellido;
        this.dni=dni;
    } 

    public String getNombre(){ 
        return this.nombre; 
    } 

    public String getApellido(){ 
        return this.apellido; 
    } 

    public String getDni(){
        return dni;
    }

}
