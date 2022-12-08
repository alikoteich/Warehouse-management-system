package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelsPackage.Employee;
import modelsPackage.Invoice;
import modelsPackage.InvoiceDetailModel;
import modelsPackage.Order;
import modelsPackage.OrderModel;

public class DbHelper {

    private Connection con;
    private String url;
    private int flag;

    public DbHelper() {
        flag = 0;
        con = null;
        url = "jdbc:sqlserver://localhost:1433;databaseName=WSMS_database;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet getEmployee(String query) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void insertEmployee(Employee e) {
        String query = "INSERT Employee VALUES('" + e.getFirstName() + "', '" + e.getLastName() + "', " + e.getAge() + ", " + e.getSalary() + ", '" + e.getPosition() + "', '" + e.getPassword() + "');";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE employeeID=" + id;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet getItems(String query) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public ResultSet getOrders(String query) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public Order getOrder(int id) {
        String query = "SELECT otr.orderID, dateMade, totalCost, arrivingDate, itemID, itemCount FROM Orders as o,OrderToRecieve as otr WHERE otr.orderID = o.orderID AND otr.orderID=" + id;
        try {
            int test = -1;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            LocalDate made = null;
            LocalDate arriving = null;
            int totalCost = 0;
            ArrayList<Integer> itemsID = new ArrayList<>();
            ArrayList<Integer> itemsCount = new ArrayList<>();
            while (rs.next()) {
                if (test == -1) {
                    made = Date.valueOf(rs.getDate("dateMade").toString()).toLocalDate();
                    arriving = Date.valueOf(rs.getDate("arrivingDate").toString()).toLocalDate();
                    totalCost = rs.getInt("totalCost");
                    test = 1;
                }
                itemsID.add(rs.getInt("itemID"));
                itemsCount.add(rs.getInt("itemCount"));
            }
            return new Order(id, made, arriving, totalCost, itemsID, itemsCount);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean insertOrder(Order order) {
        int id = -1;
        String query1 = "INSERT Orders VALUES ('" + order.getDateMade() + "', " + order.getTotalCost() + ")";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query1, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            if (id != -1) {
                for (int i = 0; i < order.getItemsID().size(); i++) {
                    String query2 = "INSERT OrderToRecieve VALUES (" + id + ", " + order.getItemsID().get(i) + ", " + order.getItemsCount().get(i) + ", '" + order.getDateArriving() + "')";
                    st.executeUpdate(query2);
                }
            }
            return true;
        } catch (SQLException ex) {
            if(ex.getMessage().contains("FK__OrderToRe__itemI")){
                JOptionPane.showMessageDialog(null, "Invalid item ID.");
            } else {
                System.out.println(ex.getMessage());
            }
            return false;
        }

    }

    public ResultSet getInvoices(String query) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void insertInvoice(Invoice invoice) {
        int id = -1;
        String query1 = "INSERT Invoices VALUES ('" + invoice.getDateSold() + "', " + invoice.getTotalPrice() + ", " + invoice.getEmployeeID() + ")";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query1, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            if (id != -1) {
                for (int i = 0; i < invoice.getItemsID().size(); i++) {
                    String query2 = "INSERT InvoicesMade VALUES (" + id + ", " + invoice.getItemsID().get(i) + ", " + invoice.getItemsCount().get(i) + ")";
                    st.executeUpdate(query2);
                }
            }
        } catch (SQLException ex) {
            flag = 1;
            if (ex.getMessage().contains("FK__InvoicesM__itemI")) {
                JOptionPane.showMessageDialog(null, "Invalid item ID.");
            } else {
                if (ex.getMessage().contains("FK__Invoices__employ")) {
                    JOptionPane.showMessageDialog(null, "Invalid employee ID.");
                } else {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void removeOrder(int orderId) {
        String query1 = "DELETE FROM OrderToRecieve WHERE orderID=" + orderId;
        String query2 = "DELETE FROM Orders WHERE orderID=" + orderId;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addItemsToDb(OrderModel orderModel) {
        ArrayList<Integer> itemId = orderModel.getOrder().getItemsID();
        ArrayList<Integer> itemCount = orderModel.getOrder().getItemsCount();
        for (int i = 0; i < itemId.size(); i++) {
            try {
                String query1 = "SELECT stockCount FROM Items WHERE itemID=" + itemId.get(i);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query1);
                int stock = 0;
                if (rs.next()) {
                    stock = rs.getInt("stockCount");
                }
                int newStock = stock + itemCount.get(i);
                String query2 = "UPDATE Items SET stockCount=" + newStock + "WHERE itemID=" + itemId.get(i);
                st.executeUpdate(query2);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void removeItems(InvoiceDetailModel invoiceDetailModel) {
        ArrayList<Integer> itemId = invoiceDetailModel.getInvoice().getItemsID();
        ArrayList<Integer> itemCount = invoiceDetailModel.getInvoice().getItemsCount();
        for (int i = 0; i < itemId.size(); i++) {
            try {
                String query1 = "SELECT stockCount FROM Items WHERE itemID=" + itemId.get(i);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query1);
                int stock = 0;
                if (rs.next()) {
                    stock = rs.getInt("stockCount");
                }
                int newStock = stock - itemCount.get(i);
                if (newStock < 0 && flag == 0) {
                    JOptionPane.showMessageDialog(null, "Not Enough Stock.");
                    break;
                }

                String query2 = "UPDATE Items SET stockCount=" + newStock + "WHERE itemID=" + itemId.get(i);
                st.executeUpdate(query2);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet getEmployee(int id) {
        ResultSet rs = null;
        String query = "SELECT * FROM Employee WHERE employeeID=" + id;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

}
