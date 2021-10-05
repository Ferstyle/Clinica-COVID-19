package menús;
import personas.*; 
import java.util.ArrayList; 
import javax.swing.*; 
import auxiliar.*; 
import Stock.*; 

public class MenuAdministrador
{ 
    protected static ArrayList<Enfermero> misEnfermeros=new ArrayList<Enfermero>(); 
    protected static ArrayList<Tecnico> misTecnicos=new ArrayList<Tecnico>();
    protected static ArrayList<Paciente> misPacientes=new ArrayList<Paciente>();
    protected static ArrayList<Empleado> misEmpleados =new ArrayList<Empleado>(); 
    protected static ArrayList<PedidoV> MispedidosV=new ArrayList<PedidoV>(); 
    protected static ArrayList<PedidoP> MispedidosP=new ArrayList<PedidoP>();
    protected static ArrayList<Material> Listamateriales=new ArrayList<Material>(); 

    private enum tipoEmpleado{ 
        ADMINISTRADOR, ENFERMERO, TECNICO 
    } 
    private enum tipoPaciente{ 
        NORMAL, PRIORITARIO, CONFINADO 
    } 

    public static void main (String[] args){ 
        Menu(); 
        try { 
            int opcion; 
            do { 
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Elige una Opcion")); 
                switch(opcion) { 
                    case 1: ListarEmpleados(); break; 
                    case 2: AddEmpleados(); break; 
                    case 3: EditEmpleados(); break; 
                    case 4: EliminarEmpleados(); break; 
                    case 5: ListarPacientes(); break; 
                    case 6: addPacientes(); break; 
                    case 7: EditPacientes(); break; 
                    case 8: EliminarPacientes(); break; 
                    case 9: Inventario.main(null); break; 
                    case 10: AsigPruebaDiag(); break; 
                    case 11: AsigVacunacion(); break;
                    case 12: Inventario.ListarPruebas(); break;
                    case 13: Inventario.ListarVacunas(); break; 
                    case 14: hacerPedidoVacuna(); break; 
                    case 15: hacerPedidoPrueba(); break;
                    case 16: verPedidosV(); break; 
                    case 17: verPedidosP(); break;
                    default: clinica.main(args); break; 
                } 
            }while(opcion != 0); 
        }catch(NumberFormatException e) { 
            System.out.println("*****************"); 
            System.out.println("Debes introducir un Numero entero entre 0 y 10"); 
            System.out.println("*****************"); 
        } 
        MenuAdministrador.main(args); 
    } 

    public static void Menu(){ 
        System.out.println("Gestion Empleados/Pacientes"); 
        System.out.println("==================="); 
        System.out.println("1. Listar Empleados"); 
        System.out.println("2. Añadir un Empleado"); 
        System.out.println("3. Editar un Empleado"); 
        System.out.println("4. Eliminar un Empleado"); 
        System.out.println("==================="); 
        System.out.println("5. Listar Pacientes"); 
        System.out.println("6. Añadir un Paciente"); 
        System.out.println("7. Editar un Paciente"); 
        System.out.println("8. Eliminar un Paciente"); 
        System.out.println("==================="); 
        System.out.println("9. Gestion inventario"); 
        System.out.println("10. Asignar Técnico para Prueba Diagnóstica");
        System.out.println("11. Asignar Enfermero para Vacunación");
        System.out.println("12. Listar Pruebas");
        System.out.println("13. Listar Vacunas");
        System.out.println("14. Asignar vacuna a paciente");
        System.out.println("15. Asignar prueba diagnóstica a paciente");
        System.out.println("16. Ver Tentativa de Vacunas");
        System.out.println("17. Ver Tentativa de Pruebas");
        System.out.println("0. Salir\n"); 
    } 

