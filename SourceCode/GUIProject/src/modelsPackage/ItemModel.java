package modelsPackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ItemModel extends AbstractTableModel {
    
    private ArrayList<Item> rows;
    private String[] headers;
    private String type;

    public ItemModel(ArrayList<Item> rows, String[] headers, String type) {
        this.rows = rows;
        this.headers = headers;
        this.type = type;
    }
    
    public boolean addRow(Item it){
        boolean check = false;
        for(int i = 0; i < rows.size(); i++){
            if(rows.get(i).getId() == it.getId())
                check = true;
        }
        if(check == false){
            rows.add(it);
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
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        if(i1 == 0)
            return rows.get(i).getId();
        if(i1 == 1)
            return rows.get(i).getName();
        if(i1 == 2)
            return rows.get(i).getBrand();
        if(type.equals("Sales") || type.equals("AdminStock")){
            if(i1 == 3)
                return rows.get(i).getCategory();
            if(i1 == 4)
                return rows.get(i).getStockCount();
            if(i1 == 5)
                return rows.get(i).getPrice();
        }
        if(type.equals("Accountant")){
            if(i1 == 3)
                return rows.get(i).getStockCount();
            if(i1 == 4)
                return rows.get(i).getCategory();
        }
        if(type.equals("AdminStock")){
            if(i1 == 6)
                return rows.get(i).getCost();
        }
        return null;
    }
    
    public void setRowCount(int i) {
        while(rows.size() > i){
            rows.remove(rows.size() - 1);
        }
    }
    
}
