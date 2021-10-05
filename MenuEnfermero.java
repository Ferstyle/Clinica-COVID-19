package menús;

import javax.swing.JOptionPane; 
public class MenuEnfermero { 
    public static void main(String[] args) { 
        Menu(); 
        try { 
            int opcion; 
            do { 
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Elige una Opcion")); 
                switch(opcion) { 
                    case 1: getPacientesAsignados(); break; 
                    case 2: Inventario.main(args); break; 
                    case 0: clinica.main(args); break; 
                } 
            }while(opcion != 0); 
        }catch(NumberFormatException e) { 
            System.out.println("*****************"); 
            System.out.println("Debes introducir un Numero entero entre 0 y 2"); 
            System.out.println("*****************"); 
        } 
        MenuEnfermero.main(args); 
    } 

    public static void Menu(){ 
        System.out.println("Menu Enfermeros"); 
        System.out.println("==================="); 
        System.out.println("1. Ver mis pacientes asignados"); 
        System.out.println("2. Inventario"); 
        System.out.println("0. Salir\n"); 
    } 

    public static void getPacientesAsignados() { 
        MenuAdministrador.ListarEnfermeros(); 
        int posicion=Integer.parseInt(JOptionPane.showInputDialog("Elige un paciente, con id:")); 
        if(posicion<0 || posicion >= MenuAdministrador.misPacientes.size()) 
        {System.out.println("Paciente Incorrecto"); 
        }else { 
            System.out.println("Se te ha asignado el paciente:\n"); 
            MenuAdministrador.misEnfermeros.get(posicion).getEncargo(); 
        } 
    } 
}