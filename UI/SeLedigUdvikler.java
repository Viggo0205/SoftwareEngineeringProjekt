import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeLedigUdvikler extends JFrame implements ActionListener {
    private JLabel startDatoLabel = new JLabel("Start dato");
    private JTextField startDato = new JTextField();
    private JLabel slutDatoLabel = new JLabel("Slut dato");
    private JTextField slutDato = new JTextField();
    private JButton registrer = new JButton("Se udviklere");
    private JPanel mainPanel;

    public SeLedigUdvikler() {
        JFrame frame = new JFrame("Se ledige udviklere");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(startDatoLabel);
        mainPanel.add(startDato);

        mainPanel.add(slutDatoLabel);
        mainPanel.add(slutDato);

        mainPanel.add(registrer);
        registrer.addActionListener();
        frame.setSize(400, 500);
    }

    public static void popup() {
        new SeLedigUdvikler();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
