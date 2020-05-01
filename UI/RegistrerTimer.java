import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrerTimer {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton registrerTimerButton;
    private JPanel mainPanel;

    public RegistrerTimer() {
        registrerTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Timer er blevet registret");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registrer timer");
        frame.setContentPane(new RegistrerTimer().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
