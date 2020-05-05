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
	private String windowWait;
	
//	public static void main(String[] args) {
//		menu();
//	}

	public static void menu() {
		UserInterface window = new UserInterface();
		window.setTitle("Software company. Velkommen " + Login.initialer);
		window.setSize(600, 600);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	
	public UserInterface() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		
		JPanel medarbAktiv = new JPanel();
		medarbAktiv.setLayout(new GridLayout(2,3));
		medarbAktiv.setBorder(BorderFactory.createLineBorder(Color.black));
		
		maAkt1 = new JButton("Bestil ny aktivitet");
		maAkt2 = new JButton("Tildel opgaver til udviklere");
		maAkt3 = new JButton("akt 3");
		maAkt4 = new JButton("akt 4");
		maAkt5 = new JButton("akt 5");
		maAkt6 = new JButton("akt 6");
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
		
		leAkt1 = new JButton("akt 1");
		leAkt2 = new JButton("akt 2");
		leAkt3 = new JButton("akt 3");
		leAkt4 = new JButton("akt 4");
		leAkt5 = new JButton("akt 5");
		leAkt6 = new JButton("akt 6");
		lederBut.add(leAkt1);
		lederBut.add(leAkt2);
		lederBut.add(leAkt3);
		lederBut.add(leAkt4);
		lederBut.add(leAkt5);
		lederBut.add(leAkt6);
		
		lederAktiv.add(udvText);
		lederAktiv.add(lederBut);
		
		JTextArea log = new JTextArea("Hvis det er din tur, kan du vælge et af dine kort på hånden og herefter den ingrediens, man vil battle med. Din modstander kan så vælge et kort fra sin hånd at kæmpe tilbage med. Her vinder den person der har flest gram af den givne ingrediens");
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
		if(e.getSource() == maAkt1) {
			Communicator.sendProjAccess();
			windowWait = "maAkt1";
//			Communicator.sendOpretAktiv("1234", "5", "50", "", "");
		}
		if(e.getSource() == maAkt2) {
			
		}
		if(e.getSource() == maAkt3) {
			
		}
		if(e.getSource() == maAkt4) {
			
		}
		if(e.getSource() == maAkt5) {
			
		}
		if(e.getSource() == maAkt6) {
			
		}
		if(e.getSource() == leAkt1) {
			//OpretProjekt.init();
		}
		if(e.getSource() == leAkt2) {
			
		}
		if(e.getSource() == leAkt3) {
			
		}
		if(e.getSource() == leAkt4) {
			
		}
		if(e.getSource() == leAkt5) {
			
		}
		if(e.getSource() == leAkt6) {
			
		}

		
	}
	
}