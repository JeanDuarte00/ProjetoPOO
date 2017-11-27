package server.model;

import java.util.ArrayList;
import java.util.List;

import estados.*;

public class Pedido {
    private String id;
    private String voucher;
    private List<Item> itens;
    private StatePedido state;
    
    public Pedido(String idLoja, String voucher, List<Item> itens){
    
        this.itens = new ArrayList<>();
        
        this.voucher =  voucher;
        this.id = "" + idLoja + this.voucher;   	   
        this.itens = itens;

        
   }    
   public void setState(StatePedido state){
       this.state = state;
   }
    
   public String getEstadoPedido(){
       return this.state.estadoPedido();
   }
   
    
    public String getId() {
        return this.id;
    }

    public String getReferenciaLoja(){
        return id.substring(0, 2);        
    } 
     
    public String getVoucherO(){
        return this.voucher;
    }
     
    
    public double getPreco() {
        double total = 0;

        for(Item item : itens) {
                total += item.getPreco();
        }

        return total;
    }
    
    public List <Item> getItens(){
        return this.itens;
    }

}