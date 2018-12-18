/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.awt.image.BufferedImage;

public class Order {
    private BufferedImage BookCover;
    private String BookName;
    private String BookPrice;
    
    public Order(BufferedImage c, String n, String p) {
        BookCover = c;
        BookName = n;
        BookPrice = p;
    }
    
    public BufferedImage getBookCover() {
        return BookCover;
    }
    public String getBookName() {
        return BookName;
    }
    public String getBookPrice() {
        return BookPrice;
    }
}
