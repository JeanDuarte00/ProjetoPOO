package server.model;

import java.util.ArrayList;
import java.util.List;

public class ContaCliente extends Conta{
    Cliente cliente;
    List<Pedido> pedidos;
    
    public ContaCliente (String nome, String telefone,String login, String senha){
        this.cliente = new Cliente(nome, telefone);
        this.pedidos = new ArrayList<>(); 
        super.setLogin(login);
        super.setSenha(senha);  
        
    }
    
    public List<Pedido> getTodosPedidos(){
        return this.pedidos;
    }
    
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public boolean removePedidosEntregues(String idPedido){
        boolean objeto = false;
        for(Pedido pedido : pedidos){
            if( pedido.getEstadoPedido().equals("Entregue")){
                objeto = pedidos.remove(pedido);
            }
        }
        return objeto;
    }

    public String getNome(){
        return this.cliente.getNome();
    }
    
    public String getTelefone(){
        return this.cliente.getTelefone();
    }
    public void setNome(String nome){
        this.cliente.setNome(nome);
    }
    
    public void setTelefone(String telefone){
        this.cliente.setTelefone(telefone);
    }
}
