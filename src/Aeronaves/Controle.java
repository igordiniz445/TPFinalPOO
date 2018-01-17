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


    private final List<Aeronave> aeronavesDisponiveis;
    
    private final List<Aeronave> aeronavesAlugadas;
    /*
    Contrutor da classe, quando a classe controle for instanciada, 
    então todas as listas se iniciam.
    */
    public Controle() {
        this.aeronavesDisponiveis = new ArrayList<>();
        this.aeronavesAlugadas = new ArrayList<>();
    }

    public List<Aeronave> getAeronavesDisponiveis() {
        return aeronavesDisponiveis;
    }
    public List<Aeronave> getAeronavesAlugadas() {
        return aeronavesAlugadas;
    }
    
    /*
    Metodos para cadastrar um tipo de aeronave especifico
    cada tipo de aeronave cadastrada será adicionada ao array do determinado
    tipo de aeronave
    */
    /*public void cadastrarAviao(Aviao aviao){
        listaAviao.add(aviao);
    }
    public void cadastrarBalao(Balao balao){
        listaBalao.add(balao);
    }
    public void cadastrarHelicoptero(Helicoptero h){
        listaHelicoptero.add(h);
    }*/
    public void cadastrarAeronave(Aeronave aeronave){
        aeronavesDisponiveis.add(aeronave);
    }
    /*
    Todos os metodos para alugar uma determinada aeronave receberão como parametro
    o tipo de aeronave, e o cliente na qual está alugando aquela aeronave
    então a aeronave fica cadastrada no array de aeronaves alugadas do cliente
    e ao mesmo tempo, sai do array de aeronaves diponiveis para alugar e entra
    para o array de aeronaves alugadas.
    */
    private void alugaAeronave(Aeronave aeronave, Cliente cliente){
        this.aeronavesDisponiveis.remove(aeronave);
        this.aeronavesAlugadas.add(aeronave);
        cliente.alugaAviao(aeronave);
    }
  
    /*
    Todos os metodos de devolução de aeronaves recebem a aeronave como parametro
    e remove do array de aeronaves alugadas e passam para o arrey de aeronaves 
    disponiveis.
    */
    public void devolveAviao(Aviao aviao){
        this.aeronavesAlugadas.remove(aviao);
        this.aeronavesDisponiveis.add(aviao);
    }
    public void devolveBalao(Balao balao){
        this.aeronavesAlugadas.remove(balao);
        this.aeronavesDisponiveis.add(balao);
    }
    public void devolveHelicoptero(Helicoptero h){
        this.aeronavesAlugadas.remove(h);
        this.aeronavesDisponiveis.add(h);
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
            //usuario quer aviao
           for(int i =0;i<aeronavesDisponiveis.size();i++){
                Aeronave aeronave = aeronavesDisponiveis.get(i);
                if(aeronave instanceof Aviao){
                    System.out.println("indice:"+i+" - "+aeronave);
                }
            }
        }
        
        //exibe todos os baloes disponiveis
        if(opcao2 == 2){
            for(int i =0;i<aeronavesDisponiveis.size();i++){
                Aeronave aeronave = aeronavesDisponiveis.get(i);
                if(aeronave instanceof Balao){
                    System.out.println("indice:"+i+" - "+aeronave);
                }
            }
        }
        //exibe todos os helicopteros disponiveis
        if(opcao2 == 3){
            for(int i =0;i<aeronavesDisponiveis.size();i++){
                Aeronave aeronave = aeronavesDisponiveis.get(i);
                if(aeronave instanceof Helicoptero){
                    System.out.println("indice:"+i+" - "+aeronave);
                }
            }
        }
        //Pergunta ao usuario qual dessas aeronaves o usuario quer alugar e retorna o indice selecionado
        posicao = Mensagens.selecaoPosicao();
        //Pergunta ao usuario quantos dias ele quer alugar a aeronave e recebe de retorno o numero de dias
        dias = Mensagens.recebeQtdDias();
        //Calcula o valor que ficará o aluguel
        System.out.println(posicao);
        if(opcao2 == 1){
            PrecoAluguel valor = (PrecoAluguel)aeronavesDisponiveis.get(posicao);
            valorDoAluguel = valor.valorDoAluguel(dias);
        }else if(opcao2 == 2){
            PrecoAluguel valor = (PrecoAluguel)aeronavesDisponiveis.get(posicao);
            valorDoAluguel = valor.valorDoAluguel(dias);
        }else{
            PrecoAluguel valor = (PrecoAluguel)aeronavesDisponiveis.get(posicao);
            valorDoAluguel = valor.valorDoAluguel(dias);
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
                alugaAeronave(aeronavesDisponiveis.get(posicao),cliente);
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Aviao foi alugado com sucesso!");
            }if(opcao2 == 2){
                try {
                alugaAeronave(aeronavesDisponiveis.get(posicao),cliente);
                } catch (IndexOutOfBoundsException e) {
                System.err.println("Este indice não exite");
                }
                System.out.println("Balao foi alugado com sucesso!");
            }if(opcao2 == 3){
                try {
                alugaAeronave(aeronavesDisponiveis.get(posicao),cliente);
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
        boolean aux = false;
        int indice = Mensagens.recebeIndice();
        int opcao = Mensagens.tipoAeronave("devolver");
        if(opcao == 1){
            for (Cliente listaCliente : clientes.getListaClientes()) {
                if(clientes.getListaClientes() instanceof Aviao){
                    aux = true;
                }
            }
            if(aux == false){
                System.out.println("Não existem avioes alugados com este cliente");
                return;
            }else
            clientes.getListaClientes().get(indice).devolveAviao( this);
        }if(opcao == 2){
            for (Cliente listaCliente : clientes.getListaClientes()) {
                if(clientes.getListaClientes() instanceof Balao){
                    aux = true;
                }
            }
            if(aux == false){
                System.out.println("Não existem Baloes alugados com este cliente");
                return;
            }else
            clientes.getListaClientes().get(indice).devolveBalao( this);
        }if(opcao == 3){
            for (Cliente listaCliente : clientes.getListaClientes()) {
                if(clientes.getListaClientes() instanceof Helicoptero){
                    aux = true;
                }
            }
            if(aux == false){
                System.out.println("Não existem Helicopteros alugados com este cliente");
                return;
            }else
            clientes.getListaClientes().get(indice).devolveHelicoptero(this);
        }
    }
}
