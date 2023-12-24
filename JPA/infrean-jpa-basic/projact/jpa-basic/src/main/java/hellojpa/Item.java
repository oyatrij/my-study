<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 4c4eccd70deee0aea21a83cbc24f9f929a7ede8f
package hellojpa;

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
package hellojpa;public class Item {
>>>>>>> 8f591b5 (상품 주문 실습예제를 위한 프로젝트)
=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 4c4eccd70deee0aea21a83cbc24f9f929a7ede8f
}
