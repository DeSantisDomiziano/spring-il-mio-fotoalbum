package org.java.app.entity.service;

import java.util.List;

import org.java.app.entity.pojo.Categories;
import org.java.app.entity.repo.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
	
	@Autowired
	private CategoriesRepo categoriesRepo;
	
	public void save(Categories categories) {
		categoriesRepo.save(categories);
	}
	
	public List<Categories> findAll() {
		return categoriesRepo.findAll();
	}
	
	public Categories findById(long id) {
		return categoriesRepo.findById(id).get();
	}
	
	public void deleteById(long id) {
		categoriesRepo.deleteById(id);
	}

}