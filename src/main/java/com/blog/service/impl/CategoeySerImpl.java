package com.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.repository.CategoryRepo;
import com.blog.service.CategorySer;

@Service
public class CategoeySerImpl implements CategorySer {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category cat = modelMapper.map(categoryDto, Category.class);
		Category addCat = categoryRepo.save(cat);
		return modelMapper.map(addCat, CategoryDto.class);
	}

	@Override
	public CategoryDto upCategory(CategoryDto categoryDto, Integer categoryId) {

		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Categoey Id", categoryId));

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCat = categoryRepo.save(cat);
		return modelMapper.map(updateCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer CategoryId) {
		Category category = categoryRepo.findById(CategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", CategoryId));
		categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {

		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoey Id", categoryId));
		return modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getallCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat) -> modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}

}
