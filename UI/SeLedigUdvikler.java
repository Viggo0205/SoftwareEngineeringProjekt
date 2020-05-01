import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeLedigUdvikler {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton seLedigeUdviklereButton;
    private JPanel panel1;

    public SeLedigUdvikler() {
        seLedigeUdviklereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Aktivitet er bestilt");
            }
        });
    }

    public static void main(String[] args) {
        JFrame seUdviklere = new JFrame("Ledige udviklere");
        seUdviklere.setContentPane(new SeLedigUdvikler().panel1);
        seUdviklere.setDefaultCloseOperation(seUdviklere.EXIT_ON_CLOSE);
        seUdviklere.pack();
        seUdviklere.setVisible(true);
    }
}
