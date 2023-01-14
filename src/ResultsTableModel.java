import javax.swing.table.AbstractTableModel;

public class ResultsTableModel extends AbstractTableModel {

	private String results [][] = new String [10][2];
	private int numresults = 0;
	
	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return results [rowIndex][columnIndex];
	}

	public void addRow (String question, String result)
	{
		results [numresults][0] = question;
		results [numresults][1] = result;
		numresults ++;
		fireTableDataChanged();

	}
	
	public String getColumnName(int columnNumber)
	{
		if (columnNumber == 0)
		{
			return "Question";
		}
		if (columnNumber == 1)
		{
			return "Result";
		}
		else 
			return "";
	}
	
	public boolean isCellEditable (int row, int col) {
		return false;
	}
}
