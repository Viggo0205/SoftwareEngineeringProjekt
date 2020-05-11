import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
public class RegistrerTimer extends JFrame implements ActionListener {
	private JLabel ProjektLabel = new JLabel("Projekt");
	private JComboBox projekter = new JComboBox();
	private JLabel aktivitetLabel = new JLabel("Aktivitet");
	private JComboBox aktiviteter =new JComboBox();
	private JLabel datoLabel = new JLabel("Dato");
	private JTextField dato = new JTextField();
	private JLabel timerLabel = new JLabel("Tid brugt i halve timer");
	private JTextField timer = new JTextField();
	private JButton registrerTimerButton = new JButton("Registrer timer");
	private JPanel mainPanel;
	private JFrame frame;

	public RegistrerTimer() {
		frame = new JFrame("Registrer timer");
		mainPanel = new JPanel();
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

		mainPanel.add(aktivitetLabel);
		mainPanel.add(aktiviteter);


		mainPanel.add(datoLabel);
		mainPanel.add(dato);

		mainPanel.add(timerLabel);
		mainPanel.add(timer);

		mainPanel.add(registrerTimerButton);
		registrerTimerButton.addActionListener(this);
		frame.setSize(200, 500);
	}

	public static void popup() { new RegistrerTimer(); }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrerTimerButton) {
			if(!Controll.isValidDato(dato.getText())) {
				UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
				dato.setText("");	
			} else if(Integer.parseInt(timer.getText()) < 0 || Integer.parseInt(timer.getText()) > 1000000 ) {
				UserInterface.log.append("Fejl i antal timer\n");
				timer.setText("");
			} else {
			Communicator.sendIndmeldTid((String)projekter.getSelectedItem(), (String)aktiviteter.getSelectedItem(), dato.getText(), timer.getText());
			frame.setVisible(false);
			frame.dispose();
			}
		} else if(e.getSource() == projekter) {							// valg af projekt skal inds�tte aktiviteter i dropdown
			for( int i = 0; i < aktiviteter.getItemCount();i+=0)			// ryder dropdown
				aktiviteter.removeItemAt(0);							//
			Controll.chooseAktiv(projekter.getSelectedIndex());			// v�lger korrekt liste at tr�kke aktiviteter fra
			for(int i = 0; i < Controll.choiseAktivListe.size(); i++) {	// tr�kker aktiviteter og inds�tter i dropdown
				aktiviteter.addItem(Controll.choiseAktivListe.get(i));
			}
		}
	}
}
