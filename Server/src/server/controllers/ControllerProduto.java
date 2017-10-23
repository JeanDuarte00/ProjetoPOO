package server.controllers;

import java.util.ArrayList;
import server.model.Cardapio;
import server.model.Produto;
import server.DAO.CardapioDAO;

public class ControllerProduto {
    private CardapioDAO dao = new CardapioDAO();
    
    public Produto busca(String idLoja, String idProduto){
        Cardapio c = dao.buscaCardapio(idLoja);
        ArrayList<Produto> produtos = c.getProdutos();
        
        for(Produto p: produtos){
            if(p.getId().equals(idProduto)){
                return p;
            }
        }
        return null;
    }
}
