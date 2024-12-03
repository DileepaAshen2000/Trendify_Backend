package com.trendify.trendifyBackend.service;

import com.trendify.trendifyBackend.dto.CategoryDto;
import com.trendify.trendifyBackend.model.Category;
import com.trendify.trendifyBackend.model.CategoryType;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public Category getCategory(UUID categoryId);
    public Category createCategory(CategoryDto category);
    public List<Category> getAllCategory();
    public Category updateCategory(CategoryDto categoryDto, UUID categoryId);
    public void deleteCategory(UUID categoryId);


}
