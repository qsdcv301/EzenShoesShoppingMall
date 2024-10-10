package ezen.com.esmall.service;

import ezen.com.esmall.entity.Category;
import ezen.com.esmall.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category categoryDetails) {
        Category category = findById(id);
        if (category != null) {
            category.update(categoryDetails.getName());
            return categoryRepository.save(category);
        }
        return null;
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
