import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    String[] coulmms = {"this",
                        "is", 
                        "a", 
                        "test"};
    Object[][] rows = {
        {"Hello", "World"}, 
        {"palindrome", "tacocat"}, 
        {"god", "I", "hope", "this", "works"}
    };

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return coulmms.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        rows[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
}
