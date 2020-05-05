import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistraerFraemtidigtFravaer extends JFrame implements ActionListener {

    private JLabel startDatoLabel = new JLabel("Start Dato");
    private JTextField startDato = new JTextField();
    private JLabel slutDatoLabel = new JLabel("Slut dato");
    private JTextField slutDato = new JTextField();
    private JButton registrer = new JButton("Registrer");
    private JPanel mainPanel;

    public RegistraerFraemtidigtFravaer()
    {
        JFrame frame = new JFrame("Registrer fraemtidigt fravaer");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainPanel.add(startDatoLabel);
        mainPanel.add(startDato);

        mainPanel.add(slutDatoLabel);
        mainPanel.add(slutDato);

        mainPanel.add(registrer);
        frame.setSize(400, 500);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        new RegistraerFraemtidigtFravaer();
    }
}
