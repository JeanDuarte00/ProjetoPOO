package server.model;


import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private String id;
    private List<Produto> produtos;
    
    public Cardapio(String idLoja){       

        this.id = idLoja; // mesmo ID que Loja
        this.produtos = new ArrayList<>();

    }
    
    
    
    public String getId() {
        return id;
    }
    
    
    
    public void addProduto(Produto produto){       
        this.produtos.add(produto);
       
    }
    
    
    
    public void removeProduto(String idProduto){
       for(Produto produto : produtos){
           if( produto.getId().equals(idProduto) ){
               produtos.remove(produto);
           }
       }
    }  
    
    public Produto getProdutoPorID(String id){
        for(Produto produto : produtos){
            if(produto.getId().equals(id))
                return produto;
        }
        return null;
    }
    
    
    
    public ArrayList<Produto> getProdutos(){
    	return (ArrayList<Produto>) this.produtos;
    }
}
