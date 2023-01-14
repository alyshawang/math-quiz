import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class MathQuizMainScreen {

	private JFrame mainScreen;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rdbtnAddSub, rdbtnMultDiv, rdbtnExp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathQuizMainScreen window = new MathQuizMainScreen();
					window.mainScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MathQuizMainScreen() {
		initialize();
	}

	private void initialize() {
		mainScreen = new JFrame();
		mainScreen.setBounds(100, 100, 400, 400);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.getContentPane().setLayout(null);

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNext.setBounds(214, 287, 157, 40);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String topic = "";

				if (rdbtnAddSub.isSelected()) {
					topic = "Addition/Subtraction";
				}
				if (rdbtnMultDiv.isSelected()) {
					topic = "Multiplication/Division";
				}
				if (rdbtnExp.isSelected()) {
					topic = "Exponents";
				}
				if (rdbtnAddSub.isSelected() || rdbtnMultDiv.isSelected() || rdbtnExp.isSelected()) {
					DifficultyChooser frame1 = new DifficultyChooser(topic);
					frame1.setVisible(true);
					mainScreen.setVisible(false);
				} else {
					DifficultyChooser frame1 = new DifficultyChooser(topic);
					frame1.setVisible(false);
				}

			}
		});
		mainScreen.getContentPane().add(btnNext);

		JTextArea txtIntroBox = new JTextArea();
		txtIntroBox.setEditable(false);
		txtIntroBox.setText("Welcome!" + "\n" + "\n" + "This is a math quiz" + "\n" + "program designed to test" + "\n"
				+ "you on the following" + " \n" + "math topics shown to the" + "\n" + "right. Each of these topics"
				+ "\n" + "have two difficulty levels" + "\n" + "which you can choose" + "\n" + "from. As well, you can"
				+ "\n" + "customize the number of" + "\n" + "questions asked." + "\n" + "\n" + "Good luck and have fun!");
		txtIntroBox.setBounds(17, 88, 175, 239);
		mainScreen.getContentPane().add(txtIntroBox);

		JLabel lblMathQuiz = new JLabel("MATH QUIZ");
		lblMathQuiz.setFont(new Font("Apple Braille", Font.PLAIN, 25));
		lblMathQuiz.setBounds(130, 33, 157, 35);
		mainScreen.getContentPane().add(lblMathQuiz);

		rdbtnAddSub = new JRadioButton("Addition/Subtraction");
		rdbtnAddSub.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		buttonGroup.add(rdbtnAddSub);
		rdbtnAddSub.setBounds(214, 122, 180, 23);
		mainScreen.getContentPane().add(rdbtnAddSub);

		rdbtnMultDiv = new JRadioButton("Multiplication/Division");
		rdbtnMultDiv.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		buttonGroup.add(rdbtnMultDiv);
		rdbtnMultDiv.setBounds(214, 186, 180, 23);
		mainScreen.getContentPane().add(rdbtnMultDiv);

		rdbtnExp = new JRadioButton("Exponents");
		rdbtnExp.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		buttonGroup.add(rdbtnExp);
		rdbtnExp.setBounds(214, 251, 141, 23);
		mainScreen.getContentPane().add(rdbtnExp);

		JLabel lblTopic = new JLabel("Choose a topic:");
		lblTopic.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		lblTopic.setBounds(214, 79, 175, 35);
		mainScreen.getContentPane().add(lblTopic);
	}
}
