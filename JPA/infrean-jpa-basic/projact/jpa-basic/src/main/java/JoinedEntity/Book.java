package JoinedEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item{
    private String author;
    private String ISNB;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISNB() {
        return ISNB;
    }

    public void setISNB(String ISNB) {
        this.ISNB = ISNB;
    }
}
