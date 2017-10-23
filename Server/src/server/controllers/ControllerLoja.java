package server.controllers;

import java.util.ArrayList;
import server.DAO.LojaDAO;
import server.model.ContaLoja;

public class ControllerLoja {

    private LojaDAO dao = new LojaDAO();

    public ContaLoja buscarDados(String id) {
        for (ContaLoja conta : this.dao.getTodos()) {
            if (id.equals(conta.getId())) {
                return conta;
            }
        }
        return null;
    }

    public ArrayList<ContaLoja> todasLojas() {
        return dao.getTodos();
    }

    public ArrayList<String> verLojas() {
        ArrayList<String> lista = new ArrayList<>();

        for (ContaLoja loja : dao.getTodos()) {
            lista.add("Id: " + loja.getId() + "   " + loja.getNome() + "  Contato: " + loja.getTelefone());
        }
        return lista;
    }

    public String tamanhoLoja() {
        String id = Integer.toString(dao.getTodos().size() + 1);
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
