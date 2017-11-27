package persistencia;

import java.util.List;

import server.model.Cardapio;


public class CardapioArquivoDAO extends AbstractBancoDeDadosArquivos{
	
	public CardapioArquivoDAO() {
		super.setCaminhoDir("base/cardapios/");
	}
	
	@Override
	public void salvar(Object objeto) {
		Cardapio cardapio = (Cardapio)objeto;
		
		setArquivoDeRegistro( getCaminhoDir() + cardapio.getId() + getFormatoArquivo() );
		super.salvar(cardapio);
		
	}
	
	
	@Override
	public Cardapio buscar(String identificador) {
		
		setArquivoDeRegistro( getCaminhoDir() + identificador + getFormatoArquivo() );
		return (Cardapio) super.buscar(identificador);
		
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
