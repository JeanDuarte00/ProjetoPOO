package server.model;


public class Cliente{
    private String nome;
    private String telefone; 
    
    public Cliente(String  nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getNome(){
        return this.nome;        
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
