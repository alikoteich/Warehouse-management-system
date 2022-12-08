package modelsPackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EmployeeModel extends AbstractTableModel {

    ArrayList<Employee> rows;
    String[] headers;

    public EmployeeModel(ArrayList<Employee> rows, String[] headers) {
        this.rows = rows;
        this.headers = headers;
    }
    
    public boolean addRow(Employee e){
        boolean check = false;
        for(int i = 0; i < rows.size(); i++){
            if(rows.get(i).getId() == e.getId())
                check = true;
        }
        if(check == false){
            rows.add(e);
            this.fireTableDataChanged();
            return true;
        }
        return false;
    }
    
    public boolean removeRow(int id){
        for(int i = 0; i < rows.size(); i++){
            if(rows.get(i).getId() == id){
                rows.remove(rows.get(i));
                return true;
            }
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
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return rows.get(r).getId();
            case 1:
                return rows.get(r).getFirstName();
            case 2:
                return rows.get(r).getLastName();
            case 3:
                return rows.get(r).getAge();
            case 4:
                return rows.get(r).getSalary();
            case 5:
                return rows.get(r).getPosition();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    public void setRowCount(int i) {
        while(rows.size() > i){
            rows.remove(rows.size() - 1);
        }
    }
}
