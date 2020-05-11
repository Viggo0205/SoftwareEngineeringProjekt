// Skrevet af Rasmus Nyhus - s194285
/*
 * Klasse til klientens grund-menu
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class UserInterface extends JFrame implements ActionListener{

	private static JButton leAkt1;
	private static JButton leAkt2;
	private static JButton leAkt3;
	private static JButton leAkt4;
	private static JButton leAkt5;
	private static JButton leAkt6;
	private static JButton maAkt1;
	private static JButton maAkt2;
	private static JButton maAkt3;
	private static JButton maAkt4;
	private static JButton maAkt5;
	private static JButton maAkt6;
	public static String windowWait;
	public static JTextArea log;
	private static boolean isGrey;

	public static void menu() {
		UserInterface window = new UserInterface();
		window.setTitle("Software company. Velkommen " + Login.initialer.toUpperCase());
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public UserInterface() {
		isGrey = false;
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel medarbAktiv = new JPanel();
		medarbAktiv.setLayout(new GridLayout(2,3));
		medarbAktiv.setBorder(BorderFactory.createLineBorder(Color.black));

		// knapper tilføjes
		maAkt1 = new JButton("Registrer fremtidig fravær");
		maAkt2 = new JButton("Se timer brugt");
		maAkt3 = new JButton("Ret registrerede timer");
		maAkt4 = new JButton("Søg hjælp fra anden udvikler");
		maAkt5 = new JButton("Opret projekt");
		maAkt6 = new JButton("Indmeld timer"); 
		maAkt1.addActionListener(this);
		maAkt2.addActionListener(this);
		maAkt3.addActionListener(this);
		maAkt4.addActionListener(this);
		maAkt5.addActionListener(this);
		maAkt6.addActionListener(this);
		medarbAktiv.add(maAkt1);
		medarbAktiv.add(maAkt2);
		medarbAktiv.add(maAkt3);
		medarbAktiv.add(maAkt4);
		medarbAktiv.add(maAkt5);
		medarbAktiv.add(maAkt6);

		JPanel lederAktiv = new JPanel();
		lederAktiv.setLayout(new BoxLayout(lederAktiv, BoxLayout.Y_AXIS));
		lederAktiv.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel udvText = new JLabel("Udviklerleder aktiviteter");

		JPanel lederBut = new JPanel();
		lederBut.setLayout(new GridLayout(2,3));

		// knapper tilføjes
		leAkt1 = new JButton("Bestil ny aktivitet");
		leAkt2 = new JButton("Tildel opgaver til udviklere");
		leAkt3 = new JButton("Se ledige udviklere for perioder || OoO");leAkt3.setEnabled(false); // OoO
		leAkt4 = new JButton("Se udvikling af timer på aktivitet");
		leAkt5 = new JButton("Skaf rapporter");
		leAkt6 = new JButton("");leAkt6.setEnabled(false); // der er endnu kun behov for 5 knapper
		leAkt1.addActionListener(this);
		leAkt2.addActionListener(this);
		leAkt3.addActionListener(this);
		leAkt4.addActionListener(this);
		leAkt5.addActionListener(this);
		leAkt6.addActionListener(this);
		lederBut.add(leAkt1);
		lederBut.add(leAkt2);
		lederBut.add(leAkt3);
		lederBut.add(leAkt4);
		lederBut.add(leAkt5);
		lederBut.add(leAkt6);

		lederAktiv.add(udvText);
		lederAktiv.add(lederBut);

		// log tekstfelt tilføjes
		log = new JTextArea("Dags dato: " + Controll.currentDag.getFormatedDate() + "\n");
		log.setLineWrap(true);
		log.setEditable(false);
		JScrollPane logScroll = new JScrollPane(log);
		logScroll.setPreferredSize(new Dimension(8000,100));
		logScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		logScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		getContentPane().add(medarbAktiv);
		getContentPane().add(lederAktiv);
		getContentPane().add(logScroll);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == maAkt1) {		// Registrer fremtidig fravær
			RegistraerFraemtidigtFravaer.popup();
		}
		if(e.getSource() == maAkt2) {		// Se timer brugt i dag
			Communicator.sendSeArbejde();			
		}
		if(e.getSource() == maAkt3) {		// Ret registrerede timer
			windowWait = "maAkt3";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == maAkt4) {		// Søg hjælp fra anden udvikler
			windowWait = "maAkt4";
			Communicator.sendMedAktAccess();
		}
		if(e.getSource() == maAkt5) {		// Opret projekt
			windowWait = "maAkt5";
			Communicator.sendMedarbAccess();
		}
		if(e.getSource() == maAkt6) {		// indmeld brugt tid
			windowWait = "maAkt6";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == leAkt1) {		// Bestil ny aktivitet
			windowWait = "leAkt1";
			Communicator.sendProjAccess();
		}
		if(e.getSource() == leAkt2) {		// Tildel opgaver til udviklere
			windowWait = "leAkt2";
			Communicator.sendAktLedMedAccess();
		}
		if(e.getSource() == leAkt3) {		// Se ledige udviklere for perioder
			SeLedigUdvikler.popup();
		}
		if(e.getSource() == leAkt4) {		// Se udvikling af timer på aktivitet
			windowWait = "leAkt4";
			Communicator.sendAktLedAccess();
		}
		if(e.getSource() == leAkt5) {		// Skaf rapporter
			windowWait = "leAkt5";
			Communicator.sendProjAccess();
		}
		if(e.getSource() == leAkt6) {		// tom

		}
	}

	// gør knapperne utilgængelige, da man kun skal sende en besked til serveren ad gangen
	public static void greyOut() {
		if(!isGrey) {
			leAkt1.setEnabled(false);
			leAkt2.setEnabled(false);
			leAkt4.setEnabled(false);
			leAkt5.setEnabled(false);

			maAkt1.setEnabled(false);
			maAkt2.setEnabled(false);
			maAkt3.setEnabled(false);
			maAkt4.setEnabled(false);
			maAkt5.setEnabled(false);
			maAkt6.setEnabled(false);
		}
		isGrey = true;		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(isGrey) {
			log.append("Fejl!!! Intet svar modtaget fra server. Prøv igen eller genstart klien\n");
			greyIn();
		}

	}
	public static void greyIn() {
		if(isGrey) {
			leAkt1.setEnabled(true);
			leAkt2.setEnabled(true);
			leAkt4.setEnabled(true);
			leAkt5.setEnabled(true);

			maAkt1.setEnabled(true);
			maAkt2.setEnabled(true);
			maAkt3.setEnabled(true);
			maAkt4.setEnabled(true);
			maAkt5.setEnabled(true);
			maAkt6.setEnabled(true);
		}
		isGrey = false;
	}
}