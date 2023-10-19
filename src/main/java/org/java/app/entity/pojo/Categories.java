package org.java.app.entity.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false)
	@NotBlank
	private String nameCategory;
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private List<Photo> photos;

	public Categories() {}	

	public Categories(String nameCategory) {
		setNameCategory(nameCategory);
	}
	
	public List<Photo> getPhotos() {
		return photos;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
}