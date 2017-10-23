/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.controllers.ControllerCliente;
import server.model.Cliente;

/**
 *
 * @author Junior
 */
public class TelaLogin {
    private Scanner entrada;
    private int escolha = 0;
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
                TelaLoginCliente tela = new TelaLoginCliente();
                tela.login();
                break;
            case 2:
                TelaLoginLoja telaLoja1 = new TelaLoginLoja();
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
