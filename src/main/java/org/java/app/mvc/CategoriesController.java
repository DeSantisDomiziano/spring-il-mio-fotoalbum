package org.java.app.mvc;

import java.util.List;

import org.java.app.entity.pojo.Categories;
import org.java.app.entity.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;

	@GetMapping("/list")
	public String getIndex(Model model) {
		
		List<Categories> categories = categoriesService.findAll(); 
		
		model.addAttribute("categories", categories);
		
		return "index-categories";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		
		model.addAttribute("categories", new Categories());
		
		return "create-categories";
	}
	
	@PostMapping("/create")
	public String getStore(@Valid @ModelAttribute Categories categories,
							BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "create-categories";
		}
		
		categoriesService.save(categories);
		return "redirect:/categories/list";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		
		Categories category = categoriesService.findById(id);
		
		if(category.getPhotos().size() > 0) {
			category.getPhotos().forEach(photo -> 
										photo.getCategories()
										.remove(category));
			categoriesService.deleteById(id);
		}else {			
			categoriesService.deleteById(id);
		}
		
		return "redirect:/categories/list";
	}
}