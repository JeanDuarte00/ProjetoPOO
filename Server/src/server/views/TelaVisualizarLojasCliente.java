/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;


import java.util.Scanner;
import server.controllers.ControllerCardapio;
import server.controllers.ControllerLoja;
import server.model.Cardapio;
import server.model.ContaCliente;


/**
 *
 * @author Felix
 */
public class TelaVisualizarLojasCliente {

    private int idPedido;
    private Scanner entrada;
    private int escolha;
    private String idLoja;
    private boolean op;
    private ContaCliente cliente;
    
    public TelaVisualizarLojasCliente(ContaCliente c){
        this.cliente = c;
    }

    public void exibirMenu() {
        listarLojas();
        System.out.println("1) Selecionar Loja e Ver Cardapio");
        System.out.println("2) Voltar");
        System.out.print("Digite uma opção:");
        lerEntrada();
        switchMenu();
    }

    private void listarLojas() {
        ControllerLoja ctrLoja = new ControllerLoja();
        for (String linha : ctrLoja.verLojas()) {
            System.out.println(linha);
        }
    }

    private void lerEntrada() {
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        entrada.nextLine();
        System.gc();
    }

    public void switchMenu() {
        switch (this.escolha) {
            case 1:
                System.out.println("Digite o ID da loja:");
                String id = entrada.nextLine();
                
                ControllerCardapio controlCardapio = new ControllerCardapio(id);
                Cardapio cardapio = controlCardapio.getCardapio(id);
                
                if (cardapio != null) {
                	
                	System.out.println(""+cardapio.getId());
                    
                	TelaVerCardapioCliente telaVCC = new TelaVerCardapioCliente(cardapio,cliente);
                    telaVCC.listarCardapio();
                
                }else {
                    System.out.println("Cardapio de Loja não encontrado!");
                }
                break;
                
            case 2:
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

	public boolean isOp() {
		return op;
	}

	public void setOp(boolean op) {
		this.op = op;
	}

	public String getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(String idLoja) {
		this.idLoja = idLoja;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
}

