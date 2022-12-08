package modelsPackage;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Invoice {
    private int id;
    private LocalDate dateSold;
    private int totalPrice;
    private int employeeID;
    private ArrayList<Integer> itemsID;
    private ArrayList<Integer> itemsCount;

    public Invoice(int id, LocalDate dateSold, int totalPrice, int employeeID, ArrayList<Integer> itemsID, ArrayList<Integer> itemsCount) {
        this.id = id;
        this.dateSold = dateSold;
        this.totalPrice = totalPrice;
        this.employeeID = employeeID;
        this.itemsID = itemsID;
        this.itemsCount = itemsCount;
    }

    public Invoice(int id, LocalDate dateSold, int totalPrice, int employeeID) {
        this.id = id;
        this.dateSold = dateSold;
        this.totalPrice = totalPrice;
        this.employeeID = employeeID;
    }
    
    public Invoice(){
        itemsID = new ArrayList<>();
        itemsCount = new ArrayList<>();
    }

    public ArrayList<Integer> getItemsID() {
        return itemsID;
    }

    public void setItemsID(ArrayList<Integer> itemsID) {
        this.itemsID = itemsID;
    }

    public ArrayList<Integer> getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(ArrayList<Integer> itemsCount) {
        this.itemsCount = itemsCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateSold(LocalDate dateSold) {
        this.dateSold = dateSold;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    

    public int getId() {
        return id;
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Invoice){
            final Invoice other = (Invoice) obj;
            if (this.id == other.id)
                return true;
        }
        return false;
    }

}