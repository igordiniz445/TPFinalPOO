package Interface;

import java.util.Scanner;


public class Mensagens {
    public static int tipoAeronave(String alugadevolve){
        Scanner cin = new Scanner(System.in);
        System.out.println("Qual aeronave deseja "+alugadevolve+" ?");
        System.out.println("1 - Avião     ||     2 - Balão     ||     3 - Helicóptero");
        int opcao = cin.nextInt();
        while(opcao > 3){
            System.out.println("Opção invalida, digite somente 1, 2 ou 3");
            opcao = cin.nextInt();
        }
        return opcao;
    }
    
    public static int selecaoPosicao(){
        Scanner cin = new Scanner(System.in);
        System.out.print("Qual destes deseja alugar:(digite o indice da aeronave desejada) ");
        int posicao = cin.nextInt();
        return posicao;
    }
    
    public static int recebeQtdDias(){
        Scanner cin = new Scanner(System.in);
        System.out.print("Quantos dias deseja alugar-lo ?");
        int dias = cin.nextInt();
        return dias;
    }
    
    public static int confirmacaoAluguel(int dias, double valorDoAluguel){
        Scanner cin = new Scanner(System.in);
        System.out.println("O Valor do aluguel para "+dias+" dias ficará em R$"+valorDoAluguel+" deseja continuar ?");
        System.out.println("1 - Sim       ||        2 - Não");
        int opcao = cin.nextInt();
        return opcao;
    }

    public static String recebeNomeCliente() {
        Scanner cin = new Scanner(System.in);
        String nome;
        System.out.print("Nome completo do cliente: ");
        nome = cin.next().trim();
        return nome;
    }

    public static String recebeCPFCliente() {
        Scanner cin = new Scanner(System.in);
        String cpf;
        System.out.print("CPF do cliente: ");
        cpf = cin.next();
        return cpf;
    }

    public static String recebeTelefoneCliente() {
        Scanner cin = new Scanner(System.in);
        String telefone;
        System.out.print("Telefone do cliente: ");
        telefone = cin.next();
        return telefone;
    }
    
    public static int recebeIndice(){
        Scanner cin = new Scanner(System.in);
        System.out.print("Indice: ");
        int indice;
        indice = cin.nextInt();
        return indice;
    }

    
}
