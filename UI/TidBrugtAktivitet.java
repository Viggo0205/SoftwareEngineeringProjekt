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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        mainPanel.add(ProjektLabel);
        mainPanel.add(Projekt);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            Projekt.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(AktivitetLabel);
        mainPanel.add(aktivitet);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            aktivitet.addItem(Controll.projektListe[i]);
        }

        mainPanel.add(seTidBrugtButton);
        seTidBrugtButton.addActionListener();
        frame.setSize(400, 500);
    }

    public static void popup() {
        new TidBrugtAktivitet();
    }
}
