package persistencia;

import java.util.List;

public interface InterfacePersistencia<T> {

	public void salvar(T objeto);
	
	public List<T> getTodos();
	
	public T buscar(String identificador);
	
	public void apagar(String identificador);
	
}
