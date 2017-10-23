package server.controllers;

import server.DAO.CardapioDAO;
import server.model.Cardapio;


/*
 * As únicas coisa que um controller cardapio pode
 * fazer é retornar o cardapio desejado do banco e
 * criar um novo, não há necessidade de deletar um cardapio
 * já o criar cardapio não é um metodo, mas sim a instanciad do objeto
 * EX: Cardapio cardapio = new Cardapio();
 * */

public class ControllerCardapio {
    CardapioDAO bancoCardapio = new CardapioDAO();

    public ControllerCardapio(String id) {
        Cardapio cardapio = new Cardapio(id);
        bancoCardapio.criarCardapio(cardapio);
    }
	
    public ControllerCardapio(){
        
    }
    //vai no banco de cardapio, busca o cardapio deseja, e retorna para quem chamou
    //assim podemos fazer qualquer coisa com um cardapio tal como
    //(remover, adicionar, alterar) um produto do cardapio
    public Cardapio getCardapio(String id){
    	Cardapio cardapio = bancoCardapio.buscaCardapio(id);  
        if(cardapio!=null){
            return cardapio;
        }
          return null;      	    	
    }
    
    
    /* quando a loja for criada, ela instancia um caradapio vazio
       o criar cardapio recebe o cardapio vazio e salva no dao.        
    */
    public void criarCardapio(Cardapio c){
        this.bancoCardapio.criarCardapio(c); 
    }
    public void atualizarCardapio(String id, Cardapio c){
        this.bancoCardapio.removerCardapio(id);
        this.criarCardapio(c);
    }
}
