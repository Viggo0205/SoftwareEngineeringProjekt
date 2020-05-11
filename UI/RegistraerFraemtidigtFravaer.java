import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//

public class RegistraerFraemtidigtFravaer extends JFrame implements ActionListener {

	private JLabel startDatoLabel = new JLabel("Start Dato");
	private JTextField startDato = new JTextField();
	private JLabel slutDatoLabel = new JLabel("Slut dato");
	private JTextField slutDato = new JTextField();
	private JButton registrer = new JButton("Registrer");
	private JPanel mainPanel;
	private JFrame frame;

	public RegistraerFraemtidigtFravaer()
	{
		frame = new JFrame("Registrer fraemtidigt fravaer");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrer) {
			if(!Controll.isValidDato(startDato.getText())) {
				UserInterface.log.append("Fejl i input af startdato. Format for dato 5. april 2018: 05042018\n");
				startDato.setText("");

			} else if(!Controll.isValidDato(slutDato.getText())) {
				UserInterface.log.append("Fejl i input af slutdato. Format for dato 5. april 2018: 05042018\n");
				slutDato.setText("");
				
			} else if (!Controll.isDagOrdered(startDato.getText(), slutDato.getText())) {
				UserInterface.log.append("Startdato er efter slutdato. Format for dato 5. april 2018: 05042018\n");
				startDato.setText("");
				slutDato.setText("");
			} else if(Integer.parseInt(startDato.getText().substring(4, 8)) !=  Integer.parseInt(slutDato.getText().substring(4, 8))) {
				UserInterface.log.append("Ferie kan kun registreres for et år ad gangen.\n");
			} else {
				Communicator.sendRegistrerFerie(startDato.getText(),slutDato.getText());
				frame.setVisible(false);
				frame.dispose();
			}
		}
	}

	public static void popup() {
		new RegistraerFraemtidigtFravaer();
	}
}
