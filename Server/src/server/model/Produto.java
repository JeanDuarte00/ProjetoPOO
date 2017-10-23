package server.model;

public class Produto {
    private String nome;
    private String id;
    private double preco;
    private String descricao;

    public Produto(String nome, String descricao, String id, double preco){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.id = id;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String n){
        this.nome = n;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getId(){
        return this.id;
    }
    
    
}
