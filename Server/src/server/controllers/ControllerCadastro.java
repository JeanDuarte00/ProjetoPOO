package server.controllers;



import persistencia.ContaClienteArquivoDAO;
import persistencia.ContaLojaArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PersistenciaImplementado;
import server.model.Conta;
import server.model.ContaCliente;
import server.model.ContaLoja;


/*
 * Controller para cadastrar e remover uma Conta qualquer.
 * Para achar uma conta, talvez, seja necessario passar por todas as contas
 * 
 * */
public class ControllerCadastro {
    	
	private InterfacePersistencia bancoCliente = new PersistenciaImplementado( new ContaClienteArquivoDAO() );	
	
	private InterfacePersistencia bancoLoja = new PersistenciaImplementado( new ContaLojaArquivoDAO() );


    public boolean buscarLoginCliente(String login) {  //metodo para buscar login e dps validar com senha
    	
        ContaCliente conta = (ContaCliente)bancoCliente.buscar(login);
        
        return (conta != null); //retorna o valor lógico da comparação - true se diferente de null, se não, false
        
    }

    public boolean buscarLoginLoja(String login) {  //metodo para buscar login e dps validar com senha
        
        ContaLoja conta = (ContaLoja)bancoLoja.buscar(login);
        
        return (conta != null); //retorna o valor lógico da comparação - true se diferente de null, se não, false
        
    }
    
    
    /**
     * adiciona uma nova conta - passando uma Conta generica(Cliente ou Loja)
     * */
    public void add(Conta conta) {

        if (conta instanceof ContaCliente) {
        	bancoCliente.salvar( (ContaCliente)conta );
            
        
        } else {
            bancoLoja.salvar( (ContaLoja)conta );
            
            //ContaLoja loja = (ContaLoja)conta;
            //ControllerCardapio ctrCardapio = new ControllerCardapio(loja.getId());
            
        }
        
    }

    //remove buscando pelo registro de login - buscar em  clientes, caso não ache vai em lojas
    public void remove(String login) {

    	try {
    		bancoCliente.apagar(login);    		
    	}catch(Exception erro) {
    		try{
        		bancoLoja.apagar(login);
        		
        	}catch(Exception error) {
        		System.out.println("Registro não encontrado");
        	}
    	}

    }

}
