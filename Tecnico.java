package personas;

import auxiliar.PedidoP; 

public class Tecnico extends Empleado { 
    
    private PedidoP hacerPrueba;
    
    public Tecnico(String nombre,String apellido,String dni) { 
        super(nombre,apellido, dni);
    } 

    public void recibirEncargo1(PedidoP p) { 
        this.hacerPrueba = p; 
    } 

    public String getEncargo1() { 
        return hacerPrueba.toString(); 
    } 

    public String descTecnico() { 
        return (super.toString() + "\nEncargo pendiente:\n" + getEncargo1());
    }
} 
