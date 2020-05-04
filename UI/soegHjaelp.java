import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class soegHjaelp {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton soegHjaelpButton;
    private JPanel mainPanel;

    public soegHjaelp() {
        soegHjaelpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Soeg Hjaelp");
        frame.setContentPane(new soegHjaelp().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
