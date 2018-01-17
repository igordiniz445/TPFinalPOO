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
            controle.cadastrarAeronave(aviao);
        }if(opcao == 2){
            Balao balao = cadastrarBalao();
            controle.cadastrarAeronave(balao);
        }if(opcao == 3){
            Helicoptero helicoptero = cadastrarHelicoptero();
            controle.cadastrarAeronave(helicoptero);
        }
    }
    
    private static Aviao cadastraAviao(){
        Scanner cin = new Scanner(System.in);
        String modelo;
        String cor;
        double valor;
        double taxa;
        System.out.print("Informe o modelo(string): ");
        modelo = cin.next().trim();
        System.out.print("Informe a cor(string): ");
        cor = cin.next().trim();
        System.out.print("Informe o valor da locação(double): ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação(double): ");
        taxa = cin.nextDouble();
        System.out.println("Dados do motor:");
        //Composição!
        Motor motor = recebeDadosDoMotor();
        Aviao aviao = new Aviao(modelo, cor, valor, taxa, motor);
        System.out.println("Avião Cadastrado !");
        return aviao;
    }
    
    private static  Balao cadastrarBalao(){
        Scanner cin = new Scanner(System.in);
        int passageiros;
        String cor;
        double valor;
        double taxa;
        System.out.print("Informe o numero de passageiros(int): ");
        passageiros = cin.nextInt();
        System.out.print("Informe a cor(string): ");
        cor = cin.next().trim();
        System.out.print("Informe o valor da locação(double): ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação(double): ");
        taxa = cin.nextDouble();
        Balao balao = new Balao(passageiros, cor, valor, taxa);
        return balao;
    }
    
    private static Helicoptero cadastrarHelicoptero(){
        Scanner cin = new Scanner(System.in);
        String modelo;
        double taxa;
        double valor;
        System.out.print("Informe o modelo(string): ");
        modelo = cin.next().trim();
        System.out.print("Informe o valor da locação(double): ");
        valor = cin.nextDouble();
        System.out.print("Informe o valor da Taxa de locação(double): ");
        taxa = cin.nextDouble();
        Helicoptero h = new Helicoptero(modelo, taxa, valor);
        return h;
    }

    private static Motor recebeDadosDoMotor() {
        //public Motor(float consumo, float peso, int ano)
        Scanner cin = new Scanner(System.in);
        System.out.print("Informe o consumo do motor(float): ");
        float consumo = cin.nextFloat();
        System.out.print("Informe o peso do motor(float): ");
        float peso = cin.nextFloat();
        System.out.print("Informe o ano do motor(int): ");
        int ano = cin.nextInt();
        Motor motor = new Motor(consumo,peso,ano);
        return motor;
    }
    
}
