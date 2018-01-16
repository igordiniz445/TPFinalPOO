package Aeronaves;

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
    
    public void cadastrarAviao(Aviao aviao){
        listaAviao.add(aviao);
    }
    public void cadastrarBalao(Balao balao){
        listaBalao.add(balao);
    }
    public void cadastrarHelicoptero(Helicoptero h){
        listaHelicoptero.add(h);
    }
    
    private void alugaAviao(Aviao aviao){
        this.listaAviao.remove(aviao);
        this.avioesAlugados.add(aviao);
    }
    private void alugaBalao(Balao balao){
        this.listaBalao.remove(balao);
        this.baloesAlugados.add(balao);
    }
    private void alugaHelicoptero(Helicoptero h){
        this.listaHelicoptero.remove(h);
        this.helicopterosAlugados.add(h);
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
    
    public void verAeronavesDisponiveis(){
        Scanner cin = new Scanner(System.in);
        int opcao, opcao2, posicao;
        int dias;
        double valorDoAluguel;
        opcao2 = Mensagens.tipoAeronave();
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
        if(opcao == 1){
            if(opcao2 == 1){
                try {
                alugaAviao(listaAviao.get(posicao));
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Aviao foi alugado com sucesso!");
            }if(opcao2 == 2){
                try {
                alugaBalao(listaBalao.get(posicao));
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Balao foi alugado com sucesso!");
            }if(opcao2 == 3){
                try {
                alugaHelicoptero(listaHelicoptero.get(posicao));
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Helicoptero foi alugado com sucesso!");
            }
        }else{
         //Não faz nada e termina a execução do aluguel
        }
    }
    
    public void devolverAeronave(){
        Scanner cin = new Scanner(System.in);
        int tipoAeronave, opcao, posicao;
        System.out.println("Qual tipo de aeronave você veio devolver ?");
        System.out.println("1 - Avião\n2 - Balão\n3 - Helicoptero");
        tipoAeronave = cin.nextInt();
        if(tipoAeronave == 1){
            
        }if(tipoAeronave == 2){
        
        }if(tipoAeronave == 3){
        
        }
    }
}
