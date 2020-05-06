/*
 * Klasse til klientens grund-menu
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserInterface extends JFrame implements ActionListener{

	private JButton leAkt1;
	private JButton leAkt2;
	private JButton leAkt3;
	private JButton leAkt4;
	private JButton leAkt5;
	private JButton leAkt6;
	private JButton maAkt1;
	private JButton maAkt2;
	private JButton maAkt3;
	private JButton maAkt4;
	private JButton maAkt5;
	private JButton maAkt6;
	public static String windowWait;
	public static JTextArea log;
	

	public static void menu() {
		UserInterface window = new UserInterface();
		window.setTitle("Software company. Velkommen " + Login.initialer.toUpperCase());
		window.setSize(600, 600);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
	public UserInterface() {
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
		leAkt3 = new JButton("Se ledige udviklere for perioder");
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
//		log = new JTextArea("Dags dato: " + Controll.currentDag.getFormatedDate()); 
		log = new JTextArea("Dags dato: " + "02 92 1032");
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
			// usikker på, om denne skal have popup eller bare tjekke nuværende dag
			/*
			 * Medarbejderen skal enkelt kunne se, 
			 * om han/hun har registreret alle timer
			 * man har arbejdet i dag.
			 */
		}
		if(e.getSource() == maAkt3) {		// Ret registrerede timer
			RetTimer.popup();
		}
		if(e.getSource() == maAkt4) {		// Søg hjælp fra anden udvikler
			windowWait = "maAkt4";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == maAkt5) {		// Opret projekt
			OpretProjekt.popup();
		}
		if(e.getSource() == maAkt6) {		// indmeld brugt tid
			windowWait = "maAkt6";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == leAkt1) {		// Bestil ny aktivitet
			BestilAktvitet.popup();
//			windowWait = "leAkt1";
//			Communicator.sendProjAccess();
			
		}
		if(e.getSource() == leAkt2) {		// Tildel opgaver til udviklere
			// ehm.... rip. Den her kræver en del. Fuld medarb liste??
			windowWait = "leAkt2";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == leAkt3) {		// Se ledige udviklere for perioder
			SeLedigUdvikler.popup();
		}
		if(e.getSource() == leAkt4) {		// Se udvikling af timer på aktivitet
			windowWait = "leAkt4";
			Communicator.sendAktivAccess();
		}
		if(e.getSource() == leAkt5) {		// Skaf rapporter
			windowWait = "leAkt6";
			Communicator.sendProjAccess();
		}
		if(e.getSource() == leAkt6) {		// tom
			
		}
	}


	
}