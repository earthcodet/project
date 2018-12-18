package Data;

import java.awt.Image;
import org.bson.types.ObjectId;

public class Book {

    public int eBookId;
    public String eBookName;
    public String eBookKinds;
    public String publisherName;
    public String authorName; 
    public int eBookPrice;
    public int eBookCoverPrice;
    public int fileBookSize;
    public int pages;
    public ObjectId eBookCover_id;

    public Book(String eBookName, String authorName, String publisherName, String eBookKinds, int fileBookSize, int eBookCoverPrice, int eBookPrice, int pages,ObjectId eBookCover_id) {
        this.eBookName = eBookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.eBookKinds = eBookKinds;
        this.fileBookSize = fileBookSize;
        this.eBookCoverPrice = eBookCoverPrice;
        this.eBookPrice = eBookPrice;
        this.pages = pages; 
        this.eBookCover_id =  eBookCover_id;

    }

    public String geteBookName() {
        return eBookName;
    }

    public String getpublisherName() {
        return publisherName;
    }

    public String getauthorName() {
        return authorName;
    }

    /*public String getfileEbook() {
        return linkFile;
    }*/

    public ObjectId geteBookCover_Id() {
        return eBookCover_id;
    }

    public int geteBookPrice() {
        return eBookPrice;
    }

    public int geteBookCoverPrice() {
        return eBookCoverPrice;
    }

    public int getfileBookSize() {
        return fileBookSize;
    }

    public String geteBookKinds() {
        return eBookKinds;
    }

    public int getepages() {
        return pages;
    }

    public String toString() {
        return eBookId + "\n"
                + eBookName + "\n"
                + publisherName + "\n"
                + authorName + "\n"               
                + eBookPrice + "\n"
                + eBookCoverPrice + "\n"
                + fileBookSize + "\n"
                + pages + "\n"
                + eBookKinds + "\n";
    }
}
