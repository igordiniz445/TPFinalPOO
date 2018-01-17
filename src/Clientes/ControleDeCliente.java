
package Clientes;

import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;

public class ControleDeCliente {
     private final List<Cliente> listaClientes;

    public ControleDeCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    public void criaCliente(){
        //public Cliente(String nome, int idade, String cpf, String telefone)
        String nome = Mensagens.recebeNomeCliente();
        String cpf = Mensagens.recebeCPFCliente();
        String telefone = Mensagens.recebeTelefoneCliente();
        Cliente cliente = new Cliente(nome, cpf, telefone);
        listaClientes.add(cliente);
    }
    /*
    Metodo para selecionar um cliente exibindo todos os clientes cadastrados
    o método retorna o cliente selecionado
    */
    public Cliente selecionaCliente(){
        System.out.println("Qual cliente está alugando esta aeronave ?");
        for(int i=0;i<listaClientes.size();i++){
            System.out.println(i+"  - "+listaClientes.get(i));
        }
        if(listaClientes.isEmpty()){
            System.out.println("Não há clientes cadastrados, cadastre um cliente antes");
            return null;
        }
        int indice = Mensagens.recebeIndice();
        while(indice>listaClientes.size()){
            System.out.println("Indice não confere, selecione novamente.");
            indice = Mensagens.recebeIndice();
        }
        return listaClientes.get(indice);
    }
}
