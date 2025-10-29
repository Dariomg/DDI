package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class InterfazSWT {

    public static void main(String[] args) {
        // Crear display y ventana principal
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Actividad 1.1 - SWT");
        shell.setSize(300, 200);
        shell.setLayout(null);

        // Etiqueta
        Label label = new Label(shell, SWT.NONE);
        label.setText("Selecciona número de puesto:");
        label.setBounds(20, 20, 200, 20);

        // Lista desplegable (Combo)
        Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        combo.setBounds(20, 50, 200, 25);

        // 🔹 Ajusta los números según tu posición en clase
        combo.add("Puesto 12 (yo)");
        combo.add("Puesto 13 (derecha)");
        combo.add("Puesto 8 (delante)");

        // Botón
        Button boton = new Button(shell, SWT.PUSH);
        boton.setText("Aceptar");
        boton.setBounds(20, 90, 100, 30);

        // Evento del botón
        boton.addListener(SWT.Selection, e -> {
            String seleccionado = combo.getText();
            System.out.println("Has seleccionado: " + seleccionado);
        });

        // Mostrar ventana
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}