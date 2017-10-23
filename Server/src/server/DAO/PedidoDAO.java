/**
 * @author Jean Duarte
 */

package server.DAO;

import java.util.ArrayList;
import java.util.List;

import server.model.Pedido;

public class PedidoDAO extends BancoDeDados {
   
	public PedidoDAO(){
		super.setCaminhoDir("base/pedidos/");		
	}
	
	
	public List<Pedido> getTodos() {
		
		List<Pedido> lista = new ArrayList<>();
		
		int listaTamanho = super.getTodosObjetos().size();
		
		for(int c = 0; c < listaTamanho; c++) {
			
			lista.add( (Pedido)super.getTodosObjetos().get(c) );
		}
		
		return lista;
	}
		
}