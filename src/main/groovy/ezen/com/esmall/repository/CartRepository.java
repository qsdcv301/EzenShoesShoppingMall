package ezen.com.esmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ezen.com.esmall.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
