package Form;

import Data.Cart;
import Service.BookService;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static Form.Header.user_name;
import static Form.Header.desktop;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CartForm extends javax.swing.JInternalFrame {
public static Cart item = null;
public static String username ;
public static int getIndexBook =-1;
    public CartForm() {
        initComponents();
        username = user_name.getText().toString();
        item = Service.BookService.loadCart(username);
        displayProduct(item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        countProduct = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        priceSum = new javax.swing.JLabel();
        vat = new javax.swing.JLabel();
        priceAll = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("ตะกร้าสินค้า");

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        countProduct.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        countProduct.setText("jLabel2");

        text.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text.setText("ราคา :");

        text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text1.setText("ราคาสุทธิ :");

        text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text2.setText(" VAT ( 7% ) :");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("ย้อนกลับ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("ลบสินค้า");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setText("ยืนยันการสั่งซื้อ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        priceSum.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        priceSum.setText("ราคารวมสินค้า");

        vat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        vat.setText("ราคา VAT");

        priceAll.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        priceAll.setText("ราคาสุทธิ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(countProduct)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(44, 44, 44)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(text2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text1)
                            .addComponent(text))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceSum, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(vat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(181, 181, 181))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(countProduct)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text)
                    .addComponent(priceSum))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text2)
                        .addComponent(vat)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text1)
                    .addComponent(priceAll))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Main b = new Main();
        desktop.add(b);
        b.setSize(1220,740);
        b.setLocation(-10,-30);
        b.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if(Service.BookService.checkItemCart(item)){
        boolean check =  Service.BookService.saveCartToDataBase(item, username);
      if(check){
         JOptionPane.showMessageDialog(null,"ยืนยันการสั่งซื้อสำเร็จ","",JOptionPane.INFORMATION_MESSAGE);
         Main b = new Main();
        desktop.add(b);
        b.setSize(1220,740);
        b.setLocation(-10,-30);
        b.setVisible(true);
      }
      }else{
          JOptionPane.showMessageDialog(null,"กรุณาเลือกสินค้าก่อนกดยืนยันการสั่งซื้อ","",JOptionPane.INFORMATION_MESSAGE);
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        getIndexBook = jTable1.getSelectedRow();    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(Service.BookService.checkSelectTable(getIndexBook)){
          Cart temp = Service.BookService.deleteProduct(item, getIndexBook,username);
          getIndexBook=-1;
         JOptionPane.showMessageDialog(null,"ลบหนังสือจากตะกร้าสินค้าแล้ว","",JOptionPane.INFORMATION_MESSAGE);
         displayProduct(temp);
      }
      else{
          JOptionPane.showMessageDialog(null,"กรุณาเลือกสินค้าก่อนกดลบ","",JOptionPane.WARNING_MESSAGE);
       
      }
    }//GEN-LAST:event_jButton2ActionPerformed
    public static void displayProduct(Cart item) {
        //text
        countProduct.setText("คุณมีสินค้า " + item.Book.size() + " ชิ้นในตะกร้าสินค้าของคุณ");
        priceSum.setText(new DecimalFormat("##.##").format(item.priceSum)+" บาท");
        vat.setText(new DecimalFormat("##.##").format(item.vat)+" บาท");
        priceAll.setText(new DecimalFormat("##.##").format(item.priceAll)+" บาท");
        //table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ปก");
	model.addColumn("ชื่อหนังสือ");
	model.addColumn("ราคา");
        for (int i = 0; i < item.Book.size(); i++) {
            BufferedImage tempImge = null;
            try {
                tempImge = ImageIO.read(new File("src/Image/" + item.Book.get(i).nameBook + ".png"));
            } catch (IOException e) {
            }
            model.addRow(new Object[]{tempImge, item.Book.get(i).nameBook, item.Book.get(i).priceBook+" บาท"});
        }
            jTable1.setModel(model);
            jTable1.getColumn("ปก").setCellRenderer(new BookService());
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
            jTable1.setRowHeight(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);  
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(480);  
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(480);  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel countProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JLabel priceAll;
    public static javax.swing.JLabel priceSum;
    private javax.swing.JLabel text;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    public static javax.swing.JLabel vat;
    // End of variables declaration//GEN-END:variables
}
