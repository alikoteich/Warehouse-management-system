package modelsPackage;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private int id;
    private LocalDate dateMade;
    private LocalDate dateArriving;
    private int totalCost;
    private ArrayList<Integer> itemsID;
    private ArrayList<Integer> itemsCount;

    public Order(int id, LocalDate dateMade, LocalDate dateArriving, int totalCost, ArrayList<Integer> itemsID, ArrayList<Integer> itemsCount) {
        this.id = id;
        this.dateMade = dateMade;
        this.dateArriving = dateArriving;
        this.totalCost = totalCost;
        this.itemsID = itemsID;
        this.itemsCount = itemsCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateMade(LocalDate dateMade) {
        this.dateMade = dateMade;
    }

    public void setDateArriving(LocalDate dateArriving) {
        this.dateArriving = dateArriving;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getDateMade() {
        return dateMade;
    }

    public LocalDate getDateArriving() {
        return dateArriving;
    }

    public int getTotalCost() {
        return totalCost;
    }
    
    

    public Order() {
        itemsID = new ArrayList<>();
        itemsCount = new ArrayList<>();
    }

    public ArrayList<Integer> getItemsID() {
        return itemsID;
    }

    public ArrayList<Integer> getItemsCount() {
        return itemsCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            final Order other = (Order) obj;
            if (this.id == other.id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Cost: " + totalCost + " Arriving date: " + dateArriving;
    }

    
}
