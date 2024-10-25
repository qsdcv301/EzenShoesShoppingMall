package ezen.com.esmall.service;

import ezen.com.esmall.entity.OrderView;
import ezen.com.esmall.repository.OrderViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderViewService {

    private final OrderViewRepository orderViewRepository;

    @Autowired
    public OrderViewService(OrderViewRepository orderViewRepository) {
        this.orderViewRepository = orderViewRepository;
    }

    public List<OrderView> findAll() {
        return orderViewRepository.findAll();
    }

    public OrderView findById(Long id) {
        return orderViewRepository.findById(id).orElse(null);
    }

    public OrderView create(OrderView orderView) {
        return orderViewRepository.save(orderView);
    }

    public OrderView update(Long id, OrderView orderViewDetails) {
        OrderView orderView = findById(id);
        if (orderView != null) {
            orderView.update(orderViewDetails.getDeliveryStatus());
            return orderViewRepository.save(orderView);
        }
        return null;
    }

    public void delete(Long id) {
        orderViewRepository.deleteById(id);
    }

    public List<OrderView> findAllByUserId(Long userId) {
        return orderViewRepository.findAllByUserId(userId);
    }


}