    public static void ListarEmpleados(){ 

        System.out.println("\n\n Lista de EMPLEADOS\n ==================="); 
        if (misEmpleados.isEmpty()) { System.out.println("No hay empleados registrados\n"); 
        }else { 
            for (int i = 0; i < misEmpleados.size(); i++) { 
                System.out.println("********************"); 
                Empleado e = misEmpleados.get(i); 
                System.out.println("Cargo:" + e.getClass().getSimpleName() + "\n" +e.toString() + "\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void AddEmpleados() { 
        System.out.println("\n\n AÑADIR EMPLEADO\n ==================="); 
        String tipo=JOptionPane.showInputDialog("Tipo de Empleado \n Enfermero|Tecnico"); 
        if(tipo.equalsIgnoreCase("Enfermero")||tipo.equalsIgnoreCase("Tecnico")) { 
            tipoEmpleado Tipo=tipoEmpleado.valueOf(tipo.toUpperCase()); 
            String nombre=JOptionPane.showInputDialog("Introduce el nombre");  
            String apellido=JOptionPane.showInputDialog("Introduce el apellido"); 
            String dni=JOptionPane.showInputDialog("Introduce el dni"); 
            switch(Tipo) {  
                case ENFERMERO: misEmpleados.add(new Enfermero(nombre,apellido,dni)); break; 
                case TECNICO: misEmpleados.add(new Tecnico(nombre,apellido,dni)); break; 
            } 
        }else{ 
            System.out.println("Tipo de Empleado Erróneo"); 
        } 
    } 

    public static void EditEmpleados() { 
        System.out.println("\n\n Editar EMPLEADO\n ==================="); 
        if(misEmpleados.isEmpty()) {System.out.println("No hay empleados registrados"); 
        }else { 
            ListarEmpleados(); 
            int pos=Integer.parseInt(JOptionPane.showInputDialog("Posicion del Empleado a Editar")); 
            String tipo=JOptionPane.showInputDialog("Tipo de Empleado \n Enfermero||Técnico"); 
            if(tipo.equalsIgnoreCase("Enfermero")||tipo.equalsIgnoreCase("Tecnico")) { 
                tipoEmpleado Tipo=tipoEmpleado.valueOf(tipo.toUpperCase()); 
                String nombre=JOptionPane.showInputDialog("Introduce el nombre"); 
                String apellido=JOptionPane.showInputDialog("Introduce el apellido"); 
                String dni=JOptionPane.showInputDialog("Introduce el dni"); 
                misEmpleados.remove(pos); 
                switch(Tipo) { 
                    case ADMINISTRADOR: misEmpleados.add(pos, (new Administrador(nombre,apellido,dni))); break; 
                    case ENFERMERO: misEmpleados.add(pos, (new Enfermero(nombre,apellido,dni))); break; 
                    case TECNICO: misEmpleados.add(pos, (new Tecnico(nombre,apellido,dni))); break; 

                } 
            }else{ 
                System.out.println("Tipo de Empleado Erroneo"); 
            } 
        } 
    } 

    public static void EliminarEmpleados() { 
        System.out.println("\nELIMINAR Empleado\n ==================="); 
        ListarEmpleados(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce La Posicion")); 
        if (posicion < 0 || posicion >= misEmpleados.size()) { System.out.println("Id erronea");} 
        else { 
            String comp = JOptionPane.showInputDialog("¿Està seguro? (S/N): "); 
            if (comp.equalsIgnoreCase("S")) {misEmpleados.remove(posicion);} 
        } 
    } 

    public static void ListarPacientes() { 
        System.out.println("\n\n Lista de Pacientes\n ==================="); 
        if (misPacientes.isEmpty()) { 
            System.out.println("No hay pacientes registrados\n"); 
        }else{ 
            for (int i = 0; i < misPacientes.size(); i++) { 
                System.out.println("********************"); 
                Paciente c = misPacientes.get(i); 
                System.out.printf("Tipo de Paciente:" + c.getClass().getSimpleName() + "\n" + c.toString() + "\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void addPacientes() { 
        System.out.println("\n\n AÑADIR PACIENTE\n ==================="); 
        boolean mayor65=Boolean.parseBoolean(JOptionPane.showInputDialog("Tipo de Paciente:\n" + "Prioritario=true\n Normal=false")); 
        boolean resultado=Boolean.parseBoolean(JOptionPane.showInputDialog("Resultado:\n" + "Positivo=true\n Negativo=false"));
        String nombre=JOptionPane.showInputDialog("Introduce el nombre");
        String apellido=JOptionPane.showInputDialog("Introduce el apellido");
        String dni=JOptionPane.showInputDialog("Introduce el dni");
        String numTelefono=JOptionPane.showInputDialog("Introduce el número de telefono");

        if (mayor65){ 
            String DNI=JOptionPane.showInputDialog("Confirmación Add Paciente mayor de 65 años: "); 
            misPacientes.add(new Paciente(nombre,apellido,dni,true,false,numTelefono)); 
        }else{ 
            String DNI=JOptionPane.showInputDialog("Confirmación Add Paciente con prioridad normal: "); 
            misPacientes.add(new Paciente(nombre,apellido, dni,false,true,numTelefono)); 
        }
    } 

    public static void EditPacientes() { 
        System.out.println("\n\n Editar un PACIENTE\n ==================="); 
        if(misPacientes.isEmpty()) {System.out.println("No hay Pacientes registrados"); 
        }else { 
            ListarPacientes(); 
            int pos=Integer.parseInt(JOptionPane.showInputDialog("Posicion del Paciente a Editar"));
            boolean tipo=Boolean.parseBoolean(JOptionPane.showInputDialog("Tipo de Paciente\n" + 
                        "Mayor65=true\n Normal=false")); 
            String nombre=JOptionPane.showInputDialog("Introduce el nombre"); 
            String apellido=JOptionPane.showInputDialog("Introduce el apellido");
            String dni=JOptionPane.showInputDialog("Introduce el dni");
            String numTelefono=JOptionPane.showInputDialog("Introduce el número de telefono");
            misPacientes.remove(pos); 
            if (tipo){ 
                String DNI=JOptionPane.showInputDialog("Introduce DNI"); 
                misPacientes.add(pos, (new Paciente(nombre,apellido,dni,true,false,numTelefono))); 
            }else{ 
                String DNI=JOptionPane.showInputDialog("Introduce DNI"); 
                misPacientes.add(pos, (new Paciente(nombre,apellido, dni,false,false,numTelefono))); 
            } 
        } 
    } 

    public static void EliminarPacientes() { 
        System.out.println("\n\nELIMINAR Paciente\n ==================="); 
        ListarPacientes(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posición del paciente: ")); 
        if (posicion < 0 || posicion >= misPacientes.size()) { System.out.println("Posición erronea");} 
        else { 
            String comp = JOptionPane.showInputDialog("¿Està seguro? (S/N): "); 
            if (comp.equalsIgnoreCase("S")) {misPacientes.remove(posicion);} 
        } 
    } 

    public static void cogerEnfermeros() { 
        for(Empleado e: misEmpleados) { 
            if(e.getClass().getSimpleName().equalsIgnoreCase("ENFERMERO")) { 
                misEnfermeros.add((Enfermero) e); 
            } 
        } 
    } 

    public static void ListarEnfermeros(){
        System.out.println("\n\n Lista de Enfermeros\n ==================="); 
        if (misEnfermeros.isEmpty()) { System.out.println("No hay Enfermeros registrados\n");
        }else { 
            for (int i = 0; i < misEnfermeros.size(); i++) { 
                System.out.println("********************"); 
                Empleado e = misEnfermeros.get(i); 
                System.out.printf("Cargo:" + e.getClass().getSimpleName() + "\n" +e.toString() + "\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void cogerTecnicos() { 
        for(Empleado e: misEmpleados) { 
            if(e.getClass().getSimpleName().equalsIgnoreCase("TECNICO")) { 
                misTecnicos.add((Tecnico) e); 
            } 
        } 
    } 

    public static void ListarTecnicos(){
        System.out.println("\n\n Lista de Técnicos\n ==================="); 
        if (misTecnicos.isEmpty()) { System.out.println("No hay Técnicos registrados\n");
        }else { 
            for (int i = 0; i < misTecnicos.size(); i++) { 
                System.out.println("********************"); 
                Empleado e = misTecnicos.get(i); 
                System.out.printf("Cargo:" + e.getClass().getSimpleName() + "\n" +e.toString() + "\n"); 
                System.out.println("********************\n"); 
            } 
        } 
    } 

    public static void AsigPruebaDiag() { 

        System.out.println("\nASIGNAR Prueba Diagnóstica\n ==================="); 
        MenuAdministrador.verPedidosP(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posición de la prueba: ")); 
        if (posicion < 0 || posicion >= MenuAdministrador.MispedidosP.size()) { 
            System.out.println("Posición erronea"); 
        }else { 

            cogerTecnicos(); 
            ListarTecnicos(); 
            int Art =Integer.parseInt(JOptionPane.showInputDialog("Elige un Técnico")); 
            misTecnicos.get(Art).recibirEncargo1(MenuAdministrador.MispedidosP.get(posicion)); 
        } 
    } 

    public static void AsigVacunacion() { 

        System.out.println("\nASIGNAR Vacunación\n ==================="); 
        MenuAdministrador.verPedidosV(); 
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posición del enfermero: ")); 
        if (posicion < 0 || posicion >= MenuAdministrador.MispedidosV.size()) { 
            System.out.println("Posición erronea"); 
        }else { 

            cogerEnfermeros(); 
            ListarEnfermeros(); 
            int Art =Integer.parseInt(JOptionPane.showInputDialog("Elige un Enfermero")); 
            misEnfermeros.get(Art).recibirEncargo(MenuAdministrador.MispedidosV.get(posicion)); 
        } 
    } 

    public static void hacerPedidoVacuna() { 

        String enfermero=JOptionPane.showInputDialog("Nombre del Paciente"); 
        System.out.println("Catalogo de Vacunas:"); 
        Inventario.ListarVacunas(); 

        String seguir=("S"); 
        while(seguir.equalsIgnoreCase("S")) { 
            int e=Integer.parseInt(JOptionPane.showInputDialog("Elige la posicion dela vacuna que deseas añadir\n"
                        + "La primera posicion es 0")); 
            if (Inventario.misVacunas.isEmpty()) { 
                System.out.println("No hay vacunas en el Inventario"); 
            }else { 
                Listamateriales.add(Inventario.misVacunas.get(e)); 
                seguir=JOptionPane.showInputDialog("Seguir añadiendo \n S/N"); 
            } 
        } 
        MispedidosV.add(new PedidoV (enfermero, Listamateriales)); 
    } 

    public static void hacerPedidoPrueba() { 

        String tecnico=JOptionPane.showInputDialog("Nombre del Paciente:"); 
        System.out.println("Catalogo de Pruebas:"); 
        Inventario.ListarPruebas();

        String seguir=("S"); 
        while(seguir.equalsIgnoreCase("S")) { 
            int e=Integer.parseInt(JOptionPane.showInputDialog("Elige la posicion de la vacuna que deseas añadir\n"
                        + "La primera posicion es 0")); 
            if (Inventario.misPruebas.isEmpty()) { 
                System.out.println("No hay material en el Inventario"); 
            }else { 
                Listamateriales.add(Inventario.misPruebas.get(e)); 
                seguir=JOptionPane.showInputDialog("Seguir añadiendo \n S/N"); 
            } 
        } 
        MispedidosP.add(new PedidoP (tecnico, Listamateriales)); 
    }

    public static void verPedidosV(){ 
        if (MispedidosV.isEmpty()) { System.out.println("No hay Pedidos registrados\n"); 
        }else { 
            for (int i = 0; i < MispedidosV.size(); i++) { 
                PedidoV e = MispedidosV.get(i); 
                System.out.println(e.toString() ) ;
                System.out.println("===================\n\n");
            } 
        } 
    } 

    public static void verPedidosP(){ 

        if (MispedidosP.isEmpty()) { System.out.println("No hay Pedidos registrados\n"); 
        }else { 
            for (int i = 0; i < MispedidosP.size(); i++) { 
                PedidoP e = MispedidosP.get(i); 
                System.out.println(e.toString() ) ;
                System.out.println("===================\n\n");
            } 
        } 
    } 
} 
