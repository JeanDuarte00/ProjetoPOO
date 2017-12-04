package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



abstract public class PersistenciaArquivo{
	

	private String formatoArquivo = ".dat";
	private String caminhoDir;
	
	private String arquivoDeRegistro;
	
	private FileInputStream fileIn;
	private FileOutputStream fileOut;
  
		
	public String getArquivoDeRegistro() {
		return this.arquivoDeRegistro;
	}

	public void setArquivoDeRegistro(String arquivoDeRegistro) {
		this.arquivoDeRegistro = arquivoDeRegistro;
	}

	public String getFormatoArquivo() {
		return this.formatoArquivo;
	}

	public void setFormatoArquivo(String formatoArquivo) {
		this.formatoArquivo = formatoArquivo;
	}

	public String getCaminhoDir() {
		return this.caminhoDir;
	}

	public void setCaminhoDir(String caminhoDir) {
		this.caminhoDir = caminhoDir;
	}

	public FileInputStream getFileIn() {
		return this.fileIn;
	}

	public void setFileIn(FileInputStream fileIn) {
		this.fileIn = fileIn;
	}

	public FileOutputStream getFileOut() {
		return this.fileOut;
	}

	public void setFileOut(FileOutputStream fileOut) {
		this.fileOut = fileOut;
	}
	
	public void mkDir() {
		File file = new File( this.getCaminhoDir() );
		file.mkdirs();
	}

	
}
