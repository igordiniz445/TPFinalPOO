
package Clientes;

import Aeronaves.Aeronave;
import Aeronaves.Aviao;
import Aeronaves.Balao;
import Aeronaves.Controle;
import Aeronaves.Helicoptero;
import Interface.Mensagens;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorc
 */
public class Cliente {
    private final String nome;
    private final String cpf;
    private final String telefone;
    //Listas das possiveis aeronaves que eo cliente irá alugar
    private final List<Aeronave> listaAeronaves;

    /**
     *
     * @param nome
     * @param cpf
     * @param telefone
     */
    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        listaAeronaves = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }

    public List<Aeronave> getListaAeronaves() {
        return listaAeronaves;
    }
    
    public void alugaAviao(Aeronave aviao){listaAeronaves.add(aviao);}
    public void alugaBalao(Aeronave balao){listaAeronaves.add(balao);}
    public void alugaHelicoptero(Aeronave h){listaAeronaves.add(h);}
    
    
    @Override
    public String toString(){
        return "Nome: "+this.nome+", cpf: "+this.cpf+" telefone: "+this.telefone;
    }
   

    /**
     *Os metodos abaixo recebem como parametro o objeto de controle de todas as aeronaves.
     *devolve a aeronave alugada para o array de aeronaves disponveis
     *e tira do array de aeronaves alugadas, e do array de aeronaves alugadas
     *pelo atual cliente
     * @param controle
     */

    public void devolveAviao( Controle controle){
        boolean existe = false;
        for(int i=0;i<this.listaAeronaves.size();i++){
            if(listaAeronaves.get(i) instanceof Aviao){
            System.out.println("opcao "+i+" - "+this.listaAeronaves.get(i));
            existe = true;
            }
        }if(existe){
            int indice = Mensagens.recebeIndice();
            controle.getAeronavesDisponiveis().add( (Aviao) this.listaAeronaves.get(indice));
            controle.getAeronavesAlugadas().remove(this.listaAeronaves.get(indice));
            listaAeronaves.remove(this.listaAeronaves.get(indice));
            System.out.println("Aviao devolvido com sucesso!");
        }else{
            System.out.println("Não existem Avioes alugados com este cliente.");
        }
        
    }
    public void devolveBalao(Controle controle){
        boolean existe = false;
        for(int i=0;i<this.listaAeronaves.size();i++){
            if(this.listaAeronaves.get(i) instanceof Balao){
                existe = true;
                System.out.println("indice: "+i+" - "+this.listaAeronaves.get(i));
            }
        }if(existe){
            int indice = Mensagens.recebeIndice();
            controle.getAeronavesDisponiveis().add(this.listaAeronaves.get(indice));
            controle.getAeronavesAlugadas().remove(this.listaAeronaves.get(indice));
            listaAeronaves.remove(this.listaAeronaves.get(indice));
            System.out.println("Balao devolvido com sucesso !");
        }else{
            System.out.println("Não existem baloes alugados com este cliente");
        }
        
    }
    public void devolveHelicoptero(Controle controle){
        boolean existe = false;
       for(int i=0;i<this.listaAeronaves.size();i++){
            if(this.listaAeronaves.get(i) instanceof Helicoptero){
                existe = true;
                System.out.println("indice: "+i+" - "+this.listaAeronaves.get(i));
            }
        }if(existe){
            int indice = Mensagens.recebeIndice();
            controle.getAeronavesDisponiveis().add(this.listaAeronaves.get(indice));
            controle.getAeronavesAlugadas().remove(this.listaAeronaves.get(indice));
            listaAeronaves.remove(this.listaAeronaves.get(indice));
            System.out.println("Helicoptero devolvido com sucesso !");
        }else{
            System.out.println("Não existem helicopteros alugados com este cliente.");
        }
        
    }

    public void alugaAeronave(Aeronave aeronave) {
        listaAeronaves.add(aeronave);
    }
    
}
