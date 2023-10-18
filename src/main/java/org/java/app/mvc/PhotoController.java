package org.java.app.mvc;

import java.util.List;

import org.java.app.entity.pojo.Photo;
import org.java.app.entity.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
