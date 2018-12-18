package DAO;

import Data.Book;
import java.util.List;
import Data.Cart;
import Data.BookCart;
import Data.Login;
import Data.MyOrder;
import Data.Order;
import Data.Payment;
import Data.Register;
import Form.Header;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import Image.ImagePanel;
import MongoConnect.Mongo;
import static com.mongodb.client.model.Filters.eq;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.bson.Document;
import org.bson.types.ObjectId;

public class BookDAO {

    public static boolean deleteBookFormCartByName(String username, String nameBook) {
        Collection = db.getCollection("cart");
        try {
            Document data = new Document("username", username);
            data.append("eBookName", nameBook);
            Collection.deleteOne(data);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    public static LinkedList<String> basket = new LinkedList<>();
    static MongoClient connectMlab = new MongoClient(new MongoClientURI("mongodb://admin:admin02@ds247223.mlab.com:47223/ebook"));
    static MongoDatabase db = connectMlab.getDatabase("ebook");
    static MongoCollection<Document> Collection;
    static GridFSBucket gridFSBucket = GridFSBuckets.create(db);
    static MongoClient mongo = Mongo.Connector();
    static MongoCollection<Document> dbColl = mongo.getDatabase("ebook").getCollection("User");

    public static boolean insertPayment(Payment Payment) {
        Collection = db.getCollection("payment");
        Document doc = new Document();
        doc.put("OrderID", Payment.getOrderID());
        doc.put("nameBankCustomer", Payment.getNameBankCustomer());
        doc.put("numBankCustomer", Payment.getNumBankCustomer());
        doc.put("nameCustomer", Payment.getNameCustomer());
        doc.put("surnameCustomer", Payment.getSurNameCustomer());
        doc.put("price", Payment.getPrice());
        doc.put("dateTransfer", Payment.getDate() + "/" + Payment.getMounth() + "/" + Payment.getYear());
        doc.put("timeTransfer", Payment.getHour() + ":" + Payment.getMinute());
        Collection.insertOne(doc);
        return true;
    }

    public static ArrayList<Order> getBookInOrder(int OrderID) {
        ArrayList<Order> myorders = getMyOrderDetail(OrderID);
        return myorders;
    }

    public static ArrayList<Book> getBook() {
        ArrayList<Book> result = new ArrayList<Book>();
        try {
            Collection = db.getCollection("Book");
            FindIterable<Document> iterateDoc = Collection.find();
            Iterator<Document> iterator = iterateDoc.iterator();
            while (iterator.hasNext()) {
                Document data = new Document(iterator.next());
                String eBookName = data.getString("eBookName");
                String authorName = data.getString("authorName");
                String publisherName = data.getString("publisherName");
                String eBookKinds = data.getString("eBookKinds");
                int fileBookSize = data.getInteger("fileBookSize");
                int eBookCoverPrice = data.getInteger("eBookCoverPrice");
                int eBookPrice = data.getInteger("eBookPrice");
                int pages = data.getInteger("pages");
                ObjectId eBookCover_id = data.getObjectId("eBookCover_id");

                Book tempResult = new Book(eBookName, authorName, publisherName, eBookKinds, fileBookSize, eBookCoverPrice, eBookPrice, pages, eBookCover_id);
                result.add(tempResult);
            }
        } catch (Exception eX) {
            eX.printStackTrace();
        }
        return result;
    }

    public static void downloadChunkToFile(String eBookName, Object eBookCover_id) {
        String eBookNamePic = eBookName;
        Object eBookCover_idPic = eBookCover_id;
        try {
            Path path = FileSystems.getDefault().getPath("src/image/" + eBookNamePic + ".png").toAbsolutePath();
            OutputStream streamToDownloadTo = new FileOutputStream(path.toString());
            gridFSBucket.downloadToStream((ObjectId) eBookCover_idPic, streamToDownloadTo);
            streamToDownloadTo.close();
            System.out.println("Download to File Success");

        } catch (Exception ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Download to File Failure");
        }
    }

    public static ArrayList<Book> getBookByName(String getEbookName) {
        ArrayList<Book> result = new ArrayList<Book>();
        try {
            Collection = db.getCollection("Book");
            //FindIterable<Document> iterateDoc = Collection.find();
            // Iterator<Document> iterator = iterateDoc.iterator();          
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("eBookName", getEbookName);
            FindIterable<Document> iterateDoc = Collection.find(whereQuery);
            Iterator<Document> iterator = iterateDoc.iterator();

            while (iterator.hasNext()) {
                Document data = new Document(iterator.next());
                String eBookName = data.getString("eBookName");
                String authorName = data.getString("authorName");
                String publisherName = data.getString("publisherName");
                String eBookKinds = data.getString("eBookKinds");
                int fileBookSize = data.getInteger("fileBookSize");
                int eBookCoverPrice = data.getInteger("eBookCoverPrice");
                int eBookPrice = data.getInteger("eBookPrice");
                int pages = data.getInteger("pages");
                ObjectId eBookCover_id = data.getObjectId("eBookCover_id");

                Book tempResult = new Book(eBookName, authorName, publisherName, eBookKinds, fileBookSize, eBookCoverPrice, eBookPrice, pages, eBookCover_id);
                result.add(tempResult);
            }
        } catch (Exception eX) {
            eX.printStackTrace();
        }
        return result;
    }

    public static boolean insertBookToCarts(String eBookName, int eBookPrice, String username) {
        Collection = db.getCollection("cart");
        try {
            Document doc = new Document();
            doc.put("eBookName", eBookName);
            doc.put("eBookPrice", eBookPrice);
            doc.put("username", username);
            Collection.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.err.println("insert Failure");
        }
        return false;

    }

    public static boolean InsertOrder(Cart item, String username) {
        Collection = db.getCollection("User");
        List<Document> myOrder = null;
        int sizeOrder = 0;

        //หาว่า user มี MaxOrder อยู่เท่าไร
        try {
            Document search = new Document("username", username);
            FindIterable<Document> iterateDoc = Collection.find(search);
            Iterator<Document> iterator = iterateDoc.iterator();
            while (iterator.hasNext()) {
                Document data = new Document(iterator.next());
                myOrder = (List<Document>) data.get("myOrder");
            }
            sizeOrder = myOrder.size();

            //ทำ Insert เข้า Array myOrder
            List<Document> order_detail = new ArrayList<>();
            Document order_doc = new Document("order_id", sizeOrder + 1);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            order_doc.append("date", dateFormat.format(date));
            order_doc.append("status", "ยังไม่ชำระเงิน");
            order_doc.append("priceAll", item.priceAll);
            for (int i = 0; i < item.Book.size(); i++) {
                Document order_detaill = new Document("eBookName", item.Book.get(i).nameBook);
                order_detaill.append("eBookPrice", item.Book.get(i).priceBook);
                order_detail.add(order_detaill);
            }
            order_doc.append("order_detail", order_detail);
            Collection.updateOne(eq("username", username), new Document("$push", new Document("myOrder", order_doc)));

        } catch (Exception ex) {
            System.out.println("error InsertOrder" + ex);
        }
        deleteBookFormCart(username);
        return true;
    }

    public static boolean deleteBookFormCart(String username) {
        Collection = db.getCollection("cart");
        try {
            Collection.deleteMany(new Document("username", username));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static ArrayList<BookCart> getBookFormCart(String username) {
        System.out.println("getBookFormCart - Start");
        ArrayList<BookCart> result = new ArrayList<BookCart>();
        try {
            Collection = db.getCollection("cart");
            FindIterable<Document> iterateDoc = Collection.find();
            Iterator<Document> iterator = iterateDoc.iterator();

            while (iterator.hasNext()) {
                Document data = new Document(iterator.next());
                if (data.getString("username").equals(username)) {
                    String name = data.getString("eBookName");
                    int price = data.getInteger("eBookPrice");
                    Data.BookCart temp = new Data.BookCart(name, price);
                    result.add(temp);

                }
            }
        } catch (Exception ex) {
            System.out.println("getBookFormCart - error " + ex);
        }

        System.out.println("getBookFormCart - Stop");
        return result;
    }

    public static Object[] authorizeLogin(Login lgInput) {
        FindIterable<Document> iterateDoc = dbColl.find();
        Iterator<Document> iterator = iterateDoc.iterator();
        while (iterator.hasNext()) {
            Document dc = iterator.next();
            String user = dc.getString("username");
            String pass = dc.getString("password");
            if (lgInput.getUser().equals(user) && lgInput.getPass().equals(pass)) {
                return new Object[]{true, user};
            }
        }
        return new Object[]{false};
    }

    public static boolean hasAlreadyInUseThisData(Register rs) {
        FindIterable<Document> iterateDoc = dbColl.find();
        Iterator<Document> iterator = iterateDoc.iterator();
        while (iterator.hasNext()) {
            Document dc = iterator.next();
            String user = dc.getString("username");
            String email = dc.getString("email");
            if (rs.getUsername().equals(user) || rs.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static void insertUser(Register rs) {
        Document userDoc = new Document();
        userDoc.append("username", rs.getUsername());
        userDoc.append("password", rs.getPassword());
        userDoc.append("email", rs.getEmail());
        userDoc.append("myOrder", new ArrayList<>());
        dbColl.insertOne(userDoc);
    }

    public static ArrayList<MyOrder> getMyOrderByStatus(String username, int status) {
        ArrayList<MyOrder> cap = new ArrayList<>();
        List<Document> user = (List<Document>) dbColl.find(eq("username", username)).into(new ArrayList<>());
        for (Document userDoc : user) {
            List<Document> myOrder = (List<Document>) userDoc.get("myOrder");
            for (Document order : myOrder) {
                switch (status) {
                    case 1:
                        if (order.getString("status").equals("รอรับสินค้า")) {
                            MyOrder od = new MyOrder("" + order.getInteger("order_id"),
                                    order.getString("date"),
                                    "" + order.getDouble("priceAll"),
                                    order.getString("status"));
                            cap.add(od);
                        }
                        break;
                    case 2:
                        if (order.getString("status").equals("ยังไม่ชำระเงิน")) {
                            MyOrder od = new MyOrder("" + order.getInteger("order_id"),
                                    order.getString("date"),
                                    "" + order.getDouble("priceAll"),
                                    order.getString("status"));
                            cap.add(od);
                        }
                        break;
                    default:
                        MyOrder od = new MyOrder("" + order.getInteger("order_id"),
                                order.getString("date"),
                                "" + order.getDouble("priceAll"),
                                order.getString("status"));
                        cap.add(od);
                        break;
                }
            }
        }
        return cap;
    }

    public static ArrayList<Order> getMyOrderDetail(int OrderID) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            MongoClient mongocon = new MongoClient(new MongoClientURI("mongodb://hanami:hanami02@ds247223.mlab.com:47223/ebook"));
            System.out.println("Connection success");
            MongoDatabase db = mongocon.getDatabase("ebook");
            MongoCollection<Document> DBCollection = db.getCollection("User");

            List<Document> user = (List<Document>) DBCollection.find(eq("username", Header.user_name.getText())).into(new ArrayList<>());

            for (Document userDoc : user) {
                List<Document> myOrder = (List<Document>) userDoc.get("myOrder");
                for (Document order : myOrder) {
                    if (order.getInteger("order_id") == OrderID) {
                        List<Document> orderDetail = (List<Document>) order.get("order_detail");
                        for (Document book : orderDetail) {
                            BufferedImage tempImge = null;
                            System.out.println(book.getString("eBookName") + " " + book.getInteger("eBookPrice"));
                            try {
                                tempImge = ImageIO.read(new File("src/Image/" + book.getString("eBookName") + ".png"));
                            } catch (IOException e) {
                            }
                            orders.add(new Order(tempImge, book.getString("eBookName"), "" + book.getInteger("eBookPrice")));
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }
        return orders;
    }

    public static void updateStatusMyOrder(int OrderID) {

        try {
            MongoClient mongocon = new MongoClient(new MongoClientURI("mongodb://hanami:hanami02@ds247223.mlab.com:47223/ebook"));
            System.out.println("Connection success");
            MongoDatabase db = mongocon.getDatabase("ebook");
            MongoCollection<Document> DBCollection = db.getCollection("User");

            
           
            Document order_doc = new Document();
            
            List<Document> order_details = new ArrayList<>();


            List<Document> user = (List<Document>) DBCollection.find(eq("username", Header.user_name.getText())).into(new ArrayList<>());
            for (Document userDoc : user) {
                List<Document> myOrder = (List<Document>) userDoc.get("myOrder");
                for (Document order : myOrder) {
                    if (order.getInteger("order_id") == OrderID) {
                        
                        order_doc.append("order_id", OrderID);
                        order_doc.append("date", order.get("date"));
                        order_doc.append("status", "รอรับสินค้า");
                        order_doc.append("priceAll", order.get("priceAll"));
                        
                        List<Document> orderDetail = (List<Document>) order.get("order_detail");
                        for (Document book : orderDetail) {
                            Document order_detail = new Document();
                            order_detail.append("eBookName", book.get("eBookName"));
                            order_detail.append("eBookPrice", book.get("eBookPrice"));
                            
                            order_details.add(order_detail);
                                    
                        }
                    }
                }
            }
            order_doc.append("order_detail", order_details);

            
            DBCollection.updateOne(eq("username", Header.user_name.getText()), new Document("$pull", new Document("myOrder", new Document("order_id", OrderID))));
            
            DBCollection.updateOne(eq("username", Header.user_name.getText()), new Document("$push", new Document("myOrder", order_doc)));
            
        } catch (Exception ex) {

        }
    }
}
