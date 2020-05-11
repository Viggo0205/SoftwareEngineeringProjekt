import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpretProjekt extends JFrame implements ActionListener  {
	//
	private JPanel mainPanel;
	private JLabel navnPåUdviklingsLeder;
	private JLabel startDatoLabel;
	private JLabel slutDatoLabel;
	private JLabel projektNavnLabel;
	private JComboBox Medarbejdere;
	private JTextField projektNavn;
	private JTextField startUge;
	private JTextField slutUge;
	private JComboBox comboBox2;
	private JButton opretProjektButton;
	private JComboBox comboBox3;
	private JLabel projektLeder;
	private JFrame frame;


	public OpretProjekt() {
		frame = new JFrame("Opret projekt");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		navnPåUdviklingsLeder = new JLabel("Navn på udvikler");
		mainPanel.add(navnPåUdviklingsLeder);
		Medarbejdere = new JComboBox();
		mainPanel.add(Medarbejdere);
		for(int i = 0; i < Controll.medarbejderListe.size(); i++) {
			Medarbejdere.addItem(Controll.medarbejderListe.get(i));
		}

		projektNavnLabel = new JLabel("Projektets navn");
		mainPanel.add(projektNavnLabel);

		projektNavn = new JTextField();
		mainPanel.add(projektNavn);

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
		opretProjektButton.addActionListener(this);
		frame.setSize(200, 500);

	}

	public static void popup() {
		new OpretProjekt();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == opretProjektButton) {
			if(!Controll.isValidDato(startUge.getText())) {
				UserInterface.log.append("Fejl i input af startdato. Format for dato 5. april 2018: 05042018\n");
				startUge.setText("");

			} else if(!Controll.isValidDato(slutUge.getText())) {
				UserInterface.log.append("Fejl i input af slutdato. Format for dato 5. april 2018: 05042018\n");
				slutUge.setText("");
			} else if (!Controll.isDagOrdered(startUge.getText(), slutUge.getText())) {
				UserInterface.log.append("Startdato er efter slutdato. Format for dato 5. april 2018: 05042018\n");
				startUge.setText("");
				slutUge.setText("");
			} else {
				Communicator.sendOpretPro((String) Medarbejdere.getSelectedItem(), startUge.getText(), slutUge.getText(), projektNavn.getText());
				frame.setVisible(false);
				frame.dispose();
			}
		}
	}
}
