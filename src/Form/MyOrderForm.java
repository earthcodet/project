/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.BookDAO;
import Data.MyOrder;
import Service.OrderService;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Easy_IT
 */
public class MyOrderForm extends javax.swing.JInternalFrame {

    ArrayList<MyOrder> myOrder;
    DefaultTableModel model;

    /**
     * Creates new form MyOrderForm
     */
    public MyOrderForm() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        myOrder = OrderService.showMyOrderByStatus(Header.user_name.getText(), 0);
        model = new DefaultTableModel();
        model.addColumn("OrderID");
        model.addColumn("Date");
        model.addColumn("Price");
        model.addColumn("Status");

        for (int i = 0; i < myOrder.size(); i++) {
            model.addRow(new Object[]{myOrder.get(i).getOrderID(),
                myOrder.get(i).getDate(),
                myOrder.get(i).getPriceAll(),
                myOrder.get(i).getStatus()});
        }

        MyOrderTable.setModel(model);

        MyOrderTable.setRowHeight(25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatusBox = new javax.swing.JComboBox<>();
        MyOrderScroll = new javax.swing.JScrollPane();
        MyOrderTable = new javax.swing.JTable();

        StatusBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        StatusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "แสดงรายการทั้งหมด", "รอรับสินค้า", "ยังไม่ชำระเงิน" }));
        StatusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusBoxActionPerformed(evt);
            }
        });

        MyOrderScroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MyOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "Date", "Price", "Status"
            }
        ));
        MyOrderTable.setRowHeight(25);
        MyOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyOrderTableMouseClicked(evt);
            }
        });
        MyOrderScroll.setViewportView(MyOrderTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MyOrderScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(StatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MyOrderScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StatusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusBoxActionPerformed

        myOrder = OrderService.showMyOrderByStatus(Header.user_name.getText(), StatusBox.getSelectedIndex());

        model.setRowCount(0);

        for (int i = 0; i < myOrder.size(); i++) {
            model.addRow(new Object[]{myOrder.get(i).getOrderID(),
                myOrder.get(i).getDate(),
                myOrder.get(i).getPriceAll(),
                myOrder.get(i).getStatus()});
        }

        MyOrderTable.setModel(model);

        MyOrderTable.setRowHeight(25);

    }//GEN-LAST:event_StatusBoxActionPerformed

    private void MyOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyOrderTableMouseClicked

        int selectedRowIndex = MyOrderTable.getSelectedRow();
        MyOrder order = new MyOrder(model.getValueAt(selectedRowIndex, 0).toString(),
                model.getValueAt(selectedRowIndex, 1).toString(),
                model.getValueAt(selectedRowIndex, 2).toString(),
                model.getValueAt(selectedRowIndex, 3).toString());

        if (model.getValueAt(selectedRowIndex, 3).toString().equals("ยังไม่ชำระเงิน")) {
            PaymentForm pf = new PaymentForm(Integer.parseInt(order.getOrderID()));
            Header.desktop.add(pf);
            pf.show();
        } else {
            MyOrderDetailForm mo = new MyOrderDetailForm(order);
            mo.setVisible(true);
        }
    }//GEN-LAST:event_MyOrderTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane MyOrderScroll;
    private javax.swing.JTable MyOrderTable;
    private javax.swing.JComboBox<String> StatusBox;
    // End of variables declaration//GEN-END:variables
}
