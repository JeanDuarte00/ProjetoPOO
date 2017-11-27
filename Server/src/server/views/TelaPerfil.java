package server.views;

import java.util.Scanner;
import server.model.ContaCliente;
import server.model.ContaLoja;

/**
 *
 * @author Junior
 */
public class TelaPerfil {

    private ContaLoja contaLoja;
    private ContaCliente contaCliente;
    private Scanner entrada;
    private int escolha;

    
    private void lerEntrada() {
        this.entrada = new Scanner(System.in);
        escolha = entrada.nextInt();
        System.gc();
    }
    
    
    
    public TelaPerfil(ContaLoja contaLoja) {
        this.contaLoja = contaLoja;
    }

    public TelaPerfil(ContaCliente contaCliente) {
        this.contaCliente = contaCliente;
    }

    
    
    public void exibirPerfilLoja() {
        System.out.println("Login: " + this.contaLoja.getLogin());
        System.out.println("Nome da loja: " + this.contaLoja.getNome());
        System.out.println("Id da loja: " + this.contaLoja.getId());
        System.out.println("Nome do dono: " + this.contaLoja.getNomeDono());
        System.out.println("Telefone: " + this.contaLoja.getTelefone());
        
    }

    public void exibirPerfilCliente() {
        System.out.println("Login: " + this.contaCliente.getLogin());
        System.out.println("Nome: " + this.contaCliente.getNome());
        System.out.println("Telefone: " + this.contaCliente.getTelefone());
        
    }

  

    private void switchMenuLoja() {
        this.entrada = new Scanner(System.in);
        String nome;
        String nomeDoDono;
        String senha;
        String telefone;
        switch (this.escolha) {
            case 1:
                System.out.println("Digite o nome: ");
                nome = entrada.nextLine();
                this.contaLoja.setNome(nome);
                break;
            case 2:
                System.out.println("Digite a senha: ");
                senha = entrada.nextLine();
                this.contaLoja.setSenha(senha);
                break;
            case 3:
                System.out.println("Digite o nome do dono: ");
                nomeDoDono = entrada.nextLine();
                this.contaLoja.setNomeDono(nomeDoDono);
                break;
            case 4:
                System.out.println("Digite o telefone: ");
                telefone = entrada.nextLine();
                this.contaLoja.setTelefone(telefone);
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void switchMenuCliente() {
        this.entrada = new Scanner(System.in);
        String nome;
        String senha;
        String telefone;
        switch (this.escolha) {
            case 1:
                System.out.println("Digite o nome: ");
                nome = entrada.nextLine();
                this.contaCliente.setNome(nome);
                break;
            case 2:
                System.out.println("Digite a senha: ");
                senha = entrada.nextLine();
                this.contaCliente.setSenha(senha);
                break;
            case 3:
                System.out.println("Digite o telefone: ");
                telefone = entrada.nextLine();
                this.contaCliente.setTelefone(telefone);
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    
    
    public void alterarPerfilLoja() {
        System.out.println("1 - Alterar nome da loja");
        System.out.println("2 - Alterar senha");
        System.out.println("3 - Alterar nome do dono");
        System.out.println("4 - Alterar telefone");
        System.out.println("5 - Voltar");
        lerEntrada();
        switchMenuLoja();

    }
    
    public void alterarPerfilCliente() {
        System.out.println("1 - Alterar nome");
        System.out.println("2 - Alterar senha");
        System.out.println("3 - Alterar telefone");
        System.out.println("4 - Voltar");
        lerEntrada();
        switchMenuCliente();

    }
    
    
    
    
}
