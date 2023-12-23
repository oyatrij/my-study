package entity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_ID")
public class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private long itemId;

    private String name;
    private int price;
    private int stockQuantity;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
