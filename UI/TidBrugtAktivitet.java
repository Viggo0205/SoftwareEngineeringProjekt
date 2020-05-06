import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TidBrugtAktivitet extends JFrame implements ActionListener{
    private JComboBox projekter = new JComboBox();
    private JComboBox aktivitet =new JComboBox();
    private JButton seTidBrugtButton =new JButton("Se tid brugt");
    private JLabel ProjektLabel =new JLabel();
    private JLabel AktivitetLabel= new JLabel();
    private JPanel mainPanel = new JPanel();

    public TidBrugtAktivitet() {
        JFrame frame = new JFrame("tid Brugt paa akvititet");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        mainPanel.add(ProjektLabel);
        mainPanel.add(projekter);
        for(int i = 0; i < Controll.projektListe.size(); i++) {
            projekter.addItem(Controll.projektListe.get(i));

        }
        projekter.addActionListener(this);

        mainPanel.add(AktivitetLabel);
        mainPanel.add(aktivitet);
        for(int i = 0; i < Controll.choiseAktivListe.size(); i++) {
            aktivitet.addItem(Controll.choiseAktivListe.get(i));
        }

        mainPanel.add(seTidBrugtButton);
        seTidBrugtButton.addActionListener(this);
        frame.setSize(400, 500);
    }

    public static void popup() {
        new TidBrugtAktivitet();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
