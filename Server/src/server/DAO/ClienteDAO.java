/**
 * @author Jean Duarte
 */

package server.DAO;

import java.util.ArrayList;
import java.util.List;

import server.model.ContaCliente;

public class ClienteDAO extends BancoDeDados{

	public ClienteDAO() {
		super.setCaminhoDir("base/contas/clientes");
	}

	
	public List<ContaCliente> getTodos() {
		
		List<ContaCliente> lista = new ArrayList<>();
		
		int listaTamanho = super.getTodosObjetos().size();
		
		for(int c = 0; c < listaTamanho; c++) {
			
			lista.add( (ContaCliente)super.getTodosObjetos().get(c) );
		}
		
		return lista;
	}
	
}


