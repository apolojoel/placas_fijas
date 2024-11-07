/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package picasyFijas;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Juego {
    private String numeroAleatorio;

    public Juego() {
        this.numeroAleatorio = generarNumeroAleatorio();
    }

    private String generarNumeroAleatorio() {
        Random random = new Random();
        Set<Integer> digitos = new HashSet<>();
        StringBuilder numero = new StringBuilder();

        while (digitos.size() < 4) {
            int digito = random.nextInt(10);
            if (digitos.add(digito)) {
                numero.append(digito);
            }
        }

        return numero.toString();
    }

    public Resultado evaluarIntento(String intento) {
        int picas = 0;
        int fijas = 0;

        for (int i = 0; i < 4; i++) {
            char digitoIntento = intento.charAt(i);
            char digitoCorrecto = numeroAleatorio.charAt(i);

            if (digitoIntento == digitoCorrecto) {
                fijas++;
            } else if (numeroAleatorio.indexOf(digitoIntento) != -1) {
                picas++;
            }
        }

        return new Resultado(picas, fijas);
    }

    public String getNumeroAleatorio() {
        return numeroAleatorio;
    }
}