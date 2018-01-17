package Interface;

import Aeronaves.CadastrarAeronave;
import Aeronaves.Controle;
import java.util.Scanner;
import Clientes.ControleDeCliente;

public class InterfaceUsuario {
    private int opcao;
    Scanner cin = new Scanner(System.in);
    Controle controleAeronaves = new Controle();
    ControleDeCliente controleCliente = new ControleDeCliente();
    public void onStart(){
        do{
        System.out.println("Digite o numero correspondente a opção");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Aeronave");
        System.out.println("3 - Alugar Aeronave");
        System.out.println("4 - Devolver Aeronave");
        System.out.print("Opção: ");
        opcao = cin.nextInt();
        if(opcao == 1){
            controleCliente.criaCliente();
        }if(opcao == 2){
            CadastrarAeronave.selecionaAeronave(controleAeronaves);
        }if(opcao ==3){
            controleAeronaves.verAeronavesDisponiveis(controleCliente);
        }if(opcao == 4){
            controleAeronaves.devolverAeronave(controleCliente);
        }else{System.out.println("Digite um numero válido.");}
        }while(opcao!=0);
    }

}
