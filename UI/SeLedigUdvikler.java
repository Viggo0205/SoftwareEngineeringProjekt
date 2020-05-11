// Skrevet af Victor Tadeusz Ulstrup Olszowski - s194281 og Rasmus Nyhus - s194285

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SeLedigUdvikler extends JFrame implements ActionListener {
	private JLabel startDatoLabel = new JLabel("Start dato");
	private JTextField startDato = new JTextField();
	private JLabel slutDatoLabel = new JLabel("Slut dato");
	private JTextField slutDato = new JTextField();
	private JButton registrer = new JButton("Se udviklere");
	private JPanel mainPanel;
	private JFrame frame;

	public SeLedigUdvikler() {
		frame = new JFrame("Se ledige udviklere");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		mainPanel.add(startDatoLabel);
		mainPanel.add(startDato);

		mainPanel.add(slutDatoLabel);
		mainPanel.add(slutDato);

		mainPanel.add(registrer);
		registrer.addActionListener(this);
		frame.setSize(400, 500);
	}

	public static void popup() {
		new SeLedigUdvikler();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrer) {						// ved klik på knap
																// tjek for ugyldige inputs
			if(!Controll.isValidDato(startDato.getText())) {
				UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
				startDato.setText("");
			} else {											// gyldigt input
				Communicator.sendErLedig(startDato.getText());
				frame.setVisible(false);
				frame.dispose();
			}
		}
	}
}
