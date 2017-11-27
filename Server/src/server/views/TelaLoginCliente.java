/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.controllers.ControllerLoginCliente;
import server.model.ContaCliente;

public class TelaLoginCliente {
	private static TelaLoginCliente instance=null;
    
    private TelaLoginCliente(){
    }
    
    public static TelaLoginCliente getInstance(){
        if(instance==null){
            instance= new TelaLoginCliente();
        }
        
        return instance;
    }
    
     public void login(){
    	Scanner tec = new Scanner(System.in);
    	
    	ContaCliente c;
        
        String senha;
        String login;
        
        
        System.out.println("Digite o login: ");
        login = tec.nextLine();
        System.out.println("Digite a senha: ");
        senha = tec.nextLine();
        
        ControllerLoginCliente controller1 = new ControllerLoginCliente();
        
        c = controller1.logar(login, senha);
        if(c == null){
            System.out.println("Conta não existe");
            tec.close();
        }else{
            System.out.println("Bem vindo !!!");
            //c = controller1.buscarDados(login);
            TelaMenuCliente tela = new TelaMenuCliente(c);
            tela.exibirMenu();
        }
    }
     
     
     
}
