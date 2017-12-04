package server.controllers;

import java.util.ArrayList;

import persistencia1.CardapioArquivoDAO;
import persistencia1.InterfacePersistencia;
import persistencia1.PersistenciaImplementado;
import server.model.Cardapio;
import server.model.Produto;


public class ControllerProduto {
	private InterfacePersistencia bancoCardapio = new PersistenciaImplementado( new CardapioArquivoDAO() );
    
    public Produto busca(String idLoja, String idProduto){
        Cardapio c = (Cardapio)bancoCardapio.buscar(idLoja);
        ArrayList<Produto> produtos = c.getProdutos();
        
        for(Produto p: produtos){
            if(p.getId().equals(idProduto)){
                return p;
            }
        }
        return null;
    }
}
