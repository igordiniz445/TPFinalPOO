package Aeronaves;
/**
 *
 * @author igorc
 * 
 */
public class Aviao extends Aeronave implements PrecoAluguel{
    
    private final String modelo;
    private final String cor;

    public Aviao(String modelo, String cor, double valor, double taxa){
        super(valor, taxa);
        this.modelo = modelo;
        this.cor = cor;
    }
    
    //Cada tipo de aeronave tem uma taxa especifica
    //A regra para o avião é que de a cada 5 dias que o avião for ficar alugado
    //a taxa aumenta em 1.45
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
