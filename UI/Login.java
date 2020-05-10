/*
 * Klasse til det første vindue, der bruges til at logge ind
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//
public class Login extends JFrame implements ActionListener {

	private JPanel center;
	private JLabel logLabel;
	private static JTextField logInput;
	private static JButton logInBut;
	public static String initialer;
	public static JLabel bund;

	public static void menu() {
		Login window = new Login();
		window.setTitle("Login til Software Company A/S");
		window.setSize(400, 200);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public Login() {
		getContentPane().setLayout(new BorderLayout());
		
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		center.add(Box.createRigidArea(new Dimension(0,20)));

		logLabel = new JLabel("Log ind med din initialer");
		logLabel.setAlignmentX(CENTER_ALIGNMENT);
		center.add(logLabel);

		center.add(Box.createRigidArea(new Dimension(0,10)));

		// tekst input
		logInput = new JTextField("XXXX");
		logInput.setAlignmentX(CENTER_ALIGNMENT);
		logInput.setMaximumSize( new Dimension( 280, 20 ));
		logInput.addActionListener(this);
		center.add(logInput);

		center.add(Box.createRigidArea(new Dimension(0,10)));

		// knap
		logInBut = new JButton("Log ind");
		logInBut.addActionListener(this);
		logInBut.setAlignmentX(CENTER_ALIGNMENT);
		logInBut.setPreferredSize(new Dimension(100, 25));
		center.add(logInBut);

		center.add(Box.createRigidArea(new Dimension(0,20)));

		getContentPane().add(center, BorderLayout.CENTER);
		bund = new JLabel(" ");
		getContentPane().add(bund, BorderLayout.SOUTH);

	}

	// Action events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logInBut) { 						// knap for at logge ind
			tryLogin();														// *
		} else if(e.getSource()==logInput) { 					// ved tryk på enter for at logge ind
			tryLogin();
		}
	}

	private void tryLogin() {
		initialer = logInput.getText();
		logInput.setEnabled(false);
		logInBut.setEnabled(false);
		
		Communicator.sendLogin(initialer); 			// sender login forespørgsel
		
//		if(Controll.isEmployee(initialer)) { 					// testkode indtil comm virker
//			Controll.loggedIn();								// *
//		} else { 												// *
//			failed();											// *
//		}														// *
	}

	// Ved fejlet login / forkerte initialer
	public static void failed() {
		bund.setText("Forkerte initialer");
		logInput.setEnabled(true);
		logInBut.setEnabled(true);
	}
}
