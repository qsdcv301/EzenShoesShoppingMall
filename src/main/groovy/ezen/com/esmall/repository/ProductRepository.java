package ezen.com.esmall.repository;

import ezen.com.esmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(long categoryId);

    List<Product> findAllByCategoryIdAndSubcategoryId(Long categoryId, Long subcategoryId);

    Product findProductByName(String name);
}
