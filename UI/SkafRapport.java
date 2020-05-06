import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkafRapport extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();;
    private JComboBox projekter =new JComboBox();
    private JComboBox aktivitet = new JComboBox();
    private JButton skafRapportButton = new JButton("Skaf Rapport");
    private JLabel projektlabel = new JLabel();
    private JLabel aktivitetlabel=new JLabel();

    public SkafRapport() {
        JFrame frame = new JFrame("Skaf Rapport");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(projektlabel);
        mainPanel.add(projekter);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            projekter.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(aktivitetlabel);
        mainPanel.add(aktivitet);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            aktivitet.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(skafRapportButton);
        skafRapportButton.addActionListener();
        frame.setSize(400, 500);

    }


    public static void popup() {
        new SkafRapport();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
