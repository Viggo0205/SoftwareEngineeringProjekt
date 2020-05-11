// Skrevet af Victor Tadeusz Ulstrup Olszowski - s194281 og Rasmus Nyhus - s194285

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
@SuppressWarnings("serial")
public class TildelAktivitet extends JFrame implements ActionListener {
    private JComboBox aktivitet =new JComboBox();
    private JComboBox projekter =new JComboBox();
    private JComboBox medarbejdere = new JComboBox();
    public JPanel mainPanel =new JPanel();
    private JButton tildel = new JButton("Tildel");
    private JLabel aktivitetLabel = new JLabel("Aktivitet");
    private JLabel projektLabel = new JLabel("projekt");
    private JLabel medarbejderLabel = new JLabel("Medarbejder");
    private JFrame frame;

    public TildelAktivitet() {
        frame = new JFrame("Tildel aktivitet");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(projektLabel);
        mainPanel.add(projekter);
        for( int i = 0; i < projekter.getItemCount();i+=0)			// ryder dropdown
        	projekter.removeItemAt(0);
        for(int i = 0; i < Controll.projektListe.size(); i++) {
            projekter.addItem(Controll.projektListe.get(i));
        }
        projekter.addActionListener(this);

        mainPanel.add(aktivitetLabel);
        mainPanel.add(aktivitet);
        
        mainPanel.add(medarbejderLabel);
        mainPanel.add(medarbejdere);
        for( int i = 0; i < medarbejdere.getItemCount();i+=0)			// ryder dropdown
        	medarbejdere.removeItemAt(0);
        for(int i = 0; i < Controll.medarbejderListe.size(); i++) {
        	medarbejdere.addItem(Controll.medarbejderListe.get(i));
        }

        mainPanel.add(tildel);
        tildel.addActionListener(this);
        frame.setSize(400,500);
    }

    public static void popup() {
      new TildelAktivitet();
      
    }

    // Metode skrevet af Rasmus Nyhus - s194285
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == tildel) {							// ved klik på knap
			Communicator.sendSoegHjaelp((String) projekter.getSelectedItem(), (String)aktivitet.getSelectedItem(), (String)medarbejdere.getSelectedItem());
			frame.setVisible(false);
			frame.dispose();
		} else if (e.getSource() == projekter) {				// ved valg af projekt
			for( int i = 0; i < aktivitet.getItemCount();i+=0)
				aktivitet.removeItemAt(0);
			Controll.chooseAktiv(projekter.getSelectedIndex());
			for(int i = 0; i < Controll.choiseAktivListe.size(); i++) {
				aktivitet.addItem(Controll.choiseAktivListe.get(i));
			}
		}
    }
}
