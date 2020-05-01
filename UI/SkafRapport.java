import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkafRapport {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton skafRapportButton;
    private JLabel projekt;
    private JLabel aktivitet;

    public SkafRapport() {
        skafRapportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aktivitet er tildelt");
        frame.setContentPane(new  SkafRapport().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
