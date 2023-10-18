package org.java.app.entity.repo;

import org.java.app.entity.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long>{
	
	public List<Photo> findByTitleContainingOrOverviewContaining(String title, String overview);
}
