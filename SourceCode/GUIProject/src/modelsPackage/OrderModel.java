package modelsPackage;

import javax.swing.table.AbstractTableModel;

public class OrderModel extends AbstractTableModel {
    
    private Order order;
    private String[] headers;

    public OrderModel(Order order, String[] headers) {
        this.order = order;
        this.headers = headers;
    }
    
    public boolean isEmpty(){
        if(order.getItemsID().isEmpty())
            return true;
        return false;
    }

    public Order getOrder() {
        return order;
    }
    
    public void setRowCount(int i){
        while(order.getItemsID().size() > i){
            order.getItemsID().remove(order.getItemsID().size() - 1);
            order.getItemsCount().remove(order.getItemsCount().size() - 1);
        }
    }
    
    public boolean addRow(int id, int count){
        boolean check = false;
        for(int i = 0; i < order.getItemsID().size(); i++){
            if(order.getItemsID().get(i) == id)
                check = true;
        }
        if(check == false){
            order.getItemsID().add(id);
            order.getItemsCount().add(count);
            this.fireTableDataChanged();
            return true;
        }
        return false;
        
    }
    
    @Override
    public int getRowCount() {
        return order.getItemsID().size();
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
        if(i1 == 0){
            return order.getItemsID().get(i);
        }
        if(i1 == 1){
            return order.getItemsCount().get(i);
        }
        return null;
    }
    
}
