import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
public class RetTimer extends JFrame implements ActionListener {
    private JLabel LabelDato = new JLabel("Dato");
    private JTextField dato = new JTextField();
    private JLabel TimerLabel = new JLabel("Antal timer");
    private JTextField antalTimer = new JTextField();
    private JButton retTimerButton = new JButton("Ret timer");
    private JPanel mainPanel = new JPanel();
    private JFrame frame;

    public RetTimer() {
        frame = new JFrame("Ret timer");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainPanel.add(LabelDato);
        mainPanel.add(dato);

        mainPanel.add(TimerLabel);
        mainPanel.add(antalTimer);

        mainPanel.add(retTimerButton);
        retTimerButton.addActionListener(this);
        frame.setSize(400, 500);

    }

    public static void popup(){

        new RetTimer();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == retTimerButton) {
    		Communicator.sendRetterTimer(dato.getText(), antalTimer.getText());
    		frame.setVisible(false);
    		frame.dispose();
    	}
    }
}
