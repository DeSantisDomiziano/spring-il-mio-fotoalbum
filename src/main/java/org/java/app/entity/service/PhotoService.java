package org.java.app.entity.service;

import java.util.List;

import org.java.app.entity.pojo.Photo;
import org.java.app.entity.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepo photoRepo;
	
	public void save(Photo photo) {
		photoRepo.save(photo);
	}
	
	public List<Photo> findAll() {
		
		return photoRepo.findAll();
	}
	public Photo findById(long id) {
		
		return photoRepo.findById(id).get();
	}
	
	public void deleteById(long id) {
		photoRepo.deleteById(id);
	}
	
	public List<Photo> searchPizzaByTitleOrOverview(String name, String overview){
		return photoRepo.findByTitleContainingOrOverviewContaining(name, overview);
	}
	
}