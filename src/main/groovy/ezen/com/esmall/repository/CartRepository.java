package ezen.com.esmall.repository;

import ezen.com.esmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import ezen.com.esmall.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(long userId);

    List<Cart> findByUserIdAndProductIdIn(Long userId, List<Long> productIds);
}
