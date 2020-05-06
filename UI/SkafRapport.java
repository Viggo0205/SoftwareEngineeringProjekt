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

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(projektlabel);
        mainPanel.add(projekter);
        for(int i = 0; i < Controll.projektListe.size(); i++) {
            projekter.addItem(Controll.projektListe.get(i));

        }
        projekter.addActionListener(this);

        mainPanel.add(aktivitetlabel);
        mainPanel.add(aktivitet);
        for(int i = 0; i < Controll.choiseAktivListe.size(); i++) {
            aktivitet.addItem(Controll.choiseAktivListe.get(i));

        }

        mainPanel.add(skafRapportButton);
        skafRapportButton.addActionListener(this);
        frame.setSize(400, 500);

    }


    public static void popup() {
        new SkafRapport();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
