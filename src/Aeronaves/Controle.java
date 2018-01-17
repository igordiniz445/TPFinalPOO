package Aeronaves;

import Clientes.Cliente;
import Clientes.ControleDeCliente;
import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Classe controle irá gerenciar todas as aeronaves disponiveis ou alugadas
*/
public class Controle {


    private final List<Aviao> listaAviao;
    private final List<Balao> listaBalao;
    private final List<Helicoptero> listaHelicoptero;
    
    private final List<Aviao> avioesAlugados;
    private final List<Balao> baloesAlugados;
    private final List<Helicoptero> helicopterosAlugados;
    /*
    Contrutor da classe, quando a classe controle for instanciada, 
    então todas as listas se iniciam.
    */
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
    /*
    Metodos para cadastrar um tipo de aeronave especifico
    cada tipo de aeronave cadastrada será adicionada ao array do determinado
    tipo de aeronave
    */
    public void cadastrarAviao(Aviao aviao){
        listaAviao.add(aviao);
    }
    public void cadastrarBalao(Balao balao){
        listaBalao.add(balao);
    }
    public void cadastrarHelicoptero(Helicoptero h){
        listaHelicoptero.add(h);
    }
    /*
    Todos os metodos para alugar uma determinada aeronave receberão como parametro
    o tipo de aeronave, e o cliente na qual está alugando aquela aeronave
    então a aeronave fica cadastrada no array de aeronaves alugadas do cliente
    e ao mesmo tempo, sai do array de aeronaves diponiveis para alugar e entra
    para o array de aeronaves alugadas.
    */
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
    /*
    Todos os metodos de devolução de aeronaves recebem a aeronave como parametro
    e remove do array de aeronaves alugadas e passam para o arrey de aeronaves 
    disponiveis.
    */
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
    /*
    O método verAeronavesDisponiveis pergunta ao usuario que tipo de aeronave ele quer alugar
    e mostra a ele todas as aeronaves daquele tipo disponiveis para serem alugadas, mostrando junto
    a aeronave o indice dela, apos escolher uma aeronave, pergunta-se ao usuario quantos dias ele pretende
    alugar a aeronave, apos o usuario informar quantos dias ele quer manter a eronave alugada e então
    é retornado para o cliente o valor que ficará alugar aquela aeronave por aquela quantidades de dias
    e pergunta o usuario se ele realmente quer alugar aquela aeronave, se o usuario confirmar,
    então chama-se o matodo para alugar aquela aeronave passando como parametros o indice que o usuario
    selecionou referente a aeronave, e o cliente que está requisitando o aluguel
    */
    public void verAeronavesDisponiveis(ControleDeCliente controleCliente){
        Scanner cin = new Scanner(System.in);
        int opcao, opcao2, posicao;
        int dias;
        double valorDoAluguel;
        //Chama a função da interface para perguntar o tipo de aeronave
        //passando como paramento a string "alugar" para substituir na frase
        //exibida para o usuario, já que esta memsa função é chamada em outras situações
        //retornando a opção selecionada pelo usuário.
        opcao2 = Mensagens.tipoAeronave("alugar");
        //Exibe todos os avioes disponiveis
        if(opcao2 == 1){
            if(listaAviao.isEmpty()){
                System.out.println("\nNão há aviões cadastrados, ou estão todos alugados !\n");
                return;
            }for(int i =0;i<listaAviao.size();i++){
            System.out.println(i+" - "+listaAviao.get(i));
            }
        }
        //exibe todos os baloes disponiveis
        if(opcao2 == 2){
            if(listaBalao.isEmpty()){
                System.out.println("\nNão há balões cadastrados, ou estão todos alugados! \n");
                return;
            }for(int i =0;i<listaBalao.size();i++){
            System.out.println(i+" - "+listaBalao.get(i));
            }
        }
        //exibe todos os helicopteros disponiveis
        if(opcao2 == 3){
            if(listaHelicoptero.isEmpty()){
                System.out.println("\nNão há helicopteros cadastrados, ou estão todos alugados! \n");
                return;
            }for(int i =0;i<listaHelicoptero.size();i++){
            System.out.println(i+" - "+listaHelicoptero.get(i));
            }
        }
        //Pergunta ao usuario qual dessas aeronaves o usuario quer alugar e retorna o indice selecionado
        posicao = Mensagens.selecaoPosicao();
        //Pergunta ao usuario quantos dias ele quer alugar a aeronave e recebe de retorno o numero de dias
        dias = Mensagens.recebeQtdDias();
        //Calcula o valor que ficará o aluguel
        if(opcao2 == 1){
            valorDoAluguel = listaAviao.get(posicao).valorDoAluguel(dias);
        }if(opcao2 == 2){
            valorDoAluguel = listaBalao.get(posicao).valorDoAluguel(dias);
        }else{
            valorDoAluguel = listaHelicoptero.get(posicao).valorDoAluguel(dias);
        }
        //Pergunta o usuario se ele quer confirmar o aluguel
        opcao = Mensagens.confirmacaoAluguel(dias, valorDoAluguel);
        
        if(opcao == 1){
            //exibe os clientes cadastros e retorna o cliente que fará o aluguel.
            //apos receber o aluguel, chama-se a função para alugar a aeronave
            //passando como paramentro a aeronave e o cliente
            Cliente cliente = controleCliente.selecionaCliente();
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
    /*
    Metodo para  exibir todos os clientes, passando como paramentro o controle sob
    os clientes, apos selecionar o cliente, então pergunta ao usuario que tipo de
    aeronave ele quer devolver, e então exibe-se para ele todas as aeronaves daquele tipo
    e efetua a devolução da aeronave de volta para o array de aeronaves disponiveis
    */
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
            clientes.getListaClientes().get(indice).devolveHelicoptero(this);
        }
    }
}
