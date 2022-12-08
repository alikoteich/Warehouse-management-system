package modelsPackage;

import javax.swing.table.AbstractTableModel;

public class InvoiceDetailModel extends AbstractTableModel {

    private Invoice invoice;
    private String[] headers;

    public InvoiceDetailModel(Invoice invoice, String[] headers) {
        this.invoice = invoice;
        this.headers = headers;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    public boolean isEmpty(){
        if(invoice.getItemsID().isEmpty())
            return true;
        return false;
    }
    
    public boolean addRow(int id, int count){
        boolean check = false;
        for(int i = 0; i < invoice.getItemsID().size(); i++){
            if(invoice.getItemsID().get(i) == id)
                check = true;
        }
        if(check == false){
            invoice.getItemsID().add(id);
            invoice.getItemsCount().add(count);
            this.fireTableDataChanged();
            return true;
        }
        return false;
        
    }
    
    @Override
    public int getRowCount() {
        return invoice.getItemsID().size();
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
            return invoice.getItemsID().get(i);
        }
        if(i1 == 1){
            return invoice.getItemsCount().get(i);
        }
        return null;
    }
    
}
