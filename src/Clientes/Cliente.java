
package Clientes;

import Aeronaves.Aviao;
import Aeronaves.Balao;
import Aeronaves.Controle;
import Aeronaves.Helicoptero;
import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final String telefone;
    //Listas das possiveis aeronaves que eo cliente irá alugar
    private final List<Aviao> listaAviao;
    private final List<Balao> listaBalao;
    private final List<Helicoptero> listaHelicoptero;

    

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.listaHelicoptero = new ArrayList<>();
        this.listaBalao = new ArrayList<>();
        this.listaAviao = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    
    public List<Aviao> getListaAviao() {
        return listaAviao;
    }
    public List<Balao> getListaBalao() {
        return listaBalao;
    }
    public List<Helicoptero> getListaHelicoptero() {
        return listaHelicoptero;
    }
    
    public void alugaAviao(Aviao aviao){listaAviao.add(aviao);}
    public void alugaBalao(Balao balao){listaBalao.add(balao);}
    public void alugaHelicoptero(Helicoptero h){listaHelicoptero.add(h);}
    
    @Override
    public String toString(){
        return "Nome: "+this.nome+", cpf: "+this.cpf+" telefone: "+this.telefone;
    }
    /*
    Os metodos abaixo recebem como parametro o objeto de controle de todas as aeronaves.
    devolve a aeronave alugada para o array de aeronaves disponveis
    e tira do array de aeronaves alugadas, e do array de aeronaves alugadas
    pelo atual cliente.
    */
    public void devolveAviao( Controle controle){
        for(int i=0;i<this.listaAviao.size();i++){
            System.out.println("opcao "+i+" - "+this.listaAviao.get(i));
        }
        int indice = Mensagens.recebeIndice();
        controle.getListaAviao().add(this.listaAviao.get(indice));
        controle.getAvioesAlugados().remove(this.listaAviao.get(indice));
        listaAviao.remove(this.listaAviao.get(indice));
        System.out.println("Aviao devolvido com sucesso!");
    }
    public void devolveBalao(Controle controle){
        for(int i=0;i<this.listaBalao.size();i++){
            System.out.println("opcao "+i+" - "+this.listaBalao.get(i));
        }
        int indice = Mensagens.recebeIndice();
        controle.getListaBalao().add(this.listaBalao.get(indice));
        controle.getBaloesAlugados().remove(this.listaBalao.get(indice));
        listaBalao.remove(this.listaBalao.get(indice));
        System.out.println("Balao devolvido com sucesso !");
    }
    public void devolveHelicoptero(Controle controle){
        for(int i=0;i<this.listaHelicoptero.size();i++){
            System.out.println("opcao "+i+" - "+this.listaHelicoptero.get(i));
        }
        int indice = Mensagens.recebeIndice();
        controle.getListaHelicoptero().add(this.listaHelicoptero.get(indice));
        controle.getHelicopterosAlugados().remove(this.listaHelicoptero.get(indice));
        listaHelicoptero.remove(this.listaHelicoptero.get(indice));
        System.out.println("Helicoptero devolvido com sucesso !");
    }
    
}
