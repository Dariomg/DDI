/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cifpaviles.dam.actividad4_swing;

/**
 *
 * @author dariomg
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class VentanaInteractiva extends JFrame {

    // Dimensiones iniciales y predeterminadas
    private final int ANCHO_INICIAL = 400;
    private final int ALTO_INICIAL = 300;
    private final int ANCHO_PREDETERMINADO = 600;
    private final int ALTO_PREDETERMINADO = 400;

    // Botones
    private JButton btnColor;
    private JButton btnRedimensionar;
    private JButton btnRestaurar;

    // Generador de colores aleatorios
    private Random random;

    // Constructor
    public VentanaInteractiva() {
        super("Actividad 4 - Interfaz Gráfica con Swing");

        random = new Random();

        // Configuración de la ventana
        setSize(ANCHO_INICIAL, ALTO_INICIAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar
        setResizable(true); // Permitir redimensionar

        // Crear botones
        btnColor = new JButton("Cambiar color de fondo");
        btnRedimensionar = new JButton("Redimensionar a 600x400");
        btnRestaurar = new JButton("Restaurar tamaño original");

        // Añadir eventos a los botones
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorFondo();
            }
        });

        btnRedimensionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(ANCHO_PREDETERMINADO, ALTO_PREDETERMINADO);
            }
        });

        btnRestaurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(ANCHO_INICIAL, ALTO_INICIAL);
            }
        });

        // Layout sencillo y ordenado
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        // Agregar botones a la ventana
        add(btnColor);
        add(btnRedimensionar);
        add(btnRestaurar);
    }

    // Método para cambiar el color de fondo de forma aleatoria
    private void cambiarColorFondo() {
        Color colorAleatorio = new Color(
                random.nextInt(256), // Rojo
                random.nextInt(256), // Verde
                random.nextInt(256)  // Azul
        );
        getContentPane().setBackground(colorAleatorio);
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInteractiva ventana = new VentanaInteractiva();
            ventana.setVisible(true);
        });
    }
}