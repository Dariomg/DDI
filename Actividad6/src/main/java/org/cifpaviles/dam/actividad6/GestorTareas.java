/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cifpaviles.dam.actividad6;

/**
 *
 * @author dariomg
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestorTareas extends JFrame {

    private JTextField txtTarea;
    private JButton btnAgregar, btnEliminar;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloLista;
    private JLabel lblEstado;
    private JMenuItem itemSalir;

    public GestorTareas() {
        setTitle("Gestor de Tareas");
        setSize(400, 350);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        inicializarComponentes();
        registrarEventos();

        setVisible(true);
    }

    private void inicializarComponentes() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        txtTarea = new JTextField();
        btnAgregar = new JButton("Agregar");
        panelSuperior.add(txtTarea, BorderLayout.CENTER);
        panelSuperior.add(btnAgregar, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        add(new JScrollPane(listaTareas), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        btnEliminar = new JButton("Eliminar");
        lblEstado = new JLabel(" ");
        panelInferior.add(btnEliminar, BorderLayout.WEST);
        panelInferior.add(lblEstado, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void registrarEventos() {

        btnAgregar.addActionListener(e -> agregarTarea());
        txtTarea.addActionListener(e -> agregarTarea());

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea();
            }
        });

        listaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !listaTareas.isSelectionEmpty()) {
                    String tarea = listaTareas.getSelectedValue();
                    JOptionPane.showMessageDialog(
                            GestorTareas.this,
                            "Has hecho doble clic sobre la tarea: " + tarea
                    );
                }
            }
        });

        listaTareas.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    eliminarTarea();
                }
            }
            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {}
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });

        itemSalir.addActionListener(e -> cerrarAplicacion());
    }

    private void agregarTarea() {
        String tarea = txtTarea.getText().trim();

        if (tarea.isEmpty()) {
            lblEstado.setText("No puedes añadir una tarea vacía.");
            return;
        }

        modeloLista.addElement(tarea);
        txtTarea.setText("");
        lblEstado.setText("Tarea añadida.");
    }

    private void eliminarTarea() {
        int index = listaTareas.getSelectedIndex();

        if (index == -1) {
            lblEstado.setText("No hay tarea seleccionada.");
            return;
        }

        modeloLista.remove(index);
        lblEstado.setText("Tarea eliminada.");
    }

    private void cerrarAplicacion() {
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas salir del programa?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorTareas());
    }
}
