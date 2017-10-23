
package server.model;

public class Item {
    private int quantidade;
    private Produto produto;
    
    public Item(int quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
    }
 
    public double getPreco(){
        return produto.getPreco() * this.quantidade;
    }
    
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    
    
}

