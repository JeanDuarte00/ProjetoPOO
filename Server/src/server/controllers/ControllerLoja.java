package server.controllers;

import java.util.ArrayList;


import persistencia.ContaLojaArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PersistenciaImplementado;
import server.model.ContaLoja;

public class ControllerLoja {

	private InterfacePersistencia bancoLoja = new PersistenciaImplementado( new ContaLojaArquivoDAO() );	


    public ContaLoja buscarDados(String id) {
        for (Object conta : this.bancoLoja.getTodos()) {
            if (id.equals(((ContaLoja) conta).getId())) {
                return (ContaLoja)conta;
            }
        }
        return null;
    }

    public ArrayList<ContaLoja> todasLojas() {
    	ArrayList<ContaLoja> lista = new ArrayList<>();
        
    	for(Object loja : bancoLoja.getTodos()) {
    		lista.add((ContaLoja)loja);
    	}
    	return lista;
    	
    }

    public ArrayList<String> verLojas() {
        ArrayList<String> lista = new ArrayList<>();

        for (Object loja : bancoLoja.getTodos()) {
            lista.add("Id: " + ((ContaLoja) loja).getId() + "   " + ((ContaLoja) loja).getNome() + "  Contato: " + ((ContaLoja) loja).getTelefone());
        }
        return lista;
    }

    public String tamanhoLoja() {
        String id = Integer.toString(bancoLoja.getTodos().size() + 1);
        if (id.length() <= 3) {
            if (id.length() == 2) {
                id = "0" + id;
            } else if (id.length() == 1) {
                id = "00" + id;
            }
            return id;
        }
        else{
            return null;
        }
    }
}
