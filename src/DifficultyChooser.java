import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DifficultyChooser extends JFrame {

	private JPanel contentPane;
	private JFrame a;
	private JTextField textField;
	JComboBox comboBoxDifficultyLevel;
	String text = "";
	String text1 = "";

	
	/**
	 * Create the frame.
	 */
	public DifficultyChooser(String title) {
		a = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 300);

		setTitle(title);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTopicTitle2 = new JLabel(title);
		lblTopicTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopicTitle2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTopicTitle2.setBounds(6, 67, 371, 49);
		contentPane.add(lblTopicTitle2);

		comboBoxDifficultyLevel = new JComboBox();
		comboBoxDifficultyLevel.addItem("");
		comboBoxDifficultyLevel.addItem("Easy");
		comboBoxDifficultyLevel.addItem("Hard");
		comboBoxDifficultyLevel.setBounds(97, 110, 195, 49);
		comboBoxDifficultyLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == comboBoxDifficultyLevel) {
					if (comboBoxDifficultyLevel.getSelectedItem().equals("Easy")) {
						text = "Easy";
					} else if (comboBoxDifficultyLevel.getSelectedItem().equals("Hard")) {
						text = "Hard";
					} else if (comboBoxDifficultyLevel.getSelectedItem().equals("")) {
						text = "";
					}

				}
			}
		});
		contentPane.add(comboBoxDifficultyLevel);

		JButton btnNext2 = new JButton("Next");
		btnNext2.setBounds(134, 178, 117, 29);
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String topic = "";

				if (title.equals("Addition/Subtraction") && text.equals("Easy")) {
					topic = "Addition/Subtraction Easy";
				}
				if (title.equals("Addition/Subtraction") && text.equals("Hard")) {
					topic = "Addition/Subtraction Hard";
				}
				if (title.equals("Multiplication/Division") && text.equals("Easy")) {
					topic = "Multiplication/Division Easy";
				}
				if (title.equals("Multiplication/Division") && text.equals("Hard")) {
					topic = "Multiplication/Division Hard";
				}
				if (title.equals("Exponents") && text.equals("Easy")) {
					topic = "Exponents Easy";
				}
				if (title.equals("Exponents") && text.equals("Hard")) {
					topic = "Exponents Hard";
				}

				if (text.equals("Easy") || (text.equals("Hard"))) {

					NumberOfQuestionChooser frame2 = new NumberOfQuestionChooser(topic);
					frame2.setVisible(true);
					a.setVisible(false);
				}

			}
		});
		contentPane.add(btnNext2);

	}
}
