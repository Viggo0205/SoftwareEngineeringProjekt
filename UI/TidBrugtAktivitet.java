import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TidBrugtAktivitet {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton seTidBrugtButton;
    private JLabel Projekt;
    private JLabel Aktivitet;
    private JPanel mainPanel;

    public TidBrugtAktivitet() {
        seTidBrugtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tid brugt paa aktivitet");
        frame.setContentPane(new TidBrugtAktivitet().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
