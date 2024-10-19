package ezen.com.esmall.service;

import ezen.com.esmall.entity.Cart;
import ezen.com.esmall.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart findById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart update(Long id, Cart cartDetails) {
        Cart cart = findById(id);
        if (cart != null) {
            cart.update(cartDetails.getProductId(), cartDetails.getQuantity());
            return cartRepository.save(cart);
        }
        return null;
    }

    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> findAllByUserId(long userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public List<Cart> findByUserIdAndProductIds(Long userId, List<Long> productIds) {
        return cartRepository.findByUserIdAndProductIdIn(userId, productIds);
    }
    
}
