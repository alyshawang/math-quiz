import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NumberOfQuestionChooser extends JFrame {

	private ChangeListener listener;
	private JPanel contentPane;
	private JFrame b;
	public int number;
	private JTextField textFieldNumberQuestions;
	private Table scoreTable;

	public void addSlider(JSlider s, String description) {
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.setBounds(120, 118, 211, 62);
		panel.add(s);
		panel.add(new JLabel(description));
		contentPane.add(panel);
	}

	/**
	 * Create the frame.
	 */
	public NumberOfQuestionChooser(String title) {
		b = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(title);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblTopicTitle2 = new JLabel(title);
		lblTopicTitle2.setBounds(17, 26, 412, 26);
		lblTopicTitle2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblTopicTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTopicTitle2);

		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				JSlider source = (JSlider) event.getSource();
				textFieldNumberQuestions.setText("" + source.getValue());
			}
		};

		JSlider sliderNumQuestions = new JSlider();
		sliderNumQuestions.setMinorTickSpacing(2);
		sliderNumQuestions.setMaximum(10);
		sliderNumQuestions.setMinimum(1);
		sliderNumQuestions.setMajorTickSpacing(9);
		sliderNumQuestions.setPaintTicks(true);
		sliderNumQuestions.setPaintLabels(true);
		addSlider(sliderNumQuestions, "");
		getContentPane().add(contentPane, BorderLayout.CENTER);

		JLabel lblNumberOfQuestions = new JLabel("Number of questions");
		lblNumberOfQuestions.setBounds(158, 91, 244, 26);
		contentPane.add(lblNumberOfQuestions);

		JButton btnNext3 = new JButton("Next");
		btnNext3.setBounds(173, 219, 117, 29);
		btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textFieldNumberQuestions.getText().equals("")) {
					QuestionsBeingAsked frame3 = new QuestionsBeingAsked(title, sliderNumQuestions.getValue());
					frame3.setVisible(true);

					b.setVisible(false);

				} else {

				}

			}
		});
		contentPane.add(btnNext3);

		textFieldNumberQuestions = new JTextField();
		textFieldNumberQuestions.setEditable(false);
		textFieldNumberQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumberQuestions.setBounds(143, 181, 167, 26);
		contentPane.add(textFieldNumberQuestions);

	}

}
