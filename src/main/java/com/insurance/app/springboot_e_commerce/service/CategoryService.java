package com.insurance.app.springboot_e_commerce.service;

import com.insurance.app.springboot_e_commerce.entity.Category;
import com.insurance.app.springboot_e_commerce.exception.ProductNotFoundException;
import com.insurance.app.springboot_e_commerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Category not found"));
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category){
        Category category1 = getCategory(id);
        category1.setName(category.getName());

        return categoryRepository.save(category1);
    }

    public String deleteCategory(Long id){
        Category category = getCategory(id);
        categoryRepository.delete(category);

        return "Comment deleted";
    }
}
