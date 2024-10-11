package ezen.com.esmall.service;

import ezen.com.esmall.entity.Order;
import ezen.com.esmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long id, Order orderDetails) {
        Order order = findById(id);
        if (order != null) {
            order.update(orderDetails.getOrderNumber(), orderDetails.getTotalPrice(),
                    orderDetails.getPayment(), orderDetails.getAddr());
            return orderRepository.save(order);
        }
        return null;
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
