package Aeronaves;

public class Aeronave {
    private final double valor;
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
