
package Clientes;

import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;

public class ControleDeCliente {
     private List<Cliente> listaClientes;

    public ControleDeCliente() {
        this.listaClientes = new ArrayList<>();
    }
    
    public void criaCliente(){
        //public Cliente(String nome, int idade, String cpf, String telefone)
        String nome = Mensagens.recebeNomeCliente();
        int idade = Mensagens.recebeIdadeCliente();
        String cpf = Mensagens.recebeCPFCliente();
        String telefone = Mensagens.recebeTelefoneCliente();
        Cliente cliente = new Cliente(nome, idade, cpf, telefone);
        listaClientes.add(cliente);
    }
}
