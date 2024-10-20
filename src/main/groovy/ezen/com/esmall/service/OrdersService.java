package ezen.com.esmall.service;

import ezen.com.esmall.entity.Orders;
import ezen.com.esmall.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Orders findById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders create(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders update(Long id, Orders orderDetails) {
        Orders orders = findById(id);
        if (orders != null) {
            orders.update(orderDetails.getTotalPrice(), orderDetails.getAddr());
            return ordersRepository.save(orders);
        }
        return null;
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}
