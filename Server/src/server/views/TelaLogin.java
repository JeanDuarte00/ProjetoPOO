/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
/**
 *
 * @author Junior
 */
public class TelaLogin {
	private static TelaLogin instance=null;
    private Scanner entrada;
    private int escolha = 0;
    
    private TelaLogin(){ 
    }
    
    public static TelaLogin getInstance(){
        if(instance==null){
            instance= new TelaLogin();
        }
        return instance;
    }
    
    public void exibirMenu() {
        System.out.println("1) LOGIN CLIENTE");
        System.out.println("2) LOGIN LOJA");
        System.out.println("3) SAIR");
        System.out.println("DIGITE A OPÇÃO: ");
        
        lerEntrada();
        switchMenu();
    }

    public void lerEntrada() {
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        System.gc();
    }

    public void switchMenu() {
        switch (this.escolha) {
            case 1:
                TelaLoginCliente tela = TelaLoginCliente.getInstance();
                tela.login();
                break;
            case 2:
                TelaLoginLoja telaLoja1 = TelaLoginLoja.getInstance();
                telaLoja1.login();
                break;
            case 3:
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
       
}
