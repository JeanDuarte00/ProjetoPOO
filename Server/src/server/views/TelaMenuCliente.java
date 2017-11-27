package server.views;

import java.util.Scanner;
import server.controllers.ControllerCliente;
import server.model.ContaCliente;

public class TelaMenuCliente {

    private ControllerCliente controllerC;
    private int idPedido;
    private Scanner entrada;
    private int escolha;
    private ContaCliente c;
    private boolean loop = true;

    TelaMenuCliente(ContaCliente c) {
        this.setControllerC(new ControllerCliente());
        this.c = c;
        this.escolha = 0;
    }
    
	public ControllerCliente getControllerC() {
		return controllerC;
	}

	public void setControllerC(ControllerCliente controllerC) {
		this.controllerC = controllerC;
	}

    @SuppressWarnings("unused")
	private int getId() {
        return this.idPedido;
    }

    public boolean isLoop() {
        return this.loop;
    }

    private void sair() {
        this.loop = false;
    }

    @SuppressWarnings("unused")
	private void setId(int id) {
        this.idPedido = id;
    }

    public void exibirMenu() {
        while (isLoop()) {
            System.out.println("1) Ver Lojas");
            System.out.println("2) Checar seus pedidos");
            System.out.println("3) Ver Seu Perfil");
            System.out.println("4)Editar Perfil");
            System.out.println("5) Sair");
            System.out.print("Digite uma opção:");
            lerEntrada();
            switchMenu();

        }
    }

    private void lerEntrada() {
        this.entrada = new Scanner(System.in);
        this.escolha = entrada.nextInt();
        System.gc();
    }

    public void switchMenu() {
        switch (this.escolha) {
            case 1:
                TelaVisualizarLojasCliente tvl = new TelaVisualizarLojasCliente(c); //criar uma variavel apenas para chamar as telas, pode ser outro nome
                tvl.exibirMenu();
                break;
            case 2:
                //checarPedido
                TelaChecarPedidoCliente verPedido = new TelaChecarPedidoCliente();
                verPedido.mostrarPedido(c);
                break;
            case 3:
                TelaPerfil tpl = new TelaPerfil(this.c);
                tpl.exibirPerfilCliente();
                break;

            case 4:
                TelaPerfil telaPerfil = new TelaPerfil(this.c);
                telaPerfil.exibirPerfilCliente();
                telaPerfil.alterarPerfilLoja();
            case 5:
                sair();
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }
    ////////////////////////MODIFICADO
    /* private void editarPerfil(){
        String nome;
        String senha;
        String telefone;
        Validador valida = new Validador();
        Scanner tec = new Scanner(System.in);
        System.out.println("nome: "+ c.getNome()+"Senha: "+ c.getSenha() + "telefone: " + c.getTelefone());
        System.out.println("Digite o nome:");
        nome = tec.nextLine();
        if(!valida.nome(nome)){
            System.out.println("Nome invalido!");
            return;
        }System.out.println("Digite o senha:");
        senha = tec.nextLine();       
        if(!valida.nome(nome)){
            System.out.println("Nome invalido!");
            return;
        }     
        System.out.println("Digite o telefone");
        telefone = tec.nextLine();       
        if(!valida.telefone(telefone)){
            System.out.print("Telefone invalido!");
            return;
        } 
        c.setSenha(senha);
        c.cliente.setNome(nome);
        c.cliente.setTelefone(telefone);      
    }
     */


}
