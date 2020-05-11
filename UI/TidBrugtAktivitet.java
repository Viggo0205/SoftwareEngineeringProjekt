// Skrevet af Victor Tadeusz Ulstrup Olszowski - s194281 og Rasmus Nyhus - s194285

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TidBrugtAktivitet extends JFrame implements ActionListener{
	private JComboBox projekter = new JComboBox();
	private JComboBox aktivitet = new JComboBox();
	private JButton seTidBrugtButton = new JButton("Se tid brugt");
	private JLabel ProjektLabel = new JLabel();
	private JLabel AktivitetLabel = new JLabel();
	private JPanel mainPanel = new JPanel();
	private JFrame frame;

	public TidBrugtAktivitet() {
		frame = new JFrame("tid Brugt paa akvititet");

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		mainPanel.add(ProjektLabel);
		mainPanel.add(projekter);
		for( int i = 0; i < projekter.getItemCount();i+=0)			// ryder dropdown
			projekter.removeItemAt(0);
		for(int i = 0; i < Controll.projektListe.size(); i++) {
			projekter.addItem(Controll.projektListe.get(i));
		}
		projekter.addActionListener(this);

		mainPanel.add(AktivitetLabel);
		mainPanel.add(aktivitet);

		mainPanel.add(seTidBrugtButton);
		seTidBrugtButton.addActionListener(this);
		frame.setSize(400, 500);
	}

	public static void popup() {
		new TidBrugtAktivitet();

	}

	// Metode skrevet af Rasmus Nyhus - s194285
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == seTidBrugtButton) {					// ved klik p� knap
			Communicator.sendTidsbrug((String) projekter.getSelectedItem(), (String) aktivitet.getSelectedItem());
			frame.setVisible(false);
			frame.dispose();
		} else if(e.getSource() == projekter) {						// ved valg af projekt
			for( int i = 0; i < aktivitet.getItemCount();i++)
				aktivitet.removeItemAt(0);
			Controll.chooseAktiv(projekter.getSelectedIndex());
			for( int i = 0; i < aktivitet.getItemCount();i+=0)
				aktivitet.removeItemAt(0);
			for(int i = 0; i < Controll.choiseAktivListe.size(); i++) {
				aktivitet.addItem(Controll.choiseAktivListe.get(i));
			}
		}
	}
}
