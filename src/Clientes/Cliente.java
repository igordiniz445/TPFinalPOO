
package Clientes;

import Aeronaves.Aviao;
import Aeronaves.Balao;
import Aeronaves.Helicoptero;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nome;
    private final int idade;
    private final String cpf;
    private final String telefone;
    //Listas das possiveis aeronaves que eo cliente irá alugar
    private final List<Aviao> listaAviao;
    private final List<Balao> listaBalao;
    private final List<Helicoptero> listaHelicoptero;

    public Cliente(String nome, int idade, String cpf, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.listaHelicoptero = new ArrayList<>();
        this.listaBalao = new ArrayList<>();
        this.listaAviao = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void alugaAviao(){}
    public void alugaBalao(){}
    public void AlugaHelicoptero(){}
    
}
