package Aeronaves;

import Clientes.Cliente;
import Clientes.ControleDeCliente;
import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {


    private final List<Aviao> listaAviao;
    private final List<Balao> listaBalao;
    private final List<Helicoptero> listaHelicoptero;
    
    private final List<Aviao> avioesAlugados;
    private final List<Balao> baloesAlugados;
    private final List<Helicoptero> helicopterosAlugados;
    
    public Controle() {
        this.helicopterosAlugados = new ArrayList<>();
        this.baloesAlugados = new ArrayList<>();
        this.avioesAlugados = new ArrayList<>();
        this.listaHelicoptero = new ArrayList<>();
        this.listaBalao = new ArrayList<>();
        this.listaAviao = new ArrayList<>();
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
    public List<Aviao> getAvioesAlugados() {
        return avioesAlugados;
    }
    public List<Balao> getBaloesAlugados() {
        return baloesAlugados;
    }
    public List<Helicoptero> getHelicopterosAlugados() {
        return helicopterosAlugados;
    }
    
    public void cadastrarAviao(Aviao aviao){
        listaAviao.add(aviao);
    }
    public void cadastrarBalao(Balao balao){
        listaBalao.add(balao);
    }
    public void cadastrarHelicoptero(Helicoptero h){
        listaHelicoptero.add(h);
    }
    
    private void alugaAviao(Aviao aviao, Cliente cliente){
        this.listaAviao.remove(aviao);
        this.avioesAlugados.add(aviao);
        cliente.alugaAviao(aviao);
    }
    private void alugaBalao(Balao balao, Cliente cliente){
        this.listaBalao.remove(balao);
        this.baloesAlugados.add(balao);
        cliente.alugaBalao(balao);
    }
    private void alugaHelicoptero(Helicoptero h, Cliente cliente){
        this.listaHelicoptero.remove(h);
        this.helicopterosAlugados.add(h);
        cliente.alugaHelicoptero(h);
    }
    
    public void devolveAviao(Aviao aviao){
        this.avioesAlugados.remove(aviao);
        this.listaAviao.add(aviao);
    }
    public void devolveBalao(Balao balao){
        this.baloesAlugados.remove(balao);
        this.listaBalao.add(balao);
    }
    public void devolveHelicoptero(Helicoptero h){
        this.helicopterosAlugados.remove(h);
        this.listaHelicoptero.add(h);
    }
    
    public void verAeronavesDisponiveis(ControleDeCliente controleCliente){
        Scanner cin = new Scanner(System.in);
        int opcao, opcao2, posicao;
        int dias;
        double valorDoAluguel;
        opcao2 = Mensagens.tipoAeronave("alugar");
        if(opcao2 == 1){
                for(int i =0;i<listaAviao.size();i++){
                System.out.println(i+" - "+listaAviao.get(i));
                }
                if(listaAviao.isEmpty()){
                    System.out.println("\nNão há aviões cadastrados, ou estão todos alugados !\n");
                    return;
                }
            }if(opcao2 == 2){
                for(int i =0;i<listaBalao.size();i++){
                System.out.println(i+" - "+listaBalao.get(i));
                }if(listaBalao.isEmpty()){
                    System.out.println("\nNão há balões cadastrados, ou estão todos alugados! \n");
                    return;
                }
            }if(opcao2 == 3){
                for(int i =0;i<listaHelicoptero.size();i++){
                System.out.println(i+" - "+listaHelicoptero.get(i));
                }
                if(listaHelicoptero.isEmpty()){
                    System.out.println("\nNão há helicopteros cadastrados, ou estão todos alugados! \n");
                    return;
                }
            }
        posicao = Mensagens.selecaoPosicao();
        dias = Mensagens.recebeQtdDias();
        if(opcao2 == 1){
            valorDoAluguel = listaAviao.get(posicao).valorDoAluguel(dias);
        }else if(opcao2 == 2){
            valorDoAluguel = listaBalao.get(posicao).valorDoAluguel(dias);
        }else{
            valorDoAluguel = listaHelicoptero.get(posicao).valorDoAluguel(dias);
        }
        
        opcao = Mensagens.confirmacaoAluguel(dias, valorDoAluguel);
        Cliente cliente = controleCliente.selecionaCliente();
        if(opcao == 1){
            if(opcao2 == 1){
                try {
                alugaAviao(listaAviao.get(posicao),cliente);
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Aviao foi alugado com sucesso!");
            }if(opcao2 == 2){
                try {
                alugaBalao(listaBalao.get(posicao),cliente);
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Balao foi alugado com sucesso!");
            }if(opcao2 == 3){
                try {
                alugaHelicoptero(listaHelicoptero.get(posicao),cliente);
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Helicoptero foi alugado com sucesso!");
            }
        }else{
        }
    }
    
    public void devolverAeronave(ControleDeCliente clientes){
        for(int i=0;i<clientes.getListaClientes().size();i++){
            System.out.println(i+" - "+clientes.getListaClientes().get(i));
        }if(clientes.getListaClientes().isEmpty()){
            System.out.println("Não há clientes Cadastrados, logo não há aeronaves alugadas");
            return;
        }
        
        int indice = Mensagens.recebeIndice();
        int opcao = Mensagens.tipoAeronave("devolver");
        if(opcao == 1){
            if(clientes.getListaClientes().get(indice).getListaAviao().isEmpty()){
                System.out.println("Não existem avioes alugados com este cliente");
                return;
            }
            clientes.getListaClientes().get(indice).devolveAviao( this);
        }if(opcao == 2){
            if(clientes.getListaClientes().get(indice).getListaBalao().isEmpty()){
                System.out.println("Não exitem baloes alugados com este cliente");
                return;
            }
            clientes.getListaClientes().get(indice).devolveBalao( this);
        }if(opcao == 3){
            if(clientes.getListaClientes().get(indice).getListaHelicoptero().isEmpty()){
                System.out.println("Não existem helicopteros alugados com este cliente");
                return;
            }
            clientes.getListaClientes().get(indice).devolveHelicoptero( this);
        }
    }
}
