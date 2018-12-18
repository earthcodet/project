package Data;

import java.util.ArrayList;

public class Cart {

    public ArrayList<BookCart> Book;
    public double vat;
    public double priceSum;
    public double priceAll;

    public Cart(ArrayList<BookCart> Book, double vat ,double priceSum , double priceAll) {
       this.Book = Book;
       this.priceSum = priceSum;
       this.vat = vat;
       this.priceAll = priceAll;
    }
}
