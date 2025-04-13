import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboModelo;
    private JTextField txtAnio;
    private JButton btnAgregar;
    private JButton btnDesencolar;
    private JTextArea txtListarAutos;
    private JLabel lblMensaje;
    private ColaAutos listaAutos = new ColaAutos();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String modelo = cboModelo.getSelectedItem().toString();
                    int anio = Integer.parseInt(txtAnio.getText());

                    if(txtAnio.bounds().isEmpty()){
                        throw new Exception("El año no puede estar vacio");
                    }

                    if(anio < 0){
                        throw new Exception("El año no puede ser negativo");
                    }

                    if(anio > 2025){
                        throw new Exception("El año no puede ser mayor a 2025");
                    }

                    listaAutos.encolar(new Auto(modelo, anio));
                    txtListarAutos.setText(listaAutos.listarAutos());
                    JOptionPane.showMessageDialog(null,"El auto se agrego al carrito");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"El debe ser un numero valido");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Auto autox = listaAutos.desencolar();
                    int antiguedad = 2025 - autox.getAnio();
                    int totalPagar = 50 + (antiguedad * 50);
                    txtListarAutos.setText(listaAutos.listarAutos());
                    lblMensaje.setText("Auto atendido " + autox + "Debe pagar: " + totalPagar );
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
