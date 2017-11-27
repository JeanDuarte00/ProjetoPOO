/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import server.controllers.ControllerPedido;
import server.controllers.ControllerProduto;
import server.model.Cardapio;
import server.model.ContaCliente;
import server.model.Item;
import server.model.Pedido;
import server.model.Produto;

public class TelaPedidoCliente {

    private Scanner entrada = new Scanner(System.in);
    private ArrayList<Item> itens = new ArrayList<>();
    private ControllerProduto ctrProduto = new ControllerProduto();
    private ControllerPedido ctrPedido = new ControllerPedido();
    private Cardapio cardapio;
    private boolean loop = true;
    private ContaCliente conta;

    private int escolha;

    public TelaPedidoCliente(Cardapio cardapio, ContaCliente c) {
        this.cardapio = cardapio;
        this.conta = c;      
    }

    private boolean isLoop() {
        return loop;
    }

    private void sair() {
        this.loop = false;
    }

    public void menuPedidoCliente() {
        while (isLoop()) {
            System.out.println("1) Adicionar produto");
            System.out.println("2) Retirar produto");
            System.out.println("3) Confirmar Pedido");
            System.out.println("4) Cancelar Pedido");
            lerEntrada();
            switchMenu();
        }
    }

    
    private boolean verificarVoucher(String voucher) {
    	
        for ( Pedido pedido : ctrPedido.getTodosPedidos() ) {
            if ( pedido.getVoucherO().equals(voucher) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    private void criarPedido() {
        boolean loop = true;

        while (loop) {
            String voucher = gerarVoucher();
            boolean voucherExiste = verificarVoucher(voucher);

            if ( !voucherExiste ) {
                Pedido pedido = new Pedido(cardapio.getId(), voucher, itens);
                ctrPedido.addPedido(pedido);
                conta.addPedido(pedido);           
                loop = false;
            }
        }

    }

    private String gerarVoucher() {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * string.length());
            salt.append(string.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    private void retirarItem() {
        System.out.print("ID do item a ser removido: ");
        String idItem = entrada.nextLine();

        Item item = buscarIdItem(idItem);
        if (item != null) {
            itens.remove(item);
        }
    }

    private Item buscarIdItem(String idItem) {

        for (Item item : itens) {
            if (item.getProduto().getId().equals(idItem)) {
                return item;
            }
        }
        return null;
    }

    private void lerEntrada() {
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        entrada.nextLine();
        System.gc();
    }

    private void switchMenu() {
        switch (this.escolha) {
            case 1:
                itens.add(criarItem());
                break;

            case 2:
                retirarItem();
                break;

            case 3:
                criarPedido();
                sair();
                break;

            case 4:
                sair();
                break;

            default:
                System.out.println("Opcao invalida");
                break;

        }

    }

    private Item criarItem() {

        System.out.print("ID do produto: ");
        String id = entrada.nextLine();
        Produto produto = cardapio.getProdutoPorID(id);

        System.out.print("Quantidade: ");
        int qtd = entrada.nextInt();
        entrada.nextLine();

        Item item = new Item(qtd, produto);
        return item;
    }

	public ControllerProduto getCtrProduto() {
		return ctrProduto;
	}

	public void setCtrProduto(ControllerProduto ctrProduto) {
		this.ctrProduto = ctrProduto;
	}

}
