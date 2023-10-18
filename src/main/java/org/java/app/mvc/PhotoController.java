package org.java.app.mvc;

import java.util.List;
import org.java.app.entity.pojo.Photo;
import org.java.app.entity.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/list")
	public String GetIndex(Model model, @RequestParam(required = false) String title) {
		
		List<Photo> photos = title == null
									? photoService.findAll()
									: photoService.searchPizzaByTitleOrOverview(title, title);
		
		String oldTitle = title;
		
		model.addAttribute("photos",photos);
		model.addAttribute("oldTitle",oldTitle);
									 
		return "index-photo";
	}
	
	@GetMapping("/photo/{id}")
	public String getShow(@PathVariable long id, Model model) {
		
		Photo photo = photoService.findById(id);
		
		model.addAttribute("photo", photo);
		
		return "show-photo";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		
		model.addAttribute("photo", new Photo());
		
		return "create-photo";
	}
	
	@PostMapping("/create")
	public String getStore(@Valid @ModelAttribute Photo photo,
							BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "create-photo";
		}
		
		photoService.save(photo);
		
		return "redirect:/home/list";
	}
	
	@GetMapping("/photo/edit/{id}")
	public String getUpdate(@PathVariable long id,
						  Model model) {
		
		model.addAttribute("photo", photoService.findById(id));
		
		return "edit-photo";
	}
	
	@PostMapping("/photo/edit/{id}")
	public String getUpdate(@Valid @ModelAttribute Photo photo,
							BindingResult bindingResult,
							Model model) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "edit-photo";
		}
		
		photoService.save(photo);
		
		return "redirect:/home/list";
	}
	
	@PostMapping("/photo/delete/{id}")
	public String delete(@PathVariable long id) {
		photoService.deleteById(id);
		
		return "redirect:/home/list";
	}

}