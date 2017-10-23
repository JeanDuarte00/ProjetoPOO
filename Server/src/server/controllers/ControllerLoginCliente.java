
package server.controllers;
import server.model.ContaCliente;
import server.DAO.ClienteDAO;

public class ControllerLoginCliente {
    private ClienteDAO dao = new ClienteDAO();
    
    // apenas loga e retorna para view o objeto do cliente
    // a view com o objeto retornado, pode visualizar o cliente
   /* public boolean buscarLogin(String login){  //metodo para buscar login e dps validar com senha
        ContaCliente c;
        c = dao.buscar(login);
        if(c != null){
            return true;
        }
        else{
            return false;
        }
    }*/
    public ContaCliente logar(String login, String senha){
        ContaCliente c;
        c = dao.buscar(login);
        if(c != null && c.getSenha().equals(senha)){
            return c;
        }
        return null;
    }
}

        