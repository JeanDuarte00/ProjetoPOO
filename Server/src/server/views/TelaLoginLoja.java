/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.controllers.ControllerLoginLoja;

import server.model.ContaLoja;


/**
 *
 * @author
 */
public class TelaLoginLoja {
	private static TelaLoginLoja instance=null;
    
    private TelaLoginLoja(){
    }
    
    public static TelaLoginLoja getInstance(){
        if(instance==null){
            instance= new TelaLoginLoja();
        }
        
        return instance;
    }
    
	
    public void login(){
    
    	ContaLoja loja;
        Scanner tec = new Scanner(System.in);
        String senha;
        String login;
        System.out.println("Digite o login: ");
        login = tec.nextLine();
        System.out.println("Digite a senha: ");
        senha = tec.nextLine();
        ControllerLoginLoja controller1 = new ControllerLoginLoja();
       loja = controller1.logar(login, senha);
        if(loja == null){
            System.out.println("Conta não existe");
            tec.close();
        }else{
            System.out.println("Bem vindo !!!");
            //c = controller1.buscarDados(login);
            TelaMenuLoja tela = new TelaMenuLoja(loja);
            tela.exibirMenu();
        }
    }
}
