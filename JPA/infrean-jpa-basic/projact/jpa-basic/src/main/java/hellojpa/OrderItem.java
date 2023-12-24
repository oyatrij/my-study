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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int oderPirce;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOderPirce() {
        return oderPirce;
    }

    public void setOderPirce(int oderPirce) {
        this.oderPirce = oderPirce;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
package hellojpa;public class OrderItem {
>>>>>>> 8f591b5 (상품 주문 실습예제를 위한 프로젝트)
=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 4c4eccd70deee0aea21a83cbc24f9f929a7ede8f
}
