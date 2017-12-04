package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import server.model.Cardapio;



public class PersistenciaArquivoCardapio extends PersistenciaArquivo implements InterfacePersistencia<Cardapio>{
	
	PersistenciaArquivoCardapio(){
		super.setCaminhoDir("REGISTROS/CARDAPIOS/");
		super.mkDir();
	}
	
	
	public Cardapio buscar(String login) {
				
		File file = new File( this.getArquivoDeRegistro() );
		
		if( file.exists() ) {
			
			try {
				
				setFileIn( new FileInputStream( file ) );
				ObjectInputStream stream = new ObjectInputStream( this.getFileIn() );
				
				Cardapio objeto = (Cardapio)stream.readObject();
				
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
				

		String arquivoDeRegistro = this.getCaminhoDir() + id + this.getFormatoArquivo(); 
		
		File file = new File( arquivoDeRegistro );

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
	public void salvar(Cardapio objeto) {
		
		String arquivoDeRegistro = getCaminhoDir() + objeto.getId() + getFormatoArquivo(); 
				
		File file = new File( arquivoDeRegistro );
						
		try {				
						
			if( file.exists() ) {
				System.out.println("Base de dados ja contem esse registro");
			
			}else {
				
				setFileOut( new FileOutputStream( arquivoDeRegistro , false) ); 			
				
				ObjectOutputStream stream = new ObjectOutputStream( this.getFileOut() );
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
	public List<Cardapio> getTodos() {
		
		File dir = new File( this.getCaminhoDir() );
		File files[] = dir.listFiles();
		
		List<Cardapio> lista = new ArrayList<>();
		
		for(File fileAtual : files) {
		
			try {
				setFileIn( new FileInputStream( fileAtual ) );
				ObjectInputStream stream = new ObjectInputStream( this.getFileIn() );
				
				Cardapio objeto = (Cardapio)stream.readObject();
				lista.add(objeto);
				
			}catch(Exception erro) {
				System.out.println("Erro ao buscar todos os registros " + erro.getMessage());
			}
		}
		
		return lista;
	}

}
