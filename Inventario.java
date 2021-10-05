package menús;
import java.util.ArrayList; 
import javax.swing.*; 
import Stock.*; 

public class Inventario { 
    protected static ArrayList<Vacuna> misVacunas=new ArrayList<Vacuna>();
    protected static ArrayList<Prueba> misPruebas=new ArrayList<Prueba>();

    private enum tipovacuna { 
        PFIZER,JOHNSON,MODERNA 
    } 
    private enum tipoprueba{ 
        SEROLOGICA,PCR,ANTIGENOS 
    } 
    public static void main(String[] args) { 
        Menuinv(); 
        try { 
            int opcion; 
            do { 
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Elige una Opcion")); 
                switch(opcion) { 
                    case 1: ListarVacunas(); break; 
                    case 2: ListarPruebas(); break;
                    case 3: addMaterial(); break; 
                    case 4: EliminarVacuna(); break; 
                    case 5: EliminarPrueba(); break;
                    case 0: MenuAdministrador.main(args); break; 
                } 
            }while (opcion!=0); 
        }catch(NumberFormatException e) { 
            System.out.println("*****************"); 
            System.out.println("Debes introducir un Numero entero entre 0 y 5"); 
            System.out.println("*****************"); 
        } 
        Inventario.main(args); 
    } 

    public static void Menuinv() { 
        System.out.println("INVENTARIO"); 
        System.out.println("==================="); 
        System.out.println("1. Listar Vacunas"); 
        System.out.println("2. Listar Pruebas");
        System.out.println("3. Preparar Material Clínico"); 
        System.out.println("4. Eliminar Vacuna");
        System.out.println("5. Eliminar Prueba");
        System.out.println("0. Salir\n"); 
    } 

    public static void ListarVacunas() { 
        System.out.println("\n\n Lista de Vacunas\n ===================");
        if (misVacunas.isEmpty()) { System.out.println("No hay Vacunas registradas\n");} 
        else { 
            for (int i = 0; i < misVacunas.size(); i++) { 
                System.out.println("********************"); 
                Material m = misVacunas.get(i); 
                System.out.printf("Tipo:" + m.getClass().getSimpleName()+"\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void ListarPruebas() { 
        System.out.println("\n\n Lista de Pruebas\n ===================");
        if (misPruebas.isEmpty()) { System.out.println("No hay Pruebas registradas\n");} 
        else { 
            for (int i = 0; i < misPruebas.size(); i++) { 
                System.out.println("********************"); 
                Material m = misPruebas.get(i); 
                System.out.printf("Tipo:" + m.getClass().getSimpleName()+"\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void addMaterial() { 
        System.out.println("\n\n Asignar Material clínico"); 
        boolean tipomaterial=Boolean.parseBoolean(JOptionPane.showInputDialog("Tipo de material\n"+ " true = Vacuna \n false = Prueba ")); 
      
        if (tipomaterial) { 
            String tipo=JOptionPane.showInputDialog("Tipo de Vacuna \n Pfizer||Johnson||Moderna"); 

            if(tipo.equalsIgnoreCase("Pfizer")||tipo.equalsIgnoreCase("Johnson")||tipo.equalsIgnoreCase("Moderna")) { 
                tipovacuna Tipo=tipovacuna.valueOf(tipo.toUpperCase()); 
                String fechaEntrada=JOptionPane.showInputDialog("Fecha de inoculación:");
                String proximaDosis=JOptionPane.showInputDialog("Vacuna registrada:\nPulse Enter");
                switch(Tipo) { 
                    case PFIZER:misVacunas.add(new Pfizer(fechaEntrada,proximaDosis)); break;
                    case JOHNSON: misVacunas.add(new Johnson(fechaEntrada,proximaDosis)); break; 
                    case MODERNA: misVacunas.add(new Moderna(fechaEntrada,proximaDosis)); break; 
                    default: System.out.println("El tipo no es valido"); 
                } 
            } 
        }else { 
            String tipo=JOptionPane.showInputDialog("Tipo de Prueba \n Serologica|Pcr|Antigenos"); 
        
            if(tipo.equalsIgnoreCase("Serologica")||tipo.equalsIgnoreCase("Pcr")||tipo.equalsIgnoreCase(
                "Antigenos")) { 
                tipoprueba Tipo=tipoprueba.valueOf(tipo.toUpperCase()); 
                String fechaEntrada = JOptionPane.showInputDialog("Fecha de realización:"); 
                
                String masPruebas=JOptionPane.showInputDialog("Prueba registrada:\nPulse Enter");
                
                switch(Tipo) { 
                    case SEROLOGICA: misPruebas.add(new Serologica(fechaEntrada,masPruebas)); break; 
                    case PCR:misPruebas.add(new Pcr(fechaEntrada,masPruebas)); break;
                    case ANTIGENOS:  misPruebas.add(new Antigenos(fechaEntrada,masPruebas,true)); break; 
                    default: System.out.println("El tipo no es valido"); 
                } 
            } 
        }}

    public static void cogerVacunas() { 
        for(Material v: misVacunas) { 
            if(v.getClass().getSimpleName().equalsIgnoreCase("ENFERMERO")) { 
                misVacunas.add((Vacuna) v); 
            } 
        } 
    } 

    public static void cogerPruebas() { 
        for(Material p: misPruebas) { 
            if(p.getClass().getSimpleName().equalsIgnoreCase("TÉCNICO")) { 
                misPruebas.add((Prueba) p); 
            } 
        } 
    } 

    public static void EliminarVacuna() { 
        System.out.println("\nELIMINAR Material"); 
        ListarVacunas(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce La Posicion")); 
        if (posicion < 0 || posicion >= misVacunas.size()) { System.out.println("Id erronea");}
        else { 
            String comp = JOptionPane.showInputDialog("¿Està seguro? (S/N): "); 
            if (comp.equalsIgnoreCase("S")) {misVacunas.remove(posicion);} 
        } 
    } 
    
    public static void EliminarPrueba() { 
        System.out.println("\nELIMINAR Material"); 
        ListarVacunas(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce La Posicion")); 
        if (posicion < 0 || posicion >= misPruebas.size()) { System.out.println("Id erronea");}
        else { 
            String comp = JOptionPane.showInputDialog("¿Està seguro? (S/N): "); 
            if (comp.equalsIgnoreCase("S")) {misPruebas.remove(posicion);} 
        } 
    } 
}
