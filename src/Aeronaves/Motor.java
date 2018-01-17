/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeronaves;

public class Motor {
    private final float consumo;
    private final float peso;
    private final int ano;

    public Motor(float consumo, float peso, int ano) {
        this.consumo = consumo;
        this.peso = peso;
        this.ano = ano;
    }

    public float getConsumo() {
        return consumo;
    }
    public float getPeso() {
        return peso;
    }
    public int getAno() {
        return ano;
    }
    
}

