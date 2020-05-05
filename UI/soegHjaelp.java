import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class soegHjaelp extends JFrame implements ActionListener {
    private JLabel DitNavnLabel = new JLabel();
    private JTextField ditNavn = new JTextField();
    private  JLabel spoergsmaalLabel = new JLabel();
    private JTextField spoegsmaal = new JTextField();
    private JLabel navnPaaUdviklerLabel = new JLabel();
    private JTextField navnPaaUdvikler = new JTextField();
    private JButton soegHjaelpButton = new JButton("Soeg hjaelp") ;
    private JPanel mainPanel = new JPanel() ;

    public soegHjaelp() {
        JFrame frame = new JFrame("Soeg hjaelp");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainPanel.add(DitNavnLabel);
        mainPanel.add(ditNavn);

        mainPanel.add(spoergsmaalLabel);
        mainPanel.add(spoegsmaal);

        mainPanel.add(navnPaaUdviklerLabel);
        mainPanel.add(navnPaaUdvikler);

        mainPanel.add(soegHjaelpButton);
        frame.setSize(400, 500);
    }

    public static void main(String[] args) {
        new soegHjaelp();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
