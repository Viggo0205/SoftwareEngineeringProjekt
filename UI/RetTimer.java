import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetTimer {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel LabelDato;
    private JLabel LabelTimerBrugt;
    private JButton retTimerButton;
    private JPanel mainPanel;

    public RetTimer() {
        retTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Timer er blevet rettet");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ret timer");
        frame.setContentPane(new RetTimer().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
