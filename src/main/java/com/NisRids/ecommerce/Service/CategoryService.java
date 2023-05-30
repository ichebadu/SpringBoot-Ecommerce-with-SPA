package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.model.Category;
import com.NisRids.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category readCategory(String categoryName){
        return categoryRepository.findByCategoryName(categoryName);

    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category>readCategory(Long categoryID) {
        return categoryRepository.findById(categoryID);
    }

    public void updateCategory(Long categoryID, Category category) {
        Category newCategory = categoryRepository.findById(categoryID).get();
        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setDescription(category.getDescription());
        newCategory.setImageUrl(category.getImageUrl());
        categoryRepository.save(newCategory);
    }
}
