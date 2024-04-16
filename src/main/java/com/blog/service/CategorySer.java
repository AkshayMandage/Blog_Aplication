package com.blog.service;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategorySer {

	// create

	CategoryDto createCategory(CategoryDto categoryDto);

	// Update

	CategoryDto upCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	public void deleteCategory(Integer CategoeyId);

	// Get
	public CategoryDto getCategory(Integer categoryId);

	// get all
	List<CategoryDto> getallCategories();

}
