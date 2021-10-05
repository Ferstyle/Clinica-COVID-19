package personas;

public class Empleado extends Persona {
    private int id; 
    private static int idSiguiente=1;

    public Empleado(String nombre,String apellido,String dni) {
        super(nombre,apellido,dni);
        id=idSiguiente; 
        idSiguiente++; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Muestra por consola todos los datos del Empleado
     */
    public String toString(){ 
        return ("Nombre:" + getNombre() +"\nApellido:"+ getApellido() + "\nDni:" + getDni()+ "\nID:" + id ); 
    } 
}

