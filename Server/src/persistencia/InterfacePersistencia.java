package persistencia;

import java.util.List;

public interface InterfacePersistencia {

	public void salvar(Object object);
	
	public Object buscar(String identificador);
	
	public void apagar(String identificador);
	
	public List<Object> getTodos();
		
}
