/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeronaves;

/**
 *
 * @author igorc
 * Esta interface serve para garantir que cada aeronave tenha
 * uma regra especifica para calcular o valor que ficará o aluguel
 * referente a quantidade de dias que o usuario queira alugar a aeronave
 */
public interface PrecoAluguel {
    public double valorDoAluguel(int dias);
}
