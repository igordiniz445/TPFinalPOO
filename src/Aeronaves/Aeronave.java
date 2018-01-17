package Aeronaves;
//Classe pai de todos os tipos de aeronaves
public class Aeronave {
    //valor siginifica o preço da locação da aeronave
    private final double valor;
    //taxa é refenrete ao preço de manuntençao pós-aluguel.
    private final double taxa;
    
    public Aeronave(double valor, double taxa){
        this.valor = valor;
        this.taxa = taxa;
    }

    public double getValor() {
        return valor;
    }

    public double getTaxa() {
        return taxa;
    }
    
    @Override
    public String toString() {
      return "Valor: "+getValor()+" Taxa: "+getTaxa();
    }
}
