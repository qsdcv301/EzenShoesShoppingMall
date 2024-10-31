package ezen.com.esmall.controller;

import ezen.com.esmall.entity.Product;
import ezen.com.esmall.entity.ProductSize;
import ezen.com.esmall.service.CategoryService;
import ezen.com.esmall.service.ProductService;
import ezen.com.esmall.service.ProductSizeService;
import ezen.com.esmall.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final SubCategoryService subCategoryService;

    private final ProductSizeService productSizeService;

    @GetMapping
    public String admin() {
        List<Product> productList = productService.findAll();
        List<ProductSize> productSizeList = new ArrayList<>();
        for(Product product : productList) {
            productSizeList = productSizeService.findByProductId(product.getId());
        }

        return "admin";
    }
}
