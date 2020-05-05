import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

	private JPanel center;
	private JLabel logLabel;
	private JTextField logInput;
	private JButton logInBut;
	private boolean employeeStatus;
	public static String initialer;
	private JLabel bund;
	
	public static void menu() {
		Login window = new Login();
		window.setTitle("Login til software company");
		window.setSize(400, 200);
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
		
		logInput = new JTextField("XXXX");
		logInput.setAlignmentX(CENTER_ALIGNMENT);
		logInput.setMaximumSize( new Dimension( 280, 20 ));
		center.add(logInput);
		
		center.add(Box.createRigidArea(new Dimension(0,10)));
		
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
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logInBut) {
			initialer = logInput.getText();
			if(Controll.isEmployee(initialer)) {
				bund.setText("logget ind");
				Controll.loggedIn();
			}
			else 
				bund.setText("Forkerte initialer");
			employeeStatus = Controll.isEmployee(initialer);
		}
		
	}
	// totally changed, pls let me push github
}
