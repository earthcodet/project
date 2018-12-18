package Data;

public class MyOrder {
    private String OrderID;
    private String Date;
    private String PriceAll;
    private String Status;
    
    public MyOrder(String oid, String d, String p, String s) {
        OrderID = oid;
        Date = d;
        PriceAll = p;
        Status = s;
    }

    
    public String getOrderID() {
        return OrderID;
    }
    public String getDate() {
        return Date;
    }
    public String getPriceAll() {
        return PriceAll;
    }
    public String getStatus() {
        return Status;
    }
}