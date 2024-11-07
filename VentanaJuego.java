/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import picasyFijas.Juego;
import picasyFijas.Resultado;
import player.Jugador;

public class VentanaJuego extends JFrame {
    private Juego juego;
    private Jugador jugador;
    private JTextField campoEntrada;
    private JTextPane areaResultados;
    private StyledDocument doc;

    public VentanaJuego() {
        juego = new Juego();
        jugador = new Jugador(); 

        setTitle("Juego de Picas y Fijas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

   
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

       
        areaResultados = new JTextPane();
        areaResultados.setEditable(false);
        areaResultados.setBackground(Color.WHITE);
        areaResultados.setForeground(Color.BLACK);
        doc = areaResultados.getStyledDocument();
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        panel.add(scrollPane, BorderLayout.CENTER);

 
        campoEntrada = new JTextField(10);
        JButton botonIntentar = new JButton("Intentar");

        JPanel panelEntrada = new JPanel();
        panelEntrada.setBackground(Color.WHITE);
        panelEntrada.add(new JLabel("Ingrese un número de 4 dígitos:"));
        panelEntrada.add(campoEntrada);
        panelEntrada.add(botonIntentar);
        panel.add(panelEntrada, BorderLayout.SOUTH);

       
        botonIntentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarIntento();
            }
        });

        add(panel);
    }

    private void manejarIntento() {
        String intento = campoEntrada.getText();

        
        if (intento.equalsIgnoreCase("fin")) {
            JOptionPane.showMessageDialog(this, "Gracias por jugar!");
            System.exit(0);
        }

        if (intento.length() != 4 || !intento.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de 4 dígitos.");
            return;
        }

       jugador.incrementarIntentos();
        Resultado resultado = juego.evaluarIntento(intento);

        
        mostrarResultado(intento, resultado);

    
        if (resultado.getFijas() == 4) {
            JOptionPane.showMessageDialog(this, "¡Felicidades, " + jugador.getNombre() + "! Adivinaste el número en " + jugador.getIntentos() + " intentos.");
            System.exit(0);
        }
    }

    private void mostrarResultado(String intento, Resultado resultado) {
        try {
           
            SimpleAttributeSet estiloPica = new SimpleAttributeSet();
            StyleConstants.setForeground(estiloPica, Color.YELLOW);

            SimpleAttributeSet estiloFija = new SimpleAttributeSet();
            StyleConstants.setForeground(estiloFija, Color.GREEN);

            SimpleAttributeSet estiloNeutral = new SimpleAttributeSet();
            StyleConstants.setForeground(estiloNeutral, Color.BLACK);

           
            doc.remove(0, doc.getLength());

           
            for (int i = 0; i < 4; i++) {
                char digito = intento.charAt(i);
                boolean esFija = juego.getNumeroAleatorio().charAt(i) == digito;
                boolean esPica = juego.getNumeroAleatorio().indexOf(digito) != -1 && !esFija;

                if (esFija) {
                    doc.insertString(doc.getLength(), String.valueOf(digito), estiloFija);
                } else if (esPica) {
                    doc.insertString(doc.getLength(), String.valueOf(digito), estiloPica);
                } else {
                    doc.insertString(doc.getLength(), String.valueOf(digito), estiloNeutral);
                }
            }
            doc.insertString(doc.getLength(), " - Picas: " + resultado.getPicas() + ", Fijas: " + resultado.getFijas() + "\n", estiloNeutral);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}