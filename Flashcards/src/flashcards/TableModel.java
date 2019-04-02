/* 
 * Jason Tressler
 * Flashcards
 * TableModel.java
 * Apr 1, 2019 @ 10:07:31 PM
 */
package flashcards;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    Object[][] data;
    String[] colNames = {"Word", "Definition"};
    
    public TableModel(Object[][] data){
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (rowIndex < 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
