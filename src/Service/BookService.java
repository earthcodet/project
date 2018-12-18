/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.BookDAO;
import Data.Book;
import Data.BookCart;
import Data.Cart;
import Data.ImagePanel;
import Data.Login;
import Data.Order;
import Data.Payment;
import Data.Register;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS
 */
public class BookService extends DefaultTableCellRenderer implements TableCellRenderer {
     public static ArrayList<Book> showBook() {
        ArrayList<Book> result = BookDAO.getBook();       
        return result;
    }
   public static boolean getImage(String eBookName, Object eBookCover_id){
        BookDAO.downloadChunkToFile(eBookName,eBookCover_id);
        return true;
         
    }
    public static ArrayList<Book> findBookByName(String getEbookName) {
        ArrayList<Book> result = BookDAO.getBookByName(getEbookName);       
        return result;
    }
    public static boolean addBookToCarts(String eBookName,int eBookPrice,String username ){
        boolean temp  = BookDAO.insertBookToCarts(eBookName,eBookPrice,username);      
         if (temp) {
            return true;
        } else {
            return false;
        }     
         
    }
    
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImagePanel i = new ImagePanel();
        i.img = (BufferedImage) value;
        return i;
    }
     public static Cart loadCart(String username) {
        ArrayList<BookCart> Cart = DAO.BookDAO.getBookFormCart(username);
        Cart result = sumPriceProduct(Cart);
        return result;
    }

    public static Cart sumPriceProduct(ArrayList<BookCart> product) {
        double vat;
        double priceAll;
        double priceSumProduct = 0.0;
        for (int i = 0; i < product.size(); i++) {
            int price = product.get(i).priceBook;
            priceSumProduct = priceSumProduct + price;
        }
        vat = priceSumProduct * 0.07;
        priceAll = priceSumProduct + vat;
        Cart result = new Cart(product, vat, priceSumProduct, priceAll);
        System.out.println("sumPriceProduct - Stop");
        return result;
    }

    public static boolean saveCartToDataBase(Cart result, String username) {
        boolean Pass = DAO.BookDAO.InsertOrder(result, username);
        return Pass;
    }

  public static Cart deleteProduct(Cart item, int select,String username) {
     DAO.BookDAO.deleteBookFormCartByName(username, item.Book.get(select).nameBook);
     item.Book.remove(select);
     Cart result = sumPriceProductForDelete(item);
        return result;
    }
  public static Cart sumPriceProductForDelete(Cart product) {
        double vat;
        double priceAll;
        double priceSumProduct = 0.0;
        for (int i = 0; i < product.Book.size(); i++) {
            int price = product.Book.get(i).priceBook;
            priceSumProduct = priceSumProduct + price;
        }
        vat = priceSumProduct * 0.07;
        priceAll = priceSumProduct + vat;
        product.priceAll = priceAll;
        product.vat = vat;
        product.priceSum = priceSumProduct;
        return product;
    }
    public static boolean checkEmptyPay(Payment Payment){
       if(Payment.getNameBankCustomer().length()<1||
          Payment.getNumBankCustomer().length()<1||
          Payment.getNameCustomer().length()<1||
          Payment.getSurNameCustomer().length()<1||
          Payment.getDate().length()<1||
          Payment.getMounth().length()<1||
          Payment.getYear().length()<1|
          Payment.getHour().length()<1||
          Payment.getMinute().length()<1
         ){
         return false;  
       }else{
           return true;
       }
          
    }
    public static void updateMyOrderStutus(int OrderID){
         BookDAO.updateStatusMyOrder(OrderID);
        
    }
    public static ArrayList<Order>showBookInOrder(int OrderID2){      
        return BookDAO.getBookInOrder(OrderID2);
    }
     
    public static boolean addPayment(Payment Payment){
        if(BookDAO.insertPayment(Payment)){
            return true;
        }else{
            return false;
          }
       }
    public static boolean checkItemCart(Cart item){
        if(item.Book.size()>0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkSelectTable(int select){
        if(select!=-1){
            return true;
        }else{
            return false;
        }
    }
}
