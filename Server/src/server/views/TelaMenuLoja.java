/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.views;
import java.util.Scanner;
import server.controllers.ControllerPedido;
import server.model.ContaLoja;

/**
 *
 * @author tarcisio
 */
public class TelaMenuLoja {
    private final ContaLoja loja;
    private int escolha;
    private Scanner entrada;
    private boolean loop = true;
    
    
    public TelaMenuLoja(ContaLoja loja){
        this.loja = loja;
    }
    
    public void exibirMenu(){
        while(isLoop()){
            System.out.println("1) Ver Cardapio");
            System.out.println("2) Ver perfil");
            System.out.println("3) Editar perfil");
            System.out.println("4) pedidos");
            System.out.println("5) Sair");
            System.out.println("Digite uma opção:");
            lerEntrada();
            switchMenu();
            
        }
    }
    
    public boolean isLoop(){
        return this.loop;
    }
    
    private void sair(){
        this.loop = false;
    }
    
    public void lerEntrada(){
        this.entrada = new Scanner(System.in);
        escolha = entrada.nextInt();
        System.gc();
    }
   
    public void switchMenu(){
        switch (this.escolha){
                
                case 1:
                    TelaVerCardapioLoja tela = new TelaVerCardapioLoja(this.loja.getCardapio());
                    tela.listarCardapio();
                    tela.telaMenuOp();
                    break;
                    
                case 2:
                    TelaPerfil tpl = new TelaPerfil(this.loja);
                    tpl.exibirPerfilLoja(); 
                    break;
                    
                case 3:
                    TelaPerfil telaPerfil = new TelaPerfil(this.loja);
                    telaPerfil.exibirPerfilLoja(); 
                    telaPerfil.alterarPerfilLoja();
                    break;
                    
                case 4:
                    TelaPedidosLoja tela1 = new TelaPedidosLoja(this.loja.getId());
                    tela1.telaMenuOp();
                    break;            
                
                case 5:
                    sair();
                    break;
                
                default:
                    System.out.println("Opção inválida");
                    break;
            }
    }
    
    public void pedidos(){
        ControllerPedido p = new ControllerPedido();
        p.novosPedidos(loja.getId()); //rodar o array de novos pedidos
        
    }
}
