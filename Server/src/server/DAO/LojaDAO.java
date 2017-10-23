/**
 * @author Jean Duarte
 */

package server.DAO;

import java.util.ArrayList;
import java.util.List;

import server.model.ContaLoja;

public class LojaDAO extends BancoDeDados{
    
    public LojaDAO() {
		super.setCaminhoDir("base/contas/lojas/");
	}  
    
    
	public List<ContaLoja> getTodos() {
		
		List<ContaLoja> lista = new ArrayList<>();
		
		int listaTamanho = super.getTodosObjetos().size();
		
		for(int c = 0; c < listaTamanho; c++) {
			
			lista.add( (ContaLoja)super.getTodosObjetos().get(c) );
		}
		
		return lista;
	}
	
}
