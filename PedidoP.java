package auxiliar;
import java.util.ArrayList; 
import Stock.*; 

public class PedidoP{ 
    private ArrayList<Material> pedidoP; 
    private double numPedido2; 
    private static double pedidoSig=1; 
    private String paciente; 
    private double Total=0;

    public PedidoP(String paciente,ArrayList<Material> pedidoP) { 
        this.paciente=paciente; 
        this.pedidoP=pedidoP; 
        numPedido2=pedidoSig; 
        pedidoSig++; 
    } 

    public String impPedido() { 
        System.out.println("********************"); 
        System.out.println("Paciente:" + paciente + "\nNumero Pedido:" + numPedido2); 
        for(int i=0; i<pedidoP.size();i++) { 
            Material p =pedidoP.get(i); 
            System.out.println(p.getClass().getSimpleName() + "\n" + p.toString() ); 
        } 
        return ""; 
    } 

    public void setTotal(double p) { 
        this.Total=p; 
    } 

    public String toString() { 

        return (impPedido()); 
    } 
}