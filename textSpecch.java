package textSpeech;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class textSpecch extends JFrame {

	private JPanel contentPane;
	private JTextField txtYourTextGoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textSpecch frame = new textSpecch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public textSpecch() {
		setTitle("Speak Until The Dust");
		setIconImage(Toolkit.getDefaultToolkit().getImage(textSpecch.class.getResource("/Jampack/Doc/images/blue-ball.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextToSpeech = new JLabel("TEXT TO SPEECH ");
		lblTextToSpeech.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTextToSpeech.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextToSpeech.setBounds(94, 28, 244, 14);
		contentPane.add(lblTextToSpeech);
		
		txtYourTextGoes = new JTextField();
		txtYourTextGoes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtYourTextGoes.setBackground(Color.WHITE);
		txtYourTextGoes.setForeground(Color.DARK_GRAY);
		txtYourTextGoes.setText("Your Text Goes Here !");
		txtYourTextGoes.setBounds(10, 72, 398, 55);
		contentPane.add(txtYourTextGoes);
		txtYourTextGoes.setColumns(10);
		
		JButton btnSpeech = new JButton("Speech");
		btnSpeech.setBackground(Color.WHITE);
		btnSpeech.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpeech.setToolTipText("Speech Initialiser");
		btnSpeech.setForeground(Color.DARK_GRAY);
		btnSpeech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comment=txtYourTextGoes.getText();
				TextToSpeech.say(comment);
			}
		});
		btnSpeech.setBounds(152, 161, 125, 39);
		contentPane.add(btnSpeech);
	}
}
