package ezen.com.esmall.service;

import ezen.com.esmall.entity.SubCategory;
import ezen.com.esmall.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    public SubCategory findById(Long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    public SubCategory create(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory update(Long id, SubCategory subCategoryDetails) {
        SubCategory subCategory = findById(id);
        if (subCategory != null) {
            subCategory.update(subCategoryDetails.getName());
            return subCategoryRepository.save(subCategory);
        }
        return null;
    }

    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public Optional<SubCategory> findByName(String name) {
        return subCategoryRepository.findByName(name);
    }
}
