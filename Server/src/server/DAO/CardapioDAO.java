/**
 * @author Jean Duarte
 */

package server.DAO;

import java.util.ArrayList;
import java.util.List;

import server.model.Cardapio;

public class CardapioDAO extends BancoDeDados{
	    	
	public CardapioDAO() {
		super.setCaminhoDir("base/cardapios/");
	}
	
	
	public List<Cardapio> getTodos() {
		
		List<Cardapio> lista = new ArrayList<>();
		
		int listaTamanho = super.getTodosObjetos().size();
		
		for(int c = 0; c < listaTamanho; c++) {
			
			lista.add( (Cardapio)super.getTodosObjetos().get(c) );
		}
		
		return lista;
	}

}
