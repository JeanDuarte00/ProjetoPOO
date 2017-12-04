package persistencia;

public abstract class FabricaPersistencia {

	PersistenciaArquivo banco;
	
	public abstract void makeIt( String tipoObjeto );
	
	public PersistenciaArquivo getIt() {
		return this.banco;
	}
}
