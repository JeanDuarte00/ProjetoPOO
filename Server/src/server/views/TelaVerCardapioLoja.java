package server.views;

import java.util.Scanner;
import server.controllers.ControllerCardapio;
import server.model.Cardapio;
import server.model.Produto;

/**
 *
 * @author Junior
 */
public class TelaVerCardapioLoja {

    private Cardapio cardapio;
    private Scanner entrada;
    private String idProduto;
    private int escolha;

    public TelaVerCardapioLoja(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void listarCardapio() {
        for (Produto p : this.cardapio.getProdutos()) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Preço: R$ " + p.getPreco());

        }
    }

    private void lerEntrada() {
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        entrada.nextLine();
        System.gc();
    }

    private void lerEntradaNovoProduto(Produto p) {
        this.entrada = new Scanner(System.in);
        String nome;
        String descricao;
        float preco;
        System.out.println("Digite o novo nome: ");
        nome = this.entrada.nextLine();
        System.out.println("Digite a nova descrição: ");
        descricao = this.entrada.nextLine();
        System.out.println("Digite o novo preço: ");
        preco = this.entrada.nextFloat();
        p.setNome(nome);
        p.setDescricao(descricao);
        p.setPreco(preco);
        ControllerCardapio ctr = new ControllerCardapio(idProduto);
        ctr.atualizarCardapio(this.cardapio.getId(), this.cardapio);

    }

    public void alterarProduto() {
        System.out.println("Digite o id do produto à ser alterado: ");
        this.entrada = new Scanner(System.in);
        this.idProduto = this.entrada.nextLine();
        for (Produto p : this.cardapio.getProdutos()) {
            if (p.getId().equals(idProduto)) {
                lerEntradaNovoProduto(p);
                System.out.println("Produto alterado com sucesso.");
                break;
            }
        }
    }

    public void removerProduto() {
        System.out.println("Digite o id do produto à ser removido: ");
        this.entrada = new Scanner(System.in);
        this.idProduto = this.entrada.nextLine();
        this.cardapio.removeProduto(idProduto);
        ControllerCardapio ctr = new ControllerCardapio(this.idProduto);
        ctr.atualizarCardapio(this.cardapio.getId(), this.cardapio);
        System.out.println("Produto removido");
    }

    public void telaMenuOp() {
        System.out.println("1)Adicionar Produto");
        System.out.println("2)Alterar Produto");
        System.out.println("3)Remover Produto");
        System.out.println("4)Voltar");
        lerEntrada();
        switchMenu();
    }

    public void adicionarProduto() {

        double preco;
        String nome;
        String descricao;
        String id;
        System.out.println("Digite o nome:");
        nome = entrada.nextLine();
        System.out.println("Digite a descrição:");
        descricao = entrada.nextLine();
        System.out.println("Digite o id:");
        id = entrada.nextLine();
        System.out.println("Digite o preco:");
        preco = entrada.nextDouble();
        Produto produto = new Produto(nome, descricao, id, preco);
        cardapio.addProduto(produto);
        ControllerCardapio ctr = new ControllerCardapio(id);
        ctr.atualizarCardapio(this.cardapio.getId(), this.cardapio);
    }

    public void switchMenu() {
        switch (this.escolha) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                removerProduto();
                break;
            case 4:
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}/////////////////

