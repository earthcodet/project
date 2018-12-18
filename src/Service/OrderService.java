package Service;

import DAO.BookDAO;
import Data.MyOrder;
import Data.Order;
import java.util.ArrayList;

public class OrderService {
    
    public static ArrayList<MyOrder> showMyOrderByStatus(String username, int status) {
        return BookDAO.getMyOrderByStatus(username,status);
    }  
    
    public static ArrayList<Order> showMyOrderDetail(int orderId) {
       return BookDAO.getMyOrderDetail(orderId);
    }
    
}
