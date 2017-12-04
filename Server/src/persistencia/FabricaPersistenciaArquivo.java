package persistencia;


/**
 * Fabrica de banco de dados
 * */
public class FabricaPersistenciaArquivo extends FabricaPersistencia{

	
	public void makeIt( String tipoObjeto ) {
		
		if( tipoObjeto.toUpperCase().equals("PEDIDO") ) {
			banco = new PersistenciaArquivoPedido();
		}
		
		if( tipoObjeto.toUpperCase().equals("CARDAPIO") ) {
			banco = new PersistenciaArquivoCardapio();
		}		
			
	}
	

	
}
