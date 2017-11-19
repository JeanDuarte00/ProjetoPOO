package persistencia;

import java.util.List;

public class PersistenciaImplementado implements InterfacePersistencia{

	
	private InterfaceBancoDeDados dao = null;
	
	/**
	 * Construtor
	 * @return 
	 * */
	public PersistenciaImplementado( InterfaceBancoDeDados dao) {
		
		this.dao = dao;		
	}

	
	@Override
	public void salvar(Object object) {
		dao.salvar(object);
	}
	
	public Object buscar(String identificador) {
		return dao.buscar(identificador);
	}
	
	public void apagar(String identificador) {
		dao.apagar(identificador);
	}
	
	public List<Object> getTodos(){
		return dao.getTodos();		
	}


	
}
