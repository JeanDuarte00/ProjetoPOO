/**
 * @author Jean Duarte
 */

package server.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Interfaces.InterfaceBancoDeDados;
import server.model.ContaCliente;


abstract public class BancoDeDados implements InterfaceBancoDeDados{
	
	private String formatoArquivo = ".dat";
	private String caminhoDir;
	
	private FileInputStream fileIn;
	private FileOutputStream fileOut;
  
		
	public String getFormatoArquivo() {
		return formatoArquivo;
	}

	public void setFormatoArquivo(String formatoArquivo) {
		this.formatoArquivo = formatoArquivo;
	}

	public String getCaminhoDir() {
		return caminhoDir;
	}

	public void setCaminhoDir(String caminhoDir) {
		this.caminhoDir = caminhoDir;
	}

	public FileInputStream getFileIn() {
		return fileIn;
	}

	public void setFileIn(FileInputStream fileIn) {
		this.fileIn = fileIn;
	}

	public FileOutputStream getFileOut() {
		return fileOut;
	}

	public void setFileOut(FileOutputStream fileOut) {
		this.fileOut = fileOut;
	}


	
	
	
	
	
	public Object buscar(String login) {
		
		String arquivoDeRegistro = getCaminhoDir() + login + getFormatoArquivo();
		
		File file = new File( arquivoDeRegistro );
		
		if( file.exists() ) {
			
			try {
				setFileIn( new FileInputStream( file ) );			
				ObjectInputStream stream = new ObjectInputStream(this.fileIn);
				
				ContaCliente cliente = (ContaCliente)stream.readObject();
				
				return cliente;
				
			}catch(Exception erro) {
				System.out.println("Erro ao buscar o registro " + erro.getMessage());
			}
		}
		
		return null;
		
	}
	
	
	
	
	
	
	/**	 
	 * Metodo para deletar um registro de conta cliente
	 * @param String login
	 * */
	public void apagar(String login) {
		
		String arquivoDeRegistro = getCaminhoDir() + login + getFormatoArquivo(); 
		
		File file = new File( arquivoDeRegistro );
		
		
		if( file.exists() ) {
			//bastante redundante, mas para deixar claro o que ocorre aqui deixamos assim...
			file.delete();
			
		}else {
			
			System.out.println("Registro nao existe");
			
		}
		
		
		
	}
	
	
	
	
	

	/**
	 * Salva um objeto Cliente na base de dados
	 * criando um arquivo expecifico para cada registro
	 * portanto organização dos diretorios é importante
	 * @param Objeto Cliente
	 * */
	public void salvar(Object objeto) {
		
		ContaCliente cliente = (ContaCliente)objeto;
		
		String arquivoDeRegistro = getCaminhoDir() + cliente.getNome() + getFormatoArquivo(); 
				
		File file = new File( arquivoDeRegistro );
						
		try {				
						
			if( file.exists() ) {
				System.out.println("Base de dados ja contem esse registro");
			
			}else {
							
				setFileOut( new FileOutputStream( arquivoDeRegistro , false) ); 			
				
				ObjectOutputStream stream = new ObjectOutputStream(this.fileOut);
				stream.writeObject(cliente);
				
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public List<Object> getTodosObjetos() {
		
		File dir = new File( getCaminhoDir() );
		File files[] = dir.listFiles();
		
		List<Object> lista = new ArrayList<>();
		
		for(File fileAtual : files) {
		
			try {
				setFileIn( new FileInputStream( fileAtual ) );
				ObjectInputStream stream = new ObjectInputStream(this.fileIn);
				
				ContaCliente cliente = (ContaCliente)stream.readObject();
				lista.add(cliente);
				
			}catch(Exception erro) {
				System.out.println("Erro ao buscar todos os registros " + erro.getMessage());
			}
		}
		
		return lista;
	}
	
	
	
}


