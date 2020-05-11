// Skrevet af Victor Tadeusz Ulstrup Olszowski - s194281 og Rasmus Nyhus - s194285

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BestilAktvitet extends JFrame implements ActionListener {

	private JComboBox projekter;
	public  JPanel panel1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField NavnTextField;
	private JButton bestilButton;
	private JLabel NavnAktivitet;
	private JLabel VaelgProj;
	private JLabel startUge;
	private JLabel slutUge;
	private JLabel BudgeteretTid;
	private JFrame frame;
	private String[] startUgeInput = new String[]{"",""};
	private String[] slutUgeInput = new String[]{"",""};


	// Metode der laver selve UI til BestilAktivitet popupen.
	public BestilAktvitet()
	{

		System.out.println(startUgeInput[0] + "  " + startUgeInput[1]);
		System.out.println(slutUgeInput[0] + "  " + slutUgeInput[1]);
		frame = new JFrame("Bestil aktivitet");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		frame.add(panel1);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		NavnAktivitet = new JLabel("Navn på Aktivitet");
		panel1.add(NavnAktivitet);
		NavnTextField = new JTextField();
		panel1.add(NavnTextField);

		VaelgProj = new JLabel("Vælg projekt");
		panel1.add(VaelgProj);

		projekter = new JComboBox();
		panel1.add(projekter);
		for(int i = 0; i < Controll.projektListe.size(); i++) {
			projekter.addItem(Controll.projektListe.get(i));
		}
		projekter.addActionListener(this);

		startUge = new JLabel("Start Uge");
		panel1.add(startUge);
		textField3 = new JTextField();
		panel1.add(textField3);


		slutUge = new JLabel("Slut uge");
		panel1.add(slutUge);
		textField4 = new JTextField();
		panel1.add(textField4);

		BudgeteretTid = new JLabel("Budgeteret tid i halve timer");
		panel1.add(BudgeteretTid);
		textField1 = new JTextField();
		panel1.add(textField1);

		bestilButton = new JButton("Bestil Aktivitet");
		bestilButton.addActionListener(this);
		panel1.add(bestilButton);

		frame.setSize(200, 500);
	}

	public static void popup() {
		new BestilAktvitet();

	}

	// Metode skrevet af Rasmus Nyhus - s194285
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bestilButton) {						// ved klik på knap
			// tjek for diverse fejl af input
			if(!Controll.isValidWeek(textField3.getText()) ) {
				UserInterface.log.append("Fejl i input af startuge. Format for uge 5 i år 2018: 2018.5\n");
				textField3.setText("");
			} else if (!Controll.isValidWeek(textField4.getText())) {
				UserInterface.log.append("Fejl i input af slutuge. Format for uge 5 i år 2018: 2018.5\n");
				textField4.setText("");
			} else if(!Controll.isWeekOrdered(textField3.getText(),textField4.getText() )) {
				UserInterface.log.append("Startuge er efter slutuge. Format for uge 5 i år 2018: 2018.5\n");
				textField3.setText("");
				textField4.setText("");
			} else if(Integer.parseInt(textField1.getText()) < 0 || Integer.parseInt(textField1.getText()) > 1000000 ) {
				UserInterface.log.append("Fejl i antal timer\n");
				textField1.setText("");
			} else {											// gyldige inputs
				System.out.println("good");
				Communicator.sendOpretAktiv((String) projekter.getSelectedItem(),textField3.getText(),textField4.getText(),textField1.getText(),NavnTextField.getText());
				System.out.println("knap trykket");
				frame.setVisible(false);
				frame.dispose();
			}
		}
	}
}
