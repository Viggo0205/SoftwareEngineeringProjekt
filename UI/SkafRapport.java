// Skrevet af Victor Tadeusz Ulstrup Olszowski - s194281 og Rasmus Nyhus - s194285

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
@SuppressWarnings("serial")
public class SkafRapport extends JFrame implements ActionListener {
	private JPanel mainPanel = new JPanel();;
	private JComboBox projekter =new JComboBox();
	private JButton skafRapportButton = new JButton("Skaf Rapport");
	private JLabel projektlabel = new JLabel();
	private JFrame frame;

	public SkafRapport() {
		frame = new JFrame("Skaf Rapport");

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		mainPanel.add(projektlabel);
		mainPanel.add(projekter);
		for( int i = 0; i < projekter.getItemCount();i+=0)			// ryder dropdown
			projekter.removeItemAt(0);	
		for(int i = 0; i < Controll.projektListe.size(); i++) {
			projekter.addItem(Controll.projektListe.get(i));
		}
		projekter.addActionListener(this);

		mainPanel.add(skafRapportButton);
		skafRapportButton.addActionListener(this);
		frame.setSize(400, 500);
	}

	public static void popup() {
		new SkafRapport();

	}
	// Metode skrevet af Rasmus Nyhus - s194285
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == skafRapportButton) {				// ved klik på knap
			frame.setVisible(false);
			frame.dispose();
			Communicator.sendSkafRapport((String)projekter.getSelectedItem());
		}
	}
}
