package persistencia;

import server.model.Cardapio;
import server.model.Pedido;


public class Test {

	
	
	

	public static void main(String[] args) {
	
		Cardapio cad = new Cardapio("23");
		Pedido ped = new Pedido("edf","@df",null);
		
		PersistenciaArquivoCardapio dao = new PersistenciaArquivoCardapio();
		dao.salvar(cad);		
		System.out.println("parte1");
		
		InterfacePersistencia<Cardapio> dao2 = new PersistenciaArquivoCardapio();
		dao2.salvar(cad);	
		System.out.println("parte2");
		
		FabricaPersistenciaArquivo fabrica = new FabricaPersistenciaArquivo();		
		fabrica.makeIt("pedido");
		PersistenciaArquivoPedido banco = (PersistenciaArquivoPedido)fabrica.getIt();
		banco.salvar(ped);		
		System.out.println("parte3");
	}

}
