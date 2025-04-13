import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JButton btnInsertar;
    private JButton btnExtraer;
    private JTextArea txtListado;
    private JLabel lblEtiqueta;
    private JTextField txtDato;
    private JButton btnDevolver;
    private Pila coleccion=new Pila();

    public Ventana(){

        btnInsertar.addActionListener(new ActionListener() {
            int contador = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (contador < 10) {
                        coleccion.insertar(txtDato.getText());
                        contador++;
                        txtListado.setText(coleccion.toString());
                    } else {
                        throw new IllegalArgumentException("Unicamente se pueden poner 10 objetos");
                    }
                }catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnExtraer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eliminado=coleccion.extraer();
                JOptionPane.showMessageDialog(null,"Se elimino: "+eliminado);
                txtListado.setText(coleccion.toString());
            }
        });
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String extraido =coleccion.cima();
                JOptionPane.showMessageDialog(null, "Objeto extraido: "+extraido);
                txtListado.setText(coleccion.toString());
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
