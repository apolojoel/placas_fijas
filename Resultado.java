/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package picasyFijas;

public class Resultado {
    private int picas;
    private int fijas;

    public Resultado(int picas, int fijas) {
        this.picas = picas;
        this.fijas = fijas;
    }

    public int getPicas() {
        return picas;
    }

    public int getFijas() {
        return fijas;
    }

    @Override
    public String toString() {
        return "Picas: " + picas + ", Fijas: " + fijas;
    }
}

