
package server.controllers;

import persistencia.ContaClienteArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PersistenciaImplementado;
import server.model.ContaCliente;


public class ControllerCliente {
	private InterfacePersistencia bancoCliente = new PersistenciaImplementado( new ContaClienteArquivoDAO() );
    
    // Apenas busca os dados do cliente, retornando o objeto
    // quando a view receber o objeto, ela mesmo altera os dados do objeto
    // cliente.setNome("garibalda");
    public ContaCliente buscar(String login){
        return (ContaCliente) bancoCliente.buscar(login);
    }
    
}