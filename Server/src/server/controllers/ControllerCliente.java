
package server.controllers;


import java.util.ArrayList;

import server.DAO.ClienteDAO;
import server.model.ContaCliente;


public class ControllerCliente {
    private ClienteDAO bancoCliente = new ClienteDAO();
    
    // Apenas busca os dados do cliente, retornando o objeto
    // quando a view receber o objeto, ela mesmo altera os dados do objeto
    // cliente.setNome("garibalda");
    public ContaCliente buscar(String login){
        return bancoCliente.buscar(login);
    }
}