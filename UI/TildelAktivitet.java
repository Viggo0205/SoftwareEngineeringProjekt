import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TildelAktivitet extends JFrame implements ActionListener {
    private JComboBox aktivitet =new JComboBox();
    private JComboBox projekter =new JComboBox();
    public JPanel mainPanel =new JPanel();
    private JButton Tildel = new JButton("Tildel");
    private JLabel aktivitetLabel = new JLabel("Aktivitet");
    private JLabel projektLabel = new JLabel("projekt");

    public TildelAktivitet() {
        JFrame frame = new JFrame("Tildel aktivitet");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(projektLabel);
        mainPanel.add(projekter);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            projekter.addItem(Controll.projektListe[i]);

        }
        projekter.addActionListener(this);

        mainPanel.add(aktivitetLabel);
        mainPanel.add(aktivitet);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            aktivitet.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(Tildel);
        Tildel.addActionListener(this);
        frame.setSize(400,500);
    }

    public static void popup() {
      new TildelAktivitet();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
