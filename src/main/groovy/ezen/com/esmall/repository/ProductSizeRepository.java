package ezen.com.esmall.repository;

import ezen.com.esmall.entity.Product;
import ezen.com.esmall.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    ProductSize findByProductIdAndSize(Long productId, String size);
    List<ProductSize> findALLByProductId(Long productId);
}
