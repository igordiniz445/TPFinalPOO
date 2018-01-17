package Aeronaves;

import java.util.Scanner;

public final class CadastrarAeronave {
    
    //Classe menu referente ao cadastro de aeronaves
    public static final void selecionaAeronave(Controle controle){
        int opcao;
        Scanner cin = new Scanner(System.in);
        System.out.println("Qual aeronave deseja cadastrar ?");
        System.out.println("1 - Avião");
        System.out.println("2 - Balão");
        System.out.println("3 - Helicóptero");
        System.out.print("opcao: ");
        opcao = cin.nextInt();
        if(opcao == 1){
            Aviao aviao = cadastraAviao();
            controle.cadastrarAviao(aviao);
        }if(opcao == 2){
            Balao balao = cadastrarBalao();
            controle.cadastrarBalao(balao);
        }if(opcao == 3){
            Helicoptero helicoptero = cadastrarHelicoptero();
            controle.cadastrarHelicoptero(helicoptero);
        }
    }
    
    private static Aviao cadastraAviao(){
        Scanner cin = new Scanner(System.in);
        String modelo;
        String cor;
        double valor;
        double taxa;
        System.out.print("Informe o modelo: ");
        modelo = cin.next().trim();
        System.out.print("Informe a cor: ");
        cor = cin.next().trim();
        System.out.print("Informe o valor da locação: ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação: ");
        taxa = cin.nextDouble();
        Aviao aviao = new Aviao(modelo, cor, valor, taxa);
        System.out.println("Avião Cadastrado !");
        return aviao;
    }
    
    private static  Balao cadastrarBalao(){
        Scanner cin = new Scanner(System.in);
        int passageiros;
        String cor;
        double valor;
        double taxa;
        System.out.print("Informe o numero de passageiros: ");
        passageiros = cin.nextInt();
        System.out.print("Informe a cor: ");
        cor = cin.next().trim();
        System.out.print("Informe o valor da locação: ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação: ");
        taxa = cin.nextDouble();
        Balao balao = new Balao(passageiros, cor, valor, taxa);
        return balao;
    }
    
    private static Helicoptero cadastrarHelicoptero(){
        Scanner cin = new Scanner(System.in);
        String modelo;
        double taxa;
        double valor;
        System.out.print("Informe o modelo: ");
        modelo = cin.next().trim();
        System.out.print("Informe o valor da locação: ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação: ");
        taxa = cin.nextDouble();
        Helicoptero h = new Helicoptero(modelo, taxa, valor);
        return h;
    }
    
}
