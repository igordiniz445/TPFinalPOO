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
public class Helicoptero extends Aeronave implements PrecoAluguel{
    private String modelo;

    public Helicoptero(String modelo, double taxa, double valor) {
        super(valor, taxa);
        this.modelo = modelo;
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
                    taxa = taxa * 1.35;
                }
            }
            valorDoAluguel = (dias*taxa)+super.getValor();
        }
        return valorDoAluguel;
    }
    @Override
    public String toString() {
      return "Modelo: "+this.modelo+"   "+super.toString();
    }
    
}
