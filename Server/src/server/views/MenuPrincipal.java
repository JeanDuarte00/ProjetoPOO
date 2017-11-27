package server.views;

import java.util.Scanner;

public class MenuPrincipal implements InterfaceViews {

    private Scanner entrada;
    private int escolha = 0;
    private boolean loop = true;

    public boolean isLoop() {
        return this.loop;
    }

    private void sair() {
        this.loop = false;
    }

    public int getOpcao() {
        return this.escolha;
    }

    @Override
    public void exibirMenu() {
        System.out.println("1) LOGIN");
        System.out.println("2) CADASTRO");
        System.out.println("3) SAIR");
        System.out.println("DIGITE A OPÇÃO: ");

        lerEntrada();
        switchMenu();
    }

    @Override
    public void lerEntrada() {
        try {
            this.entrada = new Scanner(System.in);
            this.escolha = entrada.nextInt();
            entrada.nextLine();
        } catch (Exception e) {
            System.out.println("Digite dados validos");
        }
    }

    @Override
    public void switchMenu() {
        switch (this.escolha) {
            case 1:
                TelaLogin telaUsuario1 = TelaLogin.getInstance();
                telaUsuario1.exibirMenu();
                break;
            case 2:
                TelaCadastro telaLoja1 = TelaCadastro.getInstance();
                telaLoja1.exibirMenu();
               
                break;
            case 3:
                sair();
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }

}
