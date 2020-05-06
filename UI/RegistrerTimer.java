import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrerTimer extends JFrame implements ActionListener {
    private JLabel ProjektLabel = new JLabel("Projekt");
    private JComboBox projekt = new JComboBox();
    private JLabel aktivitetLabel = new JLabel("Aktivitet");
    private JComboBox aktiviteter =new JComboBox();
    private JLabel datoLabel = new JLabel("Dato");
    private JTextField dato = new JTextField();
    private JLabel timerLabel = new JLabel("Timer brugt");
    private JTextField timer = new JTextField();
    private JButton registrerTimerButton = new JButton("Registrer timer");
    private JPanel mainPanel;

    public RegistrerTimer() {
        JFrame frame = new JFrame("Registrer timer");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        mainPanel.add(ProjektLabel);
        mainPanel.add(projekt);
        for(int i = 0; i < Controll.projektListe.length; i++) {
            projekt.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(aktivitetLabel);
        mainPanel.add(aktiviteter);
        for(int i = 0; i < Controll.projektListe.length; i++) {
           aktiviteter.addItem(Controll.projektListe[i]);

        }

        mainPanel.add(datoLabel);
        mainPanel.add(dato);

        mainPanel.add(timerLabel);
        mainPanel.add(timer);

        mainPanel.add(registrerTimerButton);
        registrerTimerButton.addActionListener();
        frame.setSize(200, 500);
    }

    public static void popup() { new RegistrerTimer(); }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
