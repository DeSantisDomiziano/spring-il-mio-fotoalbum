package org.java.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.java.app.controller.auth.service.RoleService;
import org.java.app.controller.auth.service.UserService;
import org.java.app.entity.pojo.Categories;
import org.java.app.entity.pojo.Photo;
import org.java.app.entity.service.CategoriesService;
import org.java.app.entity.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categories c1 = new Categories("natura");
		Categories c2 = new Categories("città");
		Categories c3 = new Categories("animali");
		Categories c4 = new Categories("autoritratto");
		Categories c5 = new Categories("architettura");
		Categories c6 = new Categories("persone");
		Categories c7 = new Categories("stagione");
		
		categoriesService.save(c1);
		categoriesService.save(c2);
		categoriesService.save(c3);
		categoriesService.save(c4);
		categoriesService.save(c5);
		categoriesService.save(c6);
		categoriesService.save(c7);
		
		Photo p1 = new Photo("tigre", "una tigre che dorme nella natura",
				"https://images.pexels.com/photos/2055100/pexels-photo-2055100.jpeg?auto=compress&cs=tinysrgb&w=400",
				true, c1, c3);
		
		Photo p2 = new Photo("NY", "New York e la sua architettura e central park",
				"https://images.pexels.com/photos/327502/pexels-photo-327502.jpeg?auto=compress&cs=tinysrgb&w=400",
				true, c1, c2, c5);
		
		Photo p3 = new Photo("mamma e figlia", "mamma e figlia",
				"https://images.pexels.com/photos/3768131/pexels-photo-3768131.jpeg?auto=compress&cs=tinysrgb&w=400",
				true, c6);
		
		Photo p4 = new Photo("mare", "il mare d'inverno con un pinguino",
				"https://images.pexels.com/photos/3889695/pexels-photo-3889695.jpeg?auto=compress&cs=tinysrgb&w=400",
				true, c1, c7, c2);
		
		Photo p5 = new Photo("roma", "roma di notte",
				"https://images.pexels.com/photos/753639/pexels-photo-753639.jpeg?auto=compress&cs=tinysrgb&w=400",
				true, c2, c5);
		
		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
		photoService.save(p4);
		photoService.save(p5);
		
		
	}
}