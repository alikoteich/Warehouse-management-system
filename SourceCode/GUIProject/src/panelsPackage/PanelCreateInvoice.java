/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelsPackage;

import database.DbHelper;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelsPackage.Invoice;
import modelsPackage.InvoiceDetailModel;

/**
 *
 * @author Moust
 */
public class PanelCreateInvoice extends javax.swing.JPanel {

    /**
     * Creates new form PanelCreateInvoice
     */
    public PanelCreateInvoice() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_itemId = new javax.swing.JTextField();
        btn_addItem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_count = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_employeeId = new javax.swing.JTextField();
        tf_totalPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        String[] header = new String [] {"ID", "Count"};
        Invoice invoice = new Invoice();
        invoiceDetailModel = new InvoiceDetailModel(invoice, header);
        jTable1 = new javax.swing.JTable();
        btn_createInvoice = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 86, 146), 3));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 86, 146)));

        jLabel1.setText("Item ID:");

        btn_addItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_addItem.setText("Add Item");
        btn_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addItemActionPerformed(evt);
            }
        });

        jLabel2.setText("Count:");

        jLabel3.setText("Employee ID:");

        jLabel4.setText("Total Price:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tf_itemId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_count, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tf_totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btn_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_itemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tf_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(tf_employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_addItem, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(invoiceDetailModel);
        jScrollPane1.setViewportView(jTable1);

        btn_createInvoice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_createInvoice.setText("Create Invoice");
        btn_createInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(btn_createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createInvoiceActionPerformed
        if (!tf_employeeId.getText().isEmpty() && !tf_totalPrice.getText().isEmpty()) {
            if (tf_employeeId.getText().matches("-?\\d+") && tf_totalPrice.getText().matches("-?\\d+")) {
                if (!invoiceDetailModel.isEmpty()) {
                    Invoice invoice = invoiceDetailModel.getInvoice();
                    invoice.setId(-1);
                    invoice.setEmployeeID(Integer.parseInt(tf_employeeId.getText()));
                    invoice.setTotalPrice(Integer.parseInt(tf_totalPrice.getText()));
                    invoice.setDateSold(LocalDate.now());
                    db.insertInvoice(invoice);
                    db.removeItems(invoiceDetailModel);
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    topFrame.dispatchEvent(new WindowEvent(topFrame, WindowEvent.WINDOW_CLOSING));
                } else {
                    JOptionPane.showMessageDialog(null, "You have no items added.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid employee ID or total price.");
            }
        }
    }//GEN-LAST:event_btn_createInvoiceActionPerformed

    private void btn_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addItemActionPerformed
        if (!tf_itemId.getText().isEmpty() && !tf_count.getText().isEmpty()) {
            if (tf_itemId.getText().matches("-?\\d+") && tf_count.getText().matches("-?\\d+")) {
                invoiceDetailModel.addRow(Integer.parseInt(tf_itemId.getText()), Integer.parseInt(tf_count.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid item ID or count.");
            }
        }
    }//GEN-LAST:event_btn_addItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addItem;
    private javax.swing.JButton btn_createInvoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_count;
    private javax.swing.JTextField tf_employeeId;
    private javax.swing.JTextField tf_itemId;
    private javax.swing.JTextField tf_totalPrice;
    // End of variables declaration//GEN-END:variables

    private DbHelper db = new DbHelper();
    private InvoiceDetailModel invoiceDetailModel;

}
