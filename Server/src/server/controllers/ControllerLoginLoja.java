/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controllers;
import persistencia.ContaLojaArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PersistenciaImplementado;
import server.model.ContaLoja;
/**
 *
 * @author tarcisio
 */
public class ControllerLoginLoja {
	private InterfacePersistencia bancoCliente = new PersistenciaImplementado( new ContaLojaArquivoDAO() );
    
    // apenas loga e retorna para view o objeto da loja;
    // a view com o objeto retornado, pode visualizar a loja
    public ContaLoja logar(String login, String senha){
        ContaLoja l;
        l = (ContaLoja) bancoCliente.buscar(login);
        if(l != null && l.getSenha().equals(senha)){
            return l;
        }
        return null;
    }
}
