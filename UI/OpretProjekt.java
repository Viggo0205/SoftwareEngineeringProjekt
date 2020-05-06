import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpretProjekt extends JFrame implements ActionListener  {

    private JPanel mainPanel;
    private JLabel navnPåUdviklingsLeder;
    private JLabel startDatoLabel;
    private JLabel slutDatoLabel;
    private JLabel projektBeskrivelseLabel;
    private JComboBox Medarbejdere;
    private JTextField projektBeskrivelse;
    private JTextField startUge;
    private JTextField slutUge;
    private JComboBox comboBox2;
    private JButton opretProjektButton;
    private JComboBox comboBox3;
    private JLabel projektLeder;


    public OpretProjekt() {
        JFrame frame = new JFrame("Opret projekt");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        navnPåUdviklingsLeder = new JLabel("Navn paa udvikler");
        mainPanel.add(navnPåUdviklingsLeder);
        Medarbejdere = new JComboBox();
        mainPanel.add(Medarbejdere);

        projektBeskrivelseLabel = new JLabel("Projekt Beksrivelse");
        mainPanel.add(projektBeskrivelseLabel);

        projektBeskrivelse = new JTextField();
        mainPanel.add(projektBeskrivelse);

        startDatoLabel = new JLabel("Start dato");
        mainPanel.add(startDatoLabel);
        startUge = new JTextField();
        mainPanel.add(startUge);

        slutDatoLabel = new JLabel("Slut dato");
        mainPanel.add(slutDatoLabel);
        slutUge = new JTextField();
        mainPanel.add(slutUge);

        opretProjektButton = new JButton("Opret Projekt");
        mainPanel.add(opretProjektButton);
        opretProjektButton.addActionListener();
        frame.setSize(200, 500);

    }

    public static void popup() {
       new OpretProjekt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
