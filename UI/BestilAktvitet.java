import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestilAktvitet extends JFrame implements ActionListener {

    private JComboBox comboBox1;
    public  JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField NavnTextField;
    private JButton bestilButton;
    private JLabel Beskrivelse;
    private JLabel NavnAktivitet;
    private JLabel VaelgProj;
    private JLabel startUge;
    private JLabel slutUge;
    private JLabel BudgeteretTid;
    public  JFrame frame = new JFrame("Bestil Aktivitet");

    public BestilAktvitet()
    {

        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        frame.add(panel1);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        NavnAktivitet = new JLabel("Navn paa Aktivitet");
        panel1.add(NavnAktivitet);
        NavnTextField = new JTextField();
        panel1.add(NavnTextField);

        VaelgProj = new JLabel("Vaelg projekt");
        panel1.add(VaelgProj);

        comboBox1 = new JComboBox();
        panel1.add(comboBox1);

        Beskrivelse = new JLabel("Beskrivelse af aktivitet");
        panel1.add(Beskrivelse);

        textField2 = new JTextField();
        panel1.add(textField2);

        startUge = new JLabel("Start Uge");
        panel1.add(startUge);
        textField3 = new JTextField();
        panel1.add(textField3);


        slutUge = new JLabel("Slut uge");
        panel1.add(slutUge);
        textField4 = new JTextField();
        panel1.add(textField4);

        BudgeteretTid = new JLabel("Budgeteret tid");
        panel1.add(BudgeteretTid);
        textField1 = new JTextField();
        panel1.add(textField1);

        bestilButton = new JButton("Bestil Aktivitet");
        panel1.add(bestilButton);

        frame.setSize(200, 500);
    }

    public static void main(String[] args) {
        new BestilAktvitet();

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bestilButton) {

        }



    }
}
