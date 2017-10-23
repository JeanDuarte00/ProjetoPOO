package server.model;
import server.model.Cardapio;

public class ContaLoja extends Conta{
    private String id;
    private Cardapio cardapio;
    private Loja loja;
    
    public ContaLoja(String id, String login, String senha, String nome, String telefone, String dono) {
        this.loja = new Loja(nome, telefone, dono);
        this.id = id;
        this.cardapio = new Cardapio(id);
        super.setLogin(login);
        super.setSenha(senha);
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cardapio getCardapio() {
        return this.cardapio;
    }  

    public Loja getLoja(){
        return this.loja;
    }
    
    public void setNome(String nome){
        this.loja.setNome(nome);
    }
    
    public String getNome(){
        return this.loja.getNome();
    }
        
    public String getTelefone(){
        return this.loja.getTelefone();
    }
        
    public void setTelefone(String telefone){
        this.loja.setTelefone(telefone);
    }
    
    public void setNomeDono(String nome){
        this.loja.setNomeDono(nome);
    }
    
    public String getNomeDono(){
        return this.loja.getNomeDono();
    }

}
