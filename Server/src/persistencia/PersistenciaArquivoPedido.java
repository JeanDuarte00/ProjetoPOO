package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import server.model.Pedido;

public class PersistenciaArquivoPedido extends PersistenciaArquivo implements InterfacePersistencia<Pedido>{

	public PersistenciaArquivoPedido() {
		super.setCaminhoDir("REGISTROS/PEDIDOS/");
		super.mkDir();
	}
	
	public Pedido buscar(String login) {
		
		File file = new File( this.getCaminhoDir() + login + this.getFormatoArquivo() );
		
		if( file.exists() ) {
			
			try {
				
				setFileIn( new FileInputStream( file ) );
				ObjectInputStream stream = new ObjectInputStream( this.getFileIn() );
				
				Pedido objeto = (Pedido)stream.readObject();
				
				return objeto;
				
			} catch (IOException erro) {
				System.out.println("Erro ao buscar registro " + erro.getMessage());
				
			} catch (ClassNotFoundException erro) {
				System.out.println("Erro ao buscar registro " + erro.getMessage());
				
			}			
			
			
		}
		
		return null;
		
	}
	
	
	
	/**	 
	 * Metodo para deletar um registro de conta cliente
	 * @param String login
	 * */
	public void apagar(String id) {
				
		File file = new File( this.getCaminhoDir() + id + this.getFormatoArquivo() );

		try {
			file.delete();
			
		}catch(Exception error) {
			System.out.println( "Erro ao deletar registro: " + error.getMessage() );
		}
	}

	
	
	
	
	/**
	 * Salva um objeto Cliente na base de dados
	 * criando um arquivo expecifico para cada registro
	 * portanto organização dos diretorios é importante
	 * @param Objeto Cliente
	 * */
	public void salvar(Pedido objeto) {
		
		setArquivoDeRegistro( getCaminhoDir() + objeto.getId() + getFormatoArquivo( ) ); 
				
		File file = new File( getArquivoDeRegistro() );
						
		try {				
						
			if( file.exists() ) {
				System.out.println("Base de dados ja contem esse registro");
			
			}else {
							
				setFileOut( new FileOutputStream( getArquivoDeRegistro() , false) ); 			
				
				ObjectOutputStream stream = new ObjectOutputStream( getFileOut() );
				stream.writeObject( objeto );
				
			}

		}catch(Exception erro) {			
			System.out.println("Erro - Escrita em base de dados: " + erro.getMessage() + " : " + erro.getCause());
		}
		
	}
  
	
	
	
	
	
	/**
	 * Retorna todos os cliente do arquivo de conta clientes
	 * portanto deve percorrer por todos os arquivo e 
	 * ler os objtos e inserir na lista
	 * @return List<Cliente>
	 */
	public List<Pedido> getTodos() {
		
		File dir = new File( this.getCaminhoDir() );
		File files[] = dir.listFiles();
		
		List<Pedido> lista = new ArrayList<>();
		
		for(File fileAtual : files) {
		
			try {
				setFileIn( new FileInputStream( fileAtual ) );
				ObjectInputStream stream = new ObjectInputStream( this.getFileIn() );
				
				Pedido objeto = (Pedido)stream.readObject();
				lista.add(objeto);
				
			}catch(Exception erro) {
				System.out.println("Erro ao buscar todos os registros " + erro.getMessage());
			}
		}
		
		return lista;
	}

	
	
}
