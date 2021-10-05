package menús;
import javax.swing.JOptionPane; 
public class MenuEmpleado { 
    public static void main(String[] args) { 
        Menu(); 
        try { 
            int opcion; 
            do { 
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Elige una Opcion")); 
                switch(opcion) { 
                    case 1: MenuEnfermero.main(args); break; 
                    case 2: MenuTecnico.main(args); break;
                    case 0: clinica.main(args); break; 
                } 
            }while(opcion != 0); 
        }catch(NumberFormatException e) { 
            System.out.println("*****************"); 
            System.out.println("Debes introducir un Numero entero entre 0 y 2"); 
            System.out.println("*****************"); 
        } 
        MenuEmpleado.main(args); 
    } 

    public static void Menu(){ 
        System.out.println("Menú Empleado"); 
        System.out.println("==================="); 
        System.out.println("1. Enfermeros"); 
        System.out.println("2. Técnicos");
        System.out.println("0. Salir\n"); 
    } 
} 
