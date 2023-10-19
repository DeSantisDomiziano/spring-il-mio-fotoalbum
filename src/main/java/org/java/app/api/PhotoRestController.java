package org.java.app.api;

import java.util.List;

import org.java.app.entity.pojo.Photo;
import org.java.app.entity.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoRestController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public ResponseEntity<List<Photo>> getAll() {
		List<Photo> photos = photoService.findAll();
		
		if (photos.size() < 1) {
			 return new ResponseEntity<List<Photo>>(HttpStatus.NOT_FOUND);}

		return new ResponseEntity<>(photos, HttpStatus.OK);
	}
}
