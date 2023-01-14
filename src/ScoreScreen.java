import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ScoreScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ScoreScreen(int numCorrect, int numQuestions) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResults = new JLabel(numCorrect + " / " + numQuestions);
		lblResults.setBounds(211, 130, 61, 16);
		contentPane.add(lblResults);

		JLabel lblScore = new JLabel("Your score is ");
		lblScore.setBounds(187, 78, 206, 16);
		contentPane.add(lblScore);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(170, 186, 117, 29);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		contentPane.add(btnClose);
	}
}
