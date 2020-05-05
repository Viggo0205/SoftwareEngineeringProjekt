import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestilAktvitet extends JFrame implements ActionListener {

    private JComboBox comboBox1;
    public  JPanel panel1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JTextField textField2;
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
        comboBox2 = new JComboBox();
        panel1.add(comboBox2);


        slutUge = new JLabel("Slut uge");
        panel1.add(slutUge);
        comboBox3 = new JComboBox();
        panel1.add(comboBox3);

        BudgeteretTid = new JLabel("Budgeteret tid");
        panel1.add(BudgeteretTid);
        textField1 = new JTextField();
        panel1.add(textField1);

        bestilButton = new JButton("Bestil Aktivitet");
        panel1.add(bestilButton);

        frame.setPreferredSize(new Dimension(8000,100));
    }

    public static void main(String[] args) {
        new BestilAktvitet();

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bestilButton) {
            
        }



    }
}
