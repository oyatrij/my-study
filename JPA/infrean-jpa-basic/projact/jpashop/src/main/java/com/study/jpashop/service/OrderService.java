package com.study.jpashop.service;

import com.study.jpashop.domain.Order;
import com.study.jpashop.domain.OrderSearch;
import com.study.jpashop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch.toSpecification());
    }
}
