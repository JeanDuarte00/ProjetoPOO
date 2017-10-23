package server.model;

public abstract class Conta {

    private String login;
    private String senha;

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login) {
    	this.login = login;
    }

    public void setSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public String getSenha() {
    	return this.senha;
    }
}
