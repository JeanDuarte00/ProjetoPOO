/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.ArrayList;
import java.util.Scanner;

import estados.*;
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
        int item =1;
        ControllerPedido contPedidos = new ControllerPedido();
        
        this.pedidos = new ArrayList<Pedido>();
        this.pedidos = contPedidos.novosPedidos(id);
        
        if(this.pedidos != null){
            for(Pedido p: this.pedidos){
                System.out.println("--------------------------------");
                System.out.println("ID: " + p.getId());           
                for(Item i: p.getItens()){
                     System.out.println("Item: "+item +"      Produto: "+i.getProduto().getNome()+"        "+ "   Desc: "+i.getProduto().getDescricao()+ " Qtd: "+i.getQuantidade()+"        R$"+i.getProduto().getPreco());
                    item++;
                }
                System.out.println("Voucher: " + p.getVoucherO());
                System.out.println("Preço Total: "+p.getPreco());
                item = 1;
            }
        }else{
            System.out.println("Não há novos pedidos");
        }
        
    }
    
    public void exibirTodosPedidos(){
        ControllerPedido contPedidos = new ControllerPedido();
        this.pedidos = new ArrayList<Pedido>();
        this.pedidos = contPedidos.getTodosPedidos();
        
        if(this.pedidos != null){
            for(Pedido p: this.pedidos){
                System.out.println("--------------------------------");
                System.out.println("ID: " + p.getId());
                for(Item i: p.getItens()){
                    System.out.println(i.getProduto().getNome());
                }
                System.out.println("Voucher: " + p.getVoucherO());
                System.out.println("Preço Total: "+p.getPreco());
            }
        }else{
            System.out.println("Não há pedidos");
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
                this.pedido = contPedidos.buscarPedido(idPedido);
                this.pedido.setState( new StateVisualizado() );
                break;
            case 4:
                System.out.println("Digite o id do pedido: ");
                this.idPedido = this.entrada.nextLine();
                this.pedido = contPedidos.buscarPedido(idPedido);
                this.pedido.setState( new StatePronto() );;
                break;
            case 5:
                System.out.println("Digite o id do pedido: ");
                this.idPedido = this.entrada.nextLine();
                this.pedido = contPedidos.buscarPedido(idPedido);
                this.pedido.setState( new StateEntregue() );
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
