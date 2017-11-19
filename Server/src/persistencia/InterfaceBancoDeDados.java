package persistencia;

import java.util.List;

public interface InterfaceBancoDeDados {

	public void salvar(Object object);
	
	public Object buscar(String identificador);
	
	public void apagar(String identificador);
	
	public List<Object> getTodos();

	
}
