import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkafRapport {
    private JPanel mainPanel = new JPanel();;
    private JComboBox Projekt =new JComboBox();
    private JComboBox Aktivitet = new JComboBox();
    private JButton skafRapportButton = new JButton("Skaf Rapport");
    private JLabel projektlabel = new JLabel();
    private JLabel aktivitetlabel=new JLabel();

    public SkafRapport() {
        JFrame frame = new JFrame("Skaf Rapport");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainPanel.add(projektlabel);
        mainPanel.add(Projekt);

        mainPanel.add(aktivitetlabel);
        mainPanel.add(Aktivitet);

        mainPanel.add(skafRapportButton);
        frame.setSize(400, 500);

    }


    public static void main(String[] args) {
        new SkafRapport();

    }
}
