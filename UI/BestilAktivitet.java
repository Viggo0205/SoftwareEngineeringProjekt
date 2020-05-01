import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestilAktivitet {



    private JComboBox comboBox1;
    private JPanel panel1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton bestilButton;
    private JLabel NavnAktivitet;
    private JLabel VaelgProj;

    public BestilAktivitet() {
        bestilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Aktivitet er bestilt");
            }
        });
    }

    public static void main(String[] args) {
       JFrame frame = new JFrame("Bestil Aktivitet");
       frame.setContentPane(new BestilAktivitet().panel1);
       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
    }
}
