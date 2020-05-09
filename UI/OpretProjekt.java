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
	private JLabel projektBeskrivelseLabel;
	private JComboBox Medarbejdere;
	private JTextField projektBeskrivelse;
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
		opretProjektButton.addActionListener(this);
		frame.setSize(200, 500);

	}

	public static void popup() {
		new OpretProjekt();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(startUge.getText());
		System.out.println(slutUge.getText());


		if(e.getSource() == opretProjektButton) {

			try {
				if(startUge.getText().length() != 8 || slutUge.getText().length() != 8 ) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					startUge.setText("");
					slutUge.setText("");
				} else if(Integer.parseInt(startUge.getText().substring(4, 8)) < 1990 || Integer.parseInt(startUge.getText().substring(5, 8)) > 2050) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					startUge.setText("");
				} else if(Integer.parseInt(slutUge.getText().substring(4, 8)) < 1990 || Integer.parseInt(slutUge.getText().substring(5, 8)) > 2050) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					slutUge.setText("");
					
				} else if(Integer.parseInt(startUge.getText().substring(0, 2)) < 1 || Integer.parseInt(startUge.getText().substring(0, 2)) > 31) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					startUge.setText("");
				} else if(Integer.parseInt(slutUge.getText().substring(0, 2)) < 1 || Integer.parseInt(slutUge.getText().substring(0, 2)) > 31) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					slutUge.setText("");
				} else if(Integer.parseInt(startUge.getText().substring(2, 4)) < 1 || Integer.parseInt(startUge.getText().substring(2, 4)) > 12) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					startUge.setText("");
				} else if(Integer.parseInt(slutUge.getText().substring(2, 4)) < 1 || Integer.parseInt(slutUge.getText().substring(2, 4)) > 12) {
					UserInterface.log.append("Fejl i input af dato. Format for dato 5. april 2018: 05042018\n");
					slutUge.setText("");
				} else if()
				
				
				
				
				
				
				else {
					Communicator.sendOpretPro((String) Medarbejdere.getSelectedItem(), projektBeskrivelse.getText(), startUge.getText(), slutUge.getText());
					frame.setVisible(false);
					frame.dispose();
				}

			} catch(NumberFormatException err){
				UserInterface.log.append("Fejl i input. Format for dato 5. april 2018: 05042018\n");
			}

		}


	}
}
