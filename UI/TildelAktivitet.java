import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TildelAktivitet extends JFrame implements ActionListener {
    private JComboBox Aktivitet =new JComboBox();
    private JComboBox Projekt =new JComboBox();
    public JPanel mainPanel =new JPanel();
    private JButton Tildel = new JButton("Tildel");
    private JLabel aktivitetLabel = new JLabel("Aktivitet");
    private JLabel projektLabel = new JLabel("projekt");

    public TildelAktivitet() {
        JFrame frame = new JFrame("Tildel aktivitet");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(projektLabel);
        mainPanel.add(Projekt);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            Projekt.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(aktivitetLabel);
        mainPanel.add(Aktivitet);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            Aktivitet.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(Tildel);
        Tildel.addActionListener();
        frame.setSize(400,500);
    }

    public static void popup() {
      new TildelAktivitet();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
