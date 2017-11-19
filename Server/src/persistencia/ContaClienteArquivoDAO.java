package persistencia;

import java.util.List;

import server.model.ContaCliente;

public class ContaClienteArquivoDAO extends AbstractBancoDeDadosArquivos{
	
	public ContaClienteArquivoDAO() {
		super.setCaminhoDir("base/contas/clientes");
	}

	@Override
	public void salvar(Object objeto) {
		ContaCliente conta = (ContaCliente)objeto;
		
		setArquivoDeRegistro( getCaminhoDir() + conta.getLogin() + getFormatoArquivo() );
		super.salvar(conta);
		
	}
	
	
	@Override
	public ContaCliente buscar(String login) {
		
		setArquivoDeRegistro( getCaminhoDir() + login + getFormatoArquivo() );
		return (ContaCliente) super.buscar(login);
		
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

