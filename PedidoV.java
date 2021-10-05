package auxiliar;
import java.util.ArrayList; 
import Stock.*; 

public class PedidoV{ 
    private ArrayList<Material> pedidoV; 
    private double numPedido1; 
    private static double pedidoSig=1; 
    private String paciente; 
    private double Total=0;

    public PedidoV(String paciente,ArrayList<Material> pedidoV) { 
        this.paciente=paciente; 
        this.pedidoV=pedidoV; 
        numPedido1=pedidoSig; 
        pedidoSig++; 
    } 

    public String impPedido() { 
        System.out.println("********************"); 
        System.out.println("Paciente:" + paciente + "\nNumero Pedido:" + numPedido1); 
        for(int i=0; i<pedidoV.size();i++) { 
            Material v =pedidoV.get(i); 
            System.out.println(v.getClass().getSimpleName() + "\n" + v.toString()+"\n" ); 
        } 
        return ""; 
    } 

    public void setTotal(double v) { 
        this.Total=v; 
    } 

    public String toString() { 

        return (impPedido()); 
    }
}