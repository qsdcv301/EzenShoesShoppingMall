package ezen.com.esmall.repository;

import ezen.com.esmall.entity.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, Long> {
    List<OrderView> findByUserId(Long userId);
}
