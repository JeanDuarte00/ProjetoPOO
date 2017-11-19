package persistencia;

import java.util.List;

import server.model.ContaLoja;

public class ContaLojaArquivoDAO extends AbstractBancoDeDadosArquivos {

	public ContaLojaArquivoDAO() {
		super.setCaminhoDir("base/contas/lojas");
	}

	@Override
	public void salvar(Object objeto) {
		ContaLoja conta = (ContaLoja)objeto;
		
		setArquivoDeRegistro( getCaminhoDir() + conta.getLogin() + getFormatoArquivo() );
		super.salvar(conta);
		
	}
	
	
	@Override
	public ContaLoja buscar(String login) {
		
		setArquivoDeRegistro( getCaminhoDir() + login + getFormatoArquivo() );
		return (ContaLoja) super.buscar(login);
		
	}
	
	
	@Override
	public void apagar(String login) {
		
		setArquivoDeRegistro( getCaminhoDir() + login + getFormatoArquivo() );
		super.apagar(login);
		
	}
	
	
	public List<Object> getTodos() {
		//O usuario desse método deve ser responsavel pelo retorno		
		return super.getTodos();
		
	}
	
	
}
