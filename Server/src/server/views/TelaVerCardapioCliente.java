/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.Scanner;
import server.model.Cardapio;
import server.model.ContaCliente;
import server.model.Produto;

/**
 *
 * @author Felix
 * 
 */
public class TelaVerCardapioCliente {
    private Cardapio cardapio;
    private Scanner entrada;
    private int escolha;
    private ContaCliente cliente;
   // private int escolha;
    public TelaVerCardapioCliente(Cardapio c,ContaCliente cliente){
        this.cardapio = c;
        this.cliente = cliente;
    }
    
    public void menuCardapio(){
        System.out.println("1)Selecionar Produtos");
        System.out.println("2)Voltar");
        
    }
    public void listarCardapio(){
        for(Produto p : this.cardapio.getProdutos()){
            System.out.println("--------------------------------");
            System.out.println("ID: "+ p.getId());
            System.out.println("Nome: "+ p.getNome());
            System.out.println("Descrição: "+ p.getDescricao());
            System.out.println("Preço: R$ "+ p.getPreco());
                   
        }
        menuCardapio();
        lerEntrada();
        switchMenu();
    }
    private void lerEntrada(){
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        entrada.nextLine();
        System.gc();
    }
    private void switchMenu(){
        switch (this.escolha) {
            case 1:
                TelaPedidoCliente telaRPC = new TelaPedidoCliente(this.cardapio,this.cliente); //ALTERADO
                telaRPC.menuPedidoCliente();      //ALTERADO       
                break;
            case 2:
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }  
}
