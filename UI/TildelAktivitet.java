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
        frame.setVisible(true);

        mainPanel.add(projektLabel);
        mainPanel.add(Projekt);

        mainPanel.add(aktivitetLabel);
        mainPanel.add(Aktivitet);

        mainPanel.add(Tildel);

        frame.setSize(400,500);
    }

    public static void main(String[] args) {
      new TildelAktivitet();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
