/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.ArrayList;
import java.util.Scanner;
import server.controllers.ControllerPedido;
import server.model.Item;
import server.model.Pedido;

/**
 *
 * @author users
 */
public class TelaPedidosLoja {
    private String id;
    private Scanner entrada;
    private int escolha;
    private String idPedido;
    private ArrayList <Pedido> pedidos;
    private Pedido pedido;
    public TelaPedidosLoja(String id){
        this.id = id;
    }
    public void exibirNovosPedidos(){
        ControllerPedido contPedidos = new ControllerPedido();
        this.pedidos = new ArrayList();
        pedidos = contPedidos.novosPedidos(id);
        for(Pedido p: this.pedidos){
            System.out.println("--------------------------------");
            System.out.println("ID: " + p.getId());
            for(Item i: p.getItens()){
                System.out.println(i.getProduto().getNome());
            }
            System.out.println("Voucher: " + p.getVoucherO());
            System.out.println("Preço Total: "+p.getPreco());
        }
    }
    
    public void exibirTodosPedidos(){
        ControllerPedido contPedidos = new ControllerPedido();
        this.pedidos = new ArrayList();
        pedidos = contPedidos.getTodosPedidos(id);
        for(Pedido p: this.pedidos){
            System.out.println("--------------------------------");
            System.out.println("ID: " + p.getId());
            for(Item i: p.getItens()){
                System.out.println(i.getProduto().getNome());
            }
            System.out.println("Voucher: " + p.getVoucherO());
            System.out.println("Preço Total: "+p.getPreco());
        }
    }
    public void telaMenuOp(){
        System.out.println("1)Novos pedidos");
        System.out.println("2)Todos os pedidos");
        System.out.println("3)Marcar um pedido como visualizado");
        System.out.println("4)Marcar um pedido como pronto");
        System.out.println("5)Marcar um pedido como entregue");
        System.out.println("6)Voltar");
        lerEntrada();
        switchMenu();
    }
    public void switchMenu() {
        this.entrada = new Scanner(System.in);
        ControllerPedido contPedidos = new ControllerPedido();
        switch (this.escolha) {
            case 1:
                exibirNovosPedidos();
                break;
            case 2:
                exibirTodosPedidos();
                break;
            case 3:
                System.out.println("Digite o id do pedido: ");
                this.idPedido = this.entrada.nextLine();
                this.pedido = contPedidos.buscarPedido(id);
                this.pedido.setStatusVisualizado();
                break;
            case 4:
                System.out.println("Digite o id do pedido: ");
                this.idPedido = this.entrada.nextLine();
                this.pedido = contPedidos.buscarPedido(id);
                this.pedido.setStatusPronto();
                break;
            case 5:
                System.out.println("Digite o id do pedido: ");
                this.idPedido = this.entrada.nextLine();
                this.pedido = contPedidos.buscarPedido(id);
                this.pedido.setStatusEntregue();
                break;
            case 6:
                return;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
     private void lerEntrada(){
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        System.gc();
    }
}
