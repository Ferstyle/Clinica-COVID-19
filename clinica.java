package menús;
import javax.swing.*; 

public class clinica{ 
    public static void main(String[] args){ 
        Menu(); 
        try { 
            int opcion; 
            do{ 
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Elige una opción"));
                switch(opcion){
                    case 1: MenuAdministrador.main(null); break; 
                    case 2: MenuEmpleado.main(null); break; 
                    case 0: System.out.println("HASTA LUEGO!"); System.exit(0); break; 
                } 
            }while(opcion!=0); 
        }catch(NumberFormatException e){ 
            System.out.println("*****************"); 
            System.out.println("Debes introducir un Numero entero entre 0 y 2."); 
            System.out.println("*****************"); 
        } 
        clinica.main(args); 
    } 

    public static void Menu(){ 
        System.out.println("Clínica"); 
        System.out.println("==================="); 
        System.out.println("1. Entrar como Administrador"); 
        System.out.println("2. Entrar como Empleado");
        System.out.println("0. Salir\n"); 
    } 
} 