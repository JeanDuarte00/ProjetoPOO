package persistencia;

import java.util.List;

import server.model.Pedido;

public class PedidoArquivoDAO extends AbstractBancoDeDadosArquivos{

	public PedidoArquivoDAO(){
		super.setCaminhoDir("base/pedidos/");		
	}
		
	@Override
	public void salvar(Object objeto) {
		Pedido pedido = (Pedido)objeto;
		
		setArquivoDeRegistro( getCaminhoDir() + pedido.getId() + getFormatoArquivo() );
		super.salvar(pedido);
		
	}
	
	
	@Override
	public Pedido buscar(String identificador) {
		
		setArquivoDeRegistro( getCaminhoDir() + identificador + getFormatoArquivo() );
		return (Pedido) super.buscar(identificador);
		
	}
	
	
	@Override
	public void apagar(String identificador) {
		
		setArquivoDeRegistro( getCaminhoDir() + identificador + getFormatoArquivo() );
		super.apagar(identificador);
		
	}
	
	
	public List<Object> getTodos() {
		//O usuario desse método deve ser responsavel pelo retorno		
		return super.getTodos();
		
	}
	
}
