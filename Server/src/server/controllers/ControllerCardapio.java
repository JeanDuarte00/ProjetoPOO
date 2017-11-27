package server.controllers;

import persistencia.CardapioArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PersistenciaImplementado;
import server.model.Cardapio;


/*
 * As únicas coisa que um controller cardapio pode
 * fazer é retornar o cardapio desejado do banco e
 * criar um novo, não há necessidade de deletar um cardapio
 * já o criar cardapio não é um metodo, mas sim a instanciad do objeto
 * EX: Cardapio cardapio = new Cardapio();
 * */

public class ControllerCardapio {
	private InterfacePersistencia bancoCardapio = new PersistenciaImplementado( new CardapioArquivoDAO() );	

    public ControllerCardapio(String id) {
        Cardapio cardapio = new Cardapio(id);
        bancoCardapio.salvar(cardapio);
    }
	
    
    //vai no banco de cardapio, busca o cardapio deseja, e retorna para quem chamou
    //assim podemos fazer qualquer coisa com um cardapio tal como
    //(remover, adicionar, alterar) um produto do cardapio
    public Cardapio getCardapio(String id){
    	Cardapio cardapio = (Cardapio)bancoCardapio.buscar(id);  
        if(cardapio!=null){
            return cardapio;
        }
          return null;      	    	
    }
    
    
    /* quando a loja for criada, ela instancia um caradapio vazio
       o criar cardapio recebe o cardapio vazio e salva no dao.        
    */
    public void criarCardapio(Cardapio c){
        this.bancoCardapio.salvar(c); 
    }


	public void atualizarCardapio(String id, Cardapio cardapio) {
		this.bancoCardapio.apagar(id);
		this.bancoCardapio.salvar(cardapio);
		
	}
}
