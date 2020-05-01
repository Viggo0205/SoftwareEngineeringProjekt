import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistererFremtidigtFravaer {
    private JLabel StartDato;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton registrerButton;
    private JPanel mainPanel;

    public RegistererFremtidigtFravaer() {
        registrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Fravaer registreret");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fravaers registrering");
        frame.setContentPane(new RegistererFremtidigtFravaer().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
