import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpretProjekt {

    private JPanel mainPanel;
    private JLabel slutDatoLabel;
    private JLabel startDatoLabel;
    private JLabel projektBeskrivelseLabel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JButton opretProjektButton;
    private JComboBox comboBox3;
    private JLabel projektLeder;


    public OpretProjekt() {
        opretProjektButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Projekt opretet");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Opret Projekt");
        frame.setContentPane(new OpretProjekt().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
