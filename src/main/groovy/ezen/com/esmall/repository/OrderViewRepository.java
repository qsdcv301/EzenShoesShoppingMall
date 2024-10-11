package ezen.com.esmall.repository;

import ezen.com.esmall.entity.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, Long> {
}
