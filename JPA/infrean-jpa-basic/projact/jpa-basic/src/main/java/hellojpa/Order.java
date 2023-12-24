<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Member_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //연관관계 편의 메소드
    public void setMember(Member member) {
        if (this.member != null) {
            member.getOrders().remove(this);
        }
        member.getOrders().add(this);
        this.member = member;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
package hellojpa;public class Order {
>>>>>>> 8f591b5 (상품 주문 실습예제를 위한 프로젝트)
=======
>>>>>>> e0d6a41 (다대다 양방향 연관관계 Member, Team entity 추가)
=======
>>>>>>> 48984da (다대다 양방향 연관관계 Member, Team entity 추가)
}
