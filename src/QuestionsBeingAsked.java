import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class QuestionsBeingAsked extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserInput;
	private JFrame c;
	private int numQuestions;
	private int currentQuestion = 1;
	private int numCorrect = 0;
	private int i;
	private JLabel lblQuestionAsked = new JLabel();
	private String result;
	private Table scoreTable;

	/**
	 * Create the frame.
	 */

	public QuestionsBeingAsked(String title, int number) {
		numQuestions = number;
		c = this;

		final int MAX = 500;

		String[] questions = new String[MAX];

		String[] answers = new String[MAX];

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("Questions.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		int counter = 0;

		String line;
		int count = 0;

		try {
			while ((line = reader.readLine()) != null) {

				questions[count] = line;
				count++;

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		BufferedReader reader2 = null;
		try {
			reader2 = new BufferedReader(new FileReader("Answers.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String line2;
		int count2 = 0;

		try {
			while ((line2 = reader2.readLine()) != null) {

				answers[count2] = line2;
				count2++;

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			reader2.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		if (title.equals("Addition/Subtraction Easy")) {
			i = 0;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(155, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}
		if (title.equals("Addition/Subtraction Hard")) {
			i = 10;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(135, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}
		if (title.equals("Multiplication/Division Easy")) {
			i = 20;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(155, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}
		if (title.equals("Multiplication/Division Hard")) {
			i = 30;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(140, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}
		if (title.equals("Exponents Easy")) {
			i = 40;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(155, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}
		if (title.equals("Exponents Hard")) {
			i = 50;
			lblQuestionAsked.setText(questions[i]);
			lblQuestionAsked.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblQuestionAsked.setBounds(135, 60, 124, 37);
			contentPane.add(lblQuestionAsked);

		}

		textFieldUserInput = new JTextField();
		textFieldUserInput.setBounds(102, 109, 175, 46);
		contentPane.add(textFieldUserInput);
		textFieldUserInput.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					return;
				} else {
					e.consume();
				}
			}
		});
		textFieldUserInput.setColumns(10);

		setTitle(String.valueOf(currentQuestion));

		JButton btnNext4 = new JButton("Next");
		btnNext4.setBounds(124, 167, 117, 29);
		btnNext4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textFieldUserInput.getText().equals("")) {
					if (currentQuestion < numQuestions) {

						if (textFieldUserInput.getText().equals(answers[i])) {
							result = "Correct";
							numCorrect++;
						}
						if (!textFieldUserInput.getText().equals(answers[i])) {
							result = "Wrong";
						}

						++i;
						scoreTable.addResults("" + currentQuestion, result);
						textFieldUserInput.setText("");

						currentQuestion++;
						setTitle(String.valueOf(currentQuestion));
						lblQuestionAsked.setText(questions[i]);

					}

					else {
						if (textFieldUserInput.getText().equals(answers[i])) {
							result = "Correct";
							numCorrect++;
						}
						if (!textFieldUserInput.getText().equals(answers[i])) {
							result = "Wrong";
						}
						scoreTable.addResults("" + currentQuestion, result);
						ScoreScreen frame4 = new ScoreScreen(numCorrect, numQuestions);
						frame4.setVisible(true);
						c.setVisible(false);
					}

				} else {

				}
			}
		});
		contentPane.add(btnNext4);

		scoreTable = new Table();
		scoreTable.setLocationRelativeTo(null);
		scoreTable.setVisible(true);
	}
}
