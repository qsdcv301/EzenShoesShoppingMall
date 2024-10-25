package ezen.com.esmall.repository;

import ezen.com.esmall.entity.Orders;
import ezen.com.esmall.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProductId(Long productId);

    int countAllByProductId(Long productId);

    List<Review> findAllByUserId(Long userId);

}
