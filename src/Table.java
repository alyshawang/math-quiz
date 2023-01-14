import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;


public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ResultsTableModel model;

	/**
	 * Create the frame.
	 */
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    model = new ResultsTableModel();
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addResults(String question, String result) {
		model.addRow(question, result);
	}

}
