package ezen.com.esmall.service;

import ezen.com.esmall.entity.ProductSize;
import ezen.com.esmall.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeService {

    private final ProductSizeRepository productSizeRepository;

    @Autowired
    public ProductSizeService(ProductSizeRepository productSizeRepository) {
        this.productSizeRepository = productSizeRepository;
    }

    public List<ProductSize> findAll() {
        return productSizeRepository.findAll();
    }

    public ProductSize findById(Long id) {
        return productSizeRepository.findById(id).orElse(null);
    }

    public ProductSize update(Long id, ProductSize productDetails) {
        ProductSize productSize = findById(id);
        if (productSize != null) {
            productSize.update(productDetails.getStock());
            return productSizeRepository.save(productSize);
        }
        return null;
    }

    public void delete(Long id) {
        productSizeRepository.deleteById(id);
    }

}
