
package server.views;

import java.util.Scanner;

public class TelaCadastro implements InterfaceViews{

    private Scanner entrada;
    private int escolha;


    @Override
    public void exibirMenu() {
        System.out.println("1) CADASTRO CLIENTE");
        System.out.println("2) CADASTRO LOJA");
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
                TelaCadastroCliente telaUsuario1 = new TelaCadastroCliente();
                telaUsuario1.cadastroCliente();
                break;
            case 2:
                TelaCadastroLoja telaLoja1 = new TelaCadastroLoja();
                telaLoja1.cadastroLoja();              
                break;
            case 3:
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }

}