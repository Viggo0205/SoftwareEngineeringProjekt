import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TidBrugtAktivitet {
    private JComboBox Projekt = new JComboBox();
    private JComboBox aktivitet =new JComboBox();
    private JButton seTidBrugtButton =new JButton("Se tid brugt");
    private JLabel ProjektLabel =new JLabel();
    private JLabel AktivitetLabel= new JLabel();
    private JPanel mainPanel = new JPanel();

    public TidBrugtAktivitet() {
        JFrame frame = new JFrame("tid Brugt paa akvititet");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        mainPanel.add(ProjektLabel);
        mainPanel.add(Projekt);

        mainPanel.add(AktivitetLabel);
        mainPanel.add(aktivitet);

        mainPanel.add(seTidBrugtButton);
        frame.setSize(400, 500);
    }

    public static void main(String[] args) {
        new TidBrugtAktivitet();
    }
}
