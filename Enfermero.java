package personas;

import auxiliar.PedidoV; 

public class Enfermero extends Empleado { 
    
    private PedidoV vacunar; 
    
    public Enfermero(String nombre,String apellido,String dni) { 
        super(nombre,apellido,dni);
    }

    public void recibirEncargo(PedidoV v) { 
        this.vacunar = v; 
    } 

    public String getEncargo() { 
        return vacunar.toString(); 
    } 

    public String descEnfermero() { 
        return (super.toString() + "\nEncargo pendiente:\n" + getEncargo());
    }
} 