package ezen.com.esmall.service;

import ezen.com.esmall.entity.Product;
import ezen.com.esmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productsRepository;

    @Autowired
    public ProductService(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    public Product update(Long id, Product productDetails) {
        Product product = findById(id);
        if (product != null) {
            product.update(productDetails.getName(), productDetails.getPrice(),
                    productDetails.getSize(), productDetails.getStock(),
                    productDetails.getDescription());
            return productsRepository.save(product);
        }
        return null;
    }

    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
