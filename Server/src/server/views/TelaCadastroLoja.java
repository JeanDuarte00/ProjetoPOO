/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.controllers.ControllerCadastro;
import server.controllers.ControllerLoja;
import server.model.ContaLoja;
import server.model.Validador;

/**
 *
 * @author tarcisio
 */
public class TelaCadastroLoja {
    
    ControllerCadastro ctrCadastro = new ControllerCadastro();
    ControllerLoja ctrLoja = new ControllerLoja();
    Validador valida = new Validador();
    
    public void cadastroLoja() {
    
    	ContaLoja l = lerDados();
        if (l != null) {
            ControllerCadastro ctrCadastro = new ControllerCadastro();  
            l.setId(ctrLoja.tamanhoLoja());
            ctrCadastro.add(l);
            //ctrCadastro.add(l.get);
            System.out.println("Cadastrado com sucesso!");       
        } 
        else{
            System.out.println("Não foi possivel realizar o cadastro!");
        }
    }

    private ContaLoja lerDados() {
    	Scanner tec = new Scanner(System.in);
    	boolean retornoController = false;
    	
        String nome;
        String senha;
        String login;
        String telefone;
        String nomeDono;

        
        System.out.println("Digite o login: ");
        login = tec.nextLine();
        retornoController = ctrCadastro.buscarLoginLoja(login);
        if (retornoController == true) {
            System.out.println("Cliente já cadastrado");
            tec.close();            
            return null;
        }
        System.out.println("Digite Senha: ");
        senha = tec.nextLine();
        if(!valida.senha(senha)){
            System.out.println("Senha invalida,");
            tec.close();
            return null;
        }
        System.out.println("Digite o nome:");
        nome = tec.nextLine();
        if(!valida.nome(nome)){
            System.out.println("Nome invalido!");
            tec.close();
            return null;
        }
        System.out.println("Digite o telefone");
        telefone = tec.nextLine();
         if(!valida.telefone(telefone)){
            System.out.print("Telefone invalido!");
            tec.close();
            return null;
        }
        System.out.println("Digite o nome do Dono");
        nomeDono = tec.nextLine();
        if(!valida.nome(nomeDono)){
            System.out.println("Nome invalido!");
            tec.close();
            return null;
        }
        ContaLoja novoLoja = new ContaLoja(this.ctrLoja.tamanhoLoja(), login, senha, nome, telefone, nomeDono);
        tec.close();
        return novoLoja;
    }
}
