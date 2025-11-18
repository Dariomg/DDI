/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cifpaviles.dam.diact1_2;

/**
 *
 * @author dariomg
 */
import javax.swing.*;

public class AlumnoForm extends JFrame {

    private JTextField txtNombre, txtApellidos, txtEmail, txtEdad, txtTelefono;
    private JLabel lblError;
    private JButton btnAgregar;

    public AlumnoForm() {
        setTitle("Formulario Alumno");
        setSize(350, 330);
        setLayout(null);

        JLabel lbl1 = new JLabel("Nombre:");
        lbl1.setBounds(20, 20, 100, 25);
        add(lbl1);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 20, 150, 25);
        add(txtNombre);

        JLabel lbl2 = new JLabel("Apellidos:");
        lbl2.setBounds(20, 60, 100, 25);
        add(lbl2);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(130, 60, 150, 25);
        add(txtApellidos);

        JLabel lbl3 = new JLabel("Email:");
        lbl3.setBounds(20, 100, 100, 25);
        add(lbl3);

        txtEmail = new JTextField();
        txtEmail.setBounds(130, 100, 150, 25);
        add(txtEmail);

        JLabel lbl4 = new JLabel("Edad:");
        lbl4.setBounds(20, 140, 100, 25);
        add(lbl4);

        txtEdad = new JTextField();
        txtEdad.setBounds(130, 140, 150, 25);
        add(txtEdad);

        JLabel lbl5 = new JLabel("Teléfono:");
        lbl5.setBounds(20, 180, 100, 25);
        add(lbl5);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(130, 180, 150, 25);
        add(txtTelefono);

        btnAgregar = new JButton("Añadir");
        btnAgregar.setBounds(100, 220, 120, 30);
        add(btnAgregar);

        lblError = new JLabel("Máximo de 5 alumnos alcanzado.");
        lblError.setBounds(20, 260, 300, 25);
        lblError.setForeground(java.awt.Color.RED);
        lblError.setVisible(false);
        add(lblError);

        btnAgregar.addActionListener(e -> agregarAlumno());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void agregarAlumno() {
        if (Principal.indiceAlumnos >= 5) {
            lblError.setVisible(true);
            return;
        }

        try {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String email = txtEmail.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String telefono = txtTelefono.getText();

            Alumno nuevo = new Alumno(nombre, apellidos, email, edad, telefono);

            Principal.alumnos[Principal.indiceAlumnos] = nuevo;
            Principal.indiceAlumnos++;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad no válida");
        }
    }
}