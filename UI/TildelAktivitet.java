import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TildelAktivitet {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    public JPanel mainPanel;
    private JButton Tildel;

    public TildelAktivitet() {
        Tildel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Aktivitet er tildelt");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tildel aktivitet");
        frame.setContentPane(new TildelAktivitet().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
