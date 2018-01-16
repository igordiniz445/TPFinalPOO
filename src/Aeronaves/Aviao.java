/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeronaves;

/**
 *
 * @author igorc
 */
public class Aviao extends Aeronave implements PrecoAluguel{
    
    private final String modelo;
    private final String cor;

    public Aviao(String modelo, String cor, double valor, double taxa){
        super(valor, taxa);
        this.modelo = modelo;
        this.cor = cor;
    }
    
    @Override
    public double valorDoAluguel(int dias) {
        double valorDoAluguel;
        double taxa = super.getTaxa();
        if(dias <= 5){
            valorDoAluguel = (dias*taxa)+super.getValor();
        }else{
            for(int i = 5; i<dias;i++){
                if(i%5 == 0){
                    //Taxa aumenta a cada 5 dias que for alugar
                    taxa = taxa * 1.45;
                }
            }
            valorDoAluguel = (dias*taxa)+super.getValor();
        }
        
        return valorDoAluguel;
    }
    @Override
    public String toString() {
      return "Modelo: "+this.modelo+"   Cor: "+this.cor+"   "+super.toString();
    }
    
}
