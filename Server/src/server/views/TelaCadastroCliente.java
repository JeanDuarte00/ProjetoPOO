/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.controllers.ControllerCadastro;
import server.controllers.ControllerCliente;
import server.controllers.ControllerLoginCliente;
import server.model.Cliente;
import server.model.ContaCliente;
import server.model.Validador;

/**
 *
 * @author Junior/Felix
 */
public class TelaCadastroCliente {
    ControllerCadastro ctrCadastro = new ControllerCadastro();
    Validador valida = new Validador();
    
    public void cadastroCliente() {
        ContaCliente c = lerDados();
         if(c != null){          
            ControllerCadastro ctrCadastro = new ControllerCadastro();
            ctrCadastro.add(c);
            System.out.println("Cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possivel realizar o cadastro!");
        }
    }
    private ContaCliente lerDados() {
        boolean retornoController = false;
        String nome;
        String senha;
        String login;
        String telefone;
        
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o login: ");
        login = tec.nextLine();      
        retornoController = ctrCadastro.buscarLoginCliente(login);
        if (retornoController == true) {
            System.out.println("Cliente já cadastrado");
            return null;
        }
        
        System.out.println("Digite Senha: ");
        senha = tec.nextLine();
        if(!valida.senha(senha)){
            System.out.println("Senha invalida,");
            return null;
        }
        
        System.out.println("Digite o nome:");
        nome = tec.nextLine();       
        if(!valida.nome(nome)){
            System.out.println("Nome invalido!");
            return null;
        }
        
        System.out.println("Digite o telefone");
        telefone = tec.nextLine();       
        if(!valida.telefone(telefone)){
            System.out.print("Telefone invalido!");
            return null;
        }  
        
        ContaCliente novoCliente = new ContaCliente(nome, telefone, login, senha);
        return novoCliente;
    }

}

    /*        USAR VALIDAÇÃO DE JEAN
    private boolean validaString(String s) { // VALIDAÇÃO PODE SER MELHOR
        if (s.equals("")) {
            return false;
        }
        return true;
    }

    private boolean validaCliente(ContaCliente c) {

        if (validaString(c.getLogin()) == false) {
            System.out.println("login inválido");
            return false;
        } else if (validaString(c.getSenha()) == false) {
            System.out.println("Senha inválida");
            return false;
        } else if (validaString(c.getNome()) == false) {
            System.out.println("Nome inválido");
            return false;
        } else if (validaString(c.getTelefone()) == false) {
            System.out.println("Telefone inválido");
            return false;
        }
        return true;

    }
}
*/