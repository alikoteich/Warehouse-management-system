package modelsPackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceModel extends AbstractTableModel {

    ArrayList<Invoice> rows;
    String[] headers;

    public InvoiceModel(ArrayList<Invoice> rows, String[] headers) {
        this.rows = rows;
        this.headers = headers;
    }
    
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    public boolean addRow(Invoice iv){
        boolean check = false;
        for(int i = 0; i < rows.size(); i++){
            if(rows.get(i).getId() == iv.getId())
                check = true;
        }
        if(check == false){
            rows.add(iv);
            this.fireTableDataChanged();
            return true;
        }
        return false;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return rows.get(i).getId();
            case 1:
                return rows.get(i).getEmployeeID();
            case 2:
                return rows.get(i).getTotalPrice();
            case 3:
                return rows.get(i).getDateSold();
            default:
                return null;
        }
    }
    
    public void setRowCount(int i) {
        while(rows.size() > i){
            rows.remove(rows.size() - 1);
        }
    }

}
