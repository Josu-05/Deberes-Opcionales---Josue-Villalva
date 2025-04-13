import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblCodigo;
    private JTextArea IMPRESION;

    public Ventana() {

        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Pila pilas = new Pila();
                    String codigo = txtCodigo.getText();

                    StringBuilder impresion = new StringBuilder();

                    for (int i = 0; i <= codigo.length()-1; i++) {
                        char c = codigo.charAt(i);

                        if (c == '(' || c == '{' || c == '[') {
                            pilas.insertar(String.valueOf(c));
                            impresion.append("Insertado: ").append(c).append("\n");

                            IMPRESION.setText(impresion.toString());
                            JOptionPane.showMessageDialog(null, "Elemento ingresado: " + c + "\n" + impresion.toString());
                        } else {
                            if (c == ')') {
                                char salida = pilas.extraer().charAt(0);
                                if (salida != '(') {
                                    JOptionPane.showMessageDialog(null, "Código no balanceado");
                                    return;
                                }

                                impresion.append("Extraído: ").append(')').append("\n");
                                IMPRESION.setText(impresion.toString());
                                JOptionPane.showMessageDialog(null, "Elemento extraído: " + salida + "\n" + impresion.toString());
                            } else {
                                if (c == '}') {
                                    char salida = pilas.extraer().charAt(0);
                                    if (salida != '{') {
                                        JOptionPane.showMessageDialog(null, "Código no balanceado");
                                        return;
                                    }

                                    impresion.append("Extraído: ").append('}').append("\n");
                                    IMPRESION.setText(impresion.toString());
                                    JOptionPane.showMessageDialog(null, "Elemento extraído: " + salida + "\n" + impresion.toString());
                                } else {
                                    if (c == ']') {
                                        char salida = pilas.extraer().charAt(0);
                                        if (salida != '[') {
                                            JOptionPane.showMessageDialog(null, "Código no balanceado");
                                            return;
                                        }

                                        impresion.append("Extraído: ").append(']').append("\n");
                                        IMPRESION.setText(impresion.toString());
                                        JOptionPane.showMessageDialog(null, "Elemento extraído: " + salida + "\n" + impresion.toString());
                                    }
                                }
                            }
                        }

                    }
                    if (pilas.esVacia()) {
                        JOptionPane.showMessageDialog(null, "Código balanceado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código no balanceado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}