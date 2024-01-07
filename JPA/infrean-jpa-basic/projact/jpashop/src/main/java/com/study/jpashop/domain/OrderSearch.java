package com.study.jpashop.domain;

import org.springframework.data.jpa.domain.Specification;

import static com.study.jpashop.domain.OderSpec.memberNameLike;
import static com.study.jpashop.domain.OderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specification.where;

public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Specification<Order> toSpecification() {
        return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
    }
}
