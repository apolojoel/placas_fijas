/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;

import javax.swing.JOptionPane;

public class Jugador {
    
    private String nombre;
    private int intentos;

    public Jugador() {
        this.nombre = solicitarNombre();
        this.intentos = 0;
    }
    
    

    public String solicitarNombre() {
        return JOptionPane.showInputDialog(null,"Ingrese su nombre:", "Nombre del Jugador", JOptionPane.PLAIN_MESSAGE);
    }

    public void incrementarIntentos() {
            setIntentos(getIntentos() + 1);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public String getResultadosFinales() {
        return "Jugador: " + getNombre() + " - Intentos: " + getIntentos();
    }

       
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        
        public void setIntentos(int intentos) {
            this.intentos = intentos;
        }
    }
    

