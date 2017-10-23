package server.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private String voucher;
    private List<Item> itens;

    private boolean statusVisualizado;
    private boolean statusPronto;
    private boolean statusEntregue;

    public Pedido(String idLoja, String voucher, List<Item> itens){
    
        this.itens = new ArrayList<>();
        
        this.voucher =  voucher;
        this.id = "" + idLoja + this.voucher;   	   
        this.itens = itens;

        this.statusPronto = false;
        this.statusVisualizado = false;
        this.statusEntregue = false;
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
     
    public boolean isStatusVisualizado() {
        return this.statusVisualizado;
    }

    public boolean isStatusPronto() {
    	return this.statusPronto;
    }
    
    public boolean isStatusEntregue() {
    	return this.statusEntregue;
    }
       
    public void setStatusVisualizado() {
        this.statusVisualizado = true;
    }

    public void setStatusPronto() {
        this.statusPronto = true;
    }
       
    public void setStatusEntregue(){
        this.statusEntregue = true;
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
