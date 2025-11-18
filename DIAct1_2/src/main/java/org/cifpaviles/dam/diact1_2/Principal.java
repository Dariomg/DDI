/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cifpaviles.dam.diact1_2;

/**
 *
 * @author dariomg
 */
public class Principal {

    public static Alumno[] alumnos = new Alumno[5];
    public static int indiceAlumnos = 0;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlumnoForm f = new AlumnoForm();
                f.setVisible(true);
            }
        });
    }
}