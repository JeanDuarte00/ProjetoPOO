/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

/**
 *
 * @author junior
 */
public class StatusPedido{
    private String statusPedido;
    
    public StatusPedido(){
        this.statusPedido = "Não há alterações no pedido";
    }
    public void setStatusVisualizado() {
        this.statusPedido = "Visualizado";
    }

    public void setStatusPronto() {
        this.statusPedido = "Pronto";
    }
       
    public void setStatusEntregue(){
        this.statusPedido = "Entregue";
    }
    public String getStatusPedido(){
        return this.statusPedido;
    }
}
