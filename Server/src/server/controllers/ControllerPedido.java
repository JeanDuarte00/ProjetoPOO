
package server.controllers;

import java.util.ArrayList;
import server.DAO.PedidoDAO;
import server.model.Pedido;

public class ControllerPedido {
    private PedidoDAO pedidos = new PedidoDAO();
    
    
    public ArrayList<Pedido> getTodosPedidos(String idLoja){
        return pedidos.buscarTodosPedidos(idLoja);
    }
    
    
    public void addPedido(Pedido p){
        pedidos.adiciona(p);
    }    
    
    public boolean removerPedido(String idLoja, String idPedido){
        ArrayList<Pedido> pedidosLoja = pedidos.buscarTodosPedidos(idLoja);
        if(!pedidosLoja.isEmpty()){
            for(Pedido p : pedidosLoja){
                if(p.getId().equals(idPedido)){
                    pedidos.remove(p);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Pedido buscarPedido(String id){
        Pedido p;
        return p = pedidos.buscar(id);
    }
    
    public ArrayList<Pedido> novosPedidos(String idLoja){
        ArrayList<Pedido> todos = null;
        ArrayList<Pedido> novos = new ArrayList<>();
        todos = pedidos.buscarTodosPedidos(idLoja);
        if(!todos.isEmpty()){
            for (Pedido p : todos){
                if(!p.isStatusVisualizado()){
                    novos.add(p);
                }
            }
            
            if(novos.isEmpty()){
                return null;
            }
            
            return novos;
        }
        return null;
    }
}
