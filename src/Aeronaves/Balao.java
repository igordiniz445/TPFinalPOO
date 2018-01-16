/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeronaves;

public class Balao extends Aeronave implements PrecoAluguel {
    private int numPassageiros;
    private String cor;

    public Balao(int passageiros, String cor, double valor, double taxa) {
        super(valor, taxa);
        this.numPassageiros = passageiros;
        this.cor = cor;
    }
    @Override
    public double valorDoAluguel(int dias) {
        double valorDoAluguel;
        double taxa = super.getTaxa();
        if(dias <= 3){
            valorDoAluguel = (dias*taxa)+super.getValor();
        }else{
            for(int i = 5; i<dias;i++){
                if(i%5 == 0){
                    //Taxa aumenta a cada 5 dias que for alugar
                    taxa = taxa * 1.15;
                }
            }
            valorDoAluguel = (dias*taxa)+super.getValor();
        }
        
        return valorDoAluguel;
    }
    @Override
    public String toString() {
        return "Qtd de passageiros: "+this.numPassageiros+"   Cor: "+this.cor+"   "+super.toString();
    }
    
}
