package org.java.app.entity.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false)
	@NotBlank
	private String title;
	
	@Column(length = 512)
	private String overview;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	@NotBlank
	private String url;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT true")
	private boolean visible;
	
	@ManyToMany
	@JsonManagedReference
	private List<Categories> categories;
	
	public Photo() {}
	
	public Photo(String title, String overview, String url, boolean visible, Categories... categories) {
		setTitle(title);
		setOverview(overview);
		setUrl(url);
		setVisible(visible);
		setCategories(Arrays.asList(categories));
	}
	
	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}