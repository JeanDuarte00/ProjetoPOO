package server.controllers;

import java.util.ArrayList;
import java.util.List;


import persistencia.InterfacePersistencia;
import persistencia.PedidoArquivoDAO;
import persistencia.PersistenciaImplementado;
import server.model.Pedido;

public class ControllerPedido {
	private InterfacePersistencia bancoPedido = new PersistenciaImplementado( new PedidoArquivoDAO() );	
    
    
    public ArrayList<Pedido> getTodosPedidos() {
    	ArrayList<Pedido> lista = new ArrayList<>();
        
    	for(Object loja : bancoPedido.getTodos()) {
    		lista.add((Pedido)loja);
    	}
    	return lista;
    	
    }
    
    public void addPedido(Pedido p){
        bancoPedido.salvar(p);
    }    
    
    public boolean removerPedido(String idLoja, String idPedido){
        List<Object> pedidosLoja = bancoPedido.getTodos();
        if(!pedidosLoja.isEmpty()){
            for(Object p : pedidosLoja){
                if(((Pedido) p).getId().equals(idPedido)){
                    bancoPedido.apagar(idPedido);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Pedido buscarPedido(String id){
        
        return (Pedido) bancoPedido.buscar(id);
    }
    

	public ArrayList<Pedido> novosPedidos(String idLoja){
	    
	    ArrayList<Pedido> novos = new ArrayList<>();
	    List<Object>todos = bancoPedido.getTodos();
	
	    if( !todos.isEmpty() ){
	    	
	    	Pedido pedido = null;
	        for (Object iterador : todos){
	            pedido = (Pedido)iterador;
	        		
	        	if(pedido.getEstadoPedido().equals("ENTREGUE")){//verificar isso
	                novos.add(pedido);
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